package com.boogie.review.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDaoImp implements ReviewDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int reviewWrite(HashMap<String, Object> map) {
		System.out.println(map.get("review_content"));
		System.out.println(map.get("id"));
		System.out.println(map.get("book_id"));
		System.out.println(map.get("rate"));
		
		return sqlSessionTemplate.insert("reviewWrite",map);
	}
}
