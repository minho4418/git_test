<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>게시물 추가</h2>
	<form action="${path}/board/add" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${sessionScope.email}" readonly> </td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="25"></textarea> </td>
			</tr>
			<tr>
				<th>파일 <br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
			
		</table>
	
	</form>
</div>	
</body>
</html>