<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>에러가 발생</h2>
	
	담당자에 문의해 주세요 email : ....
	
	<ul>
		<c:forEach var="stack" items="${exception.getStackTrace()}">
			<li>${stack.toString()}</li>
		</c:forEach>
	</ul>
	
</body>
</html>