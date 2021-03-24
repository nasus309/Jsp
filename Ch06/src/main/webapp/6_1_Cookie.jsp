<%@page import="jdk.javadoc.doclet.Reporter"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>6_1_Cookie</title>
	<!--
		날짜 : 2021/03/24
		이름 : 김나현
		내용 : JSP Cookie 실습하기
		
		Cookie
		 - 클라이언트와 서버간의 식별을 위해 사용하는 조각파일
		 - 서버에서 쿠키를 생성하고 클라이언트로 전달
		 - 클라이언트는 전달된 쿠키를 보관, 해당 서버로 다시 요청할 때 보관된 쿠키를 전송
	-->
</head>
<body>
	<%
		//쿠키생성
		Cookie c1 = new Cookie("name","홍길동");
		Cookie c2 = new Cookie("uid","hong");
		
		c1.setMaxAge(60 * 3); // 3분동안 유효
		c2.setMaxAge(60 * 3);
		
		// 응답객체에 실어서 클라이언트로 전송
		response.addCookie(c1);
		response.addCookie(c2);
	%>
	
	<h4>쿠키 생성 후 클라이언트 전송완료</h4>
	
	<a href="./6_2_CookieReceive.jsp">클라이언트 쿠키 확인</a>
	
</body>
</html>