package com.boogie.customerCenter.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.customerCenter.dto.FaqBoardDto;
import com.boogie.customerCenter.dto.StoreMapDto;

@Component
public class CustomerCenterDaoImp implements CustomerCenterDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public StoreMapDto getLatAndLongt(int location_code) {
		return sqlSessionTemplate.selectOne("selectLocation", location_code);
	}

	@Override
	public List<FaqBoardDto> getFaq(int question_code) {
		return sqlSessionTemplate.selectList("selectFaqList",question_code);
	}

	@Override
	public String getAnswer(int board_number) {
		return sqlSessionTemplate.selectOne("selectAnswer", board_number);
	}

	
}
