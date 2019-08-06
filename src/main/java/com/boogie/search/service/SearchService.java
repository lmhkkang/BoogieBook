package com.boogie.search.service;

import org.springframework.web.servlet.ModelAndView;

public interface SearchService {
	public void detailSearch(ModelAndView mav);
	public void searchResult(ModelAndView mav);
	public void multiOk(ModelAndView mav);
}
