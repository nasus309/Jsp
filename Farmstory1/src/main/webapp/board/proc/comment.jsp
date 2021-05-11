<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.farmstory1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.farmstory1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	String seq = request.getParameter("seq");
	String comment = request.getParameter("comment");
	String regip = request.getRemoteAddr();;
	String uid = request.getParameter("uid");
	
	// 1,2 단계
	Connection conn = DBConfig.getInstance().getConnection();

	// 3단계
	PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
	psmt.setString(1,seq);
	psmt.setString(2,comment);
	psmt.setString(3,uid);
	psmt.setString(4,regip);
	

	// 4단계
	psmt.executeUpdate();
	
	// 5단계
	// 6단계
	psmt.close();
	conn.close();
	
	// 리다이렉트
	response.sendRedirect("/Farmstory1/board/view.jsp?group="+group+"&cate="+cate+"&seq="+seq);
%>