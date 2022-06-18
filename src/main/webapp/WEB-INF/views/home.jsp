<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/home.js"></script>

</head>
<body>
<div class="container">
	<%@include file="header.jsp"%>
	<%-- <%=request.getRealPath("/") %> --%>
	
	<div class="bxslider">
        <div><img src="${path}/resources/images/home1.jpg"></div>
        <div><img src="${path}/resources/images/home2.jpg"></div>
        <div><img src="${path}/resources/images/home3.jpg"></div>
    </div>
</div>	
</body>
</html>