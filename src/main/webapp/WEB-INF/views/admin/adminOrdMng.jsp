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
                    <div class="logo"><a href="http://naver.com"><img id="logoImg" src="${root}/resources/images/BoogieBook_Logo.png"/></a></div>
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
					<li><a href="adminFAQMng.do">고객센터관리</a></li>
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
              <select name="order_Status">
                <option value="1">배송중</option>
                <option value="2">입금대기</option>
                <option value="3">취소</option>
              </select>
            </div>
            <div class="tmpOrdLineThree" style="border:0px solid blue; margin-top:20px;">
              <div class="container" style="padding-left:0px;">
                <div class="row col-md-13 col-md-offset-2 custyle" style="margin-left:0px;">
                <table class="table table-striped custab" style="margin-top:0px;">
                <thead>
                <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> 쓸지 말지 모르겠지만 일단 있는버튼</a>
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
               		<c:forEach var="orderItem" items="${orderList}">
                		<tr>               			
                			<td>${orderItem.order_id}</td>
                            <td>${orderItem.member_id}</td>
                            <td><fmt:formatDate value="${orderItem.order_date}" pattern="yy-MM-dd"/></td>
                            <td>${orderItem.total_price}</td>
                            <td>${orderItem.status}</td>
                            <td>${orderItem.quantity}</td>
                            <td style="font-size:0.9em">${orderItem.book_name}</td>
                            <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
                        </tr>
               		</c:forEach>
                </table>
                </div>
              </div>
            </div>
          </div>
				</div>
			</div>
      </div>
		</div>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  </body>
</html>
