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
	
	public int selectCountUser(String uid) throws Exception {
		
		Connection conn = DBConfig.getInstance().getConnection();
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_USER);
		psmt.setString(1, uid);
		
		ResultSet rs = psmt.executeQuery();
		
		int count = 0;
		
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return count;
	}
	
	public UserVo selectUser(String uid, String pass) {
		
		UserVo vo = null;
		try {
	
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			
			ResultSet rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				vo = new UserVo();
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setNick(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setHp(rs.getString(6));
				vo.setGrade(rs.getInt(7));
				vo.setZip(rs.getString(8));
				vo.setAddr1(rs.getString(9));
				vo.setAddr2(rs.getString(10));
				vo.setRegip(rs.getString(11));
				vo.setRdate(rs.getString(12));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
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
