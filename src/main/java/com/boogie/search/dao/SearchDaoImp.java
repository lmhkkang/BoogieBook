package com.boogie.search.dao;

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
		return sqlSessionTemplate.selectList("dao.searchMapper.searchList",keyword);
	}
}
