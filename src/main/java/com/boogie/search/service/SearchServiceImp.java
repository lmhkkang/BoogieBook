package com.boogie.search.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.search.dao.SearchDao;
import com.boogie.search.dto.SearchDto;

@Component
public class SearchServiceImp implements SearchService {
	
	@Autowired
	private SearchDao searchDao;
	
	@Override
	public void detailSearch(ModelAndView mav) {
		// TODO Auto-generated method stub
		mav.setViewName("search/detail_search");
	}
	
	@Override
	public void searchResult(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String keyword = request.getParameter("keyword");
		BookAspect.logger.info(BookAspect.logMsg+"keyword: "+keyword);
		
		List<SearchDto> searchResult=null;		
		if(keyword!=null) {
			searchResult=searchDao.keywordSearch(keyword);
		}
		mav.addObject("searchResult", searchResult);
		mav.setViewName("search/searchOk");
	}
}
