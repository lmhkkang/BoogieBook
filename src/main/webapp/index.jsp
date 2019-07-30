<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
	<head>
		<meta charset="UTF-8">
		<title>shop</title>
        <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_header.css"/>
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_content.css"/>
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_footer.css"/>
	
    <script type="text/javascript">
        var slideIndex = 0;
        showSlides();

        function showSlides() {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            for (i = 0; i < slides.length; i++) {
               slides[i].style.display = "none";  
            }
            slideIndex++;
            if (slideIndex > slides.length) {slideIndex = 1}    
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            $(slides[slideIndex-1]).css({display:"block"});
            setTimeout(showSlides, 5000); // Change image every 2 seconds
        }

    </script>
    </head>
	<body>
		<header>
			<div class="gnb">
				<ul class="center" id="center">
					<li class="topHeader_l"><a href="#">매장안내</a><span>∨</span></li>
					<li class="topHeader_l"><a href="#">회원혜택</a><span>∨</span></li>
					<li></li>
					<li class="topHeader_r"><a href="#"></a></li>
					<li class="topHeader_r"><a href="#">로그인</a></li>
					<li class="topHeader_r"><a href="#">회원가입</a></li>
					<li class="topHeader_r"><a href="#">고객센터</a></li>
					<li class="topHeader_r"><a href="#">주문배송</a></li>
				</ul>
			</div>
			
            <div id="center">
                <div class="middleHeader">
                    <div class="logo">LOGO</div>
                    <div class="search_form">
                        <div class="search_top"></div>
                        <div class="search"></div>
                    </div>
                </div>
            </div>
				
			<div class="lnb">
                <div id="center">
                    <ul class="center">
                        <li><a href="#">국내도서</a></li>
                        <li><a href="#">베스트셀러</a></li>
                        <li><a href="#">신간도서</a></li>
                        <li><a href="#">상세검색</a></li>
                        <li><a href="#">추천도서</a></li>
                        <li><a href="#">매장안내</a></li>
                    </ul>
                </div>
			</div>
		</header>
		
		<div id="content">
			<div class="section1">
                <div class="center" id="center">
                    <div class="slide_banner">
                       <div class="slideshow-container">
                            <div class="mySlides fade">
                              <div class="numbertext">1 / 3</div>
                              <img src="http://placehold.it/300x100" style="width:100%">
                              <div class="text">Caption One</div>
                            </div>

                            <div class="mySlides fade">
                              <div class="numbertext">2 / 3</div>
                              <img src="http://placehold.it/300x100" style="width:100%">
                              <div class="text">Caption Two</div>
                            </div>

                            <div class="mySlides fade">
                              <div class="numbertext">3 / 3</div>
                              <img src="http://placehold.it/300x100" style="width:100%">
                              <div class="text">Caption Three</div>
                            </div>

                            </div>
                            <br>

                            <div style="text-align:center">
                              <span class="dot"></span> 
                              <span class="dot"></span> 
                              <span class="dot"></span> 
                            </div>
                    </div>
                </div>
			</div>
			
			<div class="section2">
                <div class="center" id="center">
                    <div class="tmp1">
                        <div class="todayBook_form">
                            <div class="todayBook_img"></div>
                            <div class="todayBook_subject_form">
                                <div class="todayBook_sub">
                                    <div class="todayBook_subject">
                                        <div class="todayBook_subject1">책 소제목 </div>
                                        <div class="todayBook_subject2"><b>책 제목</b></div>
                                        <div class="todayBook_subject3">인터넷 판매가: <b style="color: red">19,800원</b> (출판사 | 지은이)</div>
                                    </div>
                                    <div class="todayBook_subject_img"></div>
                                </div>
                                <div class="todayBook_des">
                                    책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기  
                                </div>
                            </div>
                        </div>
                    </div>
				</div>
			</div>
            
            <div class="section3">
                <div class="center" id="center">
                    <div class="tmp2">
                        <div class="best_header">베스트셀러</div>
                        <div class="best_body">
                            <ul>
                                <div class="best_sort">
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                    <li><div class="best_img"></div><div class="th"><a class="th_txt">[분야]</a></div><div class="su"><a class="su_txt">제목</a></div></li>
                                </div>
                            </ul>
                        </div>
                    </div>
				</div>
			</div>
            
            <div class="section4">
                <div class="center" id="center">
                    <div class="tmp3">
                        <div class="spot_form">
                            <div class="spot_l">
                                <div class="spot_inside"><b>지점안내<br/></b><b>바로가기</b></div>
                            </div>
                            <div class="spot_m"></div>
                            <div class="spot_r">
                                <div class="spot_r_inside">
                                    <ul class="spot_list">
                                        <li><a>종각 종로본점</a></li>
                                        <li><a>스타필드 코엑스몰점</a></li>
                                        <li><a>강남역점</a></li>
                                        <li><a>서초역점</a></li>
                                        <li><a>여의도 IFC몰점</a></li>
                                        <li><a>김포공항 롯데점</a></li>
                                        <li><a>홍대점</a></li>
                                        <li><a>가산 마리오점</a></li>
                                        <li><a>강남 포스코점</a></li>
                                        <li><a>동대문점</a></li>
                                        <li><a>신촌역점</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
				</div>
			</div>
            
		</div>
	
		<footer>
            <div class="footer_section1">
                <div class="center" id="center">
                    <div class="sec1">
                        <ul>
                    		<li><a href="#">회사소개</a></li>
                    		<li><a href="#">이용약관</a></li>
                    		<li><a href="#">개인정보처리방침</a></li>
                    		<li><a href="#">고객센터</a></li>
                    		<li><a href="#">협력사여러분</a></li>
                    		<li><a href="#">제휴·제안</a></li>
                    		<li><a href="#">광고문의</a></li>
                    		<li><a href="#">채용정보</a></li>
                    		<li><a href="#">서비스 전체보기</a></li>
                    	</ul>
                    </div>
                </div>
            </div>
             <div class="footer_section2">
                <div class="center" id="center">
                    <div class="sec2">
                        <div class="footer_img">img</div>
                        <div class="last_footer_l">           
                            ㈜ 교보문고   서울시 종로구 종로 1   대표이사 : 박영규<br/>
                            사업자등록번호 : 102-81-11670<br/>
                            <b>대표전화 : 1544-1900 (발신자 부담전화)</b>  팩스 : 0502-987-5711 (지역번호공통)<br/>
                            서울특별시 통신판매업신고번호 : 제 653호 ▶사업자정보확인<br/>
                            COPYRIGHT(C) KYOBO BOOK CENTRE ALL RIGHTS RESERVED.<br/>
                        </div>
                        <div class="last_footer_r">
                            LG U+ 구매안전서비스   ▶서비스 가입 확인<br/>
                            고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한<br/>
                            LG유플러스의 구매안전서비스를 이용하실 수 있습니다.
                        </div>
                    </div>
                </div>
            </div>
		</footer>
	</body>
</html>