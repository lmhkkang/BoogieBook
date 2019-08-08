<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">
<title>shop</title>
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
	
	<script type="text/javascript" src="${root}/resources/javascript/review/reviewWrite.js"></script>
	<script type="text/javascript" src="${root}/resources/javascript/review/reviewDelete.js"></script>
	<script type="text/javascript" src="${root}/resources/javascript/review/reviewSelect.js"></script>
	<script type="text/javascript" src="${root}/resources/javascript/xhr/xhr.js"></script>
		
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/book/bookInfo.css" />
</head>
<body>
	<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="center">
		<div class="section1_l">
			<ul class="book_list">
				<li><a>종합</a></li>
				<li><a>소설</a></li>
				<li><a>시/에세이/기행</a></li>
				<li><a>자기계발</a></li>
				<li><a>가정/생활/요리</a></li>
				<li><a>건강/의학/미용</a></li>
				<li><a>인문/교양/철학</a></li>
				<li><a>역사/신화/문화</a></li>
				<li><a>유아</a></li>
				<li><a>어린이</a></li>
				<li><a>예술/대중문화</a></li>
				<li><a>여행/취미/레져</a></li>
				<li><a>잡지</a></li>
				<li><a>만화</a></li>
				<li><a>컴퓨터/IT</a></li>
			</ul>
		</div>
		<div class="section1_r">
			<div class="section2">
				<div class="interest">
					<div class="interest_top">
						<div class="interest_top_l">대분류&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;중분류&nbsp;&nbsp;>&nbsp;&nbsp;소분류</div>
						<div class="interest_top_r">
						</div>
					</div>
					<div class="interest_body">
						<div class="interest_img">
							<img src="${bookInfoDto.img_path}" width="100%" height="100%">
						</div>
						<div class="interest_subject_form">
							<div class="interest_sub">
								<div class="interest_subject">
									<div class="interest_subject1">
										<fmt:formatDate value="${bookInfoDto.publish_date}"
											pattern="yyyy-MM-dd" />
									</div>
									<div class="interest_subject2">
										<a href="#"><b>${bookInfoDto.book_name}</b></a>
									</div>
									<div class="interest_subject3">
										인터넷 판매가: <b style="color: red"><fmt:formatNumber value="${bookInfoDto.price}" pattern="#,###" />원</b>
										(${bookInfoDto.publisher} | ${bookInfoDto.author})
									</div>
								</div>
							</div>
							<div class="interest_des" id="interest_des"></div>
							<div class="interest_btn">
								<button>바로 구매하기</button>
								<button>장바구니 담기</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="section3">
				
			</div>
			
			<div class="section4">
				<div class="review_rate_form">
					<div class="review_rate_l">
						<div class="review_rate_l_top"><b style="font-size: 1.2em;">평점</b>&nbsp;참여 ${reviewList_size}명</div>
						<div class="review_rate_l_middle"></div>
						<div class="review_rate_l_bottom"><b style="font-size: 1.5em;"><fmt:formatNumber value="${rate_average}" pattern="#.#" /></b></div>
					</div>
					<div class="review_rate_r">
						<div class="review_rate_r_top"><b style="font-size: 1.2em;">&nbsp;&nbsp;평가하기</b></div>
						<div class="review_rate_r_middle">
							<div class="radio_form">
								<input type="radio" name="rate_group" id="rate_group" value="1"><img style="height: 21px;" src="${root}/resources/images/mark/1.PNG"/>
								<input type="radio" name="rate_group" id="rate_group" value="2"><img src="${root}/resources/images/mark/2.PNG"/>
								<input type="radio" name="rate_group" id="rate_group" value="3"><img style="height: 23px; widows: 77px;" src="${root}/resources/images/mark/3.PNG"/>
								<input type="radio" name="rate_group" id="rate_group" value="4"><img src="${root}/resources/images/mark/4.PNG"/>
								<input type="radio" name="rate_group" id="rate_group" value="5"><img style="height: 23px; widows: 77px;" src="${root}/resources/images/mark/5.PNG"/>
							</div>
						</div>
						<div class="review_rate_r_bottom">
							<textarea name="review_content" id="review_content"></textarea>
							<button type="button" onclick="writeToServer('${root}','${id}','${book_id}')">등록</button>
						</div>
					</div>
				</div>
				</div>

			
				<div class="review_rate_bottom">
					<div class="listAllDiv" id="listAllDiv">
						<c:forEach var="ReviewDto" items="${reviewList}">
							<div class="review_list_form">
								<div class="review_list_top">
									<div class="reviw_list_id" style="font-size: 1.1em;">${ReviewDto.member_id}</div>
									<div class="reviw_list_date" style="color:#CCCCCC;font-size: 0.9em;"><fmt:formatDate value="${ReviewDto.review_date}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
									<div class="reviw_list_rate"><img src="${root}/resources/images/mark/${ReviewDto.rate}.PNG">${ReviewDto.rate}</div>
								</div>
								<div class="review_list_bottom">
									<div class="review_list_content">${ReviewDto.content}</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>