<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//���� ������ ���ڵ�
	request.setCharacterEncoding("UTF-8");
	// ���� ������ ����
	String seq     = request.getParameter("seq");
	String comment = request.getParameter("comment");
	String regip   = request.getRemoteAddr();
	
	// ���� ����� ��ü ��������
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// �����ͺ��̽� ó�� - ����� �����ͺ��̽��� INSERT
	ArticleDao dao = ArticleDao.getInstance();
	dao.insertComment(seq, comment, uid, regip);
	
	// �����ͺ��̽� ó�� - ���� ��� ī��Ʈ UPDATE
	dao.updateArticleCommentInc(seq);
	
	// �����̷�Ʈ
	response.sendRedirect("/Jboard1/view.jsp?seq="+seq);
%>