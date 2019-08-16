package com.boogie.order.dao;


import java.util.List;

import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

public interface OrderDao {

	List<OrderDto> getCartInfo(String member_id);

	MemberDto getOrderForm(String member_id);

	int insertOrderInfo(String member_id, String total);

	int selectMyOrderNum(String member_id);

	int insertOrderDetail(int orderNumber, int book_id, int quantity, int price);

	List<Integer> getBookIdArray(int orderNumber);
	
	OrderDto getPaymentInfo(String member_id);

	OrderDto getPayInfoByBookId(int book_id);

	int deleteFromCart(String member_id);

	String getUserEmail(String member_id);

	int countSameBook(int book_id, String member_id);

	int addToCart(int book_id, String member_id, int amount);

	int addQuantity(int book_id, String member_id, int amount);

	int getBookPrice(int book_id);

	int addOrder(String member_id, int book_id, int total_price);

	OrderDto getOrderCheckForm(int orderNumber,String member_id);

	int getBookId(int orderNumber);

	String getBookName(int book_id);

	int cartDeleteButton(String[] book_id, String member_id);

	int cartCount(String member_id);

	OrderDto NonMemberAddCart(int book_id);

	int NonMemberAddOrder(int total, String member_id);

	int NonMemberAddOrderDetail(int order_id, String book_id, int quantity, int price);

	OrderDto NonMemberGetOrderInfo(int order_id);
	
	List<OrderDto> nonMemberOrderDetailSearch(String member_id);

}
