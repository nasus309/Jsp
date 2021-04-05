<%@page import="kr.co.jboard1.dao.UserDao"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
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
	
	UserBean user = new UserBean();
	user.setUid(uid);
	user.setPass(pass1);
	user.setName(name);
	user.setNick(nick);
	user.setEmail(email);
	user.setHp(hp);
	user.setZip(zip);
	user.setAddr1(addr1);
	user.setAddr2(addr2);
	user.setRegip(regip);
	
	// 데이터베이스 처리 1~6 단계
	UserDao.getInstance().insertUser(user);
	
	
	// 로그인 페이지로 리다이렉트
	response.sendRedirect("/Jboard1/user/login.jsp");
	
%>
