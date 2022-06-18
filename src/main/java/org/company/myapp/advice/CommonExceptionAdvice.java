package org.company.myapp.advice;

import org.springframework.mail.MailAuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//컨트롤러에서 발생되는 예외를 전문적으로 처리하는 클래스
//스프링이 객체 생성
@ControllerAdvice
public class CommonExceptionAdvice {
	
	//객체생성 안될때때
//	@ExceptionHandler(NullPointerException.class)
//	public String commonNullPointerException(NullPointerException e, Model model) {
//		System.out.println("NullPointerException 예외발생");
//		e.printStackTrace();
//		return "error";
//	}
//	
//	
//	
//	//MailAuthenticationException:메일인증예외
//	@ExceptionHandler(MailAuthenticationException.class)
//	public String commonMessagingException(MailAuthenticationException e) {
//		System.out.println("MailAuthenticationException 예외 발생");
//		System.out.println("메일접속 환경설정을 확인!");
//		System.out.println(e.toString());
//		return "error";
//	}
	
	
	//모든 예외 처리
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e, Model model) {
		System.out.println("예외 발생");
		System.out.println(e.toString());
		e.printStackTrace();
		model.addAttribute("exception", e);
		//리졸버 작동: /WEB-INF/views/error.jsp로 이동
		return "error";
	}
	
	
	
	
	
	
	
	
}
