<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 처리 페이지 -->
<%
	// 전송데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송데이터 수신
	String uid	 = request.getParameter("uid");	
	String pass1 = request.getParameter("pass1");	
	/* String pass2 = request.getParameter("pass2");	 */
	/* 클라이언트단에서  */
	String name  = request.getParameter("name");	
	String nick  = request.getParameter("nick");	
	String email = request.getParameter("email");	
	String hp    = request.getParameter("hp");	
	String zip   = request.getParameter("zip");	
	String addr1 = request.getParameter("addr1");	
	String addr2 = request.getParameter("addr2");
	String regip = request.getRemoteAddr(); //사용자 ip 주소
	
	// 데이터베이스 처리 1~6 단계
	String host= "jdbc:mysql://192.168.10.114:3306/knh";
	String user = "knh";
	String pass = "1234";
	
	// 1단계
	Class.forName("com.mysql.jdbc.Driver");
	// 2단계
	Connection conn = DriverManager.getConnection(host, user, pass);
	// 3단계
	Statement stmt = conn.createStatement();
	// 4단계
	String sql  = "INSERT INTO `JBOARD_USER` SET ";
		   sql += "`uid`='"+uid+"',";
		   sql += "`pass`=PASSWORD('"+pass1+"'),"; //PASSWORD() 암호화 함수
		   sql += "`name`='"+name+"',";
		   sql += "`nick`='"+nick+"',";
		   sql += "`email`='"+email+"',";
		   sql += "`hp`='"+hp+"',";
		   /* sql += "`grade`='',";  딱히 해줄 필요 없음*/ 
		   sql += "`zip`='"+zip+"',";
		   sql += "`addr1`='"+addr1+"',";
		   sql += "`addr2`='"+addr2+"',";
		   sql += "`regip`='"+regip+"',";
		   sql += "`rdate`=NOW();";
	
	stmt.executeUpdate(sql);
		   
	// 5단계
	// 6단계
	stmt.close();
	conn.close();
	
	// 로그인 페이지로 리다이렉트
	response.sendRedirect("/Jboard1/user/login.jsp");
	
%>
