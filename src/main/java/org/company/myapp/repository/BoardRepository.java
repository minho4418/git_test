package org.company.myapp.repository;

import java.util.List;

import org.company.myapp.dto.Board;
import org.company.myapp.dto.Page;

public interface BoardRepository {
	int insert(Board board);
	int update(Board board);
	int delete(int bnum);
	Board selectOne(int bnum);
	List<Board> selectList(Page page); //page는 페이징처리위한 정보
	//전체게시물수 구하기
	int selectTotalCnt(Page page);
	
	//조회수+1
	int updateReadCnt(int bnum);
	//좋아요+1
	int updateLikeCnt(int bnum);
	//싫어요 + 1
	int updateDisLikeCnt(int bnum);
	
	//삭제여부변경
	int updateRemoveyn(int bnum);
	
	
	
}
