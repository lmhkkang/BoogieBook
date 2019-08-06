/**
 * 
 */

function cancel(){
	self.close();
}

function forgetIdForm(obj){
	if(obj.name.value==""){
		alert("이름을 입력하세요.");	
		obj.name.focus();
		return false;
	}
	if(obj.email.value==""){
		alert("이메일을 입력하세요.");
		obj.email.focus();
		return false;
	}
}