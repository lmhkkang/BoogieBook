package com.boogie.visit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			String url="jdbc:oracle:thin:@192.168.12.42:1521:xe";
			String id = "boogie";
			String pass = "1234";
			
			conn = DriverManager.getConnection(url,id,pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
