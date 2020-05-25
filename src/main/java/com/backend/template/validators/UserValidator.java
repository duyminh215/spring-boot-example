package com.backend.template.validators;

import org.springframework.stereotype.Component;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;

@Component
public class UserValidator {

	public void validateCreateUser(CreateUserInput createUserInput) {
		if(isStringEmpty(createUserInput.getFullName())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_full_name"));
		}
		if(isEmailEmpty(createUserInput.getEmail()) && isPhoneEmpty(createUserInput.getPhone())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_email_or_phone"));
		}
		
		if(isStringEmpty(createUserInput.getPassword())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_password"));
		}
	}
	
	public boolean isStringEmpty(String string) {
		if(string == null || string.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean isEmailEmpty(String email) {
		if(email == null || email.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean isPhoneEmpty(String phone) {
		if(phone == null || phone.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
