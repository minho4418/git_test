package org.company.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.service.LoginService;
import org.company.myapp.service.NaverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private NaverService naverService;
	
	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		//네이버 간편가입 위해서 apiURL 얻기
		
		Map<String, String> rmap = naverService.getApiUrl(request.getContextPath());
		//섹션에 state넣기(callback메소드에서 인증하기 위해서)
		session.setAttribute("state", rmap.get("state"));
		//jsp에 보내기
		model.addAttribute("apiURL", rmap.get("apiURL"));
		
	}
	
	//로그인 버튼을 눌렀을때
	@PostMapping("login")
	public String login(@RequestParam String email, @RequestParam String passwd, 
			RedirectAttributes rattr, HttpSession session) {

		ErrorCode errorCode = loginService.loginCheck(email, passwd, session);
		//성공이면 홈 아니면 login로 이동
		int code = errorCode.getCode();
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());

		if (code==0 ) { //성공
			return "redirect:/";
		}
		return "redirect:login";
		
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//세션지우기
		session.invalidate();
		
		return "redirect:/";
	}
	//네이버 간편가입
//	1)네이버 로그인 요청(GET:로그인창으로 이동)
//	2)callback주소로 code, state 받기
//	3)code,state를 이용해서 access_token 얻기(회원정보 얻기위해서)
//	4)access_token를 이용해서 개인회원정보 요청
//  5)개인회원정보를 저장
	
	//네이버 콜백주소
	//code : //네이버에서 만들어준 코드(동의했다)
	@GetMapping("naverCallback")
	public String naverCallback(@RequestParam String code, @RequestParam String state,
			HttpSession session, HttpServletRequest request, RedirectAttributes rattr) throws Exception{
		//세션의 state와 파라메터의 state가 일치한다면 정상사용자
		String state_s = (String) session.getAttribute("state");
		LOGGER.info("session state : " + state_s);

		if (state_s != null && state_s.equals(state)) { 
			ErrorCode errorCode = naverService.naverLogin(code, state, session, request.getContextPath());
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			//code가 0(성공)이면 redirect방식 home.jsp로 이동
			if (errorCode.getCode()==0) {
				return "redirect:/";
			}
			//아니면(실패) redirect login.jsp로 이동
			return "redirect:login";
			
		}else {
			//state_s이 null이거나 state_s가 일치하지 않는다면
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_NAVERAUTH.getMsg());
			return "redirect:login";
		}

	}
	
	
	@GetMapping("company")
	public void company() {
		//회사정보(map)
	}
	
	
	
	
	
	
	
	
	
}
