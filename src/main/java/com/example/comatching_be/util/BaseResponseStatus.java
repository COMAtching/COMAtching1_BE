package com.example.comatching_be.util;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
	SUCCESS(true, 1000, "요청에 성공하였습니다."),
	SUCCESS_REGISTER(true, 1001, "요청에 성공하였습니다."),
	FAIL_REGISTER_DUPLICATE(false, 1002, "이미 등록된 연락처 입니다."),
	FAIL_REGISTER_NO_DEPART(false, 1003, "학과 및 전공을 입력해주세요"),
	FAIL_MBTI_MATCH(true, 2001, "MBTI 조건에 맞는 상대가 없습니다 ㅠ"),
	FAIL_NO_MATCH(true, 2002, "이성이 데이터에 한명도 없습니다");

	private final boolean isSuccess;
	private final int code;
	private final String message;

	private BaseResponseStatus(boolean isSuccess, int code, String message) {
		this.isSuccess = isSuccess;
		this.code = code;
		this.message = message;
	}
}
