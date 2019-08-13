package com.boogie.search.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.search.dto.SearchDto;

@Component
public class SearchDaoImp implements SearchDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SearchDto> keywordSearch(String keyword) {
		return sqlSessionTemplate.selectList("dao.searchMapper.searchList", keyword);
	}

	@Override
	public List<SearchDto> searchList(int startRow, int endRow) {
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSessionTemplate.selectList("dao.searchMapper.searchPageResult", hMap);
	}

	@Override
	public List<SearchDto> pageList(String keyword, int startRow, int endRow) {
		HashMap<String, Object> hMap=new HashMap<String, Object>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("keyword", keyword);
		return sqlSessionTemplate.selectList("dao.searchMapper.PageList", hMap);
	}
	@Override
	public int searchCount(String type, String book_name, String author, String publisher, String startDay, String endDay, int price01, int price02) {
		HashMap<String, Object> hMap=new HashMap<String, Object>();
		hMap.put("book_name", book_name);
		hMap.put("type", type);
		hMap.put("author", author);
		hMap.put("publisher", publisher);
		hMap.put("startDay", startDay);
		hMap.put("endDay", endDay);
		hMap.put("price01", price01);
		hMap.put("price02", price02);
		return sqlSessionTemplate.selectOne("dao.searchMapper.searchCount", hMap);
	}
	@Override
	public List<SearchDto> multiPageList(String type, String book_name, String author, String publisher, int startRow,
			int endRow, String startDay, String endDay, int price01, int price02) {
		HashMap<String, Object> hMap=new HashMap<String, Object>();
		hMap.put("type", type);
		hMap.put("book_name", book_name);
		hMap.put("author", author);
		hMap.put("publisher", publisher);
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("startDay", startDay);
		hMap.put("endDay", endDay);
		hMap.put("price01", price01);
		hMap.put("price02", price02);
		return sqlSessionTemplate.selectList("dao.searchMapper.multiList", hMap);
	}
	@Override
	public List<SearchDto> listAll2() {
		return sqlSessionTemplate.selectList("dao.searchMapper.autoList");
	}
}
