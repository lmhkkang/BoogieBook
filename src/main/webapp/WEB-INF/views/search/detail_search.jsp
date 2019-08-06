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
	<script src="${root}/resources/javascript/search/search.js"></script>
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>		
	<script type="text/javascript">
	function appendYear(){

		var date = new Date();
		var year = date.getFullYear();
		var selectValue = document.getElementById("year");
		var selectValue2 = document.getElementById("year2");
		var optionIndex = 0;


		for(var i=year;i>year-50;i--){
				selectValue.add(new Option(i,i),optionIndex++);
				selectValue2.add(new Option(i,i),optionIndex++);
		}

	}

	function appendMonth(){

		var selectValue = document.getElementById("month");
		var selectValue2 = document.getElementById("month2"); 
		var optionIndex = 0;

		for(var i=1;i<=12;i++){
				selectValue.add(new Option(i,i),optionIndex++);
				selectValue2.add(new Option(i,i),optionIndex++);
		}

	}

	
	function a(){
		$("#message2").hide();
		appendMonth();
		appendYear();
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
		
		$("#1mbtn").click(function(){
			var a = $("#1ms> option").index(this);
			alert(a);
			 var num = $("#1ms > option:eq("+a+")").val();
			$("#1ms").val(a);
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
			 <form action="${root}/search/mulitOk.do" method="get" onsubmit="return searchForm(this)">
			<div class="content_body_all">
			<div class="content_body1">
				<div class="table">
					<div class="text1">카테고리</div>
					<div class="row">
						<select name="type">
						<option value=""></option>
							<option value="소설">소설</option>
							<option value="시/에세이">시/에세이</option>
							<option value="경제/경영">경제/경영</option>
							<option value="자기계발">자기계발</option>
							
							<option value="인문">인문</option>
							<option value="역사/문화">역사/문화</option>
							<option value="종교">종교</option>
							<option value="정치/사회">정치/사회</option>
							<option value="예술/대중문화">예술/대중문화</option>
							<option value="과학">과학</option>
							<option value="기술/공학">기술/공학</option>
							<option value="컴퓨터/IT">컴퓨터/IT</option>
							
							<option value="유아(0~7세)">유아(0~7세)</option>
							<option value="어린이(초등)">어린이(초등)</option>
							<option value="어린이전집">어린이전집</option>
							<option value="어린이영어">어린이영어</option>
							<option value="청소년">청소년</option>
							
							<option value="초등참고서">초등참고서</option>
							<option value="중/고등참고서">중/고등참고서</option>
							<option value="대학교재">대학교재</option>
							<option value="취업/수험서">취업/수험서</option>
							<option value="외국어">외국어</option>
							
							<option value="가정/육아">가정/육아</option>
							<option value="건강">건강</option>
							<option value="여행">여행</option>
							<option value="요리">요리</option>
							<option value="취미/실용/스포츠">취미/실용/스포츠</option>
													
							<option value="잡지">잡지</option>
							<option value="만화">만화</option>
							
							<option value="한국소개도서">한국소개도서</option>
						</select>
					</div>
				</div>

				<div class="table">
					<div class="text1">도서명(ISDN)</div>
					<div class="row">
						<input type="text" name="book_name">
					</div>
				</div>

				<div class="table">
					<div class="text1">저자/역자</div>
					<div class="row">
						<input type="text" name="author">
					</div>
				</div>

				<div class="table">
					<div class="text1">출판사</div>
					<div class="row">
						<input type="text" name="publisher">
					</div>
				</div>

			</div>
			<div class="content_body2">
				<div class="table">
					<div class="text1">출판일</div>
					<div class="during">
						<input id="1mbtn" type="button" value="1개월">
						<input id="3mbtn" type="button" value="3개월">
						<input id="6mbtn" type="button" value="6개월">
						<input id="1ybtn" type="button" value="1년">
					</div>
				</div>
				<div class="table">
				<div class="text1"></div>
				<div class="row">
					<select id="year" name="year01">												
					</select>
						
					<label>년</label>
					<select id="month" name="month01">						
					</select>						
						<label>월 ~</label>
						
					<select id="year2" name="year02">
						
						</select>
						<label>년</label>
						<select id="month2" name="month02">
						
						</select>
						<label>월</label>
				</div>
			</div>
					<div class="table">
						<div class="text1">가격대</div>
						<div class="row">
							<input name="price01" type="text"/><label>원 부터~</label>
							<input name="price02" type="text"/><label>까지</label>
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
			<input type="hidden" name="detailtype" value="detailtype"/>
			<div class="btn">
				<input type="submit" value="검색"/>
				<input type="reset" value="초기화"/>
			</div>
			</div>
			</form>
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