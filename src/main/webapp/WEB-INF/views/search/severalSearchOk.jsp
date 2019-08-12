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
	<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/search/serSearch.css" />
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>	
</head>
<script type="text/javascript">
$( document ).ready( function() {
	var a=${keyword0};
	if(a!='')
	$('.book_info').css('background-color', 'yellow', 'color', 'red');

}
</script>

<body>
<jsp:include page="../../../header.jsp"></jsp:include>
	<c:if test="${count0==0 ||searchResult0.size()==0}">
		<p>전체 "${keyword}"검색결과 총 0건</p>
		</c:if>
	<c:if test="${searchResult0.size()>0}">
		<div id="keyword">전체 "${keyword0}"검색결과 총 ${searchResult0.size()}건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult0}" end="3">
	           
			<div class="books">
				<div class="img_file"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></div>
				<div class="book_info">
					<ul>
						<li><b>${searchDto.book_name}</b></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${searchResult1.size()>0}">
		<div>전체 "${keyword1}"검색결과 총 ${searchResult1.size()}건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult1}" end="3">
	           
			<div class="books">
				<div class="img_file"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></div>
				<div class="book_info">
					<ul>
						<li><b>${searchDto.book_name}</b></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${searchResult2.size()>0}">
		<div>전체 "${keyword2}"검색결과 총 ${searchResult2.size()}건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult2}" end="3">
	           
			<div class="books">
				<div class="img_file"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></div>
				<div class="book_info">
					<ul>
						<li><b>${searchDto.book_name}</b></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${searchResult3.size()>0}">
		<div>전체 "${keyword3}"검색결과 총 ${searchResult3.size()}건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult3}" end="3">
	           
			<div class="books">
				<div class="img_file"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></div>
				<div class="book_info">
					<ul>
						<li><b>${searchDto.book_name}</b></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${searchResult4.size()>0}">
		<div>전체 "${keyword4}"검색결과 총 ${searchResult4.size()}건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult4}" end="3">
	           
			<div class="books">
				<div class="img_file"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></div>
				<div class="book_info">
					<ul>
						<li><b>${searchDto.book_name}</b></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
</body>
</html>