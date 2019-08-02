package com.boogie.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.service.RecommendService;

@Controller
public class BookController 
{
	@Autowired
	private RecommendService recommendService;
	
	@RequestMapping(value = "/recommend/recommendMain.do", method = RequestMethod.GET)
	public ModelAndView recommendMain(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		recommendService.recommendMain(mav);
		
		return mav;
	}
	
	@RequestMapping(value = "/recommend/recommendProcxy.do", method = RequestMethod.GET)
	public String recommendProcxy(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
		String clientId = "v8R5FbX43_upxHbbKBRy";
        String clientSecret = "GAYVywiXFj";
        
        String bookName = request.getParameter("bookName");
        
        try {
            String text = URLEncoder.encode(bookName, "UTF-8");
 
            String apiURL = "https://openapi.naver.com/v1/search/book.xml?query="+ text; // xml 결과
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
            StringBuffer bufferResponse = new StringBuffer();
            
            while ((inputLine = br.readLine()) != null) {
            	bufferResponse.append(inputLine);
            }
            br.close();
                       
            //System.out.println(bufferResponse.toString());
            response.setContentType("application/xml;charset=utf-8");
            PrintWriter out = response.getWriter();
			out.print(bufferResponse.toString());
            
        } catch (Exception e) {
           e.printStackTrace();
        }
		
		return null;
	}
}
