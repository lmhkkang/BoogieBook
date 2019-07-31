package com.boogie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/register");
	}
	
	@RequestMapping(value = "/member/idCheck.do" , method = RequestMethod.POST)
	public @ResponseBody String idCheck(HttpServletRequest request, HttpServletResponse response)  {
		int result = 0;
		System.out.println(result);
	    return String.valueOf(result);
		
		
//		System.out.println("123");
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("request", request);
//		
//		boardService.idDuplChk(mav);
//		
//		Map<String, Object> map=mav.getModelMap();
//		String check = (String) map.get("check");	
//		
//		BoardAscpect.logger.info(BoardAscpect.logMsg + "check : " + check);
//		
//		JSONObject jso = new JSONObject();
//		jso.put("data", check);
//		response.setContentType("text/html;charset=utf-8");
//		
//		
//		try {
//			PrintWriter out;
//			out = response.getWriter();
//			out.print(jso.get("data"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
	
	@RequestMapping(value="/member/content1.do", method=RequestMethod.GET)
	public ModelAndView readContent1(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/content1");
	}
	
	@RequestMapping(value="/member/content2.do", method=RequestMethod.GET)
	public ModelAndView readContent2(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/content2");
	}
	
	@RequestMapping(value="/member/content3.do", method=RequestMethod.GET)
	public ModelAndView readContent3(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/content3");
	}
	
	@RequestMapping(value="/member/content4.do", method=RequestMethod.GET)
	public ModelAndView readContent4(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("member/content4");
	}
	    
}
