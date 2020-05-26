package com.backend.template.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserInput {

	private String fullName;
	private String email;
	private String phone;
	private String password;
	
	public CreateUserInput(String fullName, String email, String phone, String password) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public CreateUserInput() {
	}
}
