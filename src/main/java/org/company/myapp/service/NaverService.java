package org.company.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;

public interface NaverService {
	
	//로그인 apiurl생성 
	Map<String, String> getApiUrl(String path) throws Exception;
	
	//네이버 로그인
	ErrorCode naverLogin(String code, String state, HttpSession session, String path) throws Exception;
	
}
