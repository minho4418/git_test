<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/culture/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header2.jsp" %>
	
	<h2>맛집 글쓰기</h2>
	<form action="${path}/culture/board/add" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>이메일</th>
				<td>${sessionScope.email}</td>
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
					<button>취소</button>
				</td>
			</tr>
			
			
		</table>
	
	</form>
</div>
</body>
</html>