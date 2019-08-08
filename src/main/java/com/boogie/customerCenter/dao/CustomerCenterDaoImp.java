package com.boogie.customerCenter.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.customerCenter.dto.StoreMapDto;

@Component
public class CustomerCenterDaoImp implements CustomerCenterDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public StoreMapDto getLatAndLongt(int location_code) {
		return sqlSessionTemplate.selectOne("selectLocation", location_code);
	}

}
