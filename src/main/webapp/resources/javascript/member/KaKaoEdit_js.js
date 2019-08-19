/**
 * 
 */


var contactNumCheck = 1;

function registerForm(obj){
	makeBirthDate();
	
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

function KaKaoWithdrawal(id){
	var url="/homepage/member/KaKaoWithdrawal.do?" + "id=" + id ;
	window.open(url, "", "width=470, height=200, left=450, top=250, scrollbars=0, menubar=no, toolbar=0");
	
}








