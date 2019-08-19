/**
 * 
 */
function editOrder(root,num){
	$("#" + num).toggle();
}


function changeOrderStatus(root,ordStat){
	var changeStat = $('#order_Status'+ordStat).val();
	var url = root+"/admin/adminChangeOrdStat.do?order_status=" + changeStat + "&order_id=" + ordStat;
	location.href=url;
}