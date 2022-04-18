package java05_board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	//추가
	int insert(Board board);
	//수정
	int update(Board board);
	//삭제
	int delete(int seq); //seq기준 
	int delete(String writer);//wrtier기준
	//한건조회
	Board selctOne(int seq);
	//리스트
	List<Board> selectList();
	List<Board> selectList(String writer);
	List<Map<String, Object>> selectListMember(String subject);
	List<Map<String, Object>> selectListMemberYear(String findvalue);
}
