package kr.co.jboard2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// ?‹±ê¸??†¤ ê°ì²´
	private static DBConfig instance = new DBConfig();
	private DBConfig() {} // ?™¸ë¶??—?„œ DBConfig?˜ ê°ì²´ ?ƒ?„±?„(?ƒ?„±? ?˜¸ì¶œì„) ëª»í•˜ê²? ?•œ?‹¤.
	
	//DBConfig?— ???•œ getter
	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB ? •ë³?
	private final String HOST= "jdbc:mysql://192.168.10.114:3306/knh";
	private final String USER = "knh";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1?‹¨ê³?
		Class.forName("com.mysql.jdbc.Driver");
		// 2?‹¨ê³?
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn; //conn?˜ return ???…?? Connection?´?‹¤
	}
	
}
