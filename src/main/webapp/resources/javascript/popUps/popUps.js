/**
 * 
 */

function parentWindowToCart(root, book_id){
	alert(window.parent.location);
	if(book_id != null){
		book_id = parseInt(book_id);
		url = root + "/order/cart.do?book_id="+book_id;
		window.parent.location.href=url;
	}else{
		alert("장바구니 담기에 실패하였습니다.");
		window.close();
	}
}