<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/search/search.css" />
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>		
	<script type="text/javascript">
	function a(){
		$("#message2").hide();
	}
	$(function(){
		$("#menu1").click(function(){
			$(".tap").find("li").eq(0).css({"background-color":"#cee7ff"});
			$(".tap").find("a").eq(0).css({"color":"black"});
			$(".tap").find("li").eq(1).css({"background-color":"#003a75"});
			$(".tap").find("a").eq(1).css({"color":"white"});
			$("#message2").hide()
			$("#message1").show()
		});
		
		
		
		
		$("#menu2").click(function(){
			$(".tap").find("li").eq(1).css({"background-color":"#cee7ff"});
			$(".tap").find("a").eq(1).css({"color":"black"});
			$(".tap").find("li").eq(0).css({"background-color":"#003a75"});
			$(".tap").find("a").eq(0).css({"color":"white"});
			$("#message1").hide()
			$("#message2").show()
		});
	});
</script>
<title>Insert title here</title>
</head>
<body onload="a()">
<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="all">
		<div class="tap">
			<ul>
				<li><a href="#" id="menu1">상세검색</a></li>
				<li><a href="#" id="menu2">다권검색</a></li>
				<li><a href="#" id="menu3">쉽게찾기</a></li>
			</ul>
			<ul class="text">
				<li style="background-color: white; border:none; height: 25px;">두 가지 이상 입력시 보다 정확히 검색됩니다.</li>
			</ul>
		</div>
		
		<div  id="message1">
		<div class="content">
			<div class="content_menu">
				<ul>
					<li><a href="#">국내도서</a></li>
					<li><a href="#">eBook</a></li>
				</ul>
			</div>
			<div class="content_body_all">
			<div class="content_body1">
				<div class="table">
					<div class="text1">카테고리</div>
					<div class="row">
						<select name="col">
							<option value="1970">1</option>
							<option value="회사원">회사원</option>
							<option value="학생"> 학생</option>
							<option value="전문직">전문직</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</div>

				<div class="table">
					<div class="text1">도서명(ISDN)</div>
					<div class="row">
						<input type="text" name="" value="">
					</div>
				</div>

				<div class="table">
					<div class="text1">저자/역자</div>
					<div class="row">
						<input type="text" name="" value="">
					</div>
				</div>

				<div class="table">
					<div class="text1">출판사</div>
					<div class="row">
						<input type="text" name="" value="">
					</div>
				</div>

			</div>
			<div class="content_body2">
				<div class="table">
					<div class="text1">출판일</div>
					<div class="during">
						<input type="button" value="1개월">
						<input type="button" value="3개월">
						<input type="button" value="6개월">
						<input type="button" value="1년">
					</div>
				</div>
				<div class="table">
				<div class="text1"></div>
				<div class="row">
					<select name="cate">
						<option value="1970"></option>
						<option value="회사원">회사원</option>
						<option value="학생"> 학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
						</select>
						<label>년</label>
						<select name="cate">
						<option value="1970"></option>
						<option value="회사원">회사원</option>
						<option value="학생"> 학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
						</select>
						<label>월 ~</label>
						<select name="cate">
						<option value="1970"></option>
						<option value="회사원">회사원</option>
						<option value="학생"> 학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
						</select>
						<label>년</label>
						<select name="cate">
						<option value="1970"></option>
						<option value="회사원">회사원</option>
						<option value="학생"> 학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
						</select>
						<label>월</label>
				</div>
			</div>
					<div class="table">
						<div class="text1">가격대</div>
						<div class="row">
							<input type="text"/><label>원 부터~</label>
							<input type="text"/><label>까지</label>
						</div>
					</div>

					<div class="table">
						<div class="text1">정렬방법</div>
						<div class="row">
							<select id="state" name="solt">
								<option value="정확도">정확도</option>
								<option value="판매량">판매량</option>
								<option value="평점">평점</option>
								<option value="리뷰">리뷰</option>
							</select>
						</div>
					</div>

					<div class="table">
						<div class="text1">판매상태</div>
						<div class="row" >
							<input type="checkbox" name="" value=""> 품절/절판제외
						</div>
					</div>
			</div>
			<div class="btn">
				<input type="submit" value="검색"/>
				<input type="reset" value="초기화"/>
			</div>
			</div>
		</div>
		</div>
		<div id="message2">
			<div class="da_content">
					<label>도서명이나 저자 또는 ISBN중 하나를 입력해 주세요 </label>
				<div class="mid">
					<div class="textarea">
						<textarea></textarea>
					</div>
				<div class="subtext">
					<ul>
						<li>최대 20개까지 검색할 수 있습니다.</li>
						<li>검색창에 도서명이나 저자명(역자) 또는 ISBN중 하나를 입력 하세요.</li>
						<li>검색어와 검색어 사이에는 '엔터'키를 눌러 구분 해 주세요.</li>
						<li>엑셀 등에서 복사 후 일괄 붙여넣기도 가능합니다.</li>
					</ul>
				</div>
				</div>
				<div class="btn">
					<input type="submit" value="검색"/>
					<input type="reset" value="초기화"/>
				</div>
			</div>
		</div>				
	</div>
	 <jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>