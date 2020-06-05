package com.backend.template.controller;

import com.backend.template.dto.input.UpdateUserInput;
import com.backend.template.model.User;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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

    @Mock
    private BaseController baseController;
    
    @Test
    public void testSignUpSuccess() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1l);
        String bodyJson = "{\"fullName\":\"Nguyễn Duy Minh\",\"email\":\"duyminh215990@gmail.com\",\"phone\":\"\", \"password\": \"123456\"}";
        when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenReturn(userDto);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/sign-up").contentType(MediaType.APPLICATION_JSON).content(bodyJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", Matchers.is(1)));
    }

    @Test
    public void testSignUpWithEmptyFullName() throws Exception {
        RequestInvalidException exception = new RequestInvalidException("Full name is empty");
        String bodyJson = "{\"fullName\":\"Nguyễn Duy Minh\",\"email\":\"duyminh215990@gmail.com\",\"phone\":\"\", \"password\": \"\"}";
        when(this.userService.signUpByEmailOrPhone(Mockito.any(CreateUserInput.class))).thenThrow(exception);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/sign-up").contentType(MediaType.APPLICATION_JSON).content(bodyJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Full name is empty")));

    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1l);
        userDto.setFullName("a");
        userDto.setPhone("0969708715");
        String bodyJson = "{\"fullName\":\"a\",\"phone\":\"0969708715\"}";
       when(this.userService.updateUser(Mockito.any(UpdateUserInput.class),anyLong())).thenReturn(userDto);
       mockMvc.perform(
               MockMvcRequestBuilders.put("/user/update").contentType(MediaType.APPLICATION_JSON).content(bodyJson)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTM1NzQ1NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJjMjhmYjBiZC1hNmU1LTQ3YTItOWZjNy03NThmODZhOGNiZjEiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.kV3SvcotkmBxe_6OTxQWLcu1IGRac5Z504zq2beG4WQ"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.data.fullName", Matchers.is("a")));
    }

    @Test
    public void testGetUserById() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1l);
        User user = new User();
//        user.setId(1L);
//        user.setFullName("Duy Minh");
//        user.setEmail("duyminh215@gmail.com");
//        user.setPassword("password");
        when(baseController.getLoginedUser()).thenReturn(user);
        when(userService.getUserById(anyLong())).thenReturn(userDto);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/details")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTM1NzQ1NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJjMjhmYjBiZC1hNmU1LTQ3YTItOWZjNy03NThmODZhOGNiZjEiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.kV3SvcotkmBxe_6OTxQWLcu1IGRac5Z504zq2beG4WQ"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", Matchers.is(1)));
    }
}
