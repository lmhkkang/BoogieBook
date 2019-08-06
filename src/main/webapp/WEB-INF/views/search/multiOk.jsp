<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">
<title>searchOk</title>
<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/search/search_result.css" />
<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_footer.css" />
<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_header.css" />
</head>
<body>
	<jsp:include page="../../../header.jsp"></jsp:include>

	<div class="center">
		<c:if test="${count==0 ||searchResult.size()==0}">
			<p>전체 "${keyword}"검색결과 총 0건</p>
		</c:if>
		<c:if test="${searchResult.size()>0}">
			<div>전체 "${keyword}"검색결과 총 ${searchResult.size()}건</div>
			<c:forEach var="searchDto" items="${searchPageResult}">
				<div class="interest_sub">
					<div class="interest_subject">
						<div class="interest_subject1">${searchDto.publish_date}</div>
						<div class="interest_subject2">
							<b>${searchDto.book_name}</b>
						</div>
						<div class="interest_subject3">
							인터넷 판매가: <b style="color: red">${searchDto.price}원</b>
							(${searchDto.author} | ${searchDto.publisher})
						</div>
					</div>
				</div>

			</c:forEach>
		</c:if>
	</div>
</body>
</html>