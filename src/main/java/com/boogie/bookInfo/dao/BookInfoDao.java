package com.boogie.bookInfo.dao;

import java.util.List;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.review.dto.ReviewDto;

public interface BookInfoDao {

	public BookInfoDto writeBookInfo(int book_id);
	public List<ReviewDto> getReviewList(int book_id);
	public String getIdList(int member_num);
	public float getRateAverage(int book_id);
	public List<BookInfoDto> getBestSeller(String bookType);

}
