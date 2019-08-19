<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_header.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin_content.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_content.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_table.css"/>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
    <script type="text/javascript" src="${root}/resources/javascript/admin/editFAQ.js"></script>
    <script type="text/javascript" src="${root}/resources/javascript/admin/delFAQ.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>    
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
	              <h4 style="color:#5e6b9e">FAQ관리</h4>
	            </div>
  				<div>
  				 <b style="color:#5e6b9e">FAQ 분류 선택</b>
	              <form action="${root}/admin/adminFAQStat.do" onsubmit="return adminOrdStat(this)" name="ordStatForm">
		              <select name="questionCode">
		                <option value="1">반품/교환/환불</option>
		                <option value="2">주문/결제</option>
		                <option value="3">회원</option>
		                <option value="4">도서/상품정보</option>
		                <option value="5">배송/수령일안내</option>
		              </select>
		              <button class="btn btn-primary" style="height:70%;" type="submit" value="Submit">검색</button>
	              </form>
  				</div>
  				
  				<table class="table table-striped table-bordered" style="width:1000px;">
				     <thead>
				          <tr>
				              <td>질문 번호</td>
				              <td>질문 분류</td>
				              <td>질문</td>
				              <td class="text-center"> 수정/삭제 </td>
				          </tr>
				      </thead>
				      <tbody>
				      <c:forEach var="faqDto" items="${faqStatList}">
				          <tr>
				              <td style="width:85px;">${faqDto.board_number}</td>
				              <td style="width:141px;">
				              <c:if test="${faqDto.question_code == 1}">
				              	반품/교환/환불
				              </c:if>
				              <c:if test="${faqDto.question_code == 2}">
				              	주문/결제
				              </c:if>
				              <c:if test="${faqDto.question_code == 3}">
				              	회원
				              </c:if>
				              <c:if test="${faqDto.question_code == 4}">
				              	도서/상품정보
				              </c:if>
				              <c:if test="${faqDto.question_code == 5}">
				              	배송/수령일안내
				              </c:if>
				              </td>
				              <td style="width:634px;">${faqDto.question}</td>
				              <td style="width:140px;" class="text-center"><a class='btn btn-info btn-xs' href="javascript:editFAQ('${root}','${faqDto.board_number}','${faqDto.question_code}')" id="editBtn${faqDto.board_number}"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="javascript:delFAQ('${root}','${faqDto.board_number}','${faqDto.question_code}')" class="btn btn-danger btn-xs" id="deleteBtn${faqDto.board_number}"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
				          </tr>
				      </c:forEach>    
				      </tbody>
				 </table>
	          </div>
			</div>
		</div>
      </div>	
</body>