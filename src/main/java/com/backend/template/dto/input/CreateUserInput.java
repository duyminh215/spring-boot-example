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
	
}
