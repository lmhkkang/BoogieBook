/**
 * 
 */
function delBook(root,num){
	$("#deleteBtn"+num).click(function(){
		if(confirm("도서를 삭제하시겠습니까 ?") == true){
			var url = root+ "/admin/adminBookDelMng.do?num=" + num;
			
			location.href=url;
		}else{
			return;
		}
	});
}