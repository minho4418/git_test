package org.company.myapp.repository;

import java.util.List;

import org.company.myapp.dto.Reply;

//댓글 
public interface ReplyRepository {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(int rnum);
	Reply selectOne(int rnum);
	List<Reply> selectList(int bnum);
	
	/* 글순서 재수정 */
	int updateRestep(Reply reply);
}
