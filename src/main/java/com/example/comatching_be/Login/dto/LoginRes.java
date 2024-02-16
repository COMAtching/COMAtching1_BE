package com.example.comatching_be.Login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
public class LoginRes {
	private Boolean gender;

	private String phone;

	private String depart;

	private String song;

	private String mbti;

	private Integer year;

	private Integer chance;

	private String passwd;
}
