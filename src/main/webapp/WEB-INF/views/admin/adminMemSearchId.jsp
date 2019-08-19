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
   <jsp:include page="admin_header.jsp"></jsp:include>

    <div id="content">
      <div class="section1">
        <div class="center">
          <div class="tmp1">
            <div class="borbtmeff">
              <form action="adminMemSearchId.do" method="get">
              	 <b style="color:#5e6b9e">회원 관리</b> 
              	<input type="text" style="margin-left:70px" name="searchId" placeholder="아이디 검색"/>
              	<button class="btn btn-primary" style="height:70%;" type="submit" value="Submit">검색</button>
              </form>
            </div>
          </div>
				</div>
			</div>

      <div id="memSection">
        <div class="container" style="padding-left:0px;">
          <div class="row col-md-13 col-md-offset-2 custyle" style="margin-left:0px;">
          <c:if test="${count > 0}">
          <table class="table table-striped custab" style="margin-top:0px;">
          <thead>
              <tr>
                  <th>회원번호</th>
                  <th>이름</th>
                  <th>아이디</th>
                  <th>성별</th>
                  <th>전화번호</th>
                  <th>이메일</th>
              </tr>
          </thead>
            <!-- 회원 데이터 출력 -->         
            <c:forEach var="memberDto" items="${memberSearchList}">
            	<tr>
            		<td style="width:16%;">${memberDto.member_num}</td>
            		<td style="width:16%;">${memberDto.name}</td>
            		<td style="width:16%;">${memberDto.member_id}</td>
            		<td style="width:16%;">
            			<c:if test="${memberDto.gender == 1}">
            				남
            			</c:if>
            			<c:if test="${memberDto.gender == 2}">
            				여
            			</c:if> 
            		</td>
            		<td style="width:16%;">${memberDto.phone}</td>
            		<td style="width:17%;">${memberDto.email}</td>
            	</tr>      	
            	<tr style="display:none;" class="editInput" id="${memberDto.member_num}">            	   		
		            <td style="width:16%;"><input class="col-md-8" type="text" name="num"  id="num${memberDto.member_num}" disabled="disabled" value="${memberDto.member_num}"/></td>
		            <td style="width:16%;"><input class="col-md-8" type="text" name="name" id="name${memberDto.member_num}"placeholder="이름"/></td>
		            <td style="width:16%;"><input class="col-md-8" type="text" name="id"  id="id${memberDto.member_num}"disabled="disabled" value="${memberDto.member_id}"/></td>
		            <td style="width:16%;"><input class="col-md-8" type="text" name="gender" id="gender${memberDto.member_num}"disabled="disabled" value="${memberDto.gender}"></td>	            		
		            <td style="width:16%;"><input class="col-md-8" type="text" name="phone"  id="phone${memberDto.member_num}" placeholder="전화번호"></td>
		            <td style="width:17%;"><input class="col-md-8" type="text" name="email" id="email${memberDto.member_num}" placeholder="이메일"></td>        	          	
            	</tr>
           </c:forEach> 
          </table>
          </c:if>
          <c:if test="${count == 0}">
          	<div style="width:100%; text-align:center;">
          		<b style="font-size:2em; color:red; text-align:center;">일치하는 회원정보가 없습니다.</b>
          	</div>
          </c:if>
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
