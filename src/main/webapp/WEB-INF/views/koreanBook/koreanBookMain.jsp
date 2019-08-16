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
</head>

<script type="text/javascript">
	function head(){
	$("#ul_center > li:eq(0)").css("background","white");
	$("#ul_center > li:eq(0) > a").css("color","#5e6b9e");
	}
</script>
<body onload="head();">
	<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="center">
		<div class="section1_l">
			<ul class="book_list">
				<li><a href="${root}/koreanBook/koreanBookMain.do">종합</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=소설">소설</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=시/에세이">시/에세이</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=자기계발">자기계발</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=가정/육아">가정/육아</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=건강">건강</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=인문">인문</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=역사/문화">역사/문화</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=취업/수험서">취업/수험서</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=취미/실용/스포츠">취미/실용/스포츠</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=예술/대중문화">예술/대중문화</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=여행">여행</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=잡지">잡지</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=만화">만화</a></li>
				<li><a href="${root}/koreanBook/koreanBookMain.do?bookType=컴퓨터/IT">컴퓨터/IT</a></li>
			</ul>
		</div>
	<c:set var = "num" value = "${(currentPage-1)*5 + 1}"/>
		<div class="section1_r" style="height: 1570px;">
			<div class="section2">
				<div class="interest">
					<div class="interest_top" style="margin-bottom: 20px;">
						<div class="interest_top_l" style="font-weight: bold;">${bookType}</div>
					</div>
					<c:forEach items="${koreanBookList}" var="koreanBook">
					<div style="width: 700px; height: 300px; border:0px solid red;">
					<div style="float:left; font-size: 14px; font-weight: bold;">${num}.</div>	
					<c:set var = "num" value = "${num+1}"/>							
						<div class="interest_body" style="float:left; width: 650px;">
							<div class="interest_img">
								<a href="${root}/book/bookInfo.do?book_id=${koreanBook.book_id}"><img src="${koreanBook.img_path}" width="100%" height="100%"></a>
							</div>
							<div class="interest_subject_form">
								<div class="interest_sub">
									<div class="interest_subject">
										<div class="interest_subject1">
											<fmt:formatDate value="${koreanBook.publish_date}"
												pattern="yyyy-MM-dd" />
										</div>
										<div class="interest_subject2">
											<a href="${root}/book/bookInfo.do?book_id=${koreanBook.book_id}"><b>${koreanBook.book_name}</b></a>
										</div>
										<div class="interest_subject3">
											인터넷 판매가: <b style="color: red"><fmt:formatNumber value="${koreanBook.price}" pattern="#,###" />원</b>
											(${koreanBook.publisher} | ${koreanBook.author})
										</div>
									</div>
								</div>
								<div class="interest_des" id="interest_des"></div>
								<div class="interest_btn">
									<button type="button" class="btn" style="border: 1px solid #5e6b9e;" onclick="javascript:moveToCart('${root}','${koreanBook.book_id}','1')">장바구니담기</button>
									<button type="button" class="btn" style="border: 1px solid #5e6b9e;" onclick="javascript:moveToOrderForm('${root}','${koreanBook.book_id}','1')">바로구매</button>
								</div>
							</div>
						</div>		
						</div>
					</c:forEach>			
				</div>
			</div>				
		</div>
		<div align="center" style="margin-bottom: 30px; margin-top: 25px; margin-left: 20px;">
				<c:if test="${count > 0}">
					<c:set var="pageBlock" value="${5}"/>
					 <fmt:parseNumber var="pageCount"  integerOnly="true"
						 value="${count/boardSize+(count%boardSize==0 ? 0:1)}"/>
						 
					<%--
						int startPage=(int)((currentPage-1)/pageBlock)*pageBlock+1;
						                             (3-1)=2/10=0*10=0+1=1
						int endPage=startPage+pageBlock-1;
						                           1+10-1=10
					 --%>	 
					 
					 <fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}"
					    integerOnly="true"/>
					 <c:set var="startPage" value="${result * pageBlock+1 }"/>
					 <c:set var="endPage" value="${startPage+pageBlock-1}"/>
					 
					 <c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}"/>
					</c:if>	
					
					<c:if test="${startPage > pageBlock}">
						<a href="${root}/koreanBook/koreanBookMain.do?pageNumber=${startPage-pageBlock}">
							[이전]</a>
					</c:if>
					
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="${root}/koreanBook/koreanBookMain.do?pageNumber=${i}">[${i}]</a>
					</c:forEach>
					
					<c:if test="${endPage < pageCount}">
						<a href="${root}/koreanBook/koreanBookMain.do?pageNumber=${startPage+pageBlock}">
							[다음]</a>
					</c:if>
				</c:if>
			</div>
	</div>
	<jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>