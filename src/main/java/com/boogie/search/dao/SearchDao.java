package com.boogie.search.dao;

import java.util.List;

import com.boogie.search.dto.SearchDto;

public interface SearchDao {
	public List<SearchDto>keywordSearch(String keyword);
	public List<SearchDto>searchList(int startRow, int endRow);
	public List<SearchDto>pageList(String keyword, int startRow, int endRow);
}
