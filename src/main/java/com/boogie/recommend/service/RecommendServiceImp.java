package com.boogie.recommend.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.dao.RecommendDao;
import com.boogie.recommend.dto.RecommendInterestDto;

/**
 * @Author	: 나다윤
 * @Date	: 2019. 8. 1.
 * @Description :
 */

@Component
public class RecommendServiceImp implements RecommendService {

	@Autowired
	private RecommendDao recommandDao; 
	
	@Override
	public void recommendMain(ModelAndView mav) 
	{
		Map<String, Object> map = mav.getModelMap();
		
		RecommendInterestDto interestDto = new RecommendInterestDto();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		//String id = request.getParameter("id");
		String id = "tmp";
		
		String interest = recommandDao.getInterest(id);
		BookAspect.logger.info(BookAspect.logMsg+"interest: "+interest);
		
		//임시
		interest="소설";
		interestDto = recommandDao.getBookInterest(interest);
		BookAspect.logger.info(BookAspect.logMsg+interestDto.toString());
		
		//네이버 책 검색 api를 통해 줄거리 미리보기 가져오기

		String clientId = "v8R5FbX43_upxHbbKBRy";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "GAYVywiXFj";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(interestDto.getBook_name(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            
        } catch (Exception e) {
           e.printStackTrace();
        }
	 

		
		mav.addObject("interestDto", interestDto);
		
		//mav.setViewName("recommend/recommendMain");
		
	}

}
