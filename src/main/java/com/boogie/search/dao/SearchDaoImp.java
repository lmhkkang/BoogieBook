package com.boogie.search.dao;

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
}
