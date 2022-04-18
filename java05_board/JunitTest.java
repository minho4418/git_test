package java05_board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JunitTest {

	BoardDAO bdao = new BoardDAOImpl();
	@Test
	void testInsert() {
		int cnt = bdao.insert(new Board("java", "가입인사", "만나서반갑습니다"));
		assertEquals(1, cnt);
	}

	@Test
	void testUpdate() {
		int cnt = bdao.update(new Board(1, "hong", "가입수정", "내용수정"));
		assertEquals(1, cnt);
	}

	@Test
	void testDelete() {
		int cnt = bdao.delete(1);
		assertEquals(1, cnt);
	}

	@Test
	void testSelctOne() {
		Board board = bdao.selctOne(3);
		System.out.println(board);
		assertNotNull(board);
	}

	@Test
	void testSelectList() {
		List<Board> blist = bdao.selectList();
		System.out.println(blist);
		assertNotEquals(0, blist.size());
	}
	@Test
	void testSelectListMember() {
		List<Map<String, Object>> mlist = bdao.selectListMember("인사");
		System.out.println(mlist);
		try {
			for(Map<String, Object> map: mlist) {
				int seq = (int) map.get("seq"); // 다운캐스팅 부모 -> 자식
				System.out.println("순번 : " + seq);
				System.out.println(map.get("seq"));
				System.out.println(map.get("writer"));
				System.out.println(map.get("email"));
				System.out.println(map.get("subject"));
				System.out.println(map.get("regidate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//assertNotEquals(0, mlist.size());
	}

	@Test
	void selectListMemberYear() {
		List<Map<String, Object>> mlist = bdao.selectListMemberYear("");
		System.out.println(mlist);
		try {
			for(Map<String, Object> map: mlist) {
				int seq = (int) map.get("seq"); // 다운캐스팅 부모 -> 자식
				System.out.println("순번 : " + seq);
				System.out.println(map.get("seq"));
				System.out.println(map.get("writer"));
				System.out.println(map.get("birthyear"));
				System.out.println(map.get("subject"));
				System.out.println(map.get("regidate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//assertNotEquals(0, mlist.size());
	}
}
