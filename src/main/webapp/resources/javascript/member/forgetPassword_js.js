/**
 * 
 */
function cancel(){
	self.close();
}

function forgetPasswordForm(obj){
	if(obj.member_id.value==""){
		alert("아이디를 입력하세요.");
		obj.member_id.focus();
		return false;
	}
	
	if(obj.email.value==""){
		alert("이메일을 입력하세요.");
		obj.email.focus();
		return false;
	}
}