package org.company.myapp.service;

import java.util.List;

import org.company.myapp.dto.BoardFile;
import org.company.myapp.repository.BoardFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFileServiceImpl implements BoardFileService{
	
	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return boardFileRepository.selectList(bnum);
	}

}
