<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송데이터 인코딩
	request.setCharacterEncoding("UTF-8");
	
	// 전송데이터 수신
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String pos = request.getParameter("pos");
	String dep = request.getParameter("dep");
	
	//데이터베이스 처리 1 ~ 6단계
	String host = "jdbc:mysql://192.168.10.114:3306/knh";
	String user = "knh";
	String pass = "1234";
	// 1단계 
	Class.forName("com.mysql.jdbc.Driver");
	
	// 2단계
	Connection conn = DriverManager.getConnection(host, user, pass);
	
	// 3단계
	Statement stmt = conn.createStatement();
	
	// 4단계
	String sql = "UPDATE `MEMBER` SET ";
		   sql += "`name`='"+name+"', ";
		   sql += "`hp`='"+hp+"', ";
		   sql += "`pos`='"+pos+"', ";
		   sql += "`dep`= "+dep+" ";
		   sql += "WHERE `uid`='"+uid+"';";
		   
	stmt.executeUpdate(sql);
	// 5단계
	// 6단계
	stmt.close();
	conn.close();

	
	//리다이렉트
	response.sendRedirect("../list.jsp");
%>