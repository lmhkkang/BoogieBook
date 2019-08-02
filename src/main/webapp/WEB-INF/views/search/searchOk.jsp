<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

            <div class="section1_r">
                <div class="section2">
                    <div class="interest">
                        
                        <div class="interest_body">
                            <div class="interest_img"><img src=""></div>
                            <div class="interest_subject_form">
                                <div class="interest_sub">
                                    <div class="interest_subject">
                                        <div class="interest_subject1">책 소제목 </div>
                                        <div class="interest_subject2"><b>책 제목</b></div>
                                        <div class="interest_subject3">인터넷 판매가: <b style="color: red">0원</b> (출판사 | 지은이)</div>
                                    </div>
                                </div>
                                <div class="interest_des">
                                    책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기
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
        </div>
        <jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>