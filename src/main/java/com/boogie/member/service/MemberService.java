package com.boogie.member.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void memberRegisterOk(ModelAndView mav);
	public void idDuplChk(ModelAndView mav);
	public void loginOk(ModelAndView mav);
	public void findId(ModelAndView mav);
	public void findPassword(ModelAndView mav);
	public void memberEdit(ModelAndView mav);
	public void memberEditOk(ModelAndView mav);
	public void memberKaKaoRegisterOk(ModelAndView mav);
	public void memberKaKaologinOk(ModelAndView mav);
	public void memberKaKaoEdit(ModelAndView mav);
	public void memberKaKaoEditOk(ModelAndView mav);
	public void memberWithdrawalOk(ModelAndView mav);
	public void memberKaKaoWithdrawalOk(ModelAndView mav);
}
