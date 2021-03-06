<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link href="${root}/resources/css/member/login_css.css" rel="stylesheet" id="bootstrap-css">
<script src="${root}/resources/javascript/member/login_js.js"></script>
<script src="http://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>로그인</title>
	<div class="container" style="border: 0px solid blue; width: 670px; margin: 0px auto; height:400px; margin-top:30px;">
		<div class="row">
			<div class="col-md-6 col-md-offset-3"
				style="width: 600px; height: 400px; margin: 0px auto; border: 0px solid red; margin-left:30px;">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">로그인</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">비회원 주문조회</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="${root}/member/loginOk.do"
									method="post" role="form" onsubmit="return loginForm(this)" style="display: block;" >
									<div class="form-group">
										<input type="text" name="id" id="username" tabindex="1"
											class="form-control" placeholder="아이디" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember"
											id="remember"> <label for="remember">아이디저장</label>
									</div>
									<div class="form-group">
										<div class="row">

												<input type="submit" name="login-submit" id="login-submit" style="width:230px; float: left; margin-left: 55px; background-color: #5e6b9e;"
													tabindex="4" class="form-control btn btn-login" value="로그인" >
												<a id="kakao-login-btn" style="float: left; margin-left: 10px;"></a>

										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="javascript:forgetIdFun()" tabindex="5"
														class="forgot-id">아이디 찾기</a> <a
														href="javascript:forgetPasswordFun()" tabindex="5"
														class="forgot-password">비밀번호 찾기</a> <a
														href="javascript:registerFun()" tabindex="5"
														class="register-member">회원가입</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form"
									action="${root}/member/nonMemberCheck.do" method="get"
									role="form" style="display: none;" onsubmit="return nonMemberForm(this)">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1"
											class="form-control" placeholder="이름" value="">
									</div>
									<div class="form-group">
										<input type="text" name="email" id="email" tabindex="1"
											class="form-control" placeholder="이메일" value="">
									</div>
									<div class="form-group">
										<div class="form-group-p">
											<p>- 비회원으로 주문하신 내역이 있는 분만 이용이 가능합니다.</p>
											<p>- 비회원 주문 시 입력한 이름과 이메일을 입력해주세요.</p>
										</div>
									</div>
									<div style="font-size: 12px;">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3"
												style="width: 570px; margin: 0px auto">
												<input type="submit" name="register-submit"
													id="register-submit" tabindex="4"
													class="form-control btn btn-register" value="조회하기">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type='text/javascript'>

function checkKaKaoId(kakaoId){
	var path = "/homepage/member/idCheck.do";
	var id = kakaoId;
	var check = 0;
	$.ajax({
        url:path,
        type:'get',
        data:{id:id},
        async:false,
        success:function(data){
        	check = $.trim(data);

        },
        error:function(){
                alert("에러입니다");
        }
    });
	return check;
}

// 로그인 및 로그아웃 버튼 생성 처리
var cookiedata = document.cookie;
 
/* 로그인 관련 쿠키 생성 및 삭제 */
function setCookie( name , value , expired ){
 
 var date = new Date();
 date.setHours(date.getHours() + expired);
 var expried_set = "expries="+date.toGMTString();
 document.cookie = name + "=" + value + "; path=/;" + expried_set + ";"
 
}
 
/* 쿠키 삭제 다른방법
function deleteCookie( name ){
    
    var date = new Date();
     date.setHours(date.getHours() - 1);
     var expried_set = "expries="+date.toGMTString();
     document.cookie = name + "="  + "; path=/;" + expried_set + ";"
}
*/
 
// 
function getCookie(name){
 
    var nameofCookie = name + "=";
    var x = 0;
    while(x <= document.cookie.length){
        var y = ( x + nameofCookie.length);
        if(document.cookie.substring(x,y) == nameofCookie){
            if((endofCookie = document.cookie.indexOf(";",y)) == -1)
                endofCookie = document.cookie.length;
            return unescape(document.cookie.substring(y,endofCookie));
        }
        x = document.cookie.indexOf(" ",x) + 1;
        if( x == 0 )
            break;
        }
        
        return "";
}
 
// 카카오 script key 입력
Kakao.init('4041e4ccf092205b9b5818723e049342');
 
Kakao.Auth.createLoginButton({
    container: '#kakao-login-btn',
    persistAccessToken: true,
    persistRefreshToken: true,
    
    success: function(authObj) {
    	setCookie("kakao_login","done",1); // 쿠키생성 (로그인)

  	 	Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
// 				alert(JSON.stringify(res));        		     
//                	var userEmail = res.kakao_account.email;   //유저의 이메일
//              	var userNickName = res.properties.nickname; //유저가 등록한 별명
//                 alert(userEmail);
//  				alert(userNickName);
 				
 				var userId = res.id; //유저의 카카오톡 고유 id
				var check = checkKaKaoId(userId);
				
 				if(check == 1){
 					opener.location.href ="${root}/member/KaKaologinOk.do?id="+ userId; //부모창 리프레쉬
 				    self.close();
 				}else{
 					opener.location.href ="${root}/member/KaKaoRegister.do?id=" + userId; //부모창 리프레쉬
 				    self.close();
 				}
          	},
           	fail: function(error) {
            	alert(JSON.stringify(error));
          	}
         });
    },
    fail: function(err) {
       alert(JSON.stringify(err));
    }
});
 

 
 
 
// 로그인 버튼생성
function createLoginKakao(){
	 var login_btn = "<a id='custom-login-btn' href='javascript:loginWithKakao()'>"+
	                "<img src='..Images/puppy1.jpg' width='250'/>"+
	                "</a>";
	 document.getElementById('kakao_btn_changed').innerHTML = login_btn;
}
 
 
// 로그아웃 버튼생성
function createLogoutKakao(){
 var logout_btn = "<a id='custom-logout-btn' href='javascript:logoutWithKakao()'>"+
                "<img src='..Images/puppy3.jpg' width='200'/>"+
                "</a>";
 document.getElementById('kakao_btn_changed').innerHTML = logout_btn;
 
}
</script>