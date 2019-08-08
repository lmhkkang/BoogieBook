/**
 * 
 */

var passwordCheck = 1;
var passwordkDoublcCheck = 0;
var emailCheck = 1;
var contactNumCheck = 1;

function registerForm(obj){
	makeBirthDate();

	if(obj.password.value==""){
		alert("비밀번호를 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if(passwordCheck == 0){
		alert("비밀번호를 확인하세요.");
		obj.password.focus();
		return false;
	}
	
	if(obj.cpassword.value==""){
		alert("비밀번호확인을 입력하세요. ");
		obj.cpassword.focus();
		return false;
	}
	
	if(passwordkDoublcCheck == 0){
		alert("비밀번호가 서로 다릅니다.");
		obj.cpassword.focus();
		return false;
	}
	
	if(obj.email.value==""){
		alert("이메일을 입력하세요. ");
		obj.email.focus();
		return false;
	}
	
	if(emailCheck == 0){
		alert("이메일을 양식에 맞게 입력하세요.");
		obj.email.focus();
		return false;
	}
	
	if(obj.name.value==""){
		alert("이름을 입력하세요. ");
		obj.name.focus();
		return false;
	}
	
	if(obj.yyyy.value=="" || obj.mm.value=="" || obj.dd.value==""){
		alert("생년월일을 입력하세요.");
		obj.name.focus();
		return false;
	}
	
	if(obj.phone.value==""){
		alert("전화번호를 입력하세요. ");
		obj.phone.focus();
		return false;
	}
	
	if(contactNumCheck == 0){
		alert("잘못된 전화번호 양식 입니다.");
		obj.phone.focus();
		return false;
	}
	
	if(obj.zipcode.value=="" || obj.addr1.value==""  || obj.addr2.value=="" ){
		alert("주소를 입력하세요. ");
		obj.zipcode.focus();
		return false;
	}
	
	if(obj.job.value==""){
		alert("직업을 입력하세요. ");
		obj.job.focus();
		return false;
	}
}

function makeBirthDate(){
	var birth_date = $("select[name=yyyy]").val() + "-" + $("select[name=mm]").val() + "-" + $("select[name=dd]").val();
	$("input[name=birth_date]").val = birth_date;	
	document.getElementById('birth_date').value = birth_date;
}

function checkPassword(){
	var password = $('#password').val();
    
    var passwordReg = /^[a-zA-Z0-9]{10,15}$/;
    var checkEng1 = /[a-z]/g;
    var checkEng2 = /[A-Z]/g;
    var checkNum = /[0-9]/g;
    
    if($("input[name=password]").val()==""){
    	$('.chkPasswordMsg').css( "color" , "black")
    	$('.chkPasswordMsg').html("공백없는 10~15자의 영문/숫자 조합");
    	passwordCheck = 0;
    	if($("input[name=cpassword]").val()!="" && $("input[name=password]").val()!=$('#cpassword').val()){
    		$('.chkCpasswordMsg').css( "color" , "red");
        	$('.chkCpasswordMsg').html("비밀번호가 일치하지 않습니다.");
    		passwordkDoublcCheck = 0;
    	}else if($("input[name=cpassword]").val()!="" && $("input[name=password]").val()==$('#cpassword').val()){
        	$('.chkCpasswordMsg').css( "color" , "green")
        	$('.chkCpasswordMsg').html("비밀번호가 일치합니다.");
        	passwordkDoublcCheck = 1;
        }
    } else if(!passwordReg.test(password) || !checkNum.test(password)
    		|| (!checkEng1.test(password) && !checkEng2.test(password))) {
    	$('.chkPasswordMsg').css( "color" , "red");
    	$('.chkPasswordMsg').html("공백없는 10~15자의 영문/숫자 조합");
    	passwordCheck = 0;
    	
    	if($("input[name=cpassword]").val()!="" && $("input[name=password]").val()!=$('#cpassword').val()){
    		$('.chkCpasswordMsg').css( "color" , "red");
        	$('.chkCpasswordMsg').html("비밀번호가 일치하지 않습니다.");
    		passwordkDoublcCheck = 0;
    	}else if($("input[name=cpassword]").val()!="" && $("input[name=password]").val()==$('#cpassword').val()){
        	$('.chkCpasswordMsg').css( "color" , "green")
        	$('.chkCpasswordMsg').html("비밀번호가 일치합니다.");
        	passwordkDoublcCheck = 1;
        }
    }else{
    	$('.chkPasswordMsg').css( "color" , "green");
    	$('.chkPasswordMsg').html("해당 비밀번호는 사용가능합니다.");
    	passwordCheck = 1;
    	
    	if($("input[name=cpassword]").val()!="" && $("input[name=password]").val()!=$('#cpassword').val()){
    		$('.chkCpasswordMsg').css( "color" , "red");
        	$('.chkCpasswordMsg').html("비밀번호가 일치하지 않습니다.");
    		passwordkDoublcCheck = 0;
    	}else if($("input[name=password]").val()==$('#cpassword').val()){
        	$('.chkCpasswordMsg').css( "color" , "green")
        	$('.chkCpasswordMsg').html("비밀번호가 일치합니다.");
        	passwordkDoublcCheck = 1;
        }
    }
};

function doubleCheckPassword(){
	var cpassword = $('#cpassword').val();
	
	if($("input[name=cpassword]").val()==""){
		$('.chkCpasswordMsg').html("");
		passwordkDoublcCheck = 0;
	}else if($("input[name=password]").val()==cpassword){
    	$('.chkCpasswordMsg').css( "color" , "green")
    	$('.chkCpasswordMsg').html("비밀번호가 일치합니다.");
    	passwordkDoublcCheck = 1;
    }else{
    	$('.chkCpasswordMsg').css( "color" , "red");
    	$('.chkCpasswordMsg').html("비밀번호가 일치하지 않습니다.");
    	passwordkDoublcCheck = 0;
    }
}

function checkEmail(){
	var email = $('#email').val();
	var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	if($("input[name=email]").val()==""){
		$('.chkEmailMsg').html("");
		emailCheck = 0;
	}else if(emailReg.test(email)){
    	$('.chkEmailMsg').css( "color" , "green")
    	$('.chkEmailMsg').html("해당 이메일은 사용 가능합니다.");
    	emailCheck = 1;
    }else{
    	$('.chkEmailMsg').css( "color" , "red");
    	$('.chkEmailMsg').html("이메일 양식에 맞지 않습니다.");
    	emailCheck = 0;
    }
}

function checkContactNum(){
	var ContactNum = $('#contactNum').val();
	var NumReg = /[^0-9]/g;
	if($("input[name=phone]").val()==""){
		$('.chkContactNumMsg').html("");
		contactNumCheck = 0;
	}else if(!NumReg.test(ContactNum)){
		$('.chkContactNumMsg').html("");
		contactNumCheck = 1;
    }else{
    	$('.chkContactNumMsg').css( "color" , "red");
    	$('.chkContactNumMsg').html("잘못된 전화번호 양식 입니다.");
    	contactNumCheck = 0;
    }
}

function readContent(obj){
	var url="/homepage/member/content.do?" + "check=" + obj ;
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}

function zipcodeRead(){
	new daum.Postcode({
        oncomplete: function(data) {
        	document.getElementById('zipcode').value = data.zonecode;
        	document.getElementById('addr1').value = data.roadAddress;
        	$('#addr2').focus();
        }
    }).open();
}









