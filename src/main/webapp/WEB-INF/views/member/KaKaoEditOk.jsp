<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<head>
<meta charset="UTF-8">
<title>수정완료</title>
</head>
<body>
	<c:if test="${check == 1}">

		<script type="text/javascript">
			alert("회원정보 수정 완료");
			location.href="${root}/index.jsp";
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("수정실패");
		</script>
	</c:if>
</body>
</html>