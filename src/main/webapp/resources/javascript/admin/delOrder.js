/**
 * 
 */

function delOrder(root,orderId){
	//alert(root+","+orderId);
	if(confirm("주문정보를 삭제하시겠습니까?") == true){
		var url = root+"/admin/adminDelOrder.do?orderId="+orderId;
		location.href=url;
	}else{
		return;
	}
}