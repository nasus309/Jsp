package kr.co.jboard2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// ?±κΈ??€ κ°μ²΄
	private static DBConfig instance = new DBConfig();
	private DBConfig() {} // ?ΈλΆ??? DBConfig? κ°μ²΄ ??±?(??±? ?ΈμΆμ) λͺ»νκ²? ??€.
	
	//DBConfig? ??? getter
	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB ? λ³?
	private final String HOST= "jdbc:mysql://192.168.10.114:3306/knh";
	private final String USER = "knh";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1?¨κ³?
		Class.forName("com.mysql.jdbc.Driver");
		// 2?¨κ³?
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; //conn? return ????? Connection?΄?€
	}
	
}
