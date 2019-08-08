$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
});

function loginForm(obj){
	if(obj.id.value==""){
		alert("아이디를 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if(obj.password.value==""){
		alert("비밀번호를 입력하세요.");
		obj.id.focus();
		return false;
	}
}

function registerFun(){
    setTimeout(function() {
    opener.location = "/homepage/member/register.do";
    self.close(); //현재창 닫기
    }, 500); // 2초후 실행 1000당 1초
}

function forgetIdFun(){
	var url="/homepage/member/forgetId.do"; 
	window.open(url, "", "width=400, height=400, scrollbars=0, menubar=0, toolbar=0");

}

function forgetPasswordFun(){
	var url="/homepage/member/forgetPassword.do";
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}



