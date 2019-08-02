package com.boogie.search.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SearchServiceImp implements SearchService {
	@Override
	public void detailSearch(ModelAndView mav) {
		// TODO Auto-generated method stub
		mav.setViewName("search/detail_search");
	}
}
