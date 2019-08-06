package com.boogie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.boogie.aop.BookAspect;
import com.boogie.bookInfo.service.BookInfoService;
import com.boogie.order.dto.OrderDto;
import com.boogie.order.service.OrderService;
import com.boogie.recommend.service.RecommendService;

/**
 * @author : 이민호
 * 2019. 8. 1.
 * @description: cartWrite 함수 추가함.
 */

/**
 * @author : 이민호
 * 2019. 8. 5.
 * @description: writeOrderInfo 함수 추가 - 주문정보 page에 주문했던 정보를 뿌려줌.
 */
@Controller
public class BookController 
{
	@Autowired
	private RecommendService recommendService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BookInfoService bookInfoService;

	@RequestMapping(value = "/recommend/recommendMain.do", method = RequestMethod.GET)
	public ModelAndView recommendMain(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		recommendService.recommendMain(mav);
		
		return mav;
	}

	@RequestMapping(value = "/order/cart.do", method = RequestMethod.GET)
	public ModelAndView cartWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		orderService.getCartInfo(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/order/orderForm.do", method=RequestMethod.POST)
	public ModelAndView orderFormWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
				
		orderService.getOrderForm(mav);
		
		mav.setViewName("order/orderForm");
		
		return mav;
	}
	
	@RequestMapping(value="/order/payProgress.do", method=RequestMethod.GET)
	public ModelAndView payProgress(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("order/payProgress");
	}
	
	@RequestMapping(value="/order/paymentComplete.do", method=RequestMethod.POST)
	public ModelAndView writeOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		orderService.writeOrderInfo(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/book/bookInfo.do", method=RequestMethod.GET)
	ModelAndView writeBookInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		bookInfoService.writeBookInfo(mav);
		
		return mav;
	}
}
