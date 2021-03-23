<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3_1_Request</title>
	<!--
		날짜 : 2021/03/23
		이름 : 김나현
		내용 : JSP request 내장객체 실습하기
		
		request 내장객체
		 - Client의 요청 정보를 갖는 객체
		 - Client의 전송 데이터(parameter)를 수신하는 기능을 갖음
		 
		데이터 전송방식
		Get 전송방식
		 - 기본 데이터 전송방식
		 - 서버에 페이지나 데이터를 요청하는 전송방식 (주세요)
		 - 데이터(parameter) 주소에 노출 
		Post 전송방식
		 - 서버에 데이터를 전달하면서 처리를 요청하는 전송방식 (해주세요)
		 - 데이터(parameter) 요청메세지에 삽입되어 전송(주소노출 X)
	-->
</head>
<body>
	<h3>3.JSP request 객체</h3>
	<form action="./proc/loginProc.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	
	<h3>회원가입</h3>
	<form action="./proc/registerProc.jsp" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label></label><input type="radio" name="gender" value="1"/>남</label>
					<label></label><input type="radio" name="gender" value="2"/>여</label>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<label><input type="checkbox" name="hobby" value="등산" />등산하기</label>
					<label><input type="checkbox" name="hobby" value="독서" />독서하기</label>
					<label><input type="checkbox" name="hobby" value="여행" />여행하기</label>
					<label><input type="checkbox" name="hobby" value="운동" />운동하기</label>
					<label><input type="checkbox" name="hobby" value="영화" />영화보기</label>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<select name="addr">
						<option value="서울">서울특별시</option>
						<option value="대전">대전광역시</option>
						<option value="대구">대구광역시</option>
						<option value="부산">부산광역시</option>
						<option value="광주">광주광역시</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="가입하기" /></td>
			</tr>
		</table>
	</form>
</body>
</html>