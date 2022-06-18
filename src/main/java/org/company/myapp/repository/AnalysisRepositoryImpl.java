package org.company.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.company.myapp.dto.Joininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnalysisRepositoryImpl implements AnalysisRepository{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Joininfo> selectList_joininfo(Map<String,String> findmap) {
		// 가입현황 리스트
		return sqlSession.selectList("org.company.myapp.AnalysisMapper.selectList_joininfo",findmap );
	}

}
