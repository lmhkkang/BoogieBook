package com.boogie.customerCenter.service;

import java.util.List;

import com.boogie.customerCenter.dto.FaqBoardDto;
import com.boogie.customerCenter.dto.StoreMapDto;

public interface CustomerCenterService {

	StoreMapDto getLatAndLongt(int location_code);

	List<FaqBoardDto> getFaq(int question_code);

	String getAnswer(int board_number);



}
