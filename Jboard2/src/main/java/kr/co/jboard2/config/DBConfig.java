package kr.co.jboard2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// ?���??�� 객체
	private static DBConfig instance = new DBConfig();
	private DBConfig() {} // ?���??��?�� DBConfig?�� 객체 ?��?��?��(?��?��?�� ?��출을) 못하�? ?��?��.
	
	//DBConfig?�� ???�� getter
	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB ?���?
	private final String HOST= "jdbc:mysql://192.168.10.114:3306/knh";
	private final String USER = "knh";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1?���?
		Class.forName("com.mysql.jdbc.Driver");
		// 2?���?
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; //conn?�� return ???��?? Connection?��?��
	}
	
}
