package com.backend.template.controller;

import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.dto.output.UserDto;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.UserServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserServiceImpl userService;
	
	@Autowired
	private ResponseFactory responseFactory;
	
	@Test
	public void testSignUpSucceFull() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1);
		String bodyJson = "{\"fullName\":\"Nguyễn Duy Minh\",\"email\":\"duyminh215990@gmail.com\",\"phone\":\"\", \"password\": \"123456\"}";
		when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenReturn(userDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/sign-up")
				.contentType(MediaType.APPLICATION_JSON).content(bodyJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id", Matchers.is(1)))
				;
	}
	
	@Test
	public void testSignUpWithEmptyFullName() throws Exception {
		RequestInvalidException exception = new RequestInvalidException("Full name is empty");
		String bodyJson = "{\"fullName\":\"Nguyễn Duy Minh\",\"email\":\"duyminh215990@gmail.com\",\"phone\":\"\", \"password\": \"\"}";
		when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenThrow(exception);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/sign-up")
				.contentType(MediaType.APPLICATION_JSON).content(bodyJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Full name is empty")));
		
	}
}
