package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.farmstory2.config.DBConfig;
import kr.co.farmstory2.config.Sql;
import kr.co.farmstory2.vo.TermsVo;
import kr.co.farmstory2.vo.UserVo;

public class UserDao {

	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}	
	
	public void insertUser() {}
	
	public TermsVo selectTerms() {
		
		TermsVo vo = new TermsVo();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_TERMS);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}
	
	public int selectUserCount(String uid) {
		
		int count = 0;
		
		try {
				Connection conn = DBConfig.getInstance().getConnection();
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_USER);
				psmt.setString(1, uid);
				
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int selectNickCount(String nick) {
		
		int count = 0;
		
		try {
				Connection conn = DBConfig.getInstance().getConnection();
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_NICK);
				psmt.setString(1, nick);
				
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	public int selectHpCount(String hp) {
		
		int count = 0;
		
		try {
				Connection conn = DBConfig.getInstance().getConnection();
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_HP);
				psmt.setString(1, hp);
				
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int selectEmailCount(String email) {
		
		int count = 0;
		
		try {
				Connection conn = DBConfig.getInstance().getConnection();
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_EMAIL);
				psmt.setString(1, email);
				
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
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
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}
	public void selectUsers() {}
	
}
