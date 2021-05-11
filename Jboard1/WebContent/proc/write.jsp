<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String title = request.getParameter("title");	
	String content = request.getParameter("content");
	String regip = request.getRemoteAddr();
	
	// 세션 사용자 정보객체 가져오기
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	// 데이터베이스 처리 1~6단계
	/*
	// 1,2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	String sql  = "INSERT INTO `JBOARD_ARTICLE` SET ";
		   sql += "`title`=?,";
		   sql += "`content`=?,";
		   sql += "`uid`=?,";
		   sql += "`regip`=?,";
		   sql += "`rdate`=NOW();";
	
	PreparedStatement psmt = conn.prepareStatement(sql);
	
	psmt.setString(1, title);
	psmt.setString(2, content);
	psmt.setString(3, user.getUid());
	psmt.setString(4, regip);
	
	// 4단계
	psmt.executeUpdate();
	
	// 5단계
	// 6단계
	psmt.close();
	conn.close();
	
	articledao로 ~
	*/
	
	ArticleBean article = new ArticleBean();
	article.setTitle(title);
	article.setContent(content);
	article.setUid(uid);
	/* article.setUid(user.getUid()); */
	article.setRegip(regip);
	
	//int seq = ArticleDao.getInstance().insertArticle(article);
	
	
	// 게시판 목록 리다이렉트
	response.sendRedirect("/Jboard1/list.jsp");
%>