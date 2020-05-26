//package com.backend.template.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.mockito.Mockito.*;
//import static org.mockito.BDDMockito.given;
//	
//import com.backend.template.dto.input.CreateUserInput;
//import com.backend.template.dto.output.UserDto;
//import com.backend.template.exception.RequestInvalidException;
//import com.backend.template.model.response.ResponseFactory;
//import com.backend.template.service.UserServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(UserController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Mock
//	private UserServiceImpl userService;
//	
//	@Mock
//	private ResponseFactory responseFactory;
//	
//	@InjectMocks
//	private UserController userController;
//	
//	@Before
//    public void setup() {
//		MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//	
//	@Test
//	public void testSignUpSucceFull() throws Exception {
//		UserDto userDto = new UserDto();
//		userDto.setId(1);
//		when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenReturn(userDto);
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/sign-up", Mockito.mock(CreateUserInput.class))).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(status, 200);
//		assertEquals(userDto.getId(), 1);
//	}
//	
//	@Test
//	public void testSignUpWithEmptyFullName() throws Exception {
//		RequestInvalidException exception = new RequestInvalidException("Full name is empty");
//		when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenThrow(exception);
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/sign-up", Mockito.mock(CreateUserInput.class))).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(status, 200);
//	}
//}
