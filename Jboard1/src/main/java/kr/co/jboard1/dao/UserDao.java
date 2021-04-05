package kr.co.jboard1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.jboard1.bean.TermsBean;
import kr.co.jboard1.bean.UserBean;
import kr.co.jboard1.config.DBConfig;
import kr.co.jboard1.config.Sql;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	private UserDao() {}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	// 기본 CRUD 메서드
	public void insertUser(UserBean user) throws Exception{
		
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_USER);
		psmt.setString(1, user.getUid());
		psmt.setString(2, user.getPass());
		psmt.setString(3, user.getName());
		psmt.setString(4, user.getNick());
		psmt.setString(5, user.getEmail());
		psmt.setString(6, user.getHp());
		psmt.setString(7, user.getZip());
		psmt.setString(8, user.getAddr1());
		psmt.setString(9, user.getAddr2());
		psmt.setString(10, user.getRegip());
		
		// 4단계
		
		psmt.executeUpdate();
			   
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
	}
	public void selectUser() throws Exception{}
	public void selectUsers() throws Exception{}
	public void updateUser() throws Exception{}
	public void deleteUser() throws Exception{}
	
	public TermsBean selectTerms() throws Exception{
		
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		Statement stmt = conn.createStatement();
		
		// 4단계
		/* String sql = "SELECT * FROM `JBOARD_TERMS`;"; */
		ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
		
		// 5단계
		TermsBean tb = new TermsBean();
		
		if(rs.next()){
			tb.setTerms(rs.getString(1));
			tb.setPrivacy(rs.getString(2));
		};
		
		
		// 6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return tb;
		
	}
}
