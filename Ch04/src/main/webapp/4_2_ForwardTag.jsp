<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>4_2_ForwardTag</title>
	<!--
		날짜 : 2021/03/24
		이름 : 김나현
		내용 : JSP Forward 액션태그 실습하기 
	-->
</head>
<body>
	<h3>2.Forward 액션태그</h3>
	<jsp:forward page="./4_1_IncludeTag.jsp"></jsp:forward>
	<%
		//참고 pageContext forward 실행
	 	//pageContext.forward("./4_1_IncludeTag.jsp");
	%>
</body>
</html>