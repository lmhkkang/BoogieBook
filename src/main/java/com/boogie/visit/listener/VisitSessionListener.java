package com.boogie.visit.listener;

/**
 * @author : 김성훈
 * @date : 2019.08.02
 * @desc : 리스너활용, 세션이 새로 생성되면 방문자수 증가하고. 오늘 방문자수와 총 방문자수를 가져옴.
 */


import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

import com.boogie.visit.dao.VisitCountDao;

@Component
public class VisitSessionListener implements HttpSessionListener{
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		if(se.getSession().isNew()) {
			try {
				execute(se);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void execute(HttpSessionEvent se) throws SQLException {	
		
		HttpSession session = se.getSession();
		System.out.println("세션이 새로 생성되었습니다. 현재 세션:" + session);
		
		VisitCountDao dao = VisitCountDao.getInstance();
		// 전체 방문자 수 증가
		dao.setTotalCount();
		// 총 방문자 수 가져옴
		int totalCount = dao.getTotalCount();
		// 오늘 방문자 수 가져옴
		int todayDw = dao.getTodayDw();
		System.out.println("총 방문자 수 :" + totalCount);
		System.out.println("오늘의 요일은 :" + todayDw + "입니다.");
		
		switch(todayDw) {
		case 1:
			int sunCheck = dao.sunCountInc();
			if(sunCheck > 0) {
				System.out.println("일요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 2:
			int monCheck = dao.monCountInc();
			if(monCheck > 0) {
				System.out.println("월요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 3:
			int tueCheck = dao.tueCountInc();
			if(tueCheck > 0) {
				System.out.println("화요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 4:
			int wedCheck = dao.wedCountInc();
			if(wedCheck > 0) {
				System.out.println("수요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 5:
			int thuCheck = dao.thuCountInc();
			if(thuCheck > 0) {
				System.out.println("목요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 6:
			int friCheck = dao.friCountInc();
			if(friCheck > 0) {
				System.out.println("금요일 방문자수 1증가");
			}else visitCountError();
			break;
		case 7:
			int satCheck = dao.satCountInc();
			if(satCheck > 0) {
				System.out.println("토요일 방문자수 1증가");
			}else visitCountError();
			break;
		default:
			System.out.println("잘못된 요일 값입니다.");
			break;
		}		
	}
	//방문자 수가 증가되지 않았을때만 실행
	public void visitCountError() {
		System.out.println("방문자 수가 증가되지 않았습니다.");
	}
	//httpSessionListener를 사용할때 꼭 구현해야 하는 클래스.
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
	
}