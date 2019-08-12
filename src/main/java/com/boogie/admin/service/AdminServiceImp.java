package com.boogie.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.admin.dao.AdminDao;
import com.boogie.aop.BookAspect;
import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

@Component
public class AdminServiceImp implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void adminMain(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		//오늘 날짜를 숫자로 받아옴
		int dw = adminDao.getDw();
		System.out.println("오늘의 요일을 숫자로 표현하면??:" + dw +"이다 이말이야.");
		
		
		
		
		//dw_count 테이블의 칼럼값 뽑아와서 리스트로 담음
		ArrayList<Integer> dwCount = new ArrayList<Integer>();
		//요일별 방문자수 가져옴 (일~토)
		for(int i=1;i<8;i++) {
			dwCount.add(adminDao.getCountDw(i));
		}
		//System.out.println(dwCount);
		
		//리스트로 담은 값을 각 변수에 담음
		int sunCount = 0;
		int monCount = 0;
		int tueCount = 0;
		int wedCount = 0;
		int thuCount = 0;
		int friCount = 0;
		int satCount = 0;
		
		int [] dayOfWeek = {sunCount,monCount,tueCount,wedCount,thuCount,friCount,satCount};
		
		for(int i=0; i<dayOfWeek.length; i++) {
			dayOfWeek[i] = dwCount.get(i);
			//System.out.println(dayOfWeek[i]);
		}
		//mav에 object를 한꺼번에 담을수있나 나중에 확인할예정
		mav.addObject("sunCount", dayOfWeek[0]);
		mav.addObject("monCount", dayOfWeek[1]);
		mav.addObject("tueCount", dayOfWeek[2]);
		mav.addObject("wedCount", dayOfWeek[3]);
		mav.addObject("thuCount", dayOfWeek[4]);
		mav.addObject("friCount", dayOfWeek[5]);
		mav.addObject("satCount", dayOfWeek[6]);
	}

	@Override
	public void adminMemMng(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		//member 테이블에 있는 회원의 정보들을 가져옴.
		List<MemberDto> memberList = adminDao.getMemberDto();
		System.out.println("memberList:" + memberList.toString());
	    int count=adminDao.memberCount();
	    System.out.println("count : " + count);
		mav.addObject("memberList",memberList);
		mav.addObject("count",count);
	}

	@Override
	public void adminMemMngEditOk(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		String id = request.getParameter("id");
		BookAspect.logger.info(BookAspect.logMsg+"id : "+id);
		
		memberDto.setMember_num(Integer.parseInt(request.getParameter("num")));
		System.out.println(request.getParameter("num"));
		
		int check = adminDao.update(id);
		BookAspect.logger.info(BookAspect.logMsg+check);
	}

	@Override
	public void adminMemMngEdit(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		//input으로 입력받은 데이터를 변수로 담음.
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email");
		
		System.out.println("num: " + num + ",name: " + name + ",phone: " + phone + ",email: " + email);
		
		hMap.put("num", num);
		hMap.put("name", name);
		hMap.put("phone", phone);
		hMap.put("email", email);
		
		int check = adminDao.inputUpdate(hMap);
		System.out.println("updateCheck:" + check);
	}

	@Override
	public void adminMemMngDel(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println("AdminServiceNum:" + num);

		int check = adminDao.memberDelete(num);
		System.out.println(check);
		
	}

	@Override
	public void adminBookMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		
		
		int listSize = 20;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		
		int count = adminDao.getCountBook();
		
		List<BookInfoDto> bookList= null;
		if(count>0) {
			bookList = adminDao.getBookList(startRow, endRow);
			System.out.println("count: "+count+"currentPage :"+currentPage);
		}
		
		mav.addObject("listSize",listSize);     //한 페이지당 책의 갯수
		mav.addObject("currentPage",currentPage); //요청 페이지
		mav.addObject("count",count);             //전체 게시물 수
		mav.addObject("bookList",bookList);       //전체 게시물 레코드
	}

	@Override
	public void adminBookMngInsert(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		
		
		String type01 = request.getParameter("category");
		//장르 밸류값의 인덱스 적용전.
		String type02BeforeIndex = request.getParameter("genre");
		int index = type02BeforeIndex.indexOf(":");
		//장르 밸류 값의     : 다음에 나오는 문자열을 담는 코드
		String type02 = type02BeforeIndex.substring(index+1);
		String type03 = request.getParameter("genre_detail");
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publish_date = request.getParameter("publish_date");
		int price = Integer.parseInt(request.getParameter("price"));
		int book_id = adminDao.getCountBook()+1;
		int stock = Integer.parseInt(request.getParameter("stock"));
		String story = request.getParameter("story");
		String img_path = request.getParameter("img_path");
		
		hMap.put("type01", type01);
		hMap.put("type02", type02);
		hMap.put("type03", type03);
		hMap.put("book_name", book_name);
		hMap.put("author", author);
		hMap.put("publisher", publisher);
		hMap.put("publish_date", publish_date);
		hMap.put("price", price);
		hMap.put("book_id", book_id);
		hMap.put("stock", stock);
		hMap.put("story", story);
		hMap.put("img_path", img_path);
		
		int check = adminDao.bookInsert(hMap);
		System.out.println(type01 + "," + type02 + "," + type03 + "," + book_name + "," + author + ","+publisher+","+publish_date+","+price+","+book_id+","+stock+","+story+","+img_path);
		System.out.println(check);
		mav.addObject("check",check);
		mav.addObject("img_path",img_path);
		mav.setViewName("admin/adminBookMngOk");
	}

	@Override
	public void adminFAQMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		String question = request.getParameter("question");
		int question_code = Integer.parseInt(request.getParameter("questionCode"));
		String answer = request.getParameter("answer");
		String question_type = null;
		switch(question_code) {
		case 1:
			question_type = "반품/교환/환불";
		case 2:
			question_type = "주문/결제";
		case 3:
			question_type = "회원";
		case 4:
			question_type = "도서/상품정보";
		case 5:
			question_type = "배송/수령일안내";
		default:
			System.out.println("question_type 이 올바르게 정의되어 있지 않음.");
		}
		
		hMap.put("question", question);
		hMap.put("question_code", question_code);
		hMap.put("question_type", question_type);
		hMap.put("answer", answer);
		
		
		int check = adminDao.FAQInsert(hMap);
		
		mav.addObject("check", check);
	}

	@Override
	public void adminOrdMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
				
		//주문테이블에 있는 주문정보를 가져옴
		List<OrderDto> orderList = adminDao.getOrderDto();
		System.out.println(orderList);
			
		mav.addObject("orderList", orderList);
	}

}
