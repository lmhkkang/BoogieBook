package com.boogie.admin.service;

import org.springframework.web.servlet.ModelAndView;

public interface AdminService {
	public void adminMain(ModelAndView mav);
	public void adminMemMng(ModelAndView mav);
	public void adminMemMngEditOk(ModelAndView mav);
	public void adminMemMngEdit(ModelAndView mav);
	public void adminMemMngDel(ModelAndView mav);
	public void adminBookMng(ModelAndView mav);
	public void adminBookMngInsert(ModelAndView mav);
	public void adminFAQMng(ModelAndView mav);
	public void adminOrdMng(ModelAndView mav);
}
