package com.boogie.recommend.dao;

import com.boogie.recommend.dto.RecommendInterestDto;

public interface RecommendDao 
{
	public String getInterest(String id);
	public RecommendInterestDto getBookInterest(String interest);
}
