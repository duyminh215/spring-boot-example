package com.backend.template.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.backend.template.constant.HeaderContants;
import com.backend.template.dto.UserBasicInfoDto;
import com.backend.template.model.User;
import com.backend.template.repositories.UserRepository;

public class BaseController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpServletRequest request;

	private User loginedUser;

	public User getLoginedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(isLoginedUser()) {
			long userId = Long.parseLong(authentication.getName());
			loginedUser = userRepository.getOne(userId);
		}
		return loginedUser;
	}
	
	private boolean isLoginedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication instanceof AnonymousAuthenticationToken) {
			return false;
		}
		return true;
	}
	
	public UserBasicInfoDto getUserBasicInfo() {
		UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto();
		User loginedUser = getLoginedUser();
		if(loginedUser != null) {
			userBasicInfoDto.setUserId(loginedUser.getId());
			userBasicInfoDto.setLogin(true);
		}
		String language = request.getHeader(HeaderContants.ACCEPT_LANGUAGE);
		userBasicInfoDto.setLanguage(language);
		return userBasicInfoDto;
	}
}
