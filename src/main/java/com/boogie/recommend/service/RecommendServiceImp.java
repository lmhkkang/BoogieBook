package com.boogie.recommend.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.boogie.aop.BookAspect;
import com.boogie.recommend.dao.RecommendDao;
import com.boogie.recommend.dto.RecommendInterestDto;
import com.boogie.recommend.dto.RecommendMarkDto;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * @Author : 나다윤
 * @Date : 2019. 8. 1.
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

		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");


		String interest = recommandDao.getInterest(id);
		BookAspect.logger.info(BookAspect.logMsg + "interest: " + interest);

		// 관심분야 도서 가져오기
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
		
		//사용자 기반 추천 기능
		
		List<String[]> reviewForRecommand = new ArrayList<String[]>();
		reviewForRecommand = recommandDao.getReview();
		BookAspect.logger.info(BookAspect.logMsg+"listSize: "+reviewForRecommand.size());

//		for(int i = 0 ; i < reviewForRecommand.size() ; i++) {
//			System.out.println(reviewForRecommand.get(i)[0]+","+reviewForRecommand.get(i)[1]+","+reviewForRecommand.get(i)[2]);
//		}
		
//		try {
//            /**
//             * csv 파일을 쓰기위한 설정
//             * 설명
//             * D:\\test.csv : csv 파일저장할 위치+파일명
//             * EUC-KR : 한글깨짐설정을 방지하기위한 인코딩설정(UTF-8로 지정해줄경우 한글깨짐)
//             * ',' : 배열을 나눌 문자열
//             * '"' : 값을 감싸주기위한 문자
//             **/
//            CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream("data.csv")));
//            try {
//                 cw.writeAll(reviewForRecommand);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                //무조건 CSVWriter 객체 close
//                cw.close();
//            }  
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		File file = new File("data.csv");
	
		if(file.exists()){
            if(file.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
	
		try
		{
			BufferedWriter fw = new BufferedWriter(new FileWriter("data.csv", true));
			for(int i = 0 ; i < reviewForRecommand.size() ; i++)
			{
				fw.write(reviewForRecommand.get(i)[0]+","+reviewForRecommand.get(i)[1]+","+reviewForRecommand.get(i)[2]);
				fw.newLine();
			}
			fw.flush();
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		
		String[] recommend_imgs = new String[2];
		String[] recommend_imgs_book_id = new String[2];
		
		try {
			
			//CSVReader reader = new CSVReader(new FileReader(filename));
            // UTF-8
            // CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"), ",", '"', 1);

			File out_file = new File("data.csv");
			if(out_file.exists()){
	            System.out.println("파일이 존재합니다.");
	            //System.out.println(out_file.getAbsolutePath());
	        }else{
	            System.out.println("파일이 존재하지 않습니다.");
	        }
			
			DataModel model = new FileDataModel(out_file);
			
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

			//ID가 2번인 사람에게 3개의 아이템을 추천
			int member_num = recommandDao.getRMemberNum(id);
			List<RecommendedItem> recommendations = recommender.recommend(member_num, 2);
			
			BookAspect.logger.info(BookAspect.logMsg+"recommendations_size: "+recommendations.size());
			
			
			int i = 0;
			for (RecommendedItem recommendation : recommendations) {
				String result_book_id = String.format("%-20s", recommendation.getItemID());
				//System.out.println(result_member_num);
				recommend_imgs[i]=recommandDao.getImag(result_book_id);
				recommend_imgs_book_id[i]=result_book_id;
				i+=1;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("recommend_imgs_book_id",recommend_imgs_book_id);
		mav.addObject("recommend_imgs",recommend_imgs);
		mav.addObject("markBookIcon",markBookIcon);
		mav.addObject("markList", markList);
		mav.addObject("markBookList", markBookList);
		mav.addObject("interestDto", interestDto);

		// mav.setViewName("recommend/recommendMain");

	}

}
