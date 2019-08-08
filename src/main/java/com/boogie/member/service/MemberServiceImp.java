package com.boogie.member.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		if(request.getParameter("gender").equals("Male")) {
			gender = 1;
		}
		else {
			gender = 2;
		}
		
		memberDto.setMember_id(request.getParameter("member_id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setName(request.getParameter("name"));

		try {
			memberDto.setBirth_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		if(check > 0) {
			MemberDto memberDto = memberDao.memberSearch(id);
			String name = memberDto.getName();
			int snsNum = memberDto.getSns_num();
			mav.addObject("name", name);
			mav.addObject("snsNum", snsNum);
		}
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
	public void memberEdit(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		
		MemberDto memberDto = memberDao.memberSearch(id);
		
		String birthDate = new SimpleDateFormat("yyyy-MM-dd").format(memberDto.getBirth_date());
	
		String[] birth_date = birthDate.split("-");
		int yyyy = Integer.parseInt(birth_date[0]);
		int mm = Integer.parseInt(birth_date[1]);
		int dd = Integer.parseInt(birth_date[2]);
		
		mav.addObject("memberDto", memberDto);
		mav.addObject("yyyy", yyyy);
		mav.addObject("mm", mm);
		mav.addObject("dd", dd);
		mav.setViewName("member/memberEdit");
		
	}

	@Override
	public void memberEditOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		MemberDto memberDto = new MemberDto();
		
		int gender = 0;;
		
		if(request.getParameter("gender").equals("Male")) {
			gender = 1;
		}
		else {
			gender = 2;
		}
		
		memberDto.setMember_id(request.getParameter("member_id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setName(request.getParameter("name"));

		try {
			memberDto.setBirth_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		memberDto.setGender(gender);
		memberDto.setPhone(request.getParameter("phone"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddr1(request.getParameter("addr1"));
		memberDto.setAddr2(request.getParameter("addr2"));
		memberDto.setJob(request.getParameter("job"));
		memberDto.setInterest(request.getParameter("interestValue"));
		
		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
				
		int check = memberDao.memberUpdate(memberDto);
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		mav.addObject("id", memberDto.getMember_id());
		mav.addObject("name", memberDto.getName());
		mav.addObject("snsNum", memberDto.getSns_num());
		mav.setViewName("member/memberEditOk");	
	
	}

	@Override
	public void memberKaKaoRegisterOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		MemberDto memberDto = new MemberDto();
		
		int gender = 0;;
		
		if(request.getParameter("gender").equals("Male")) {
			gender = 1;
		}
		else {
			gender = 2;
		}
		
		memberDto.setMember_id(request.getParameter("id"));
		memberDto.setName(request.getParameter("name"));

		try {
			memberDto.setBirth_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		memberDto.setGender(gender);
		memberDto.setPhone(request.getParameter("phone"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddr1(request.getParameter("addr1"));
		memberDto.setAddr2(request.getParameter("addr2"));
		memberDto.setJob(request.getParameter("job"));
		memberDto.setInterest(request.getParameter("interestValue"));
		memberDto.setNon_member(1);
		memberDto.setSns_num(1);
		memberDto.setRegister_date(new Date());
		
		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
				
		int check = memberDao.memberKaKaoInsert(memberDto);
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		mav.addObject("id", memberDto.getMember_id());
		mav.addObject("name", memberDto.getName());
		mav.addObject("snsNum", memberDto.getSns_num());
		
		// mav.setViewName("member/registerOk");	
		mav.setViewName("member/KaKaoRegisterOk");	
	}

	@Override
	public void memberKaKaologinOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		BookAspect.logger.info(BookAspect.logMsg + "id : " + id);
		
		MemberDto memberDto = memberDao.memberSearch(id);
		System.out.println(memberDto.toString());
		String name = memberDto.getName();
		int snsNum = memberDto.getSns_num();
		
		mav.addObject("check", 1);
		mav.addObject("id", id);
		mav.addObject("name", name);
		mav.addObject("snsNum", snsNum);
		mav.setViewName("member/loginOk");		
	}

	@Override
	public void memberKaKaoEdit(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		
		MemberDto memberDto = memberDao.memberSearch(id);
		
		String birthDate = new SimpleDateFormat("yyyy-MM-dd").format(memberDto.getBirth_date());
	
		String[] birth_date = birthDate.split("-");
		int yyyy = Integer.parseInt(birth_date[0]);
		int mm = Integer.parseInt(birth_date[1]);
		int dd = Integer.parseInt(birth_date[2]);
		
		mav.addObject("memberDto", memberDto);
		mav.addObject("yyyy", yyyy);
		mav.addObject("mm", mm);
		mav.addObject("dd", dd);
		mav.setViewName("member/KaKaoEdit");		
	}

	@Override
	public void memberKaKaoEditOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		MemberDto memberDto = new MemberDto();
		
		int gender = 0;;
		
		if(request.getParameter("gender").equals("Male")) {
			gender = 1;
		}
		else {
			gender = 2;
		}
		memberDto.setMember_id(request.getParameter("id"));
		memberDto.setName(request.getParameter("name"));

		try {
			memberDto.setBirth_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		memberDto.setGender(gender);
		memberDto.setPhone(request.getParameter("phone"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddr1(request.getParameter("addr1"));
		memberDto.setAddr2(request.getParameter("addr2"));
		memberDto.setJob(request.getParameter("job"));
		memberDto.setInterest(request.getParameter("interestValue"));
		
		BookAspect.logger.info(BookAspect.logMsg + memberDto.toString());
				
		int check = memberDao.memberKaKaoUpdate(memberDto);
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		mav.addObject("id", memberDto.getMember_id());
		mav.addObject("name", memberDto.getName());
		mav.addObject("snsNum", memberDto.getSns_num());
		mav.setViewName("member/KaKaoEditOk");	
		
	}

	@Override
	public void memberWithdrawalOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("member_id");
		String password = request.getParameter("password");
		BookAspect.logger.info(BookAspect.logMsg + id + ", " + password);
		
		int check = memberDao.memberDelete(id, password);
		BookAspect.logger.info(BookAspect.logMsg + check);

		mav.addObject("check", check);
		
		mav.setViewName("member/memberWithdrawalOk");
		
	}

	@Override
	public void memberKaKaoWithdrawalOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		BookAspect.logger.info(BookAspect.logMsg + id);
		
		int check = memberDao.memberKaKaoDelete(id);
		BookAspect.logger.info(BookAspect.logMsg + check);
		
		mav.addObject("check", check);
		mav.setViewName("member/KaKaoWithdrawalOk");
		
	}
}
