package com.boogie.recommend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.dao.RecommendDao;

@Component
public class RecommendServiceImp implements RecommendService {

//	@Autowired
//	private RecommendDao recommandDao; 
	
	@Override
	public void recommendMain(ModelAndView mav) {
		// TODO Auto-generated method stub
		BookAspect.logger.info(BookAspect.logMsg+"OK");
		mav.setViewName("recommend/recommend_main");
		
	}

}
