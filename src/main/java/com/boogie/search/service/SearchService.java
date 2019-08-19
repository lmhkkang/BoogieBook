package com.boogie.search.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.boogie.bookInfo.dto.BookInfoDto;
import com.boogie.search.dto.SearchDto;

public interface SearchService {
	public void detailSearch(ModelAndView mav);
	public void searchResult(ModelAndView mav);
	public void multiOk(ModelAndView mav) throws ParseException;
	public List<SearchDto> autocomplete(ModelAndView mav);
	public void severalSearch(ModelAndView mav);
	public List<SearchDto> getCookies(ModelAndView mav);
}
