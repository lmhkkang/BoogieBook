package com.boogie.index.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.index.dao.IndexDao;
import com.boogie.index.dto.IndexDto;
import com.boogie.recommend.dto.RecommendInterestDto;

@Component
public class IndexServiceImp implements IndexService {
	
	@Autowired
	private IndexDao indexDao;
	
	@Override
	public void indexGetInfo(ModelAndView mav) 
	{
		Map<String, Object> map = mav.getModelMap();

		IndexDto todayDto = new IndexDto();

		HttpServletRequest request = (HttpServletRequest) map.get("request");


		todayDto = indexDao.getTodayBook();
		BookAspect.logger.info(BookAspect.logMsg + todayDto.toString());
		
		mav.addObject("todayDto", todayDto);
		
		mav.setViewName("forward:/index.jsp");

	}
}
