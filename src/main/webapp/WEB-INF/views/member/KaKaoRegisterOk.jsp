<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<c:if test="${check == 1}">
		<c:set var="id" value="${id}" scope="session"/> <%--application --%>
		<c:set var="name" value="${name}" scope="session"/> <%--application --%>
		<c:set var="snsNum" value="${snsNum}" scope="session"/> <%--application --%>
		
		<script type="text/javascript">
			alert("회원가입 성공");
			location.href ="${root}/index.jsp"; //부모창 리프레쉬
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("회원가입 실패");
		</script>
	</c:if>
</body>
</html>