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
            <div class="section1_r">
                <div class="section2">
                    <div class="interest">
                        
                        <div class="interest_body">
                            <div class="interest_img"><img width="100%" height="100%" src="${searchDto.img_path}"></div>
                            <div class="interest_subject_form">
                                <div class="interest_sub">
                                    <div class="interest_subject">
                                        <div class="interest_subject1">${searchDto.publish_date} </div>
                                        <div class="interest_subject2"><b>${searchDto.book_name}</b></div>
                                        <div class="interest_subject3">인터넷 판매가: <b style="color: red">${searchDto.price}원</b> (${searchDto.author} | ${searchDto.publisher})</div>
                                    </div>
                                </div>
                                <div class="interest_des">
                                 
                                </div>
                                <div class="interest_btn">
                                    <button onclick="">바로 구매하기</button>
                                    <button>장바구니 담기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        	</div>
        
        </c:forEach>
        </c:if>
        </div>
        
        <div align="center">
		<c:if test="${count>0}">
			<c:set var="pageBlock" value="${3}"/>
			<fmt:parseNumber var="pageCount" value="${count/boardSize+(count%boardSize==0 ? 0:1)}" integerOnly="true"/><%--전체페이지수 --%>
			
			<%--
				int startPage=(int)((currentPage-1)/pageBlock)*pageBlock+1; 소수점나오면 안대서 int형으로
										(3-1)=2/10=0*10=0+1=1
				int endPage=startPage+pageBlock-1;
									1+10-1=10
			 --%>
			 <fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
			 <c:set var="startPage" value="${result*pageBlock+1}"/>
			 <c:set var="endPage" value="${startPage+pageBlock-1}"/>
			 
			 <c:if test="${endPage > pageCount}">
			 	<c:set var="endPage" value="${pageCount}" />
			 </c:if>
			 
			 <c:if test="${startPage > pageBlock}">
			 	<a href="${root}/search/searchOk.do?pageNumber=${startPage-pageBlock}&keyword=${keyword}">[이전]</a>
			 </c:if>
			 
			 <c:forEach var="i" begin="${startPage}" end="${endPage}">
			 	<a href="${root}/search/searchOk.do?pageNumber=${i}&keyword=${keyword}">[${i}]</a>
			 </c:forEach>
			 
			 <c:if test="${endPage < pageCount}">
			 	<a href="${root}/search/searchOk.do?pageNumber=${startPage+pageBlock}&keyword=${keyword}">[다음]</a>
			 </c:if>
		</c:if>
	</div>
        
        <jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>