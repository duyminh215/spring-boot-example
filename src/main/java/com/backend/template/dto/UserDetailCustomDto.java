package com.backend.template.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class UserDetailCustomDto extends org.springframework.security.core.userdetails.User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailCustomDto(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, long userId) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		setId(userId);
	}

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
