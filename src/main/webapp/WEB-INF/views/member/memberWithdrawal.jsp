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
<script src="${root}/resources/javascript/member/memberWithdrawal_js.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<title>BoogieBook</title>
</head>
<body>

<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container" style="border: 0px solid red; margin: 0px auto; height: 700px; margin-left: 105px; margin-bottom: 250px;">
	<div class="row" style="margin: 0px auto; border: 0px solid red;">
    <div class="col-md-8" style="width: 1000px; height: 700px; margin: 0px auto;">  
        <h1 class="entry-title" style="border-bottom: 3px solid black; padding-bottom: 10px;"><span>회원탈퇴</span> </h1>
        <hr>
        <div>
        	<p style="padding-bottom: 0px;">그동안 BoogieBook 온라인 서점을 이용해 주셔서 감사합니다. </p>                
        	<p>	서비스 이용 시 불편하셨던 점이나 불만사항을 알려주시면 적극 수렴하여 향후 개선에 최선을 다하도록 하겠습니다</p>
        	<p>아울러 회원 탈퇴 전 아래내용을 숙지해 주시기 바랍니다.</p>
        </div>
        <div>
        	<p style="font-weight: bold;">회원 탈퇴 안내</p>
        </div>
        <div style="border: 1px solid #e1e1e1; padding: 12px; line-height: 16px; margin-bottom: 50px;">
        	<ul>
        		<li style = "margin-top: 5px;">- 회원탈퇴를 하셔도 오프라인 매장 회원카드는 사용하실 수 있습니다.</li>
        		<li style = "margin-top: 5px;">- 회원탈퇴 시 고객님의 회원정보는 전자상거래 상에서의 소비자보호 법률에의거한 BoogieBook 개인정보보호정책에따라 
					관리됩니다.</li>
        		<li style = "margin-top: 5px;">- 비 현금성 포인트인 적립금은 탈퇴 즉시 삭제 처리되어 환급되지 않으며, 재가입하셔도 복원되지 않습니다.</li>
        		<li style = "margin-top: 5px;">- 현금성 포인트인 전환금은 탈퇴 즉시 삭제 되어 환급되지 않으며, 재가입하셔도 복원되지 않습니다.</li>
        		<li style = "margin-top: 5px;">- 진행중인 거래(구매/중고책 판매) 내역이 있는 경우는 회원탈퇴가 불가능하오니, 거래 종료 후 회원 탈퇴 하실 수 있습니다.</li>
        		<li style = "margin-top: 5px;">- 인출가능 한 예치금이 있는 경우에는 잔액을 모두 인출하신 후에 회원 탈퇴하실 수 있습니다.</li>
        		<li style = "margin-top: 5px;">- 회원탈퇴 시 회원정보는 자동으로 삭제되며, 탈퇴 후 한 달 동안은 재가입이 불가능합니다. 또한 재가입 시에 
				기존 사용ID로는 이용하실 수 없습니다.</li>
        	</ul>
        </div>
        <form class="form-horizontal" action="${root}/member/memberWithdrawalOk.do" method="get" name="signup" id="signup" enctype="multipart/form-data"
        	onsubmit="return registerForm(this)">  
            
        <div class="form-group">
          <label class="control-label col-sm-3">아이디</label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
              <input type="text" style="width: 350px" class="form-control" name="member_id" id="id" placeholder="아이디를 입력하세요." oninput="checkId()" value="${id}" readOnly>
            </div>
          </div>
        </div>
        
        <div class="form-group">
          <label class="control-label col-sm-3">비밀번호</label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" style="width: 350px" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요." oninput="checkPassword()" value="${memberDto.password}">
           </div>   
          </div>
        </div>

        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10" style="padding-left: 140px; padding-top: 30px;">
            <input name="Submit" type="submit" value="탈퇴" class="btn btn-primary"
            style="width: 130px; height: 40px; background-color: #5e6b9e; margin-right: 10px;"/>          
          </div> 
        </div>
      </form>
    </div>
</div>
</div>

<jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>