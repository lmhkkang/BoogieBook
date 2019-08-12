/*
package com.boogie.visit.thread;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boogie.admin.dao.AdminDao;

/**
 * @author : 김성훈
 * @date : 2019-08-11
 * @desc : 매주 일요일마다 기존데이터값을 초기화 해주는 쓰레드
 */
/*
@Component
public class dwInitThread extends Thread{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private AdminDao admindao;
	
	int date[] = admindao.getDate();
	
	@Override
	public void run() {
		//매주 일요일 자정에 실행
		try {
			//실행될 sql문
			sqlSessionTemplate.update("dao.adminMapper.AdminDwInit");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
*/