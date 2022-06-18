package org.company.myapp.controller;

import java.util.Map;

import org.company.myapp.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("analysis")
public class AnalysisController {
	@Autowired
	private AnalysisService analysisService;
	
	@GetMapping("joininfo")
//	public void joininfo(@RequestParam(defaultValue = "") String sdate, 
//			@RequestParam(defaultValue = "") String edate) {
	public void joininfo(@RequestParam Map<String, String> findmap, Model model) {
		model.addAttribute("jilist", analysisService.selectList_joininfo(findmap));
		
		//return "analysis/joininfo";
	}
	
}
