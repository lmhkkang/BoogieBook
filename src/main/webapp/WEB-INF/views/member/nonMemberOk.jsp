<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<c:if test="${memberDto.member_id != null}">
		<script type="text/javascript">
		    setTimeout(function() {
		    opener.location.href ="${root}/member/nonMember.do?username=${memberDto.name}&email=${memberDto.email}"; 
		    self.close(); //현재창 닫기
		    }, 500); // 2초후 실행 1000당 1초
		</script>
	</c:if>
	
	<c:if test="${memberDto.member_id == null}">
		<script type="text/javascript">
			alert("입력하신 정보가 존재하지 않습니다.");
			location.href="${root}/member/login.do";
			$("#username").focus();
		</script>
	</c:if>
</body>
</html>