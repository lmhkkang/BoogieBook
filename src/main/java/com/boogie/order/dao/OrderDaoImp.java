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

	@Override
	public String getUserEmail(String member_id) {
		return sqlSessionTemplate.selectOne("selectUserEmail", member_id);
	}

	@Override
	public int addToCart(int book_id, String member_id, int quantity) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("book_id",book_id);
		map.put("member_id",member_id);
		map.put("quantity",quantity);
		return sqlSessionTemplate.insert("insertToCart",map);
	}

	@Override
	public int countSameBook(int book_id, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("book_id",(Integer)book_id);
		map.put("member_id",(String)member_id);
		return sqlSessionTemplate.selectOne("selectSameBook",map);
	}

	@Override
	public int addQuantity(int book_id, String member_id, int amount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("book_id",(Integer)book_id);
		map.put("member_id",(String)member_id);
		map.put("quantity",(Integer)amount);
		return sqlSessionTemplate.update("updateQuantity",map);
	}

	@Override
	public int addOrder(String member_id, int book_id, int total_price) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("book_id",(Integer)book_id);
		map.put("member_id",(String)member_id);
		map.put("total_price",(Integer)total_price);
		return sqlSessionTemplate.insert("insertOrder",map);
	}

	@Override
	public int getBookPrice(int book_id) {
		return sqlSessionTemplate.selectOne("selectBookPrice",book_id);
	}

	@Override
	public OrderDto getOrderCheckForm(int order_id, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_id",(Integer)order_id);
		map.put("member_id",(String)member_id);
		return sqlSessionTemplate.selectOne("selectOrderCheckForm", map);
	}

	@Override
	public int getBookId(int orderNumber) {
		return sqlSessionTemplate.selectOne("selectBookId",orderNumber);
	}

	@Override
	public String getBookName(int book_id) {
		return sqlSessionTemplate.selectOne("selectBookName",book_id);
	}

	@Override
	public int cartDeleteButton(String[] book_id, String member_id) {
		HashMap<String, Object> map = null;
		int check = 0;
		
		for(int i=0;i<book_id.length; i++) {
			map = new HashMap<String, Object>();
			map.put("book_id", Integer.parseInt(book_id[i]));
			map.put("member_id", (String)member_id);
			System.out.println(book_id[i] + member_id);
			check = sqlSessionTemplate.delete("dao.orderMapper.cartDeleteButton", map);
			
			System.out.println(check);
		}
		return check;
	}
	@Override
	public int cartCount(String member_id) {
		return sqlSessionTemplate.selectOne("cartCount", member_id);
	}
	@Override
	public OrderDto NonMemberAddCart(int book_id) {
		return sqlSessionTemplate.selectOne("NonMemberAddCart",book_id);
	}
	
	@Override
	public int NonMemberAddOrder(int total, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("total",(Integer)total);
		map.put("member_id",(String)member_id);
		return sqlSessionTemplate.insert("NonMemberAddOrder",map);
	}
	@Override
	public int NonMemberAddOrderDetail(int order_id, String book_id, int quantity, int price) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_id",(Integer)order_id);
		map.put("book_id",(String)book_id);
		map.put("quantity",(Integer)quantity);
		map.put("price",(Integer)price);
		return sqlSessionTemplate.insert("NonMemberAddOrderDetail",map);
	}
	
	@Override
	public OrderDto NonMemberGetOrderInfo(int order_id) {
		return sqlSessionTemplate.selectOne("NonMemberGetOrderInfo",order_id);
	}

	@Override
	public List<OrderDto> nonMemberOrderDetailSearch(String member_id) {
		return sqlSessionTemplate.selectList("dao.orderMapper.nonMemberOrderDetailSearch", member_id);
	}
}
