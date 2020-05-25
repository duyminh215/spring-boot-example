package com.backend.template.validators;

import org.springframework.stereotype.Component;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;
import com.backend.template.utils.EmailValidation;
import com.backend.template.utils.PhoneValidation;
import com.backend.template.utils.Utils;

@Component
public class UserValidator {

	public void validateCreateUser(CreateUserInput createUserInput) {
		if(Utils.isStringEmpty(createUserInput.getFullName())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_full_name"));
		}
		if(isEmailEmpty(createUserInput.getEmail()) && isPhoneEmpty(createUserInput.getPhone())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_email_or_phone"));
		}
		
		if(!isEmailEmpty(createUserInput.getEmail())) {
			if(isInvalidEmail(createUserInput.getEmail())) {
				throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.invalid_email"));
			}
		}
		
		if(!isPhoneEmpty(createUserInput.getPhone())) {
			if(isInvalidPhone(createUserInput.getPhone())) {
				throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.invalid_phone"));
			}
		}
		
		if(Utils.isStringEmpty(createUserInput.getPassword())) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.empty_password"));
		}
	}
	
	public boolean isInvalidEmail(String email) {
		return !EmailValidation.isValidEmailAddress(email);
	}
	
	public boolean isInvalidPhone(String phone) {
		return !PhoneValidation.isValidPhone(phone);
	}
	
	public boolean isEmailEmpty(String email) {
		if(Utils.isStringEmpty(email)) {
			return true;
		}
		return false;
	}
	
	public boolean isPhoneEmpty(String phone) {
		if(Utils.isStringEmpty(phone)) {
			return true;
		}
		return false;
	}
}
