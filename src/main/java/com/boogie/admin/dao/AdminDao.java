package com.boogie.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.customerCenter.dto.FaqBoardDto;
import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

public interface AdminDao {
	public int getDw();
	
	public int getCountDw(int dw);
	
	public List<MemberDto> getMemberDto(HashMap<String, Object> hMap);
	
	public int memberCount();
	
	public int update(String id);

	public int inputUpdate(HashMap<String, Object> hMap);

	public int memberDelete(int num);

	public List<BookInfoDto> getBookList(int startRow, int endRow);

	public int bookInsert(HashMap<String, Object> hMap);

	public int getCountBook();

	public int FAQInsert(HashMap<String, Object> hMap);

	public List<OrderDto> getOrderDto(HashMap<String, Object> hMap);

	public int[] getDate();

	public List<BookInfoDto> getSearchBookList(String book_name);

	public int getCountSearchBook(String book_name);

	public List<BookInfoDto> getSelectBookDto(int book_id);

	public int bookUpdate(HashMap<String, Object> hMap);

	public int bookDelete(int book_id);

	public List<OrderDto> getOrdStatList(int ordStat);

	public int getCountSearchOrder(int ordStat);

	public List<MemberDto> getSearchMemId(String searchId);

	public int getEditOrdStat(HashMap<String, Object> hMap);

	public int DelOrd(int order_id);

	public int getOrderCount();

	public List<OrderDto> getSearchOrderId(String searchOrderId);

	public List<FaqBoardDto> getFaqStatList(int faqStat);

	public List<FaqBoardDto> getSelectFaqDto(HashMap<String, Object> hMap);

	public int FAQUpdate(HashMap<String, Object> hMap);

	public int DelFAQ(HashMap<String, Object> hMap);
}
