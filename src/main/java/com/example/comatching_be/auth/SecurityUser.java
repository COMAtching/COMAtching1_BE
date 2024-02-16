package com.example.comatching_be.auth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.comatching_be.domain.UserInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUser extends User {
	private UserInfo userInfo;

	public SecurityUser(UserInfo userInfo) {
		super(userInfo.getUserEmail(), userInfo.getPasswd(),
			AuthorityUtils.createAuthorityList(userInfo.getRole().toString()));
		this.userInfo = userInfo;

	}
}
