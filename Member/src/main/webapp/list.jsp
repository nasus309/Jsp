<%@page import="java.util.ArrayList"%>
<%@page import="sub1.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/* String rdate = request.getParameter("rdate"); */
	
	// 데이터베이스 처리 1~6
	String host ="jdbc:mysql://192.168.10.114:3306/knh";
	String user ="knh";
	String pass ="1234";
	
	// 1단계 
	Class.forName("com.mysql.jdbc.Driver");
	// 2단계
	Connection conn = DriverManager.getConnection(host, user, pass);
	// 3단계
	Statement stmt = conn.createStatement();
	// 4단계
	String sql = "SELECT * FROM `MEMBER`;";
	ResultSet rs = stmt.executeQuery(sql);
	// 5단계
	List<UserBean> ubList = new ArrayList<>();
	
	while(rs.next()){
		UserBean ub = new UserBean();
		
		ub.setUid(rs.getString(1));
		ub.setName(rs.getString(2));
		ub.setHp(rs.getString(3));
		ub.setPos(rs.getString(4));
		ub.setDep(rs.getInt(5));
		ub.setRdate(rs.getString(6));
		
		ubList.add(ub);
	}
	
	// 6단계
	rs.close();
	stmt.close();
	conn.close();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원목록</title>
</head>
<body>
	<h3>직원목록</h3>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>입사일</th>
			<th>관리</th>
		</tr>
		
		<% for(UserBean ub :ubList){%>
			<tr>
				<td><%= ub.getUid() %></td>
				<td><%= ub.getName() %></td>
				<td><%= ub.getHp() %></td>
				<td><%= ub.getPos() %></td>
				<td><%= ub.getDep() %></td>
				<td><%= ub.getRdate() %></td>
				<td>
					<!-- 방법1. parameter(?)이용 -->
					<a href="./modify.jsp?uid=<%= ub.getUid() %>&name=<%= ub.getName() %>&hp=<%= ub.getHp() %>">수정</a> 
					<a href="./proc/deleteProc.jsp?uid=<%= ub.getUid() %>">삭제</a>
				</td>
			</tr>
		<% } %>
	</table>
</body>
</html>