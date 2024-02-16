package com.example.comatching_be.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.comatching_be.domain.UserInfo;
import com.example.comatching_be.domain.reopository.UserInfoRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		System.out.println("Func is called");
		UserInfo userInfo = userInfoRepository.findByUserEmail(userEmail);

		if (userInfo == null) {
			System.out.println("userInfo is NULL");
		}

		System.out.println("FindByUserEmail - " + userInfo.getUserEmail());

		if (userInfo == null) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}

		return org.springframework.security.core.userdetails.User
			.withUsername(userInfo.getUserEmail())
			.password(userInfo.getUserPw())
			.roles("USER")
			.build();
	}
}
