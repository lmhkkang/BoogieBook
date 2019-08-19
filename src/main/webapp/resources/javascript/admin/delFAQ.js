/**
 * 
 */

function delFAQ(root, num, qcode){
	$("#deleteBtn"+num).click(function(){
		if(confirm("FAQ를 삭제하시겠습니까 ?") == true){
			var url = root+ "/admin/adminFAQDelMng.do?num=" + num+ "&qcode=" + qcode;
			
			location.href=url;
		}else{
			return;
		}
	});
}