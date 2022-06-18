package org.company.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.company.myapp.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.company.myapp.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.company.myapp.MemberMapper.update", member);
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.company.myapp.MemberMapper.delete", email);
	}

	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.company.myapp.MemberMapper.selectOne", email);
	}

	@Override
	public List<Member> selectList(Map<String, String> map) {
		return sqlSession.selectList("org.company.myapp.MemberMapper.selectList", map);
	}

	@Override
	public int update_emailauth(String email) {
		// 이메일 인증
		return sqlSession.update("org.company.myapp.MemberMapper.update_emailauth", email);
	}
	
	//자식메소드는 부모메소드 보다 반드시 접근제한자가 크거나 같아야 한다.
	@Override
	public int insert_simplejoin(Member member) {
		// 간편가입
		return sqlSession.insert("org.company.myapp.MemberMapper.insert_simplejoin", member);
	}
	
}
