package com.boogie.search.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONValue;
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
	public void multiOk(ModelAndView mav) throws ParseException {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String type = request.getParameter("type");
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String pageNumber = request.getParameter("pageNumber");
		
		String year01 = request.getParameter("year01");
		String month01 = request.getParameter("month01");
		String day1=year01+"-"+month01+"-"+"01";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date startDay = sdf.parse(day1);
		
		
		String year02 = request.getParameter("year01");
		String month02 = request.getParameter("month01");
		String day2=year02+"-"+month02+"-"+"01";
		Date endDay = sdf.parse(day2);
		
		int boardSize = 5;

		if (pageNumber == null || pageNumber == "")
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage - 1) * boardSize + 1;// 1-1=0*10=0+1=1
		int endRow = currentPage * boardSize;// 1*10=10

		int count = 0;
		
		count=searchDao.searchCount(type, book_name, author, publisher);
		BookAspect.logger.info(BookAspect.logMsg + "count: " + count);
		List<SearchDto> searchPageResult = null;
		searchPageResult = searchDao.multiPageList(type,book_name,author,publisher, startRow, endRow);
		
		mav.addObject("searchPageResult", searchPageResult);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		
		mav.addObject("boardSize", boardSize);
		mav.addObject("type", type);
		mav.addObject("book_name", book_name);
		mav.addObject("author", author);
		mav.addObject("publisher", publisher);
		
		mav.setViewName("search/multiOk");
	}
	@Override	
	public List<SearchDto> autocomplete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		 List<SearchDto> list = searchDao.listAll2(); //result값이 포함되어 있는 emp테이블의 네임을 리턴
		 
		 return list;
	}
}
