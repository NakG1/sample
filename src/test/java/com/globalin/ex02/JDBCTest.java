package com.globalin.ex02;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCTest {
	
	
	@Test
	public void testConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Jinhak","1234");
			assertNotNull(conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//fail 메소드가 실행되면 무조건 테스트 실패
			//fail(메세지)
			e.printStackTrace();
		}
	}
}
