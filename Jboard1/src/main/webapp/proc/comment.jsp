<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String seq = request.getParameter("seq");
	String comment = request.getParameter("comment");
	String regip = request.getRemoteAddr();
	
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// 데이터베이스 처리 - 댓글 INSERT
	ArticleDao dao = ArticleDao.getInstance();
	dao.insertComment(seq, comment, uid, regip);
	
	// 데이터베이스 처리 - 원글 댓글 카운트 UPDATE
	dao.updateArticleCommentInc(seq); //deleteComment와 비교해봐라~
	
	// 리다이렉트
	response.sendRedirect("/Jboard1/view.jsp?seq="+seq);
%>