package org.company.myapp.service;

import java.util.List;
import java.util.Map;

import org.company.myapp.dto.Joininfo;

public interface AnalysisService {
	List<Joininfo> selectList_joininfo(Map<String, String> findmap);
}
