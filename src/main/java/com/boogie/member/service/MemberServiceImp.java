package com.boogie.member.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.member.dao.MemberDao;
import com.boogie.member.dto.MemberDto;

@Component
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void memberRegisterOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		MemberDto memberDto = new MemberDto();
		
		int gender = 0;;
		
		if(request.getParameter("gender").equals("male")) {
			gender = 1;
		}
		else {
			gender = 2;
		}
		
		memberDto.setMember_id(request.getParameter("member_id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setBirth_date(request.getParameter("birth_date"));
		memberDto.setGender(gender);
		memberDto.setPhone(request.getParameter("phone"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddr1(request.getParameter("addr1"));
		memberDto.setAddr2(request.getParameter("addr2"));
		memberDto.setJob(request.getParameter("job"));
		memberDto.setInterest(request.getParameter("interestValue"));
		memberDto.setNon_member(1);
		memberDto.setSns_num(3);
		memberDto.setRegister_date(new Date());
		
		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
				
		int check = memberDao.memberInsert(memberDto);
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		
		// mav.setViewName("member/registerOk");	
		mav.setViewName("member/registerOk");	
	}

	@Override
	public void idDuplChk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		
		int check = memberDao.memberCheckId(id);
		BookAspect.logger.info(BookAspect.logMsg + check);
		
		mav.addObject("check", String.valueOf(check));
	}

}
