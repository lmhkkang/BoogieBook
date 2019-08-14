package com.boogie.search.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
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
		String day1 = year01 + "-" + month01 + "-" + "01";

		String year02 = request.getParameter("year02");
		String month02 = request.getParameter("month02");
		String day2 = year02 + "-" + month02 + "-" + "01";
		BookAspect.logger.info(BookAspect.logMsg + "day1: " + day1 + "\t day2" + day2);

		String price01 = request.getParameter("price01");
		String price02 = request.getParameter("price02");

		if (price01 == null || price01 == "") {
			price01 = "0";
		}
		if (price02 == null || price02 == "") {
			price02 = "999999";
		}
		int startprice = Integer.parseInt(price01);
		int endprice = Integer.parseInt(price02);

		int boardSize = 5;

		if (pageNumber == null || pageNumber == "")
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		int startRow = (currentPage - 1) * boardSize + 1;// 1-1=0*10=0+1=1
		int endRow = currentPage * boardSize;// 1*10=10

		int count = 0;

		count = searchDao.searchCount(type, book_name, author, publisher, day1, day2, startprice, endprice);
		BookAspect.logger.info(BookAspect.logMsg + "count: " + count);
		List<SearchDto> searchPageResult = null;
		searchPageResult = searchDao.multiPageList(type, book_name, author, publisher, startRow, endRow, day1, day2,
				startprice, endprice);

		mav.addObject("searchPageResult", searchPageResult);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);

		mav.addObject("boardSize", boardSize);
		mav.addObject("type", type);
		mav.addObject("book_name", book_name);
		mav.addObject("author", author);
		mav.addObject("publisher", publisher);

		mav.addObject("year01", year01);
		mav.addObject("month01", month01);
		mav.addObject("year02", year02);
		mav.addObject("month02", month02);
		mav.addObject("price02", price02);
		mav.addObject("price01", price01);

		mav.setViewName("search/multiOk");
	}

	@Override
	public List<SearchDto> autocomplete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");

		List<SearchDto> list = searchDao.listAll2(); // result값이 포함되어 있는 emp테이블의 네임을 리턴

		return list;
	}

	@Override
	public void severalSearch(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String content = request.getParameter("content");
		BookAspect.logger.info(BookAspect.logMsg + "content: " + content);
		content = content.trim();
		String[] keyword = content.split("\n");

		for (int i = 0; i < keyword.length; i++) {
			keyword[i] = keyword[i].trim();
		}

		BookAspect.logger.info(BookAspect.logMsg + "keywords: " + keyword.length);
		HashMap<Integer, List<SearchDto>> listMap = new HashMap<Integer, List<SearchDto>>();

		for (int i = 0; i < keyword.length; i++) {
			listMap.put(i, searchDao.keywordSearch(keyword[i]));
			mav.addObject("searchResult" + i, listMap.get(i));
			mav.addObject("count" + i, listMap.get(i).size());
			mav.addObject("keyword" + i, keyword[i]);
		}
		mav.addObject("content", content);
		mav.setViewName("search/severalSearchOk");
	}

	@Override
	public List<SearchDto> getCookies(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int cnt=0;
		ArrayList<SearchDto> list=new ArrayList<SearchDto>();
		Cookie[] getCookie = request.getCookies();
		SearchDto dto=new SearchDto();
		if (getCookie != null) {

			for (int i = 0; i < getCookie.length; i++) {

				Cookie c = getCookie[i];

				String name = c.getName(); // 쿠키 이름 가져오기
				String check = "";
				check = name.substring(0, 2);				
				
				if (check.equals("id")) {
					cnt++;
					String book_id = c.getValue(); // 쿠키 값 가져오기
					System.out.println(book_id);
					dto=searchDao.getOneBook(book_id);
					System.out.println(dto.toString());
					list.add(dto);
				}												
			}
		}
		return list;
	}
}
