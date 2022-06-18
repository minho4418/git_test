package org.company.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.company.myapp.dto.Member;
import org.company.myapp.repository.MemberRepository;
import org.company.myapp.service.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTestMember {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("park@gmail.com");
		member.setPasswd("1111");
		member.setUsername("박자바");
		member.setZipcode("11111");
		member.setAddrload("신림로");
		member.setAddrdetail("6층");
		member.setFilename("a.png");
		
		int cnt = memberRepository.insert(member);
		System.out.println(cnt +"건 추가");
	}

	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setEmail("park@gmail.com");
		member.setPasswd("1111");
		member.setUsername("박자바");
		member.setZipcode("11111");
		member.setAddrload("신림로");
		member.setAddrdetail("6층");
		member.setFilename("a.png");
		
		int cnt = memberRepository.update(member);
		System.out.println(cnt +"건 수정");
	}

	@Test
	public void testDelete() {
		int cnt = memberRepository.delete("park@gmail.com");
		System.out.println(cnt +"건 삭제");
	}

	@Test
	public void testSelectOne() {
		Member member = memberRepository.selectOne("park@gmail.com");
		System.out.println(member);
	}

	@Test
	public void testSelectList() {
		Map<String,String> map = new HashMap<>();
		map.put("findkey", "username");
		map.put("findvalue", "");
		List<Member> mlist= memberRepository.selectList(map);
		System.out.println(mlist);
	}
	
	/* 이메일 보내기 */
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	@Test
	public void testMailSend() throws MessagingException {
		//"codingtreeksy@gmail.com" : 받는사람 메일주소
		//memberServiceImpl.sendAuthMail("codingtreeksy@gmail.com");
	}
	
	
	
	
	
	
	

}
