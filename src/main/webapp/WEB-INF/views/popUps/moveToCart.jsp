<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니로 이동하시겠습니까?</title>
	<link rel="stylesheet" type="text/css" href="${root}/resources/css/popUps/popUps.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript" src="${root}/resources/javascript/popUps/popUps.js"></script>
</head>
<body>
<c:set var="book_id" value="${book_id}"/>
	<div class="popUpContent">
		<div class="popUpMessageDiv" style="width: 85%;">
			<b>장바구니로 이동하시겠습니까?</b>
		</div>
		<div class="popUpButtonDiv" style="margin-top: 40px;">
			<button type="button" class="btn btn-primary" onclick="parentWindowToCart('${root}','${book_id}')">확인</button> 
			<button type="button" class="btn btn-outline-primary" onclick="javascript:'window.close();'">취소</button>
		</div>
	</div>
</body>
</html>