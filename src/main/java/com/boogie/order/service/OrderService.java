package com.boogie.order.service;

import org.springframework.web.servlet.ModelAndView;

public interface OrderService {

	void getCartInfo(ModelAndView mav);

	void getOrderForm(ModelAndView mav);

	void writeOrderInfo(ModelAndView mav);

	void addToCart(ModelAndView mav);
}
