package org.company.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.company.myapp.dto.BoardFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileRepositoryImpl implements BoardFileRepository{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.company.myapp.BoardFileMapper.insert", boardFile);
	}

	@Override
	public int update(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.BoardFileMapper.update", boardFile);
	}

	@Override
	public int delete(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.company.myapp.BoardFileMapper.delete", bfnum);
	}

	@Override
	public BoardFile selectOne(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.company.myapp.BoardFileMapper.selectOne", bfnum);
	}

	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org.company.myapp.BoardFileMapper.selectList", bnum);
	}

}
