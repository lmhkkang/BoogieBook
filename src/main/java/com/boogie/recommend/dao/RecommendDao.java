package com.boogie.recommend.dao;

import java.util.List;

import com.boogie.recommend.dto.RecommendInterestDto;
import com.boogie.recommend.dto.RecommendMarkDto;

public interface RecommendDao 
{
	public String getInterest(String id);
	public RecommendInterestDto getBookInterest(String interest);
	public List<String> getMarkBookName();
	public List<RecommendMarkDto> getMarkBookList(List<String> markBookName);
	public List<Float> getMarkList();
	public List<String[]> getReview();
}
