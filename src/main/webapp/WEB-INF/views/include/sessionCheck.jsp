<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	//세션을 체크
	if (!'${sessionScope.email}'){
		alert('로그인 후 사용하세요!');
		location.href='${path}/login';
	}

</script>