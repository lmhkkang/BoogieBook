package com.boogie.bookInfo.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.boogie.bookInfo.dto.BookInfoDto;

public interface BookInfoService {

	public void BookInfoMain(ModelAndView mav);
	public void bestSellerMain(ModelAndView mav);
	public List<BookInfoDto> indexBestSeller(ModelAndView mav);
	public void newBookMain(ModelAndView mav);
	public void koreanBookMain(ModelAndView mav);
}
