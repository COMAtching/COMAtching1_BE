package com.example.comatching_be.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.comatching_be.Login.dto.LoginReq;
import com.example.comatching_be.Login.dto.LoginRes;
import com.example.comatching_be.auth.CustomUserDetailsService;
import com.example.comatching_be.util.BaseResponse;
import com.example.comatching_be.util.BaseResponseStatus;

@RestController
public class LoginController {

	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService customUserDetailsService;

	@Autowired
	private LoginService loginService;

	@Autowired
	public LoginController(AuthenticationManager authenticationManager,
		CustomUserDetailsService customUserDetailsService) {
		this.authenticationManager = authenticationManager;
		this.customUserDetailsService = customUserDetailsService;
	}

	@PostMapping("/login")
	public BaseResponse<LoginRes> loginProcess(@RequestBody LoginReq req) {
		BaseResponse res = new BaseResponse<LoginRes>(BaseResponseStatus.SUCCESS);
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(req.getUserEmail());

		try {

			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(req.getUserEmail(), req.getUserPw())
			);

			LoginRes loginRes = loginService.loginServiceFunc(req.getUserEmail());
			res.setResult(loginRes);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResult(BaseResponseStatus.FAIL_LOGIN);
			return res;
		}
	}
}
