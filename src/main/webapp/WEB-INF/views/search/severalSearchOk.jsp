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
	
	href="${root}/resources/css/index/index_footer.css" />
	<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_header.css" />
	<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/search/search_result.css" />
	<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/search/serSearch.css" />
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>	
</head>


<body>
<jsp:include page="../../../header.jsp"></jsp:include>
	<c:if test="${count0==0 ||searchResult0.size()==0}">		
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red;">${keyword0}</b>"검색결과 없음</div>
		</c:if>
	<c:if test="${searchResult0.size()>0}">
	
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword0}</b>"검색결과 총<a href="${root}/search/searchOk.do?keyword=${keyword0}">${searchResult0.size()}</a>건</div>
	
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult0}" end="3">
	           
			<div class="books">
				<div class="img_file"><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></a></div>
				<div class="book_info">
					<ul>
						<li><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><b style="font-size: 15px;">${searchDto.book_name}</b></a></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${count1==0 ||searchResult1.size()==0}">		
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword1}</b>"검색결과 없음</div>
		</c:if>
       <c:if test="${searchResult1.size()>0}">
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword1}</b>"검색결과 총 <a href="${root}/search/searchOk.do?keyword=${keyword1}">${searchResult1.size()}</a>건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult1}" end="3">
	           
			<div class="books">
				<div class="img_file"> <a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><img  width="100%" height="100%" src="${searchDto.img_path}"></img></a></div>
				<div class="book_info">
					<ul>
						<li><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><b style="font-size: 15px;">${searchDto.book_name}</b></a></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${count2==0 ||searchResult2.size()==0}">		
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword2}</b>"검색결과 없음</div>
		</c:if>
       <c:if test="${searchResult2.size()>0}">
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword2}</b>"검색결과 총 <a href="${root}/search/searchOk.do?keyword=${keyword2}">${searchResult2.size()}</a>건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult2}" end="3">
	           
			<div class="books">
				<div class="img_file"><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></a></div>
				<div class="book_info">
					<ul>
						<li><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><b style="font-size: 15px;">${searchDto.book_name}</b></a></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		
        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${count3==0 ||searchResult3.size()==0}">		
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword3}</b>"검색결과 없음</div>
		</c:if>
       <c:if test="${searchResult3.size()>0}">
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword3}</b>"검색결과 총 <a href="${root}/search/searchOk.do?keyword=${keyword3}">${searchResult3.size()}</a>건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult3}" end="3">
	           
			<div class="books">
				<div class="img_file"><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></a></div>
				<div class="book_info">
					<ul>
						<li><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><b style="font-size: 15px;">${searchDto.book_name}</b></a></li>
						<li>${searchDto.author} | ${searchDto.publisher}</li>
						<li><b style="color: red">${searchDto.price}원</b></li>
					</ul>
				</div>
			</div>
		        
       </c:forEach>
       </div>
       </c:if>
       
       <c:if test="${count4==0 ||searchResult4.size()==0}">		
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword4}</b>"검색결과 없음</div>
		</c:if>
       <c:if test="${searchResult4.size()>0}">
		<div class="result_top" id="keyword" style="margin-left: 145px">"<b style="color:red">${keyword4}</b>"검색결과 총 <a href="${root}/search/searchOk.do?keyword=${keyword4}">${searchResult4.size()}</a>건</div>
		<div class="row_all">
		<c:forEach var="searchDto" items="${searchResult4}" end="3">
	           
			<div class="books">
				<div class="img_file"><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"> <img  width="100%" height="100%" src="${searchDto.img_path}"></img></a></div>
				<div class="book_info">
					<ul>
						<li><a href="${root}/book/bookInfo.do?book_id=${searchDto.book_id}"><b style="font-size: 15px;">${searchDto.book_name}</b></a></li>
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