package org.company.myapp.repository;

import java.util.List;
import java.util.Map;

import org.company.myapp.dto.Joininfo;

public interface AnalysisRepository {
	//가입현황 리스트
	List<Joininfo> selectList_joininfo(Map<String,String> findmap);
}
