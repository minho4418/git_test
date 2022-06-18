package org.company.myapp.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.dto.Member;
import org.company.myapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private MemberRepository memberRepository; 
	
	//암호화 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public ErrorCode loginCheck(String email, String passwd,HttpSession session) {
		
		// 한건조회
		Member member = memberRepository.selectOne(email);
		//1)이메일이 없다면 
		if (member == null) {
			return ErrorCode.ERROR_LOGIN_EMAIL;
		}
		//2)비밀번호
		//평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(passwd, member.getPasswd());
		if (!match) {
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		
		//3)이메일 인증 체크
		if (!member.getEmailauth().equals("1")) {
			return ErrorCode.ERROR_LOGIN_EMAILAUTH;
		}
		//성공:세션담기
		session.setMaxInactiveInterval(60*60*2); //기본 30분
		session.setAttribute("email", email);
		session.setAttribute("username", member.getUsername());
		
		return ErrorCode.SUCCESS_LOGIN;
	}

}
