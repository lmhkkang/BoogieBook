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

	@Override
	public void loginOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		BookAspect.logger.info(BookAspect.logMsg + "id : " + id + ", password" + password);
		
		int check = memberDao.memberLoginOk(id, password);
		BookAspect.logger.info(BookAspect.logMsg + check);
		
		mav.addObject("id", id);
		mav.addObject("check", check);
		mav.setViewName("member/loginOk");
	}

	@Override
	public void findId(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(name);
		System.out.println(email);
		
		String id = memberDao.memberFindId(name, email);
		
		BookAspect.logger.info(BookAspect.logMsg + id);
		mav.addObject("id", id);
		mav.addObject("name", name);	
	}

	@Override
	public void findPassword(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String member_id = request.getParameter("member_id");
		String email = request.getParameter("email");
		
		char[] charSet = new char[] 
				{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' }; 
		int idx = 0; 
		StringBuffer sb = new StringBuffer(); 
		System.out.println("charSet.length :::: " + charSet.length); 
		for (int i = 0; i < 10; i++) { 
			idx = (int) (charSet.length * Math.random()); 
		System.out.println("idx :::: "+idx); sb.append(charSet[idx]); 
		}
		
		int check = memberDao.memberFindPassword(member_id, email, sb.toString());
		
		BookAspect.logger.info(BookAspect.logMsg + check);
		mav.addObject("check", check);
		mav.addObject("temporaryPw", sb.toString());		
	}

	@Override
	public void makePasswordOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String newPassword = request.getParameter("newPassword"); 
		String member_id = request.getParameter("member_id");
		
		int check = memberDao.memberMakePassword(member_id, newPassword);
		mav.addObject("check", check);
	}
}
