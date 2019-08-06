<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">
<title>shop</title>
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap"
	rel="stylesheet">

<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_header.css" />
<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_content.css" />
<link rel="styleSheet" type="text/css"
	href="${root}/resources/css/index/index_footer.css" />
</head>
<body>
<jsp:include page="./header.jsp"></jsp:include>
	<div id="content">
		<div class="section1">
			<div class="center" id="center">
				<div class="slide_banner">
					<div class="slideshow-container">
						<div class="mySlides fade">
							<div class="numbertext">1 / 3</div>
							<img src="http://placehold.it/300x100" style="width: 100%">
							<div class="text">Caption One</div>
						</div>

						<div class="mySlides fade">
							<div class="numbertext">2 / 3</div>
							<img src="http://placehold.it/300x100" style="width: 100%">
							<div class="text">Caption Two</div>
						</div>

						<div class="mySlides fade">
							<div class="numbertext">3 / 3</div>
							<img src="http://placehold.it/300x100" style="width: 100%">
							<div class="text">Caption Three</div>
						</div>

					</div>
					<br>

					<div style="text-align: center">
						<span class="dot"></span> <span class="dot"></span> <span
							class="dot"></span>
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
									<div class="todayBook_subject1">책 소제목</div>
									<div class="todayBook_subject2">
										<b>책 제목</b>
									</div>
									<div class="todayBook_subject3">
										인터넷 판매가: <b style="color: red">19,800원</b> (출판사 | 지은이)
									</div>
								</div>
								<div class="todayBook_subject_img"></div>
							</div>
							<div class="todayBook_des">책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책
								내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용
								미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기
								책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기 책 내용 미리보기</div>
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
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
								<li><div class="best_img"></div>
									<div class="th">
										<a class="th_txt">[분야]</a>
									</div>
									<div class="su">
										<a class="su_txt">제목</a>
									</div></li>
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
							<div class="spot_inside">
								<b>지점안내<br /></b><b>바로가기</b>
							</div>
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
	<jsp:include page="./footer.jsp"></jsp:include>

</body>
</html>