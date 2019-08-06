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
	var win = window.open(root+"/order/payProgress.do","PopupWin", "width=530, height=500, resizable=yes ,left=500, top=200");
}
