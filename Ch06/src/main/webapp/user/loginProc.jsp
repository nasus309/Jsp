<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String uid  = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	// 데이터베이스 로직 생략
	
	
	if(uid.equals("abcd") && pass.equals("1234")) {
		// 회원 맞음
		session.setAttribute("uid", uid);
		session.setAttribute("pass", pass);
		
		response.sendRedirect("./loginSuccess.jsp");
		
	}else{
		// 회원 아님
		response.sendRedirect("./login.jsp?result=fail");	
	}

%>