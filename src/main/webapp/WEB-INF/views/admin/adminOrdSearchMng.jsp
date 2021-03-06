<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
  <head>
    <meta charset="utf-8">
    <title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_header.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_content.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_table.css"/>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
     <script type="text/javascript" src="${root}/resources/javascript/admin/ordStatSearch.js"></script>
     <script type="text/javascript" src="${root}/resources/javascript/admin/editOrder.js"></script>
     <script type="text/javascript" src="${root}/resources/javascript/admin/delOrder.js"></script>
     <script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
    <style>
    .btn-primary {
	    background-color: #4274d7;
	    border-color: #4d5bbe;
	    text-shadow: 1px 1px 0 #232bd5;
	}
	.btn-primary:hover, .btn-primary:focus {
	    background-color: #426acd;
	    border-color: #4f56aa;
	}
    </style> 
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
              <h4 style="color:#5e6b9e">주문 관리</h4>
            </div>
            <div class="tmpOrdLineTwo" style="margin-top:15px;">
              <b style="color:#5e6b9e">주문 상태</b>
              <form action="${root}/admin/adminOrdStat.do" onsubmit="return adminOrdStat(this)" name="ordStatForm">
	              <select name="order_Status">
	                <option value="1">결제완료</option>
	                <option value="2">배송중</option>
	                <option value="3">취소신청</option>
	                <option value="4">취소완료</option>
	              </select>
	              <button class="btn btn-primary" style="height:70%;" type="submit" value="Submit">검색</button>
              </form>
			            <form action="adminOrdSearchMng.do" method="get" name="ordSearchForm">
			            	<div class="ab" style="width:1000px; height:30px; display: flex; margin-top:10px;">	
			            		<div style="width:300px; height:40px;">
	                           		<input type="text" class="search-query form-control"
	                              	name="searchOrderId" id="term" placeholder="주문번호로 검색"/> 
	                       		</div>
	                       		<div>
	                              	<button class="btn btn-primary" type="submit">
	                                 	<span class=" glyphicon glyphicon-search"></span>
	                              	</button>
	                            </div>
                            </div>  	                           		
                        </form>				      
            </div>
            <div class="tmpOrdLineThree" style="border:0px solid blue; margin-top:20px;">
              <div class="container" style="padding-left:0px;">
                <div class="row col-md-13 col-md-offset-2 custyle" style="margin-left:0px;">
                <c:if test="${count > 0}">
                <table class="table table-striped custab" style="margin-top:0px;">
                <thead>
                    <tr>
                    	<th>주문번호</th>
                    	<th>아이디</th>
                    	<th>주문날짜</th>
                        <th>가격(원)</th>
                        <th>주문상태</th>
                        <th>수량</th>
                        <th>책 제목</th>
                        <th class="text-center">수정/삭제</th>
                    </tr>
                </thead>
               		<c:forEach var="orderItem" items="${searchOrderList}">
                		<tr>               			
                			<td>${orderItem.order_id}</td>
                            <td>${orderItem.member_id}</td>
                            <td><fmt:formatDate value="${orderItem.order_date}" pattern="yy-MM-dd"/></td>
                            <td>${orderItem.total_price}</td>
                            <td>${orderItem.status}</td>
                            <td>${orderItem.quantity}</td>
                            <td style="font-size:0.9em">${orderItem.book_name}</td>
                            <td class="text-center"><a class='btn btn-info btn-xs' href="javascript:editOrder('${root}','${orderItem.order_id}')"><span class="glyphicon glyphicon-edit"></span>수정</a> <a href="javascript:delOrder('${root}','${orderItem.order_id}')" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>삭제</a></td>
                        </tr>
                        
                        <tr style="display:none;" id="${orderItem.order_id}">
                        	<td>
                        		<b>주문번호: ${orderItem.order_id}</b>
	                        	<select id="order_Status${orderItem.order_id}">
					                <option value="1">결제완료</option>
					                <option value="2">배송중</option>
					                <option value="3">취소신청</option>
					                <option value="4">취소완료</option>
		              			</select>
                        	</td>
	              			<td></td>
	              			<td></td>
	              			<td></td>
	              			<td></td>
	              			<td></td>
	              			<td></td>
	              			<td><a href="javascript:changeOrderStatus('${root}','${orderItem.order_id}')" class="btn btn-primary btn-xs" id="editBtn${orderItem.order_id}" style="align:center;">확인</a></td>
                        </tr>
               		</c:forEach>
                </table>
                </c:if>