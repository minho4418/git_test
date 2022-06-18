<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
</head>
<body>
	<header>
		<h2>게시물 관리 V1.0</h2>
		<div>
			<!-- 컨택스트패스 -->
			<input type="hidden" value="${path}" id="contextpath"> 
			<span id="sessionEmail"><a href="${path}/member/info"> ${sessionScope.email} </a></span>
			<a href="${path}/login" id="aLogin">로그인</a>
			<a href="" id="aLogout">로그아웃</a>
			<a href="${path}/member/join"  id ="aJoin">회원가입</a>
		</div>
	</header>
	<hr>
	<nav>
		<div>
			<a href="${path}">홈</a>
			<a href="${path}/company">찾아오시는길</a>
		</div>
		<div>
			<a href="${path}/board/">게시물조회</a>
			<a href="${path}/board/add">게시물추가</a>
			<a href="${path}/analysis/joininfo">통계</a>	
				
		</div>
			
	</nav>
	<hr>	
</body>
</html>