/**
 * 
 */

function searchForm(obj){
//	alert("OK");
	if(obj.book_name.value==""){
		alert("검색어를 입력하세요");
		obj.book_name.focus();
		return false;
	}
}