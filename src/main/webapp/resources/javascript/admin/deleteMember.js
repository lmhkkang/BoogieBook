/**
 * 
 */

function deleteMember(root,num){
	var params = "num="+num;
	var url = root+"/admin/adminMemMngDel.do?" + params;
	
	$("#deleteBtn"+num).click(function(){
		$.ajax({
			url:root+"/admin/adminMemMngDel.do?" + params,
			type:"get",
			dataType:"text",
			success: function(){
				
			}
		});
	});
}