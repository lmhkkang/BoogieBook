package com.boogie.recommend.service;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author	: 나다윤
 * @Date	: 2019. 8. 1.
 * @Description :
 */

public interface RecommendService 
{
	public void recommendMain(ModelAndView mav);
}
