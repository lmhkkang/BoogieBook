package com.boogie.recommend.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.dao.RecommendDao;
import com.boogie.recommend.dto.RecommendInterestDto;
import com.boogie.recommend.dto.RecommendMarkDto;

/**
 * @Author : 나다윤
 * @Date : 2019. 8. 1.
 * @Description :
 */

@Component
public class RecommendServiceImp implements RecommendService 
{

	@Autowired
	private RecommendDao recommandDao;

	@Override
	public void recommendMain(ModelAndView mav) 
	{
		Map<String, Object> map = mav.getModelMap();

		RecommendInterestDto interestDto = new RecommendInterestDto();

		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// String id = request.getParameter("id");
		String id = "lmhkkang";

		String interest = recommandDao.getInterest(id);
		BookAspect.logger.info(BookAspect.logMsg + "interest: " + interest);

		// 관심분야 도서 가져오기
		// interest="소설";
		interestDto = recommandDao.getBookInterest(interest);
		BookAspect.logger.info(BookAspect.logMsg + interestDto.toString());

		// 평점 순으로 추천
		List<String> markBookName = recommandDao.getMarkBookName();
		BookAspect.logger.info(BookAspect.logMsg + "markBookName.size:" + markBookName.size());

		List<Float> markList = recommandDao.getMarkList();
		BookAspect.logger.info(BookAspect.logMsg + "markList.size:" + markList.size());

		List<RecommendMarkDto> markBookList = recommandDao.getMarkBookList(markBookName);
		BookAspect.logger.info(BookAspect.logMsg + "markBookList.size:" + markBookList.size());

		String[] markBookIcon = new String[4];
		for (int i = 0; i < 4; i++) 
		{
			if (markList.get(i) > 0 && markList.get(i) < 1) {
				markBookIcon[i]="/resources/images/mark/05.PNG";
			} else if (markList.get(i) == 1) {
				markBookIcon[i]="/resources/images/mark/1.PNG";
			} else if (markList.get(i) > 1 && markList.get(i) < 2) {
				markBookIcon[i]="/resources/images/mark/15.PNG";
			} else if (markList.get(i) == 2) {
				markBookIcon[i]="/resources/images/mark/2.PNG";
			} else if (markList.get(i) > 2 && markList.get(i) < 3) {
				markBookIcon[i]="/resources/images/mark/25.PNG";
			} else if (markList.get(i) == 3) {
				markBookIcon[i]="/resources/images/mark/3.PNG";
			} else if (markList.get(i) > 3 && markList.get(i) < 4) {
				markBookIcon[i]="/resources/images/mark/35.PNG";
			} else if (markList.get(i) == 4) {
				markBookIcon[i]="/resources/images/mark/4.PNG";
			} else if (markList.get(i) > 4 && markList.get(i) < 5) {
				markBookIcon[i]="/resources/images/mark/45.PNG";
			} else if (markList.get(i) == 5) {
				markBookIcon[i]="/resources/images/mark/5.PNG";
			}
		}

		mav.addObject("markBookIcon",markBookIcon);
		mav.addObject("markList", markList);
		mav.addObject("markBookList", markBookList);
		mav.addObject("interestDto", interestDto);

		// mav.setViewName("recommend/recommendMain");

	}

}
