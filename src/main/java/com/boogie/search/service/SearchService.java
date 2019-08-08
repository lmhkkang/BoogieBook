package com.boogie.search.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.search.dto.SearchDto;

public interface SearchService {
	public void detailSearch(ModelAndView mav);
	public void searchResult(ModelAndView mav);
	public void multiOk(ModelAndView mav) throws ParseException;
	public List<SearchDto> autocomplete(ModelAndView mav);
}
