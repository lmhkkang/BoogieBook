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
<script type='text/javascript'>
	function cancel(){
		self.close();
	}
</script>
<title>회원 탈퇴</title>
</head>
<body>
	<div class="container" style="border: 0px solid red; margin: 0px auto; height: 150px; margin-left: 0px; margin-bottom: 0px;">
	<div class="row" style="margin: 0px auto; border: 0px solid red;">
    <div class="col-md-8" style="width: 300px; height: 100px; margin: 0px auto; margin-top:20px">  
        <h3 class="entry-title" style="border-bottom: 3px solid black; padding-bottom: 10px; width: 300px;"><span>회원탈퇴</span> </h3>   
        <form class="form-horizontal" style="margin: 0px auto;"action="${root}/member/KaKaoWithdrawalOk.do" method="get" name="signup" id="signup" enctype="multipart/form-data">       
        <input type="hidden" name="id" value="${id}"/>
        <div class="form-group">
        	<div style="margin-left: 15px; margin-top: 20px;"><p>정말로 탈퇴 하시겠습니까?</p></div>
          <div style="float: left; padding-left: 15px; padding-top: 5px;">
            <input name="Submit" type="submit" value="회원 탈퇴" class="btn btn-primary"
            style="width: 110px; height: 40px; background-color: #5e6b9e;"/>
          </div>
          
          <div style="float: left; padding-left: 15px; padding-top: 5px;">
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