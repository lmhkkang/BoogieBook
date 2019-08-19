package com.boogie.order.service;

import org.springframework.web.servlet.ModelAndView;

public interface OrderService {

	void getCartInfo(ModelAndView mav);

	void getOrderForm(ModelAndView mav);

	void writeOrderInfo(ModelAndView mav);

	void addToCart(ModelAndView mav);

	void addOrder(ModelAndView mav);

	int cartDeleteButton(String[] book_id, String member_id);

	int cartCount(String member_id);

	void NonMemberAddCart(ModelAndView mav);

	void NonMemberOrderInfo(ModelAndView mav);
	
	void nonMemberOrderDetailSearch(ModelAndView mav);

	void NonMemberDirectOrder(ModelAndView mav);

}
