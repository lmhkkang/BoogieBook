package com.boogie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.view.InternalResourceView;

import com.boogie.aop.BookAspect;
import com.boogie.bookInfo.service.BookInfoService;
import com.boogie.customerCenter.dto.StoreMapDto;
import com.boogie.customerCenter.service.CustomerCenterService;
import com.boogie.order.dto.OrderDto;
import com.boogie.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import com.boogie.aop.BookAspect;
import com.boogie.email.Email;
import com.boogie.email.EmailSender;
import com.boogie.member.service.MemberService;

import com.boogie.recommend.service.RecommendService;
import com.boogie.search.service.SearchService;


/**
 * @author : 이민호
 * 2019. 8. 5.
 * @description: writeOrderInfo 함수 추가 - 주문정보 page에 주문했던 정보를 뿌려줌.
 */

@Controller
public class BookController {

	@Autowired
	private RecommendService recommendService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BookInfoService bookInfoService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	@Autowired
	private CustomerCenterService customerCenterService;

	@RequestMapping(value = "/recommend/recommendMain.do", method = RequestMethod.GET)
	public ModelAndView recommendMain(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		recommendService.recommendMain(mav);
		return mav;
	}

	@RequestMapping(value = "/recommend/recommendProcxy.do", method = RequestMethod.GET)
	public String recommendProcxy(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String clientId = "v8R5FbX43_upxHbbKBRy";
		String clientSecret = "GAYVywiXFj";

		String bookName = request.getParameter("bookName");

		try {
			String text = URLEncoder.encode(bookName, "UTF-8");

			String apiURL = "https://openapi.naver.com/v1/search/book.xml?query=" + text; // xml 결과
			URL url = new URL(apiURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();

			BufferedReader br;

			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer bufferResponse = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				bufferResponse.append(inputLine);
			}
			br.close();

			// System.out.println(bufferResponse.toString());
			response.setContentType("application/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(bufferResponse.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/register");
	}

	@RequestMapping(value = "/member/registerOk.do", method = RequestMethod.GET)
	public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		memberService.memberRegisterOk(mav);
		return mav;
	}

	@RequestMapping(value = "/member/idCheck.do", method = RequestMethod.GET)
	public @ResponseBody String idCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		memberService.idDuplChk(mav);

		Map<String, Object> map = mav.getModelMap();
		String check = (String) map.get("check");

		return check;
	}

	@RequestMapping(value = "/member/content.do", method = RequestMethod.GET)
	public ModelAndView readContent1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("check", request.getParameter("check"));
		mav.setViewName("member/content");
		return mav;
	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/login");
	}
	
	@RequestMapping(value = "/member/loginOk.do", method = RequestMethod.POST)
	public ModelAndView memberLoginOk(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		memberService.loginOk(mav);

		return mav;
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView memberLogout(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("member/logout");
	}
	
	@RequestMapping(value = "/member/forgetId.do", method = RequestMethod.GET)
	public ModelAndView memberforgetId(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/forgetId");
	}
	
	@RequestMapping(value = "/member/forgetPassword.do", method = RequestMethod.GET)
	public ModelAndView memberforgetPassword(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/forgetPassword");
	}
	
	@RequestMapping(value = "/member/findId.do", method = RequestMethod.GET)
    public ModelAndView memberFindId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
        memberService.findId(mav);
        
        Map<String, Object> map=mav.getModelMap();
		String id = (String) map.get("id");
		String name = (String) map.get("name");
		String userEmail = request.getParameter("email");
		int check = 0;
        if(id != null) {
            email.setContent(name + "님의 아이디는 "+ id + " 입니다.");
            email.setReceiver(userEmail);
            email.setSubject(name + "님 아이디 찾기 메일입니다.");
            System.out.println(email.toString());
            emailSender.SendEmail(email);
                      
            check = 1;         
        }else {
        	check = 0;
        }
               
        mav = new ModelAndView("member/findId");
        mav.addObject("check", check);
        return mav;
    }
	
	@RequestMapping(value = "/member/findPassword.do", method = RequestMethod.GET)
    public ModelAndView memberFindPassword (HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
        memberService.findPassword(mav);
        
        Map<String, Object> map=mav.getModelMap();
		String temporaryPw = (String) map.get("temporaryPw");
		int check = (Integer) map.get("check");
		String id = request.getParameter("member_id");
		String userEmail = request.getParameter("email");
		String content = id + "님의 임시비밀번호는 "+ temporaryPw + " 입니다."
        		+ "<br/>아래 링크를 이용해 새로운 비밀번호를 설정하세요.<br/>" 
        		+ "<a href='http://localhost:8181/homepage/member/makePassword.do?member_id="
        		+ id + "'>"
        		+ "새로운 비밀번호 설정" + "</a>";
			
        if(check > 0) {
            email.setContent(content);
            email.setReceiver(userEmail);
            email.setSubject(id + "님 아이디 찾기 메일입니다.");
            
            System.out.println(email.toString());
            emailSender.SendEmail(email);
                             
        }      
        mav = new ModelAndView("member/findPassword");
        mav.addObject("check", check);
        return mav;
    }
	
	@RequestMapping(value = "/member/makePassword.do", method = RequestMethod.GET)
	public ModelAndView memberMakePassword(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/makePassword");
	}
	
	@RequestMapping(value = "/member/makePasswordOk.do", method = RequestMethod.GET)
	public ModelAndView memberMakePasswordOk(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		memberService.makePasswordOk(mav);

		return mav;
	}
	
	@RequestMapping(value = "/search/detailSearch.do", method = RequestMethod.GET)
	public ModelAndView detailSearchMain(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		searchService.detailSearch(mav);

		return mav;
	}
	
	@RequestMapping(value = "/search/searchOk.do", method = RequestMethod.GET)
	public ModelAndView detailSearchResult(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		searchService.searchResult(mav);
		
		return mav;
	}


	@RequestMapping(value = "/order/cart.do", method = RequestMethod.GET)
	public ModelAndView cartWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		String book_id  = request.getParameter("book_id");
		if(book_id != null) {
			orderService.addToCart(mav);
		}
		orderService.getCartInfo(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/order/orderForm.do", method=RequestMethod.POST)
	public ModelAndView orderFormWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		String book_id  = request.getParameter("book_id");
		if(book_id != null) {
			orderService.addToCart(mav);
		}
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
	public ModelAndView writeBookInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		bookInfoService.writeBookInfo(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/customerCenter/storeMap.do", method=RequestMethod.GET)
	public ModelAndView storeMap(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		mav.setViewName("customerCenter/storeMap");		
		return mav;
	}
	
	@RequestMapping(value="/customerCenter/customerService.do", method=RequestMethod.GET)
	public ModelAndView customerService(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		mav.setViewName("customerCenter/customerService");		
		return mav;
	}
	
	@RequestMapping(value="/customerCenter/testPage.do", method=RequestMethod.GET)
	public ModelAndView customerTesting(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
			
		mav.setViewName("customerCenter/testPage");		
		return mav;
	}
	
	@RequestMapping(value="/customerCenter/storeMapChange.do",method=RequestMethod.GET, produces = "application/text; charset=utf8")
	public void storeMapChange(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getParameter("location_code"));
		int location_code = Integer.parseInt(request.getParameter("location_code"));
		StoreMapDto storeMapDto = customerCenterService.getLatAndLongt(location_code);
		if(storeMapDto != null) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print(storeMapDto.getLat()+"/");
				response.getWriter().print(storeMapDto.getLongt()+"/");
				response.getWriter().print(storeMapDto.getStore_addr()+"/");
				response.getWriter().print(storeMapDto.getStore_name()+"/");
				response.getWriter().print(storeMapDto.getStore_phone());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("storeMap에서 아무것도 가져오지 못함.");
		}
	}
}
