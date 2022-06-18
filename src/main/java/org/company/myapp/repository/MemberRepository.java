package org.company.myapp.repository;

import java.util.List;
import java.util.Map;

import org.company.myapp.dto.Member;

public interface MemberRepository {
	//추상메소드 public abstract 기본
	int insert(Member member);
	int update(Member member);
	int delete(String email);
	Member selectOne(String email);
	List<Member> selectList(Map<String, String> map);
	int update_emailauth(String email);
	
	int insert_simplejoin(Member member);
	
}
