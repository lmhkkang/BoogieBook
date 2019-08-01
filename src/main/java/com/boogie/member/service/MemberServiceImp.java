package com.boogie.member.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.member.dao.MemberDao;

@Component
public class MemberServiceImp implements MemberService {
	

	
	@Override
	public void memberRegisterOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
//		MemberDto memberDto = new MemberDto();
//		
//		memberDto.setMember_id(request.getParameter("id"));
//		memberDto.setPassword(request.getParameter("password"));
//		memberDto.setEmail(request.getParameter("email"));
//		memberDto.setName(request.getParameter("name"));
//		memberDto.setBirth_date(request.getParameter(""));
//		memberDto.setGender(request.getParameter(""));
//		memberDto.setPhone(request.getParameter(""));
//		memberDto.setZipcode(request.getParameter("zipcode"));
//		memberDto.setAddr1(request.getParameter("addr1"));
//		memberDto.setAddr2(request.getParameter("addr2"));
//		memberDto.setJob(request.getParameter(""));
//		memberDto.setInterest(request.getParameter(""));
//		memberDto.setNon_member(1);
//		memberDto.setSns_num(3);
//		memberDto.setRegister_date(new Date());
		
//		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
				
		int check = 0;
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		
		// mav.setViewName("member/registerOk");	
		mav.setViewName("member/registerOk");	
		
	}

}
