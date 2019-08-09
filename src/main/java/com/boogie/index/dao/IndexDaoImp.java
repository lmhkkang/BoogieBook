package com.boogie.index.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.index.dto.IndexDto;

@Component
public class IndexDaoImp implements IndexDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public IndexDto getTodayBook() {
		return sqlSessionTemplate.selectOne("getTodayBook");
	}
}
