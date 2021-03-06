<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:set var="num" value="1"/>

<head>
<meta charset="UTF-8">
<title>shop</title>
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
		
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/recommend/recommend_content.css" />
	<script type="text/javascript" src="${root}/resources/javascript/book/bookInfo.js"></script>
	<script type="text/javascript" src="${root}/resources/javascript/xhr/xhr.js"></script>
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
</head>
<script type="text/javascript">
	function head(){
	$("#ul_center > li:eq(1)").css("background","white");
	$("#ul_center > li:eq(1) > a").css("color","#5e6b9e");
	}
</script>
<body onload="head();">
	<jsp:include page="../../../header.jsp"></jsp:include>	
	<div class="center">
		<div class="section1_l">
			<ul class="book_list" id="book_menu">
				<li><a href="${root}/bestSeller/bestSellerMain.do">종합</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=소설">소설</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=시/에세이">시/에세이</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=자기계발">자기계발</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=가정/육아">가정/육아</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=건강">건강</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=인문">인문</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=역사/문화">역사/문화</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=취업/수험서">취업/수험서</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=취미/실용/스포츠">취미/실용/스포츠</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=예술/대중문화">예술/대중문화</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=여행">여행</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=잡지">잡지</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=만화">만화</a></li>
				<li><a href="${root}/bestSeller/bestSellerMain.do?bookType=컴퓨터/IT">컴퓨터/IT</a></li>
			</ul>
		</div>
		<div class="section1_r" style="height: 3100px;">
			<div class="section2">
				<div class="interest">
					<div class="interest_top" style="margin-bottom: 20px;">
						<div class="interest_top_l" style="font-weight: bold;">${bookType}</div>
					</div>
					<c:forEach items="${bestSellerList}" var="bestSeller">
					<div style="width: 700px; height: 300px; border:0px solid red;">
					<div style="float:left; font-size: 14px; font-weight: bold;">${num}.</div>	
					<c:set var = "num" value = "${num+1}"/>							
						<div class="interest_body" style="float:left; width: 650px;">
							<div class="interest_img">
								<a href="${root}/book/bookInfo.do?book_id=${bestSeller.book_id}&page=bestSeller"><img src="${bestSeller.img_path}" width="100%" height="100%"></a>
							</div>
							<div class="interest_subject_form">
								<div class="interest_sub">
									<div class="interest_subject">
										<div class="interest_subject1">
											<fmt:formatDate value="${bestSeller.publish_date}"
												pattern="yyyy-MM-dd" />
										</div>
										<div class="interest_subject2">
											<a href="${root}/book/bookInfo.do?book_id=${bestSeller.book_id}&page=bestSeller"><b>${bestSeller.book_name}</b></a>
										</div>
										<div class="interest_subject3">
											인터넷 판매가: <b style="color: red"><fmt:formatNumber value="${bestSeller.price}" pattern="#,###" />원</b>
											(${bestSeller.publisher} | ${bestSeller.author})
										</div>
									</div>
								</div>
								<div class="interest_des" id="interest_des"></div>
								<div class="interest_btn">
									<button type="button" class="btn" style="border: 1px solid #5e6b9e;" onclick="javascript:moveToCart2('${root}','${bestSeller.book_id}','1')">장바구니담기</button>
									<button type="button" class="btn" style="border: 1px solid #5e6b9e;" onclick="javascript:moveToOrderForm2('${root}','${bestSeller.book_id}','1')">바로구매</button>
								</div>
							</div>
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