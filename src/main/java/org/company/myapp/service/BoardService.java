package org.company.myapp.service;

import java.util.List;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.dto.Board;
import org.company.myapp.dto.Page;

public interface BoardService {
	List<Board> selectList(Page page);
	Board selectOne(int bnum);
	//열거형 반환
	ErrorCode insert(Board board) throws Exception;
	ErrorCode update(Board board,List<Integer> removeFiles) throws Exception;
	ErrorCode updateRemoveyn(int bnum);
	
	//조회수+1
	int updateReadCnt(int bnum);
	//좋아요+1
	int updateLikeCnt(int bnum);
	//싫어요+1
	int updateDisLikeCnt(int bnum);
}
