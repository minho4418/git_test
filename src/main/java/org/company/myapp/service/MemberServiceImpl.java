package org.company.myapp.service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.dto.Member;
import org.company.myapp.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private FileService fileService; //파일을 업로드
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//이메일 전송
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Transactional //트랜잭션을 메소드단위로 제어(commit, rollback을 스프링이 관리)
	public ErrorCode insert(Member member,HttpSession session, String path) throws Exception {
		
		//1)중복이메일 체크
		Member dbmember = memberRepository.selectOne(member.getEmail());
		if (dbmember != null) {
			return ErrorCode.ERROR_JOIN_ID_EXIST;
		}
		
		//2)파일 업로드
		MultipartFile photofile = member.getPhotofile();
		String filename = fileService.fileUpload(photofile);
		member.setFilename(filename);
		
		//3)비밀번호 암호화
		String cryptPasswd =  bCryptPasswordEncoder.encode(member.getPasswd());
		member.setPasswd(cryptPasswd);
		
		//4)저장
		int cnt = memberRepository.insert(member);
		
		//5)이메일전송
		String authCode = sendAuthMail(member.getEmail(), path);
		
		//6)성공시 세션 저장
		session.setMaxInactiveInterval(60*60*2);
		session.setAttribute("authCode", authCode);//이메일 인증번호
		
		return ErrorCode.SUCCESS_JOIN;
		
	}

	//인증번호 램덤으로 6자리 만들기
	private String getAuthCode() {
		StringBuffer authCode = new StringBuffer();
		Random random = new Random();
		for(int i=0; i< 6; i++)
			authCode.append(random.nextInt(10)) ; //0~9사이의 정수
			
		return authCode.toString();
	}
	
	//이메일전송하고 인증번호를 리턴
	public String sendAuthMail(String email, String path) throws MessagingException {
		//6자리 인증번호
		String authCode = getAuthCode();
		//보낼 이메일 내용
		StringBuffer content = new StringBuffer();
		content.append(email + "님 반갑습니다. 아래링크를 클릭해 주세요<br> ");
		//로컬접속용
		//content.append("<a href='http://localhost:8081"+ path +"/member/emailConfirm?authCode="+authCode+"&email="+email+"'>이메일인증확인</a>");
		//실서버용
		content.append("<a href='http://49.50.174.115:8080"+ path +"/member/emailConfirm?authCode="+authCode+"&email="+email+"'>이메일인증확인</a>");
		
		//보낼메일 메시지 객체 생성
		MimeMessage message = mailSender.createMimeMessage();

		message.setSubject("회원가입 이메일 인증", "utf-8");
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		//메일보내기
		mailSender.send(message);
			
		return authCode;
	}
	



	@Override
	public void update_emailauth(String email) {
		// 이메일 인증
		int cnt = memberRepository.update_emailauth(email);
	}

	@Override
	public Member selectOne(String email) {
		
		return memberRepository.selectOne(email);
	}
	
}


