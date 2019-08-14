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
	window.open(url, "", "width=450, height=350, left=450, top=250, scrollbars=0, menubar=no, toolbar=0");

}

function forgetPasswordFun(){
	var url="/homepage/member/forgetPassword.do";
	window.open(url, "", "width=450, height=350, left=450, top=250, scrollbars=0, menubar=no, toolbar=0");
}

$(document).ready(function(){
	 
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie1("key");
    $("#username").val(key); 
     
    if($("#username").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#remember").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#remember").change(function(){ // 체크박스에 변화가 있다면,
        if($("#remember").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie1("key", $("#username").val(), 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie1("key");
        }
    });
    
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#username").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#remember").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie1("key", $("#username").val(), 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie1(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie1(cookieName){
	
//    var expireDate = new Date();
//    expireDate.setDate(expireDate.getDate() - 1);
//
//    document.cookie = cookieName + "=" + getCookie(cookieName) +";expires=" + expireDate.toGMTString() +";";
//    alert(cookieName + "=" + getCookie(cookieName) +";expires=" + expireDate.toGMTString() +";");
	  setCookie1(cookieName,"",-1);
}
 
function getCookie1(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}




