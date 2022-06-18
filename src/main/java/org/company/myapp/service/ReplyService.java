package org.company.myapp.service;

import java.util.List;

import org.company.myapp.dto.Reply;

public interface ReplyService {
	int insert(Reply reply);

	List<Reply> selectList(int bnum);

	int delete(int rnum);

	int update(Reply reply);
	

}
