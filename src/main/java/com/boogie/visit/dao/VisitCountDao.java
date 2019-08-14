package com.boogie.visit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;


public class VisitCountDao {
	
	
	private static VisitCountDao instance;
	
	//싱글톤
	public VisitCountDao() {}
	
	public static VisitCountDao getInstance() {
		if(instance == null) {
			instance = new VisitCountDao();
		}
		return instance;
	}
	
	public void setTotalCount() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			String sql = "insert into manager values(sysdate)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("방문자 수가 1 증가 했습니다.");
			}else {
				System.out.println("인설트 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		
	}

	public int getTotalCount() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String sql = "select count(*) as totalCnt from manager";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt("totalCnt");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return totalCount;
	}

	public int getTodayCount() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int todayCount = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "select count(*) as todayCnt from manager where to_date(visit_date, 'YYYY-MM-DD') = to_date(sysdate, 'YYYY-MM-DD')";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				todayCount = rs.getInt("todayCnt");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		
		return todayCount;
	}

	public int getTodayDw() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int todayCount = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			//오늘의 요일을 숫자로 담아내는 sql문 작성.
			String sql = "select distinct to_char(sysdate,'d') as todayCount from manager";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				todayCount = rs.getInt("todayCount");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		
		return todayCount;
	}
	
	public int sunCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set sun_count = sun_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	public int monCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set mon_count = mon_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;			
	}
	
	public int tueCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set tue_count = tue_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	public int wedCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set wed_count = wed_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	public int thuCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set thu_count = thu_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	public int friCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set fri_count = fri_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	public int satCountInc() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "update dw_count set sat_count = sat_count+1";
			pstmt = conn.prepareStatement(sql);
			check = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		return check;		
	}
	
	
}
