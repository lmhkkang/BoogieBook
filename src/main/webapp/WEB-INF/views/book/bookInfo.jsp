<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Info</title>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/book/bookInfo.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<c:set var="bookInfoDto" value="${bookInfoDto}"/>
	<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="container">
		<div class="subContainer1">
			<div id="bookInfo">
				<hr />
				<div id="bookImg">
					<img src="${bookInfoDto.img_path}" style="width: 190px; height: 280px" />
				</div>
				<div id="bookTextInfo">
					<p>${bookInfoDto.book_name}</p>
					<p>${bookInfoDto.author} | ${bookInfoDto.publisher} | ${bookInfoDto.publish_date}</p>
					<p>DB에서 가져올 평점</p>
					<p>${bookInfoDto.price}</p>
					<p>DB에서 가져올 줄거리 -----------------------------------------</p>

				</div>
				<hr />
			</div>
			<div id="buttons">
				<button type="button" class="btn" onclick="">장바구니담기</button>
				<button type="button" class="btn" onclick="">바로구매</button>
			</div>
		</div>

		<div class="subContainer2">
			<h3 style="text-align: left; margin-left: 55px; margin-bottom: 0px;">회원
				리뷰</h3>
			<hr />
			<form action="#" method="get">
				<div id="review">
					<div id="commentArea">
						<textarea rows="4" cols="80" id="comment">

                        </textarea>
						<button id="btn_review" onclick="">확인</button>
					</div>
					<div id="starArea">
						<p class="star_rating">
							<a href="#" class="on">★</a> 
							<a href="#" class="">★</a> 
							<a href="#" class="">★</a> 
							<a href="#" class="">★</a> 
							<a href="#" class="">★</a>
						</p>
					</div>
				</div>
			</form>
		<c:if test="${reviewList.size() > 0}">
			<c:forEach var="reviewDto" items="${reviewList}">
				<hr style="margin: 0px 70px 10px 70px;"/>
	           	<div id="memberReview">
	                <div>아이디 &nbsp; ${reviewDto.review_date}</div>
	                <div> ${reviewDto.content}</div>
	                <div>평점 : ★★★★★ </div>
	            </div>
			</c:forEach>
			<hr style="margin: 0px 70px 10px 70px;"/>
		</c:if>
			
		</div>
	</div>
	<div id="todaysBook"></div>
	<jsp:include page="../../../footer.jsp"></jsp:include>
	<script>
    $( ".star_rating a" ).click(function() {
     $(this).parent().children("a").removeClass("on");
     $(this).addClass("on").prevAll("a").addClass("on");
     return false;
});
</script>
</body>
</html>