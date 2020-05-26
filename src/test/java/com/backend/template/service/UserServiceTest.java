package com.backend.template.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.exception.RequestInvalidException;

@SpringBootTest
public class UserServiceTest {

	@Autowired
    private UserServiceImpl userServiceImpl;
	
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
	
}
