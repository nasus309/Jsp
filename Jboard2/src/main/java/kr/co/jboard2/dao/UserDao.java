package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.jboard2.config.DBConfig;
import kr.co.jboard2.config.Sql;
import kr.co.jboard2.vo.TermsVo;
import kr.co.jboard2.vo.UserVo;

public class UserDao {
	
	private static final UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}
	
	public void insertUser(UserVo vo) throws Exception{
		
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement  psmt = conn.prepareStatement(Sql.INSERT_USER);
		psmt.setString(1, vo.getUid());
		psmt.setString(2, vo.getPass());
		psmt.setString(3, vo.getName());
		psmt.setString(4, vo.getNick());
		psmt.setString(5, vo.getEmail());
		psmt.setString(6, vo.getHp());
		psmt.setString(7, vo.getZip());
		psmt.setString(8, vo.getAddr1());
		psmt.setString(9, vo.getAddr2());
		psmt.setString(10, vo.getRegip());
		// 4단계
		psmt.executeUpdate();
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
	}
	public void selectUser() throws Exception{}
	public void selectUsers() throws Exception{}
	public TermsVo selectTerms() throws Exception{
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		Statement stmt = conn.createStatement();
		// 4단계
		ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
		// 5단계
		TermsVo vo = new TermsVo();
		
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		// 6단계
		rs.close();
		conn.close();
		stmt.close();
		
		return vo;
		
	}
	public void updateUser() throws Exception{}
	public void deleteUser() throws Exception{}
}
