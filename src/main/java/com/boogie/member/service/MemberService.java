package com.boogie.member.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void memberRegisterOk(ModelAndView mav);
	public void idDuplChk(ModelAndView mav);
	public void loginOk(ModelAndView mav);
	public void findId(ModelAndView mav);
	public void findPassword(ModelAndView mav);
	public void makePasswordOk(ModelAndView mav);
}
