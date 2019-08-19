<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
  <head>
    <meta charset="utf-8">
    <title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_header.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_content.css"/>
  </head>
  <body>
    <header>
			<div class="gnb">
				<ul class="center">
					<li class="topHeader_r"><a href="#">로그아웃</a></li>
					<li class="topHeader_r"><a href="#">홈으로</a></li>
				</ul>
			</div>
            <div class="center">
                <div class="middleHeader">
                    <div class="logo"><a href="${root}/index/index.do"><img id="logoImg" src="${root}/resources/images/BoogieBook_Logo.png"/></a></div>
                    <div class="search_form">
                        <div class="search_top"></div>
                        <div class="search"><b>Administrator</b></div>
                    </div>
                </div>
            </div>

			<div class="lnb">
				<ul class="center">
					<li><a href="admin.do">사용자 통계</a></li>
					<li><a href="adminMemMng.do">회원관리</a></li>
					<li><a href="adminBookRegMng.do">도서등록</a></li>
					<li><a href="adminBookMng.do">도서관리</a></li>
					<li><a href="adminFAQRegMng.do">FAQ등록</a></li>
					<li><a href="adminFAQMng.do">FAQ관리</a></li>
					<li><a href="adminOrdMng.do">주문 관리</a></li>
				</ul>
			</div>
		</header>

    <div id="content">
      <div class="section1">
        <div class="center">
	          <div class="tmp1">
	            <div class="borbtmeff">
	              <h4 style="color:#5e6b9e">FAQ수정</h4>
	            </div>
	            <form action="${root}/admin/adminFAQUpdate.do">
	            <input type="hidden" value="${selectFaqDto[0].board_number}" name="board_number"/>
	            <input type="hidden" value="${selectFaqDto[0].question_code}" name="question_code"/>
		            <div>
			            <div class="tmpFAQLineTwo">
			              <h4 style="color:#5e6b9e">FAQ 수정</h4>
			            </div>
			            <div class="tmpFAQLineThree">
			              <b style="color:#5e6b9e">자주 묻는 질문</b> <input type="text" id="question" name="question"/>
			            </div>
			            <div class="tmpFAQLineFour">
			              <b style="color:#5e6b9e">질문 유형</b>
			              <select name="questionCode">
			                <option value="1">반품/교환/환불</option>
			                <option value="2">주문/결제</option>
			                <option value="3">회원</option>
			                <option value="4">도서/상품정보</option>
			                <option value="5">배송/수령일안내</option>
			              </select>
			            </div>
			            <div class="tmpFAQLineFive">
			              <b style="color:#5e6b9e">답변</b>
			            </div>
			            <div class="tmpFAQContent">
			              <div>
			                <textarea name="answer" row="15" cols="50" style="width: 850px;height:100px; margin: 15px 15px 30px 30px"></textarea>
			              </div>
			            </div>
			            <div class="btnSpot" style="border: 0px solid green; width: 90%;">
			              <button type="submit" value="등록" style="float:right; width:50px;">확인</button>
			            </div>
		            </div>
		         </form>   
	          </div>
			</div>
		</div>
      </div>
  </body>
</html>
