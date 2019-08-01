<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/search/search.css" />
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_footer.css" />
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_header.css" />
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#menu1").click(function(){
			$(".tap").find("li").eq(0).css({"background-color":"#cee7ff"});
			$(".tap").find("a").eq(0).css({"color":"black"});
			$(".tap").find("li").eq(1).css({"background-color":"#003a75"});
			$(".tap").find("a").eq(1).css({"color":"white"});
			$.ajax({
				url:"${root}/views/search/search_detail.html",
				type:"get",
				dataType: "html",
				success: toServer
			})
		});
		
		function toServer(data){
			$("#message1").html(data);
			$("#message2").empty();
		};
		
		
		
		$("#menu2").click(function(){
			$(".tap").find("li").eq(1).css({"background-color":"#cee7ff"});
			$(".tap").find("a").eq(1).css({"color":"black"});
			$(".tap").find("li").eq(0).css({"background-color":"#003a75"});
			$(".tap").find("a").eq(0).css({"color":"white"});
			$.ajax({
				url:"mult_search.html",
				type:"get",
				dataType: "html",
				success: function(data){
					$("#message2").html(data);
					$("#message1").empty();
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="all">
		<div class="tap">
			<ul>
				<li><a href="#" id="menu1">상세검색</a></li>
				<li><a href="#" id="menu2">다권검색</a></li>
				<li><a href="#" id="menu3">쉽게찾기</a></li>
			</ul>
			<ul class="text">
				<li style="background-color: white; border:none; height: 25px;">두 가지 이상 입력시 보다 정확히 검색됩니다.</li>
			</ul>
		</div>
		
		<div  id="message1"></div>
		<div  id="message2"></div>		
		
	</div>
	 <jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>