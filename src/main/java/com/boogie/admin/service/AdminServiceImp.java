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
import com.boogie.customerCenter.dto.FaqBoardDto;
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
		HashMap<String,Object> hMap = new HashMap<String, Object>();
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		int listSize = 10;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		
		int count=adminDao.memberCount();
		
		//member 테이블에 있는 회원의 정보들을 가져옴.
		
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		
		List<MemberDto> memberList= null;
		if(count>0) {
			memberList = adminDao.getMemberDto(hMap);
			System.out.println("count: "+count+"currentPage :"+currentPage);
		}
		
		mav.addObject("listSize",listSize);
		mav.addObject("currentPage",currentPage);
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
	public void adminFAQRegMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		String question = request.getParameter("question");
		int question_code = Integer.parseInt(request.getParameter("questionCode"));
		String answer = request.getParameter("answer");
		String question_type = null;
		System.out.println("현재 question_code:" + question_code);
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
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		int listSize = 10;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		
		int count = adminDao.getOrderCount();
		System.out.println(count);
		
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		
		
			
		List<OrderDto> orderList= null;
		if(count>0) {
			orderList = adminDao.getOrderDto(hMap);
			System.out.println("count: "+count+"currentPage :"+currentPage);
		}
			
		mav.addObject("orderList", orderList);
		mav.addObject("listSize",listSize);    
		mav.addObject("currentPage",currentPage); //요청 페이지
		mav.addObject("count", count);
	}
	//도서 검색
	@Override
	public void adminBookSearchMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String book_name = request.getParameter("book_name");
		//책이름으로 검색했을때 해당 조건에 맞는 list를 가져옴
		List<BookInfoDto> bookSearchList = adminDao.getSearchBookList(book_name);
		System.out.println(bookSearchList);
		
		int count = adminDao.getCountSearchBook(book_name);
		System.out.println(count);
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		//한 페이지당 요청 책의 갯수
		int listSize = 20;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		
		mav.addObject("listSize",listSize);    
		mav.addObject("currentPage",currentPage); //요청 페이지
		mav.addObject("bookSearchList", bookSearchList);
		mav.addObject("count", count);
		mav.setViewName("admin/adminBookSearchMng");
	}
	//id받고 도서수정페이지로 이동하게 하는 서비스
	@Override
	public void adminBookEditMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int book_id = Integer.parseInt(request.getParameter("num"));
		System.out.println(book_id);
		
		List<BookInfoDto> selectBookDto = adminDao.getSelectBookDto(book_id);
		System.out.println(selectBookDto);
		
		mav.addObject("selectBookDto", selectBookDto);
		mav.setViewName("admin/adminBookEditMng");
		
	}
    //도서 수정페이지
	@Override
	public void adminBookMngUpdate(ModelAndView mav) {
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
		System.out.println("너이자식 : " + request.getParameter("book_id"));
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String story = request.getParameter("story");
		String img_path = request.getParameter("img_path");
		
		hMap.put("type01", (String)type01);
		hMap.put("type02", (String)type02);
		hMap.put("type03", (String)type03);
		hMap.put("book_name", (String)book_name);
		hMap.put("author", (String)author);
		hMap.put("publisher", (String)publisher);
		hMap.put("publish_date", (String)publish_date);
		hMap.put("price", (Integer)price);
		hMap.put("book_id", (int)book_id);
		hMap.put("stock", (Integer)stock);
		hMap.put("story", (String)story);
		hMap.put("img_path", (String)img_path);
		
		System.out.println("hMap: " + hMap);
		
		int check = adminDao.bookUpdate(hMap);
		mav.addObject("check",check);
		mav.addObject("img_path",img_path);
		mav.setViewName("admin/adminBookEditOk");
	}
	//회원 삭제
	@Override
	public void adminBookDelMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int book_id = Integer.parseInt(request.getParameter("num"));
		System.out.println(book_id);
		
		int check = adminDao.bookDelete(book_id);
		System.out.println(check);
		
		mav.addObject("check",check);
		mav.setViewName("admin/adminBookDelOk");
	}
	
	@Override
	public void adminOrdStat(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int ordStat = Integer.parseInt(request.getParameter("order_Status"));
		
		List<OrderDto> ordStatList = adminDao.getOrdStatList(ordStat);
		System.out.println(ordStatList);
		
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		int listSize = 20;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		int count = adminDao.getCountSearchOrder(ordStat);
		int order_status = ordStat;
		
		mav.addObject("listSize",listSize);    
		mav.addObject("currentPage",currentPage); //요청 페이지
		mav.addObject("count", count);
		mav.addObject("ordStatList", ordStatList);
		mav.addObject("order_status",order_status);
		mav.setViewName("admin/adminOrdStatMng");	
	}
	//회원정보 검색
	@Override
	public void adminMemSearchId(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String searchId = request.getParameter("searchId");
		System.out.println(searchId);
		
		List<MemberDto> memberSearchList = adminDao.getSearchMemId(searchId);
		System.out.println(memberSearchList);
		int count = memberSearchList.size();
		System.out.println(count);
		
		mav.addObject("memberSearchList", memberSearchList);
		mav.addObject("count", count);
	}

	@Override
	public void adminChangeOrdStat(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String, Object> hMap = new HashMap<String,Object>();
		
		int order_Status = Integer.parseInt(request.getParameter("order_status"));		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		hMap.put("order_Status", order_Status);
		hMap.put("order_id", order_id);
		
		int check = adminDao.getEditOrdStat(hMap);
		System.out.println(check);
		
		mav.addObject("check", check);
		
		mav.setViewName("admin/adminOrdEditOk");
	}

	@Override
	public void adminDelOrd(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int order_id = Integer.parseInt(request.getParameter("orderId"));
		
		int check = adminDao.DelOrd(order_id);
		System.out.println(check);
		
		mav.addObject("check", check);
		
		mav.setViewName("admin/adminOrdDelOk");
	}

	@Override
	public void adminOrdSearchMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		List<OrderDto> searchOrderList = new ArrayList<OrderDto>();
		
		String searchOrderId = request.getParameter("searchOrderId");
		System.out.println(searchOrderId);
		
		searchOrderList = adminDao.getSearchOrderId(searchOrderId);
		System.out.println(searchOrderList);
		
		int count = searchOrderList.size();
		System.out.println("check!: " + count);
		
		mav.addObject("searchOrderList", searchOrderList);
		mav.addObject("count",count);
	}

	@Override
	public void adminFAQMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
	}

	@Override
	public void adminFAQStat(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int faqStat = Integer.parseInt(request.getParameter("questionCode"));
		
		List<FaqBoardDto> faqStatList = adminDao.getFaqStatList(faqStat);
		System.out.println(faqStatList);
		
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null) pageNumber = "1";
		
		int listSize = 5;
		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage-1)*listSize+1;
		int endRow = currentPage*listSize;
		int count = faqStatList.size();
		int faq_status = faqStat;
		
		mav.addObject("listSize",listSize);    
		mav.addObject("currentPage",currentPage); //요청 페이지
		mav.addObject("count", count);
		mav.addObject("faqStatList", faqStatList);
		mav.addObject("faq_status",faq_status);
		mav.setViewName("admin/adminFAQStatMng");
	}

	@Override
	public void adminFAQEditMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		
		int board_number = Integer.parseInt(request.getParameter("num"));
		System.out.println(board_number);
		
		int qCode = Integer.parseInt(request.getParameter("qcode"));
		System.out.println(qCode);
		
		hMap.put("board_number", board_number);
		hMap.put("qCode", qCode);
		
		List<FaqBoardDto> selectFaqDto = adminDao.getSelectFaqDto(hMap);
		System.out.println(selectFaqDto);
		
		mav.addObject("selectFaqDto", selectFaqDto);
		mav.setViewName("admin/adminFAQEditMng");	
	}

	@Override
	public void adminFAQUpdate(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String,Object>();
		
		
		int board_number = Integer.parseInt(request.getParameter("board_number"));
		//바뀌기전 질문유형코드
		int question_code = Integer.parseInt(request.getParameter("question_code"));
		String question = request.getParameter("question");
		//바꾸기를 희망하는 질문유형코드
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		String answer = request.getParameter("answer");
		
		hMap.put("board_number", board_number);
		hMap.put("question_code", question_code);
		hMap.put("question", question);
		hMap.put("questionCode", questionCode);
		hMap.put("answer", answer);
		
		int check = adminDao.FAQUpdate(hMap);
		System.out.println(check);
		
		mav.addObject("check", check);
		mav.setViewName("admin/adminFAQEditOk");
	}

	@Override
	public void adminFAQDelMng(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HashMap<String,Object> hMap = new HashMap<String, Object>();
		
		int num = Integer.parseInt(request.getParameter("num"));
		int qcode = Integer.parseInt(request.getParameter("qcode"));
		
		hMap.put("num", num);
		hMap.put("qcode", qcode);
		
		int check = adminDao.DelFAQ(hMap);
		System.out.println(check);
		
		mav.addObject("check", check);
		mav.setViewName("admin/adminFAQDelOk");
	}

}
