<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<c:if test="${check == 1}">
		<script type="text/javascript">
			alert("이메일 전송 완료! 이메일을 확인하세요.");

		    setTimeout(function() {
		    opener.location.reload(); //부모창 리프레쉬
		    self.close(); //현재창 닫기
		    }, 500); // 2초후 실행 1000당 1초

		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("아이디와 이메일을 확인하세요.");
			location.href="${root}/member/forgetPassword.do";
		</script>
	</c:if>
</body>
</html>