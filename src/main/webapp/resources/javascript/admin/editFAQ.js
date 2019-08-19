/**
 * 
 */
function editFAQ(root, num, qcode){
	var url = root+ "/admin/adminFAQEditMng.do?num=" + num + "&qcode=" + qcode;
	
	location.href = url;
}