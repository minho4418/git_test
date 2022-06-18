package org.company.myapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.company.myapp.dto.Reply;
import org.company.myapp.repository.ReplyRepository;
import org.company.myapp.service.LoginService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JuntTestReply {
	@Autowired
	private ReplyRepository replyRepository;

	@Test
	public void testInsert() {
		Reply reply = new Reply();
		reply.setBnum(6);
		reply.setEmail("java@gmail.com");
		reply.setContent("댓글내용");
		reply.setIp("192.168.0.100");
		reply.setRelevel(1);
		reply.setRestep(1);
		
		int cnt = replyRepository.insert(reply);
		System.out.println(cnt+"건 추가");
		assertEquals(1, cnt);
	}

	@Test
	public void testUpdate() {
		Reply reply = new Reply();
		reply.setRnum(5);
		reply.setContent("댓글내용수정");
		reply.setIp("192.168.0.99");
		
		int cnt = replyRepository.update(reply);
		System.out.println(cnt+"건 수정");
		assertEquals(1, cnt);
		
	}

	@Test
	public void testDelete() {
		int cnt = replyRepository.delete(5);
		System.out.println(cnt+"건 삭제");
		assertEquals(1, cnt);
	}

	@Test
	public void testSelectOne() {
		Reply reply = replyRepository.selectOne(4);
		System.out.println(reply);
		assertNotNull(reply);
	}

	@Test
	public void testSelectList() {
		List<Reply> rlist = replyRepository.selectList(8);
		System.out.println(rlist);
		assertNotEquals(0, rlist.size()); //사이즈가 0과 같지 않으면 성공
	}
	
	
	//애플리케이션배포 4번
	
	@Autowired
	private LoginService2 loginService2; 
	
	@Test
	public void testlogincheck() {
		int result = loginService2.loginCheck("java", "1111");
		assertEquals(0, result); //반환값이 0일때 성공
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
