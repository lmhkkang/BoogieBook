/**
 * 
 */

function updateMember(root, member_num,name,member_id,gender,phone,email){
	//params = member_num+name+member_id+gender+phone+email;
		$("#" + member_num).toggle();		
}

function editMember(root,num){
	var name = $("#name"+num).val();
	var phone = $("#phone"+num).val();
	var email = $("#email"+num).val();
	//alert(name + "," + phone + "," + email);
	
	var params = "num="+num+"&name="+name+"&phone="+phone+"&email="+email;
	var url = root+"/admin/adminMemMngEdit.do?" + params;
	//alert(params,url);
	
	$("#editBtn"+num).click(function(){
		$.ajax({
			url:root+"/admin/adminMemMngEdit.do?"+params,
			type:"get",
			dataType:"text",
			//여기서부턴 새로짠코드
			success: function(data){
				var newName = $("#name"+num).val();
				alert(newName);
				$.ajax({
					async: true,
					type: "get",
					data : {
						name : newName 
					}
				});
			}	
		});
	});	
}

