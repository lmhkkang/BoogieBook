package com.boogie.customerCenter.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.aop.BookAspect;
import com.boogie.customerCenter.dao.CustomerCenterDao;
import com.boogie.customerCenter.dto.FaqBoardDto;
import com.boogie.customerCenter.dto.StoreMapDto;

@Component
public class CustomerCenterServiceImp implements CustomerCenterService {

	@Autowired
	private CustomerCenterDao customerCenterDao;
	
	@Override
	public StoreMapDto getLatAndLongt(int location_code) {
		StoreMapDto storeMapDto = new StoreMapDto();
		storeMapDto = customerCenterDao.getLatAndLongt(location_code);
		BookAspect.logger.info(BookAspect.logMsg + storeMapDto.toString());
		
		return storeMapDto;
	}

	@Override
	public List<FaqBoardDto> getFaq(int question_code) {
		List<FaqBoardDto> faqList = new ArrayList<FaqBoardDto>();
		faqList = customerCenterDao.getFaq(question_code);
		return faqList;
	}

	@Override
	public String getAnswer(int board_number) {
		String answer = customerCenterDao.getAnswer(board_number);
		return answer;
	}



}
