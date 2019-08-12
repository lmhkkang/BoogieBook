package com.boogie.admin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.member.dto.MemberDto;
import com.boogie.order.dto.OrderDto;

@Component
public class AdminDaoImp implements AdminDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	//오늘 날짜를 요일(일요일:1,월요일:2,화요일:3,.....토요일:7) 로 변환
	public int getDw() {
		return sqlSessionTemplate.selectOne("dao.adminMapper.AdminSelectDw");
	}
	@Override
	public int getCountDw(int dw) {
		int value = 0;
		switch(dw) {
		case 1:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountSunDw");
			break;
		case 2:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountMonDw");
			break;
		case 3:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountTueDw");
			break;
		case 4:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountWedDw");
			break;
		case 5:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountThuDw");
			break;
		case 6:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountFriDw");
			break;
		case 7:
			value = sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountSatDw");
			break;
		}		
		return value;
	}
	@Override
	public List<MemberDto> getMemberDto() {	
		return sqlSessionTemplate.selectList("dao.adminMapper.AdminGetMemberDto");
	}
	@Override
	public int memberCount() {
		
		return sqlSessionTemplate.selectOne("dao.adminMapper.AdminCount");
	}
		//회원수정 input에 적은값을 DB에 반영시킴.
		@Override
		public int inputUpdate(HashMap<String, Object> hMap) {
			return sqlSessionTemplate.update("dao.adminMapper.AdminMemberEdit",hMap);
		}
		@Override
		public int update(String id) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int memberDelete(int num) {
			return sqlSessionTemplate.delete("dao.adminMapper.AdminMemberDelete",num);
		}
		@Override
		public List<BookInfoDto> getBookList(int startRow, int endRow) {
			HashMap<String, Object> hMap = new HashMap<String,Object>();
			hMap.put("startRow", startRow);
			hMap.put("endRow", endRow);
			return sqlSessionTemplate.selectList("dao.adminMapper.AdminGetBookList",hMap);
		}
		
		@Override
		public int getCountBook() {
			return sqlSessionTemplate.selectOne("dao.adminMapper.AdminCountBook");
		}
		
		@Override
		public int bookInsert(HashMap<String, Object> hMap) {
			return sqlSessionTemplate.insert("dao.adminMapper.AdminBookInsert",hMap);
		}
		@Override
		public int FAQInsert(HashMap<String, Object> hMap) {
			return sqlSessionTemplate.insert("dao.adminMapper.AdminFAQInsert", hMap);
		}
		@Override
		public List<OrderDto> getOrderDto() {
			return sqlSessionTemplate.selectList("dao.adminMapper.AdminGetOrderList");
		}
		/*
		@Override
		public int[] getDate() {
			
			int[] yyyymmdd = new int[3];
			
			sqlSessionTemplate.selectOne();
			
			return null;
		}
		*/
		@Override
		public int[] getDate() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
