<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="${root}/resources/css/member/register_css.css" rel="stylesheet">
<script src="${root}/resources/javascript/member/register_js.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${root}/resources/javascript/member/forgetPassword_js.js"></script>

<title>비밀번호 찾기</title>
</head>
<body>
	<div class="container" style="border: 0px solid red; margin: 0px auto; height: 250px; margin-left: 0px; margin-bottom: 0px;">
	<div class="row" style="margin: 0px auto; border: 0px solid red;">
    <div class="col-md-8" style="border: 0px; width: 350px; height: 80px; margin: 0px auto; margin-top:10px;">  
        <h2 class="entry-title" style="border-bottom: 3px solid black; padding-bottom: 10px; width: 300px;"><span>비밀번호 찾기</span> </h2>
        
        <form class="form-horizontal" action="${root}/member/findPassword.do" method="get" name="signup" id="signup" enctype="multipart/form-data"
        	onsubmit="return forgetPasswordForm(this)">       
        <div class="form-group">
          <label class="control-label col-sm-3" style="margin-top: 20px;">아이디</label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
              <input type="text" style="width: 270px" class="form-control" name="member_id" id="member_id" placeholder="아이디를 입력하세요.">
            </div>
           </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-3">이메일</label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input type="text" style="width: 270px" class="form-control" name="email" id="email" placeholder="이메일을 입력하세요." value="">
            </div> 
            <small class="chkEmailMsg"> </small>  
            </div>
        </div>
        
        <div class="form-group">
          <div style="float: left; padding-left: 95px; padding-top: 20px;">
            <input name="Submit" type="submit" value="비밀번호 찾기" class="btn btn-primary"
            style="width: 110px; height: 40px; background-color: #5e6b9e;"/>
          </div>
          
          <div style="float: left; padding-left: 10px; padding-top: 20px;">
            <input name="button" type="button" value="취소" class="btn btn-primary"
            style="width: 110px; height: 40px; background-color: #5e6b9e;" onclick="cancel()"/>
          </div>
        </div>
      </form>
    </div>
</div>
</div>

</body>
</html>