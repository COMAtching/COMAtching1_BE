package com.example.comatching_be.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {

	private String salt = "COMAtching";

	public String encrypt(String plainText) {
		try {
			// 솔트와 비밀번호를 합쳐서 바이트 배열 생성
			byte[] saltedPassword = (salt + plainText).getBytes();

			// MessageDigest 객체 생성 (해시 알고리즘 지정)
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// 솔트와 비밀번호를 이용하여 해시 생성
			md.update(saltedPassword);
			byte[] hashBytes = md.digest();

			// 바이트 배열을 Base64 문자열로 변환
			return Base64.getEncoder().encodeToString(hashBytes);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
}
