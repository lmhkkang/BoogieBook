package com.boogie.bookInfo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.review.dto.ReviewDto;

@Component
public class BookInfoDaoImp implements BookInfoDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public BookInfoDto writeBookInfo(int book_id) {	
		return sqlSessionTemplate.selectOne("selectBookInfo",book_id);
	}

	@Override
	public List<ReviewDto> getReviewList(int book_id) {
		return sqlSessionTemplate.selectList("selectReviewList",book_id);
	}

}
