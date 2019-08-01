package com.boogie.recommend.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.recommend.dto.RecommendInterestDto;

/**
 * @Author	: 나다윤
 * @Date	: 2019. 8. 1.
 * @Description :
 */

@Component
public class RecommendDaoImp implements RecommendDao 
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public String getInterest(String id) {
		return sqlSessionTemplate.selectOne("dao.recommendMapper.RecommendSelectInterest",id);
	}

	@Override
	public RecommendInterestDto getBookInterest(String interest) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("dao.recommendMapper.RecommendSelectInterestBook",interest);
	}
	
}
