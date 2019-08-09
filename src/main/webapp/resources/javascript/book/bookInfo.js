/**
 * 책소개 페이지에서 장바구니 페이지로 넘어갈때 cartPopUp 함수로 moveToPopUp창 호출
 * 호출 창에 넘길 parameter값 은 book_id 값만 넘기면 된다.
 */

function moveToCart(root,book_id,amount){	
	if(amount=='0'){
		amount = document.getElementById('amount').value;
	}

	window.location.href=root+"/order/cart.do?book_id="+book_id+"&amount="+amount;
};

function moveToOrderForm(root, book_id,amount){
	if(amount=='0'){
		amount = document.getElementById('amount').value;
	}
	window.location.href=root +"/order/orderForm.do?book_id="+book_id+"&amount="+amount;
};