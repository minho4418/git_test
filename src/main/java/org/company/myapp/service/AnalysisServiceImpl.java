package org.company.myapp.service;

import java.util.List;
import java.util.Map;

import org.company.myapp.dto.Joininfo;
import org.company.myapp.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements AnalysisService{
	
	@Autowired
	private AnalysisRepository analysisRepository;
	
	@Override
	public List<Joininfo> selectList_joininfo(Map<String, String> findmap) {
		// 가입현황 리스트
		return analysisRepository.selectList_joininfo(findmap);
	}

}
