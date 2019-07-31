/**
 * 
 */

var idCheck = 0;
function registerForm(obj){
	//alert("OK");
	if(!$("input[name=item01]").prop("checked") || !$("input[name=item02]").prop("checked")) {
		alert("필수 약관동의를 하지 않을시 회원가입 할 수 없습니다.");
		return false;
	}
	
	if(obj.id.value==""){
		alert("아이디를 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if(idCheck == 0){
		alert("아이디를 확인하세요.");
		obj.id.focus();
		return false;
	}
	
	
}

function selectAll(){
	if($("input[name=item01]").prop("checked") && $("input[name=item02]").prop("checked")
			&& $("input[name=item03]").prop("checked") && $("input[name=item04]").prop("checked")){
		
		$("input[name=item01]").prop("checked", false);
		$("input[name=item02]").prop("checked", false);
		$("input[name=item03]").prop("checked", false);
		$("input[name=item04]").prop("checked", false);
		
	}else{
		$("input[name=item01]").prop("checked", true);
		$("input[name=item02]").prop("checked", true);
		$("input[name=item03]").prop("checked", true);
		$("input[name=item04]").prop("checked", true);
	}
};

function selectAllCheck(){
	if($("input[name=item01]").prop("checked") && $("input[name=item02]").prop("checked")
			&& $("input[name=item03]").prop("checked") && $("input[name=item04]").prop("checked")){
		$("input[name=item_all]").prop("checked", true);
	}else{
		$("input[name=item_all]").prop("checked", false);
	}
};

function checkId(){
    var id = $('#id').val();
    
    var path = "/homepage/member/idCheck.do";
    var idReg = /^[a-z]+[a-zA-Z0-9]{5,19}$/g;

    if($("input[name=id]").val()==""){
    	$('.chkIdMsg').css( "color" , "black")
    	$('.chkIdMsg').html("공백없는 6~20자의 영문/숫자 조합, 아이디 첫글자는 영문 소문자만 가능합니다.");
    	idCheck = 0;
    }
    else if(!idReg.test( $("input[name=id]").val())) {
    	$('.chkIdMsg').css( "color" , "red");
    	$('.chkIdMsg').html("공백없는 6~20자의 영문/숫자 조합, 아이디 첫글자는 영문 소문자만 가능합니다.");
    	idCheck = 0;
    }else{
    	$.ajax({
            url:path,
            type:'post',
            data:{id:id},
            success:function(data){
                if($.trim(data)==0){
                	$('.chkIdMsg').css( "color" , "green");
                    $('.chkIdMsg').html("해당 아이디는 사용가능 합니다.");  
                    idCheck = 1;
                }else{
                	$('.chkIdMsg').css( "color" , "red")
                    $('.chkIdMsg').html("이미 존재하는 아이디 입니다.");
                	idCheck = 0;
                }
            },
            error:function(){
                    alert("에러입니다");
            }
        });
    }  
};

function checkPassword(){
	var password = $('#password').val();
    
    var passwordReg = /^[a-zA-Z0-9]{10,15}$/;
    var checkEng1 = /[a-z]/g;
    var checkEng2 = /[A-Z]/g;
    var checkNum = /[0-9]/g;
    
    if($("input[name=password]").val()==""){
    	$('.chkPasswordMsg').css( "color" , "black")
    	$('.chkPasswordMsg').html("공백없는 10~15자의 영문/숫자 조합");
    }
    else if(!passwordReg.test(password) || !checkNum.test(password)
    		|| (!checkEng1.test(password) && !checkEng2.test(password))) {
    	$('.chkPasswordMsg').css( "color" , "red");
    	$('.chkPasswordMsg').html("공백없는 10~15자의 영문/숫자 조합");
    }else{
    	$('.chkPasswordMsg').css( "color" , "green");
    	$('.chkPasswordMsg').html("해당 비밀번호는 사용가능합니다.");
    }
};

function doubleCheckPassword(){
	var cpassword = $('#cpassword').val();
	
	if($("input[name=cpassword]").val()==""){
		$('.chkCpasswordMsg').html("");
	}else if($("input[name=password]").val()==cpassword){
    	$('.chkCpasswordMsg').css( "color" , "green")
    	$('.chkCpasswordMsg').html("비밀번호가 일치합니다.");
    }else{
    	$('.chkCpasswordMsg').css( "color" , "red");
    	$('.chkCpasswordMsg').html("비밀번호가 일치하지 않습니다.");
    }
}

function checkEmail(){
	var email = $('#email').val();
	var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	if($("input[name=email]").val()==""){
		$('.chkEmailMsg').html("");
	}else if(emailReg.test(email)){
    	$('.chkEmailMsg').css( "color" , "green")
    	$('.chkEmailMsg').html("해당 이메일은 사용 가능합니다.");
    }else{
    	$('.chkEmailMsg').css( "color" , "red");
    	$('.chkEmailMsg').html("이메일 양식에 맞지 않습니다.");
    }
}

function checkContactNum(){
	var ContactNum = $('#contactNum').val();
	var NumReg = /[^0-9]/g;
	if($("input[name=contactNum]").val()==""){
		$('.chkContactNumMsg').html("");
	}else if(!NumReg.test(ContactNum)){
		$('.chkContactNumMsg').html("");
    }else{
    	$('.chkContactNumMsg').css( "color" , "red");
    	$('.chkContactNumMsg').html("잘못된 전화번호 양식 입니다.");
    }
}

function readContent1(){
	var url="/homepage/member/content1.do";
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}

function readContent2(){
	var url="/homepage/member/content2.do";
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}

function readContent3(){
	var url="/homepage/member/content3.do";
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}

function readContent4(){
	var url="/homepage/member/content4.do";
	window.open(url, "", "width=400, height=400, scrollbars=yes");
}






