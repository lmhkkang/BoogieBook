package com.boogie.bookInfo.dao;

import java.util.HashMap;
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
	
	@Override
	public String getIdList(int member_num) {
		return sqlSessionTemplate.selectOne("selectIDList",member_num);
	}
	
	@Override
	public float getRateAverage(int book_id) {
		
		return sqlSessionTemplate.selectOne("selectRateAverate",book_id);
	}

	@Override
	public List<BookInfoDto> getBestSeller(String bookType) {
		return sqlSessionTemplate.selectList("selectBestSeller", bookType);
	}

	@Override
	public List<BookInfoDto> getNewBook(String bookType) {
		return sqlSessionTemplate.selectList("selectNewBook", bookType);
	}


	@Override
	public List<BookInfoDto> BookList(int startRow, int endRow, String bookType) {
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("bookType", bookType);
		
		return sqlSessionTemplate.selectList("selectKoreanBook", hMap);
	}

	@Override
	public int bookCount() {
		return sqlSessionTemplate.selectOne("bookCount");
	}

}
