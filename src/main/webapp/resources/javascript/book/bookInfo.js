/**
 * 책소개 페이지에서 장바구니 페이지로 넘어갈때 cartPopUp 함수로 moveToPopUp창 호출
 * 호출 창에 넘길 parameter값 은 book_id 값만 넘기면 된다.
 */

function moveToCart(root, book_id){
	   //alert(book_id);
	   var quantity = document.form.amount.value;
	   quantity = encodeURI(quantity);
	   if(quantity == null){
		   quantity = 1;
	   }
	   location.href=root+"/order/cart.do?book_id="+book_id+"&amount="+quantity;
}



function moveToOrderForm(root, book_id){
	   //alert(book_id);
	   var quantity = document.form.amount.value;
	   quantity = encodeURI(quantity);
	   if(quantity == null){
		   quantity = 1;
	   }
	   location.href=root+"/order/orderForm.do?book_id="+book_id+"&amount="+quantity;
}

// var quantity = document.form.amount.value;가 먹히지 않아 1로 임의 생성
function moveToCart2(root, book_id){
//	   alert(book_id);
	   var quantity = 1;
	   quantity = encodeURI(quantity);
	   book_id=book_id.trim();
	   location.href=root+"/order/cart.do?book_id="+book_id+"&amount="+quantity;
}

function moveToOrderForm2(root, book_id){
	   //alert(book_id);
	   var quantity = 1;
	   quantity = encodeURI(quantity);
	   book_id=book_id.trim();
	   location.href=root+"/order/orderForm.do?book_id="+book_id+"&amount="+quantity;
}