package com.boogie.order.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

@Component
public class OrderDaoImp implements OrderDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<OrderDto> getCartInfo(String member_id) {
		return sqlSessionTemplate.selectList("cartInfoSelect", member_id);
	}

	@Override
	public MemberDto getOrderForm(String member_id) {
		return sqlSessionTemplate.selectOne("orderFormSelect", member_id);
	}

	@Override
	public int insertOrderInfo(String member_id, String total) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", (String)member_id);
		map.put("total", Integer.parseInt(total));
		return sqlSessionTemplate.insert("bookOrderInsert", map);	
	}

	@Override
	public int selectMyOrderNum(String member_id) {
		return sqlSessionTemplate.selectOne("selectMyOrderNum",member_id);
	}

	@Override
	public int insertOrderDetail(int orderNumber, int book_id, int quantity, int price) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("order_id", orderNumber);
		map.put("book_id", book_id);
		map.put("quantity", quantity);
		map.put("price", price);
		return sqlSessionTemplate.insert("orderDetailInsert",map);
	}

	@Override
	public OrderDto getPaymentInfo(String member_id) {
		return sqlSessionTemplate.selectOne("selectPaymentInfo", member_id);
	}

	@Override
	public OrderDto getPayInfoByBookId(int book_id) {
		return sqlSessionTemplate.selectOne("getPayInfoByBookId", book_id);
	}

	@Override
	public List<Integer> getBookIdArray(int orderNumber) {
		return sqlSessionTemplate.selectList("selectIdArray", orderNumber);
	}

	@Override
	public int deleteFromCart(String member_id) {
		return sqlSessionTemplate.delete("deleteFromCart",member_id);
	}
}
