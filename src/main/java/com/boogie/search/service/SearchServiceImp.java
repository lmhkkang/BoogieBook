package com.boogie.search.service;

import java.util.Collection;
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

		BookAspect.logger.info(BookAspect.logMsg + "keyword: " + keyword);
		String pageNumber = request.getParameter("pageNumber");

		int boardSize = 5;

		if (pageNumber == null || pageNumber == "")
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage - 1) * boardSize + 1;// 1-1=0*10=0+1=1
		int endRow = currentPage * boardSize;// 1*10=10

		int count = 0;
		System.out.println("pagenumger" + pageNumber + "current" + currentPage + "start" + startRow + "end" + endRow);
		List<SearchDto> searchResult = null;
		List<SearchDto> searchPageResult = null;

		
		searchResult = searchDao.keywordSearch(keyword);
		count = searchResult.size();
		searchPageResult = searchDao.pageList(keyword, startRow, endRow);

		if (keyword == "") {
			count = 0;
			searchResult = null;
		}

		mav.addObject("searchPageResult", searchPageResult);
		mav.addObject("searchResult", searchResult);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardSize", boardSize);
		mav.addObject("count", count);
		mav.addObject("keyword", keyword);

		mav.setViewName("search/searchOk");
	}
	@Override
	public void multiOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String keyword = request.getParameter("keyword");
		
		mav.setViewName("search/multiOk");
	}
}
