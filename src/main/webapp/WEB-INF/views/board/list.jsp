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
	<h2>게시물 리스트</h2>
	<form action="${path}/board/list">
		<select name="findkey">
			<option value="email" <c:out value="${page.findkey=='email'?'selected':''}"/>>이메일</option>
			<option value="subject" <c:out value="${page.findkey=='subject'?'selected':''}"/>>제목</option>
			<option value="content" <c:out value="${page.findkey=='content'?'selected':''}"/>>내용</option>
			<option value="subcon" <c:out value="${page.findkey=='subcon'?'selected':''}"/>>제목+내용</option>
		</select>
		<input type="text" name="findvalue" value="${page.findvalue}">
		<button>조회</button>
	</form>
<%-- 	${blist} --%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이메일</th>
			<th>제목</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>싫어요</th>
			<th>등록일자</th>
			<th>수정일자</th>
		</tr>
		<c:forEach var="board" items="${blist}">
			<tr>
				<td>${board.bnum}</td>
				<td>${board.email}</td>
				<td><a href="${path}/board/detail?bnum=${board.bnum}">${board.subject}</a> </td>
				<td>${board.readcnt}</td>
				<td>${board.likecnt}</td>
				<td>${board.dislikecnt}</td>
				<td><fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
		</c:forEach>
	
	</table>
	<%-- ${page} --%>
	<hr>
	<c:if test="${page.startPage != 1}">
		<a href="${path}/board/list?curPage=${page.startPage-1}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="${path}/board/list?curPage=${i}">${i}</a> 
	</c:forEach>

	<c:if test="${page.endPage<page.totPage}">
		<a href="${path}/board/list?curPage=${page.endPage+1}">다음</a>
	</c:if>
</div>	
</body>
</html>