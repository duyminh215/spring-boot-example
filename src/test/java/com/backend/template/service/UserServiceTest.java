package com.backend.template.service;

import com.backend.template.dto.input.UpdateUserInput;
import com.backend.template.dto.output.UserDto;
import com.backend.template.model.User;
import com.backend.template.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.exception.RequestInvalidException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private UpdateUserInput updateUserInput;

    private User user;

    private List<User> users;


    @Test
    public void testSignUpEmptyFullName() {
        CreateUserInput createUserInput = new CreateUserInput("", "nguyenvana1111@gmail.com", null, "123456");
        try {
            userServiceImpl.signUpByEmailOrPhone(createUserInput);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Full name is empty"));
            assertTrue(e instanceof RequestInvalidException);
        }
    }

    @Test
    public void testSignUpEmptyPassword() {
        CreateUserInput createUserInput = new CreateUserInput("Nguyễn Văn A", "nguyenvana1111@gmail.com", null, "");
        try {
            userServiceImpl.signUpByEmailOrPhone(createUserInput);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Password is empty"));
            assertTrue(e instanceof RequestInvalidException);
        }
    }

    @Test
    public void testSignUpEmptyEmailAndPhone() {
        CreateUserInput createUserInput = new CreateUserInput("Nguyễn Văn A", null, null, "123456");
        try {
            userServiceImpl.signUpByEmailOrPhone(createUserInput);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Email or phone is empty"));
            assertTrue(e instanceof RequestInvalidException);
        }
    }

    @Test
    public void testSignUpInvalidEmail() {
        CreateUserInput createUserInput = new CreateUserInput("Nguyễn Văn A", "nguyenvana@", null, "123456");
        try {
            userServiceImpl.signUpByEmailOrPhone(createUserInput);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Invalid email"));
            assertTrue(e instanceof RequestInvalidException);
        }
    }

    @Test
    public void testSignUpInvalidPhone() {
        CreateUserInput createUserInput = new CreateUserInput("Nguyễn Văn A", "", "098", "123456");
        try {
            userServiceImpl.signUpByEmailOrPhone(createUserInput);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Invalid phone"));
            assertTrue(e instanceof RequestInvalidException);
        }
    }

    @Before
    public void setUp(){
        users = new ArrayList<>();
        users.add(new User("hien@gmail.com","hien","0969708715"));

        user = new User("vuhien@gmail.com","hien","0969708712");
        user.setId(1L);
//        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
    }

    @Test
    public void testGetUserById(){
        when(userRepository.findById(1l)).thenReturn(Optional.of(users.get(0)));
        UserDto actual  = userService.getUserById(1l);
        assertEquals(actual.getEmail(),"hien@gmail.com");
    }

    @Test
    public void testUpdateUser(){
//        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        updateUserInput = new UpdateUserInput("aa","0969708714",2313l);
        UserDto actual = userServiceImpl.updateUser(updateUserInput,1);
        assertEquals(user.getId(),actual.getId());
    }
}
