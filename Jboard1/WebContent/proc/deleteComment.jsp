<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// ���� ������ ���ڵ�
	request.setCharacterEncoding("UTF-8");
	// ���� ������ ����
	String seq    = request.getParameter("seq");
	String parent = request.getParameter("parent");
	
	// �����ͺ��̽� ó�� - ��� ����
	ArticleDao dao = ArticleDao.getInstance();
	dao.deleteComment(seq);
	
	// �����ͺ��̽� ó�� - ������ ��� ī��Ʈ -1
	dao.updateArticleCommentDec(parent);
	
	// �����̷�Ʈ
	response.sendRedirect("/Jboard1/view.jsp?seq="+parent);
%>