<%@page import="sub1.Account"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
	<meta charset="UTF-8">
	<title>2_4_Class</title>
</head>
<body>
	<h3>4.JSP 클래스</h3>
	<%
		/*
		 	날짜 : 2021/03/23
		 	이름 : 김나현
		 	내용 : JSP 클래스 실습하기
		*/
		Account kb = new Account("국민은행","121-12-1111","김유신",10000);
		kb.deposit(40000);
		kb.withdraw(7000);
		kb.show(out);
		
		Account wr = new Account("우리은행", "111-12-1010", "김춘추", 20000);
		wr.deposit(30000);
		wr.withdraw(9000);
		wr.show(out);
		
	%>

</body>
</html>