package com.example.comatching_be.Login.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginReq {
	String userEmail;
	String userPw;
}
