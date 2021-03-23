<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_3_Loop</title>
</head>
<body>
	<%--
		날짜 : 2021/03/22
		이름 : 김나현
		내용 : JSP 반복문 실습하기
	--%>
	<h3>3.JSP 반복문</h3>
	
	<h4>for</h4>
	<%
		for(int i=1; i<=5; i++){
			out.println("<h4>for 반복문 : "+i+"</h4>");
		}
	%>
	
	<h4>while</h4>
	<%
		int i = 1;
		while(i <= 5){
	%>
		<h4>while 반복문 : <%= i %></h4>
	<%
			i++;
		}
	%>
	<h4>구구단</h4>
	<table border="1">
		<tr>
			<th>2단</th>
			<th>3단</th>
			<th>4단</th>
			<th>5단</th>
			<th>6단</th>
			<th>7단</th>
			<th>8단</th>
			<th>9단</th>
		</tr>
		<tr>
			<td>2 x 1 = 2</td>
			<td>3 x 1 = 3</td>
			<td>4 x 1 = 4</td>
			<td>5 x 1 = 5</td>
			<td>6 x 1 = 6</td>
			<td>7 x 1 = 7</td>
			<td>8 x 1 = 8</td>
			<td>9 x 1 = 9</td>
		</tr>
		<tr>
			<td>2 x 2 = 4</td>
			<td>3 x 2 = 6</td>
			<td>4 x 2 = 8</td>
			<td>5 x 2 = 10</td>
			<td>6 x 2 = 12</td>
			<td>7 x 2 = 14</td>
			<td>8 x 2 = 16</td>
			<td>9 x 2 = 18</td>
		</tr>

		<%
			for(int a=1; a<=9; a++){
		%>
			<tr>
				<%
					for(int b=2; b<=9; b++){
						int c= a*b;
				%>
					<td><%= b %> x <%= a %> = <%=c %></td>
				<%
					}
				%>
			</tr>
		<%
			}
		%>
	</table>

</body>
</html>