package org.company.myapp.service;

import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.dto.Member;

//인터페이스의 메소드는 추상메소드:구현부가 없다
public interface MemberService {

	ErrorCode insert(Member member,HttpSession session, String path) throws Exception;
	
	void update_emailauth(String email);

	Member selectOne(String email);

}
