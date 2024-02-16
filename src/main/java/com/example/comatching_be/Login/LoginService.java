package com.example.comatching_be.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.comatching_be.Login.dto.LoginRes;
import com.example.comatching_be.domain.UserInfo;
import com.example.comatching_be.domain.reopository.UserInfoRepository;

@Service
public class LoginService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	public LoginRes loginServiceFunc(String userEmail) {
		System.out.println("hello hello");
		UserInfo user = userInfoRepository.findByUserEmail(userEmail);

		System.out.println("user = " + user);
		LoginRes res = new LoginRes(user.getGender(), user.getPhone(), user.getDepart(), user.getSong(), user.getMbti(),
			user.getYear(),
			user.getChance(), user.getPasswd());
		return res;

	}
}
