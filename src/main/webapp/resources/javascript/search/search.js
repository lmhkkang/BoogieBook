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

function keywordcheck(obj){
//	alert("OK");
	if(obj.content.value==""){
		alert("검색어를 입력하세요");
		obj.content.focus();
		return false;
	}
}