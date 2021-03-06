<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴완료</title>
</head>
<body>
	<c:if test="${check == 1}">
		<c:remove var="id" scope="session"/>
		<c:remove var="name" scope="session"/>
		<c:remove var="snsNum" scope="session"/>
		<script type="text/javascript">
			alert("회원탈퇴 완료");
			location.href="${root}/index.jsp";
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("회원탈퇴 실패. 비밀번호를 확인하세요.");
			location.href="${root}/member/withdrawal.do?id=${id}";
		</script>
	</c:if>
</body>
</html>