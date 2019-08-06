package com.boogie.bookInfo.dao;

import java.util.List;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.review.dto.ReviewDto;

public interface BookInfoDao {

	BookInfoDto writeBookInfo(int book_id);

	List<ReviewDto> getReviewList(int book_id);

}
