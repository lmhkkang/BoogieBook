package com.boogie.customerCenter.dao;

import java.util.HashMap;
import java.util.List;

import com.boogie.customerCenter.dto.StoreMapDto;

public interface CustomerCenterDao {

	StoreMapDto getLatAndLongt(int location_code);

}
