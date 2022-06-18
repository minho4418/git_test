<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=476wf30zkc"></script>
	<script>
		//document가 ready후 
		$(function () { 
			
			//map id에 맵생성
			var map = new naver.maps.Map('map', {
			    center: new naver.maps.LatLng(37.484746663141095, 126.93006829643338),//경도,위도 
			    zoom: 17
			});
			//마커생성
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.484746663141095, 126.93006829643338),
			    map: map
			});
		
		});
			
	</script>  
  
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div id="map" style="width:100%;height:400px;"></div>
</div>	
	
</body>
</html>