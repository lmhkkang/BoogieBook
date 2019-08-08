package com.boogie.customerCenter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.aop.BookAspect;
import com.boogie.customerCenter.dao.CustomerCenterDao;
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
}
