package org.company.myapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.company.myapp.advice.ErrorCode;
import org.company.myapp.dto.Member;
import org.company.myapp.repository.MemberRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaverServiceImpl implements NaverService{
	private static final Logger logger = LoggerFactory.getLogger(NaverServiceImpl.class);
	
	@Autowired
	private MemberRepository memberRepository;
	//네이버 콜백 url
	String naverRedirectUrl = "http://localhost:8081";
	//실서버용
	//String naverRedirectUrl = "http://101.101.219.176:8080"; 
	//네이버 로그인
	@Override
	public ErrorCode naverLogin(String code, String state, HttpSession session, String path) throws Exception{
		//토큰생성(토큰을 이용해서 개인정보 얻을수 있다)
		String access_token = getAccessToken(code, state, path);

		//개인정보얻기
		Member member = getUserInfo(access_token);
		
		//네이버간편가입 정보 db에서 조회
		Member dbmember = memberRepository.selectOne(member.getEmail());
		if (dbmember!=null) { //이미가입이 되어 있다면
			//네이버 간편가입한 회원이 아니라면
			if (!dbmember.getSimplejoin().equals("1")) {
				return ErrorCode.ERROR_NO_NAVER_JOIN;
			}else {
				//이미 간편가입 으로 가입
				session.setAttribute("email", member.getEmail()); //세션저장(이메일)
				session.setAttribute("username", member.getUsername()); //세션저장(이름)
				return ErrorCode.SUCCESS_NAVER_LOGIN;
			}
		}		
		//가입된 정보가 없다면 저장
		insert_simplejoin(member);
		session.setAttribute("email", member.getEmail());//세션저장(로그인)
		return ErrorCode.SUCCESS_NAVER_JOIN;
		
	}
	
	
	@Override
	public Map<String, String> getApiUrl(String path) throws Exception {
		//네이버 로그인을 위한 apiUrl과 state 리턴
		Map<String, String> rmap = new HashMap<>();
	    String clientId = "96SvgOujLlDWezBQKKmC";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode(naverRedirectUrl+ path +"/naverCallback", "UTF-8"); //나의 콜백주소
	    //인증값(state)생성
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    //session.setAttribute("state", state);
	    rmap.put("apiURL", apiURL);
	    rmap.put("state", state);
		    
		return rmap;
	}

	private String getAccessToken(String code, String state, String path) throws Exception{
		// accessToken반환 
		//토큰 가져오기
	    String clientId = "96SvgOujLlDWezBQKKmC";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "zwft2YON9N";//애플리케이션 클라이언트 시크릿값";
	    String access_token = "";
	    String redirectURI = URLEncoder.encode(naverRedirectUrl+ path +"/naverCallback", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;

    	URL url = new URL(apiURL);
    	HttpURLConnection con = (HttpURLConnection)url.openConnection();
    	con.setRequestMethod("GET");
    	int responseCode = con.getResponseCode();
    	BufferedReader br;
    	if(responseCode==200) { // 정상 호출
    		br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    	} else {  // 에러 발생
    		br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    	}
    	String inputLine;
    	StringBuffer res = new StringBuffer();
    	while ((inputLine = br.readLine()) != null) {
    		res.append(inputLine);
    	}
    	br.close();
    	if(responseCode==200) {
    		//json파싱 : access_token토큰 얻기
    		JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
    		access_token = (String) object.get("access_token");
    	}
	    
		return access_token;
	}

	private Member getUserInfo(String access_token) throws Exception {
		// 토큰을이용해서 개인정보 요청

		Member member = null; //반환

		String header = "Bearer " + access_token; // Bearer 다음에 공백 추가
        String apiURL = "https://openapi.naver.com/v1/nid/me";
        HttpURLConnection con = null;
        BufferedReader br = null;
		try {
		    URL url = new URL(apiURL);
		    con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			
			//json파싱
	    	JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
	    	object = (JSONObject) object.get("response");
	    	String id = (String) object.get("id");
	    	String email = (String) object.get("email");
	    	String name = (String) object.get("name");
	    	
	    	//멤버객체를 생성
	    	member = new Member();
	    	member.setEmail(email);
	    	member.setUsername(name);

	    	
		} finally {
			if (br != null) br.close();
			if (con != null) con.disconnect();
		}
		//개인정보 반환
		return member;
		
	}
	
	private void insert_simplejoin(Member member) {
		//네이버간편가입
		member.setSimplejoin("1");
		// 네이버 간편가입 데이터 db에 저장
		int cnt = memberRepository.insert_simplejoin(member);
		
	}
	
	
	
	

}
