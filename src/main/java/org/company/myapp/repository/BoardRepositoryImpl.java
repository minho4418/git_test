package org.company.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.company.myapp.dto.Board;
import org.company.myapp.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Board board) {
		
		return sqlSession.insert("org.company.myapp.BoardMapper.insert", board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.BoardMapper.update", board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.company.myapp.BoardMapper.delete", bnum);
	}

	@Override
	public Board selectOne(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.company.myapp.BoardMapper.selectOne", bnum);
	}

	@Override
	public List<Board> selectList(Page page) {
		return sqlSession.selectList("org.company.myapp.BoardMapper.selectList", page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		// 전체게시물수 구하기
		return sqlSession.selectOne("org.company.myapp.BoardMapper.selectTotalCnt", page);
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.BoardMapper.updateReadCnt", bnum);
	}

	@Override
	public int updateRemoveyn(int bnum) {
		//삭제여부 변경
		return sqlSession.update("org.company.myapp.BoardMapper.updateRemoveyn", bnum);
	}

	@Override
	public int updateLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.BoardMapper.updateLikeCnt", bnum);
	}

	@Override
	public int updateDisLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.BoardMapper.updateDisLikeCnt", bnum);
	}

}
