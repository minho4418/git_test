package org.company.myapp.service;

import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;

public interface LoginService {
	ErrorCode loginCheck(String email, String passwd, HttpSession session);
}
