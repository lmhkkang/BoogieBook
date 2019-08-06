package com.boogie.recommend.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<String[]> getReview() {
		List<Map<String, Object>> tmp = new ArrayList<Map<String,Object>>();
		tmp = sqlSessionTemplate.selectList("dao.recommendMapper.ReviewSelectList");
			
		List<String[]> result = new ArrayList<String[]>();
		for(int i = 0 ; i < tmp.size() ; i++) {
			String[] tmp_s = new String[3];
			tmp_s[0]=String.valueOf(tmp.get(i).get("MEMBER_NUM"));
			tmp_s[1]=String.valueOf(tmp.get(i).get("BOOK_ID"));
			tmp_s[2]=String.valueOf(tmp.get(i).get("RATE"));
			
			result.add(tmp_s);
		}
		
		return result;
	}
}
