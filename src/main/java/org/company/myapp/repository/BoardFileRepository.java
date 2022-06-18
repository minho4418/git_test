package org.company.myapp.repository;

import java.util.List;

import org.company.myapp.dto.BoardFile;

public interface BoardFileRepository {
	int insert(BoardFile boardFile);
	int update(BoardFile boardFile);
	int delete(int bfnum);
	BoardFile selectOne(int bfnum);
	List<BoardFile> selectList(int bnum);
}
