package com.boogie.bookInfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.bookInfo.dao.BookInfoDao;
import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.recommend.dto.RecommendMarkDto;
import com.boogie.review.dto.ReviewDto;

@Component
public class BookInfoServiceImp implements BookInfoService {

	@Autowired
	private BookInfoDao bookInfoDao;
	
	@Override
	public void BookInfoMain(ModelAndView mav) {
		
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		BookAspect.logger.info(BookAspect.logMsg+"book_id:"+book_id);
		
		BookInfoDto bookInfoDto = new BookInfoDto();
		bookInfoDto = bookInfoDao.writeBookInfo(book_id);
		BookAspect.logger.info(BookAspect.logMsg+bookInfoDto.toString());
		
		//---------------여기까지 책에관한 정보------------------------------
		
		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
		reviewList = bookInfoDao.getReviewList(book_id);
		
		BookAspect.logger.info(BookAspect.logMsg+"reviewListSize:"+reviewList.size());
		
		
		List<String> idList = new ArrayList<String>();
		
		for(int i = 0 ; i < reviewList.size(); i++) {
			reviewList.get(i).setMember_id((bookInfoDao.getIdList(reviewList.get(i).getMember_num())));
		}
		
		if(reviewList.size()!=0) {
			float rate_average = bookInfoDao.getRateAverage(book_id);
			mav.addObject("rate_average",rate_average);
		}
			
		
		
		
		mav.addObject("idList",idList);
		mav.addObject("book_id",book_id);
		mav.addObject("reviewList_size",reviewList.size());
		mav.addObject("reviewList",reviewList);
		mav.addObject("bookInfoDto", bookInfoDto);
		//mav.setViewName("book/bookInfo");
		
	}

	@Override
	public void bestSellerMain(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		List<BookInfoDto> bestSellerList = new ArrayList<BookInfoDto>();
		
		String bookType = request.getParameter("bookType");
		if(bookType==null) {
			bookType = "%";
		}
		BookAspect.logger.info(BookAspect.logMsg+"bookType : "+ bookType);
		bestSellerList = bookInfoDao.getBestSeller(bookType);
		
		if(bookType.equals("%")) {
			bookType = "종합";
		}
		
		mav.addObject("bestSellerList",bestSellerList);
		mav.addObject("bookType", bookType);
		mav.setViewName("bestSeller/bestSellerMain");
		
	}

}
