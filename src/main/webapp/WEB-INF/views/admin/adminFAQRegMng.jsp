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
   <jsp:include page="admin_header.jsp"></jsp:include>
    <div id="content">
      <div class="section1">
        <div class="center">
	          <div class="tmp1">
	            <div class="borbtmeff">
	              <h4 style="color:#5e6b9e">FAQ등록</h4>
	            </div>
	            <form action="${root}/admin/adminFAQRegMng.do">
		            <div>
			            <div class="tmpFAQLineTwo">
			              <h4 style="color:#5e6b9e">신규 FAQ 등록</h4>
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
