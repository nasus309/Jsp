<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");
	// 전송 데이터 수신
	String seq     = request.getParameter("seq");
	String comment = request.getParameter("comment");
	String regip   = request.getRemoteAddr();
	
	// 세션 사용자 객체 가져오기
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// 데이터베이스 처리 - 댓글을 데이터베이스에 INSERT
	ArticleDao dao = ArticleDao.getInstance();
	dao.insertComment(seq, comment, uid, regip);
	
	// 데이터베이스 처리 - 원글 댓글 카운트 UPDATE
	dao.updateArticleCommentInc(seq);
	
	// 리다이렉트
	response.sendRedirect("/Jboard1/view.jsp?seq="+seq);
%>