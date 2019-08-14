<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<script src="${root}/resources/javascript/member/login_js.js"></script>
<c:set var="root" value="${pageContext.request.contextPath}"/>
</head>
<script type="text/javascript">
</script>
<body>
	<c:if test="${snsNum != 1}">
		<script type="text/javascript">
			alert("로그아웃 되었습니다.");
			location.href="${root}/index.jsp";
		</script>
	</c:if>

	<c:if test="${snsNum == 1}">
		<script type="text/javascript">
			alert("로그아웃 되었습니다.");
			location.href="${root}/index.jsp";
		</script>		
	</c:if>
	
	<c:remove var="id" scope="session"/>
	<c:remove var="name" scope="session"/>
	<c:remove var="snsNum" scope="session"/>
		
</body>
</html>