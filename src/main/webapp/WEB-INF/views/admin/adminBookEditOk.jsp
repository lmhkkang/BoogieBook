<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check > 0}">
		<script type="text/javascript">
			alert("도서 수정 완료");
			location.href="adminBookMng.do"
		</script>
	</c:if>
</body>
</html>