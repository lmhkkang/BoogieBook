package com.boogie.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.boogie.member.service.MemberService;
import com.boogie.recommend.service.RecommendService;

@Controller
public class BookController {
	
	@Autowired
	private RecommendService recommendService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/recommend/recommendMain.do", method = RequestMethod.GET)
	public ModelAndView recommendMain(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		recommendService.recommendMain(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/register");
	}
	
	@RequestMapping(value="/member/registerOk.do", method=RequestMethod.GET)
	public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response){		

		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		memberService.memberRegisterOk(mav);
		return mav;
	}
	
	@RequestMapping(value = "/member/idCheck.do" , method = RequestMethod.GET)
	public @ResponseBody String idCheck(HttpServletRequest request, HttpServletResponse response)  {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		memberService.idDuplChk(mav);
		
		Map<String, Object> map=mav.getModelMap();
		String check = (String) map.get("check");
		
		return check;	
	}
	
	@RequestMapping(value="/member/content.do", method=RequestMethod.GET)
	public ModelAndView readContent1(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("check", request.getParameter("check"));
		mav.setViewName("member/content");
		return mav;
	}	    
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response){

		return new ModelAndView("member/login");
	}
}
