package org.company.myapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.company.myapp.dto.BoardFile;
import org.company.myapp.repository.BoardFileRepository;
import org.company.myapp.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTestBoardFile {
	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Test
	public void testInsert() {
		BoardFile boardFile = new BoardFile();
		boardFile.setBnum(6);
		boardFile.setFilename("a.png");
		int cnt = boardFileRepository.insert(boardFile);
		System.out.println(cnt+"건 추가");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}

	@Test
	public void testUpdate() {
		BoardFile boardFile = new BoardFile();
		boardFile.setBfnum(4);
		boardFile.setFilename("b.png");
		int cnt = boardFileRepository.update(boardFile);
		System.out.println(cnt+"건 수정");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}

	@Test
	public void testDelete() {
		int cnt = boardFileRepository.delete(4);
		System.out.println(cnt+"건 삭제");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}

	@Test
	public void testSelectOne() {
		BoardFile boardFile = boardFileRepository.selectOne(5);
		System.out.println(boardFile);
		assertNotNull(boardFile); //board가 null이 아니면 성공
	}

	@Test
	public void testSelectList() {
		List<BoardFile> bflist = boardFileRepository.selectList(6);
		System.out.println(bflist);
		assertNotEquals(0, bflist.size());//사이즈가 0과 같지 않으면 성공
	}
	
	
	@Autowired
	private FileService fleService;
	@Test
	public void testFiledelete() throws Exception {
		fleService.fileDelete("1652931492222_000901.png");
	}
	
	
	
	

}
