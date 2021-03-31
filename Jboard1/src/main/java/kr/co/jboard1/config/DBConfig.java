package kr.co.jboard1.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// 싱글톤 객체
	private static DBConfig instance = new DBConfig();
	private DBConfig() {} // 외부에서 DBConfig의 객체 생성을(생성자 호출을) 못하게 한다.
	
	//DBConfig에 대한 getter
	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB 정보
	private final String HOST= "jdbc:mysql://192.168.10.114:3306/knh";
	private final String USER = "knh";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; //conn의 return 타입은 Connection이다
	}
	
}
