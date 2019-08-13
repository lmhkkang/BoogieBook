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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script type="text/javascript" src="${root}/resources/javascript/admin/updateMember.js"></script>
    <script type="text/javascript" src="${root}/resources/javascript/admin/deleteMember.js"></script>
    <script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
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
              <b style="color:#5e6b9e">회원 관리</b> <input type="text" style="margin-left:70px"/>
              <button type="submit" class="btn btn-primary btn-success" id="searchBtn" style="height:35px; font-size:0.8em">검색</button>
            </div>
          </div>
				</div>
			</div>

      <div id="memSection">
        <div class="container" style="padding-left:0px;">
          <div class="row col-md-13 col-md-offset-2 custyle" style="margin-left:0px;">
          <table class="table table-striped custab" style="margin-top:0px;">
          <thead>
          <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b>쓸거 같은 버튼</a>
              <tr>
                  <th>회원번호</th>
                  <th>이름</th>
                  <th>아이디</th>
                  <th>성별</th>
                  <th>전화번호</th>
                  <th>이메일</th>
                  <th class="text-center">수정/삭제</th>
              </tr>
          </thead>
            <!-- 회원 데이터 출력 -->
            <c:forEach var="memberDto" items="${memberList}">
            	<tr>
            		<td style="width:14%;">${memberDto.member_num}</td>
            		<td style="width:14%;">${memberDto.name}</td>
            		<td style="width:14%;">${memberDto.member_id}</td>
            		<td style="width:14%;">${memberDto.gender}</td>
            		<td style="width:14%;">${memberDto.phone}</td>
            		<td style="width:14%;">${memberDto.email}</td>
            		<td style="width:16%;"class="text-center"><a class='btn btn-info btn-xs' href="javascript:updateMember('${root}','${memberDto.member_num}','${memberDto.name}','${memberDto.member_id}','${memberDto.gender}','${memberDto.phone}','${memberDto.email}')" id="editBtn"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="javascript:deleteMember('${root}','${memberDto.member_num}')" class="btn btn-danger btn-xs" id="deleteBtn${memberDto.member_num}"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
            	</tr>
            	
            	<tr style="display:none;" class="editInput" id="${memberDto.member_num}">            	   		
		            <td style="width:14%;"><input class="col-md-8" type="text" name="num"  id="num${memberDto.member_num}" disabled="disabled" value="${memberDto.member_num}"/></td>
		            <td style="width:14%;"><input class="col-md-8" type="text" name="name" id="name${memberDto.member_num}"placeholder="이름"/></td>
		            <td style="width:14%;"><input class="col-md-8" type="text" name="id"  id="id${memberDto.member_num}"disabled="disabled" value="${memberDto.member_id}"/></td>
		            <td style="width:14%;"><input class="col-md-8" type="text" name="gender" id="gender${memberDto.member_num}"disabled="disabled" value="${memberDto.gender}"></td>	            		
		            <td style="width:14%;"><input class="col-md-8" type="text" name="phone"  id="phone${memberDto.member_num}" placeholder="전화번호"></td>
		            <td style="width:14%;"><input class="col-md-8" type="text" name="email" id="email${memberDto.member_num}" placeholder="이메일"></td>        
		            <td style="width:16%;"><a href="javascript:editMember('${root}','${memberDto.member_num}')" class="btn btn-primary btn-xs" id="editBtn${memberDto.member_num}">확인</a></td>	          	
            	</tr>
            </c:forEach>
          </table>
          </div>
      </div>
    </div>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		</div>
  </body>
</html>
