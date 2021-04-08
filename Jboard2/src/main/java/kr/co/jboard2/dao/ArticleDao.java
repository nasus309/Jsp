package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard2.vo.ArticleVo;
import kr.co.jboard2.vo.FileVo;
import kr.co.jboard2.config.DBConfig;
import kr.co.jboard2.config.Sql;

public class ArticleDao {
	//Database Access Object
	// 싱글톤 객체
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {};
	
	public static ArticleDao getInstance() {
		return instance;
	}
	
	public FileVo selectFile(String seq) {
		
		FileVo vo = new FileVo();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, seq);

			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setSeq(rs.getInt(1));
				vo.setParent(rs.getInt(2));
				vo.setOldName(rs.getString(3));
				vo.setNewName(rs.getString(4));
				vo.setDownload(rs.getInt(5));
				vo.setRdate(rs.getString(5));
			}

			rs.close();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	public int getPageStartNum(int total, int start) {
		return total-start;
	};
	
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(lastPageNum / 10.0);
		int groupStart = (groupCurrent -1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
		
	}
	
	public int selectCountArticle() {
		int total = 0;
		
		try {
		Connection conn = DBConfig.getInstance().getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(Sql.SELECT_COUNT_ARTICLE);
		
		if(rs.next()){
			total = rs.getInt(1);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
		
	};
	
	public int selectMaxSeq() {
		
		int seq=0;
		
		try {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		Statement stmt = conn.createStatement();
		
		// 4단계
		ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_SEQ);
		
		// 5단계
		
		if(rs.next()) {
			seq= rs.getInt(1);
		}
		
		// 6단계
		rs.close();
		stmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return seq;
	}

	public int insertArticle(ArticleVo article) {
		
		
		try {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
	
		psmt.setString(1, article.getTitle());
		psmt.setString(2, article.getContent());
		psmt.setInt(3, article.getFile()); //왜 int??????
		psmt.setString(4, article.getUid()); // 원래 user.uid였음
		psmt.setString(5, article.getRegip());
		
		
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		// 방금 INSERT한 글번호 가져오기
		
		int seq = selectMaxSeq();
		return seq;//글번호
		
		
	};
	public void insertComment(String parent, String content,String uid, String regip) {
		//parent 원래 int인데 String으로 
		
		try {
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
		psmt.setString(1, parent);
		psmt.setString(2, content);
		psmt.setString(3, uid);
		psmt.setString(4, regip);
		
		//4단계
		psmt.executeUpdate();
		
		//6단계
		psmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertFile(int seq, String oldName, String newName)  { //String parent를 int seq로 ! 왜?
		
		try {
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
		psmt.setInt(1, seq);
		psmt.setString(2, oldName);
		psmt.setString(3, newName);
		
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
 	public ArticleVo selectArticle(String seq) {
		
 		ArticleVo ab = new ArticleVo();
 		
 		try {
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt =conn.prepareStatement(Sql.SELECT_ARTICLE);
		psmt.setString(1, seq);
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		
		FileVo fb = new FileVo();
		
		if(rs.next()) {
			ab.setSeq(rs.getInt(1));
			ab.setParent(rs.getInt(2));
			ab.setComment(rs.getInt(3));
			ab.setCate(rs.getString(4));
			ab.setTitle(rs.getString(5));
			ab.setContent(rs.getString(6));
			ab.setFile(rs.getInt(7));
			ab.setHit(rs.getInt(8));
			ab.setUid(rs.getString(9));
			ab.setRegip(rs.getString(10));
			ab.setRdate(rs.getString(11));
			
			fb.setSeq(rs.getInt(12));
			fb.setParent(rs.getInt(13));
			fb.setOldName(rs.getString(14));
			fb.setNewName(rs.getString(15));
			fb.setDownload(rs.getInt(16));
			fb.setRdate(rs.getString(17));
			
			ab.setFb(fb); // 왜 ???????????????
			
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
 		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ab;
		
	}
	public List<ArticleVo> selectArticles(int start) {
		
		List<ArticleVo> articles = new ArrayList<>(); // 맨 끝에 return articles 때문에 밖에서 해줌
		
		try {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계   
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
		psmt.setInt(1, start);
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		// List<ArticleVo> articles = new ArrayList<>(); => 맨 끝에 return articles 때문에 밖으로 빼줌.
		
		while(rs.next()){
			ArticleVo ab = new ArticleVo();
			ab.setSeq(rs.getInt(1));
			ab.setParent(rs.getInt(2));
			ab.setComment(rs.getInt(3));
			ab.setCate(rs.getString(4));
			ab.setTitle(rs.getString(5));
			ab.setContent(rs.getString(6));
			ab.setFile(rs.getInt(7));
			ab.setHit(rs.getInt(8));
			ab.setUid(rs.getString(9));
			ab.setRegip(rs.getString(10));
			ab.setRdate(rs.getString(11));
			ab.setNick(rs.getString(12));
			
			articles.add(ab);
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articles;
	
	};
	
	public List<ArticleVo> selectComments(String parent)  {
		
		List<ArticleVo> comments = new ArrayList<>();
		
		try {
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COMMNETS);
		psmt.setString(1, parent);
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		
		
		while(rs.next()) {
			ArticleVo ab = new ArticleVo();
			ab.setSeq(rs.getInt(1));
			ab.setParent(rs.getInt(2));
			ab.setComment(rs.getInt(3));
			ab.setCate(rs.getString(4));
			ab.setTitle(rs.getString(5));
			ab.setContent(rs.getString(6));
			ab.setFile(rs.getInt(7));
			ab.setHit(rs.getInt(8));
			ab.setUid(rs.getString(9));
			ab.setRegip(rs.getString(10));
			ab.setRdate(rs.getString(11));
			ab.setNick(rs.getString(12));
			
			comments.add(ab);
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	public void updateFileDownload(String seq) {
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, seq);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateArticle() throws Exception{};
	
	public void updateArticelHit(String seq) throws Exception{ //seq는 원래 int인데 String으로 바꿔줌
		
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt =conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
		psmt.setString(1, seq);
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
	};
	
	public void updateArticleCommentInc(String seq) {
		
		try {
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt =conn.prepareStatement(Sql.UPDATE_ARTICLE_COMMENT_INC);
		psmt.setString(1, seq);
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticleCommentDec(String seq) throws Exception{
		
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt =conn.prepareStatement(Sql.UPDATE_ARTICLE_COMMENT_DEC);
		psmt.setString(1, seq);
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
	}
	
	
	public void deleteArticle() throws Exception{};
	
	public void deleteComment(String seq) throws Exception{
		
		// 1,2 단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		PreparedStatement psmt =conn.prepareStatement(Sql.DELETE_COMMNET);
		psmt.setString(1, seq);
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
		
	};
	
}
