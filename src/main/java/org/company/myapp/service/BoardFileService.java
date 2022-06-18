package org.company.myapp.service;

import java.util.List;

import org.company.myapp.dto.BoardFile;

public interface BoardFileService {
	//boardfile db에 접근
	List<BoardFile> selectList(int bnum);
	
}
