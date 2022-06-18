<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>회원정보</h2>
	<%-- ${member} --%>
	
	<table border="1">
		<tr>
			<th>이메일</th>
			<td>${member.email}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.username}</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>${member.zipcode}</td>
		</tr>
		<tr>
			<th>도로명주소</th>
			<td>${member.addrload}</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${member.addrdetail}</td>
		</tr>
		<tr>
			<th>파일명</th>
			<td>${member.filename}
				<hr>
				<!-- servlet-context.xml 에 resources 태그에 정의 -->
				<img alt="" src="${path}/savedir/${member.filename}" width="200">
			</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><fmt:formatDate value="${member.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${member.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
	</table>
	
</div>	
</body>
</html>