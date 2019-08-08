/**
 * 
 */

var contactNumCheck = 0;

function registerForm(obj){
	makeBirthDate();
	
	if(!$("input[name=item01]").prop("checked") || !$("input[name=item02]").prop("checked")) {
		alert("필수 약관동의를 하지 않을시 회원가입 할 수 없습니다.");
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









