<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 세션에서 해당 클라이언트 정보를 제거
	session.invalidate();

	response.sendRedirect("./login.jsp?result=logout");
%>