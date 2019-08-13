package com.boogie.visit.dao;

public class DriverProvider {
	public static void getProvider() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
