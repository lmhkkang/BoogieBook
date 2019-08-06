package com.boogie.bookInfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.bookInfo.dao.BookInfoDao;
import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.review.dto.ReviewDto;

@Component
public class BookInfoServiceImp implements BookInfoService {

	@Autowired
	private BookInfoDao bookInfoDao;
	
	@Override
	public void writeBookInfo(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int book_id = 1;
		
		BookInfoDto bookInfoDto = new BookInfoDto();
		bookInfoDto = bookInfoDao.writeBookInfo(book_id);
		//---------------여기까지 책에관한 정보------------------------------
		
		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
		reviewList = bookInfoDao.getReviewList(book_id);		
		
		mav.addObject("reviewList",reviewList);
		mav.addObject("bookInfoDto", bookInfoDto);
		mav.setViewName("book/bookInfo");
	}

}
