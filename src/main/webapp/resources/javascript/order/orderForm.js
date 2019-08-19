/**
 * 
 * 이민호 구현 part
 * 
 * 기존정보 입력시 function 
 * 새로입력 클릭시 function
 * 우편번호 api
 * 배송메모 dropbox 선택시 text area
 * 결제하기 클릭시 Form에서 onsubmit="" 구현해야함.
 */


function newInfo(){
	$("#name").val("");
	$("#zipcode").val("");
	$("#addr1").val("");
	$("#addr2").val("");
	$("#phone").val("");
	$("#exampleFormControlTextarea5").val("");	
}

function oldInfo(name,zipcode,addr1,addr2,phone){
	//alert(name + ''+ zipcode + ''+ phone +'' +addr1 +''+ addr2 + '' + phone);
	$("#name").val(name);
	$("#zipcode").val(zipcode);
	$("#addr1").val(addr1);
	$("#addr2").val(addr2);
	$("#phone").val(phone);
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

function dropItem1(){
	var memo = $("#drop1").text();	
	memoInsert(memo);
}
function dropItem2(){
	var memo = $("#drop2").text();	
	memoInsert(memo);
}
function dropItem3(){
	var memo = $("#drop3").text();	
	memoInsert(memo);
}
function memoInsert(memo){
	$("#exampleFormControlTextarea5").text(memo);
}

function payProgress(root){
	var name = document.getElementById("name");
	var phone = document.getElementById("phone");
	var zipcode = document.getElementById("zipcode");
	var addr1 = document.getElementById("addr1");
	var addr2 = document.getElementById("addr2");
	var email = document.getElementById("email");
	
	if(name.value==null || name.value==""){
		alert("이름을 입력해주세요.");
		name.focus();
		return false;
	}
	if(phone.value==null || phone.value==""){
		alert("전화번호를 입력해주세요.");
		phone.focus();
		return false;
	}
	if(zipcode.value==null || zipcode.value==""){
		alert("우편번호를 입력해주세요.");
		phone.focus();
		return false;
	}
	if(addr1.value==null || addr1.value==""){
		alert("주소를 입력해주세요.");
		addr1.focus();
		return false;
	}
	if(addr2.value==null || addr2.value==""){
		alert("상세주소를 입력해주세요.");
		addr2.focus();
		return false;
	}
	if(email.value != null){
		var check = new Boolean(false);
		check = chkEmail(email.value);
		if(check==false){
			alert("유효한 메일 형식이 아닙니다.");
			email.focus();
		}
		return check;
	}
}

function chkEmail(str) {
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regExp.test(str)) return true;
    else return false;
}

