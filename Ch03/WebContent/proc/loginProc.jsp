<!-- 처리페이지
	 3_1_Requset에서 데이터를 받아야함. -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터(parameter) 수신 => 데이터 이름을 가지고 가져옴.
	String uid = request.getParameter("uid"); 
	String pass = request.getParameter("pass");
	
	out.println("<h4>로그인 출력</h4>");
	out.println("<p>");
	out.println("아이디 :"+uid+"<br />");
	out.println("비밀번호 :"+pass+"<br />");
	out.println("</p>");
%>