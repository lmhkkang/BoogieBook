package com.boogie.admin.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.boogie.bookInfo.dto.BookInfoDto;

public interface AdminService {
	public void adminMain(ModelAndView mav);
	public void adminMemMng(ModelAndView mav);
	public void adminMemMngEditOk(ModelAndView mav);
	public void adminMemMngEdit(ModelAndView mav);
	public void adminMemMngDel(ModelAndView mav);
	public void adminBookMng(ModelAndView mav);
	public void adminBookMngInsert(ModelAndView mav);
	public void adminFAQRegMng(ModelAndView mav);
	public void adminOrdMng(ModelAndView mav);
	public void adminBookSearchMng(ModelAndView mav);
	public void adminBookEditMng(ModelAndView mav);
	public void adminBookMngUpdate(ModelAndView mav);
	public void adminBookDelMng(ModelAndView mav);
	public void adminOrdStat(ModelAndView mav);
	public void adminMemSearchId(ModelAndView mav);
	public void adminChangeOrdStat(ModelAndView mav);
	public void adminDelOrd(ModelAndView mav);
	public void adminOrdSearchMng(ModelAndView mav);
	public void adminFAQMng(ModelAndView mav);
	public void adminFAQStat(ModelAndView mav);
	public void adminFAQEditMng(ModelAndView mav);
	public void adminFAQUpdate(ModelAndView mav);
	public void adminFAQDelMng(ModelAndView mav);
}
