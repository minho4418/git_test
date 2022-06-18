<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>가입 현황</h2>
	<form action="${path}/analysis/joininfo">
		가입일자 : <input type="date" name="sdate" value="${param.sdate}">
			~ <input type="date" name="edate" value="${param.edate}">
		<button type="submit">조회</button>
	</form>
	<hr>
	<%-- ${jilist} --%>
	<table border="1">
		<tr>
			<th>가입날짜</th>
			<th>일반가입수</th>
			<th>네이버가입수</th>
			<th>카카오가입수</th>
		</tr>
		<c:forEach var="joininfo" items="${jilist}">
			<tr>
				<td>${joininfo.joindate}</td>
				<td>${joininfo.join0}</td>
				<td>${joininfo.join1}</td>
				<td>${joininfo.join2}</td>
			</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>