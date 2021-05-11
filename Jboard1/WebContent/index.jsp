<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean user = (UserBean)session.getAttribute("suser"); /* /proc/login.jsp에서 setAttribute해줬음 */
	
	if(user != null){	
		// 로그인 상태이면
		pageContext.forward("./list.jsp"); //forward는 시스템경로가 안됨. 상대경로로 바꿔줌! 왜 forward써야함?
	}else{
		//로그인 상태가 아니면
		pageContext.forward("./user/login.jsp");
	}
%>