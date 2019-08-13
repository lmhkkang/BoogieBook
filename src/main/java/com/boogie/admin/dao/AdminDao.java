package com.boogie.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

public interface AdminDao {
	public int getDw();
	
	public int getCountDw(int dw);
	
	public List<MemberDto> getMemberDto();
	
	public int memberCount();
	
	public int update(String id);

	public int inputUpdate(HashMap<String, Object> hMap);

	public int memberDelete(int num);

	public List<BookInfoDto> getBookList(int startRow, int endRow);

	public int bookInsert(HashMap<String, Object> hMap);

	public int getCountBook();

	public int FAQInsert(HashMap<String, Object> hMap);

	public List<OrderDto> getOrderDto();

	public int[] getDate();
}
