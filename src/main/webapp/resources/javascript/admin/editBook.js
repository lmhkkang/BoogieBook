/**
 * 
 */

function editBook(root, num){
	var url = root+ "/admin/adminBookEditMng.do?num=" + num;
	
	location.href = url;
}