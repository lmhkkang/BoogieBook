package com.boogie.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.email.Email;
import com.boogie.email.EmailSender;
import com.boogie.member.dto.MemberDto;
import com.boogie.order.dao.OrderDao;
import com.boogie.order.dto.OrderDto;

/**
 * @author : 이민호
 * 2019. 8. 1.
 * @description: 이민호 장바구니 정보 getCartInfo
 */


/**
 * @author : 이민호
 * 2019. 8. 2.
 * @description: getOrderForm 추가 하였음 장바구니page에서 -> 주문서입력 page
 * 				 insertOrderInfo 주문정보를 DB에 insert
 */
@Component
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	
	@Override
	public void getCartInfo(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("id");
		BookAspect.logger.info(BookAspect.logMsg + "member_id:" + member_id);
		
		if (member_id == null) {
			System.out.println("장바구니에 존재하는 Item이 없습니다.");
		}
		
		List<OrderDto> cartList = new ArrayList<OrderDto>();
		cartList = orderDao.getCartInfo(member_id);
		BookAspect.logger.info(BookAspect.logMsg+cartList.size());
		
		mav.addObject("member_id",member_id);
		mav.addObject("cartList", cartList);
		mav.setViewName("order/cart");
	}

	//주문서작성 page 정보 get & write
	@Override
	public void getOrderForm(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession  session = request.getSession();
		String member_id = (String) session.getAttribute("id");
		String total = request.getParameter("total");
		BookAspect.logger.info(BookAspect.logMsg + "total: " + total + "member_id" + member_id);	
		
		MemberDto memberDto = new MemberDto();
		memberDto =  orderDao.getOrderForm(member_id);
		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
		
		mav.addObject("member_id", member_id);
		mav.addObject("memberDto",memberDto);
		mav.addObject("total", total);
		mav.setViewName("order/orderForm");
	}
	
	

	//주문정보페이지 정보 write
	@Override
	public void writeOrderInfo(ModelAndView mav) {
		OrderDto orderDto = new OrderDto();
		List<OrderDto> bookList = new ArrayList<OrderDto>();
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession  session = request.getSession();
		
		String member_id = (String) session.getAttribute("id");
		String total = request.getParameter("total");
		BookAspect.logger.info(BookAspect.logMsg + "주문정보 member_id : "+ member_id + "total:" + total);
		
		
		if(total == "") {
			int orderNumber = orderDao.selectMyOrderNum(member_id);
			BookAspect.logger.info(BookAspect.logMsg +"orderNumber: " +orderNumber);
			
			orderDto = orderDao.getOrderCheckForm(orderNumber,member_id);
			orderDto.setBook_id(getBookId(orderNumber));
			orderDto.setBook_name(getBookName(orderDto.getBook_id()));
			
			mav.addObject("orderDto", orderDto);
		}else {
			//기존 주문정보를 cart에서 가져옴 list로
			List<OrderDto> cartList = new ArrayList<OrderDto>();
			cartList = orderDao.getCartInfo(member_id);
			BookAspect.logger.info(BookAspect.logMsg+cartList.size());
			
			//주문정보 DB(book_order)에 insert
			int checkBookOrder = orderDao.insertOrderInfo(member_id, total);
			BookAspect.logger.info(BookAspect.logMsg +"checkBookOrder: " +checkBookOrder);
			
			int orderNumber = orderDao.selectMyOrderNum(member_id);
			BookAspect.logger.info(BookAspect.logMsg +"orderNumber: " +orderNumber);
			
			//주문정보 DB(order_detail)에 insert
			
			for(int i=0; i<cartList.size(); i++) {
				orderDto = (OrderDto) cartList.get(i);
				int checkOrderDetail = orderDao.insertOrderDetail(orderNumber,orderDto.getBook_id(),orderDto.getQuantity(),orderDto.getPrice());
				BookAspect.logger.info(BookAspect.logMsg +"checkOrderDetail: " +checkOrderDetail);
			}
				
			//주문정보를 가지고 주문확인 page에 뿌리기 orderDto
			OrderDto oDto = new OrderDto();
			oDto = orderDao.getPaymentInfo(member_id);
			BookAspect.logger.info(BookAspect.logMsg +"oDto.toString()" +oDto.toString());
			
			//해당 Order_id 로 book_id 들을 가져옴
			List<Integer> bookIdArray = new ArrayList<Integer>();
			bookIdArray = orderDao.getBookIdArray(orderNumber);
			BookAspect.logger.info(BookAspect.logMsg +"bookIdArray.size : " +bookIdArray.size());
			
			//book_id 로 book_name & quantity -> bookList에 저장
			for(int i=0; i<bookIdArray.size(); i++) {
				int book_id = (int)bookIdArray.get(i);
				System.out.println("book_id값 : " + book_id);
				orderDto = new OrderDto();
				orderDto = orderDao.getPayInfoByBookId(book_id);
				bookList.add(orderDto);
			}
			BookAspect.logger.info(BookAspect.logMsg + "bookList.size() : " +bookList.size());

			orderInfoSendEmail(member_id, oDto, bookList);
			
			mav.addObject("orderDto", oDto);
			mav.addObject("bookList", bookList);
			mav.setViewName("order/paymentComplete");
			
			//주문이 완료되면 DB에서 장바구상품을 삭제시킨다.
			int check = orderDao.deleteFromCart(member_id);
			BookAspect.logger.info(BookAspect.logMsg + "check : " +check);
		}
		
	}

	private String getBookName(int book_id) {
		String book_name;
		book_name = orderDao.getBookName(book_id);
		return book_name;
	}

	private int getBookId(int orderNumber) {
		int book_id = 0;
		book_id = orderDao.getBookId(orderNumber);
		return book_id;
	}

	public void orderInfoSendEmail(String member_id, OrderDto oDto, List<OrderDto> bookList) {
		String id = member_id;
		String userEmail = orderDao.getUserEmail(member_id); 
		String content = id + "<!doctypeHTML>" + 
				"    <html>" + 
				"" + 
				"    <head>" + 
				"        <title>Book Info</title>" + 
				"        <meta charset=\"utf-8\">" + 
				"        <link rel=\"stylesheet\" type=\"text/css\" href=\"bookInfo.css\" />" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" + 
				"        <style type=\"text/css\">" + 
				"            " + 
				"        </style>" + 
				"    </head>" + 
				"    <body>" + 
				"        <table class=\"table table-striped\">" + 
				"            <thead>" + 
				"                <tr>" + 
				"                    <th scope=\"col\">" + 
				"                        <h3>"+id+"님의 주문정보</h3>" + 
				"                    </th>" + 
				"                </tr>" + 
				"            </thead>" + 
				"            <tbody>" + 
				"                <tr>" + 
				"                    <td style=\"padding-left:60px;\"><label>주문번호</label> </td>" + 
				"                    <td></td>" + 
				"                    <td>"+ oDto.getOrder_id() +"</td>" + 
				"                    <td></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                </tr>" + 
				"                <tr>" + 
				"                    <td style=\"padding-left:60px;\"><label>주문날짜</label> </td>" + 
				"                    <td></td>" + 
				"                    <td>"+ oDto.getOrder_date()+"</td>" + 
				"                    <td></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                </tr>" + 
				"                <tr>" + 
				"                    <td style=\"padding-left:60px;\"><label>배송지</label> </td>" + 
				"                    <td></td>" + 
				"                    <td>"+oDto.getAddr1() +" " + oDto.getAddr2()+"</td>" + 
				"                    <td></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                </tr>" + 
				"                <tr>" + 
				"                    <td style=\"padding-left:60px;\"><label>주문자</label></td>" + 
				"                    <td></td>" + 
				"                    <td>"+ oDto.getName() +"</td>" + 
				"                    <td></td>" + 
				"                    <td></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                </tr>" + 
				"" + 
				"                <tr>" + 
				"                    <td></td>";
				for(int i=0; i<bookList.size(); i++) {
					OrderDto orderDto = new OrderDto();
					orderDto = bookList.get(i);
					content += "<td style=\"padding-left:60px;\"><label>"+ orderDto.getBook_name()+"("+orderDto.getQuantity()+")" +"</label></td>";
				}
				content += "                        <td>" + 
				"                        </td>" + 

				"                    <td></td>" + 
				"                    <td><strong></strong></td>" + 
				"                    <td class=\"text-right\"><strong></strong></td>" + 
				"                </tr>" + 
				"                <tr>" + 
				"                    <td style=\"padding-left:60px;\"><label>주문금액</label></td>" + 
				"                    <td></td>" + 
				"                    <td><strong>"+oDto.getTotal_price()+"</strong>원</td>" + 
				"                    <td></td>" + 
				"                    <td></td>" + 
				"                    <td class=\"text-right\"></td>" + 
				"                </tr>" + 
				"            </tbody>" + 
				"        </table>" + 
				"    </body>" + 
				"" + 
				"    </html>" + 
				"";
		
		if(userEmail != null) {
			email.setContent(content);
			email.setReceiver(userEmail);
			email.setSubject(id + "님의 주문정보 입니다.");

			System.out.println(email.toString());
			try {
				emailSender.SendEmail(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void addToCart(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession  session = request.getSession();
		int check=999;
		
		String member_id = (String) session.getAttribute("id");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		BookAspect.logger.info(BookAspect.logMsg + "book_id: "+book_id + " " +"member_id :" +member_id +" amount:" + amount);
		
		int countSameBook = orderDao.countSameBook(book_id, member_id);
		if(countSameBook==0) {
			check = orderDao.addToCart(book_id, member_id,amount);
		}else {
			check = orderDao.addQuantity(book_id, member_id,amount);
		}		
		BookAspect.logger.info(BookAspect.logMsg + check);		
	}

	@Override
	public void addOrder(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession  session = request.getSession();
		
		String member_id = (String) session.getAttribute("id");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		BookAspect.logger.info(BookAspect.logMsg + "book_id: "+book_id + " " +"member_id :" +member_id +" amount:" + amount);
		
		int price = orderDao.getBookPrice(book_id);
		int addOrderCheck = orderDao.addOrder(member_id, book_id, (price*amount));
		int orderNumber = orderDao.selectMyOrderNum(member_id);
		int addOrderDetailCheck = orderDao.insertOrderDetail(orderNumber,book_id,amount,price);
		BookAspect.logger.info(BookAspect.logMsg + addOrderCheck + "," +orderNumber+"," +addOrderDetailCheck);
	}


	
	
}
