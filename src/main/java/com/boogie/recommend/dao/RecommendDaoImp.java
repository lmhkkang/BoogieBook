package com.boogie.recommend.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.dto.RecommendInterestDto;
import com.boogie.recommend.dto.RecommendMarkDto;

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
	public String getInterest(String id) 
	{
		return sqlSessionTemplate.selectOne("dao.recommendMapper.RecommendSelectInterest",id);
	}

	@Override
	public RecommendInterestDto getBookInterest(String interest) 
	{
		return sqlSessionTemplate.selectOne("dao.recommendMapper.RecommendSelectInterestBook",interest);
	}
	
	@Override
	public List<String> getMarkBookName() 
	{
		return sqlSessionTemplate.selectList("dao.recommendMapper.MarkSelectBookName");
	}
	
	@Override
	public List<RecommendMarkDto> getMarkBookList(List<String> markBookName) {
//		Map<String, String> bookIdList = new HashMap<String, String>();
//		
//		bookIdList.put("one",markBookName.get(0));
//		bookIdList.put("two",markBookName.get(1));
//		bookIdList.put("three",markBookName.get(2));
//		bookIdList.put("four",markBookName.get(3));
//		
//		return sqlSessionTemplate.selectList("dao.recommendMapper.MarkSelectBook",bookIdList);
		
		List<RecommendMarkDto> tmp = new ArrayList<RecommendMarkDto>();
		
		for(int i = 0 ; i < 4 ; i++) 
		{
			String input = markBookName.get(i);
			RecommendMarkDto tmpDto = sqlSessionTemplate.selectOne("dao.recommendMapper.MarkSelectBook",input);
			BookAspect.logger.info(BookAspect.logMsg+tmpDto.toString());
			
			tmp.add(tmpDto);
		}
		
		return tmp;
	}
	
	@Override
	public List<Float> getMarkList() {
		return sqlSessionTemplate.selectList("dao.recommendMapper.MarkSelectList");
	}
}
