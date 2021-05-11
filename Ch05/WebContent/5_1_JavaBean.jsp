<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!--
		날짜 : 2021/03/24
		이름 : 김나현
		내용 : JSP 자바빈 실습하기
		
		자바빈
		 - 일반적으로 JSP에서 사용하는 객체(컴포넌트)
		 - form의 입력 필드를 멤버로 갖는 클래스
		 - Database Table의 컬럼을 멤버로 갖는 클래스
		 - JSP Model2에서 자바빈이 VO(Value Object)객체로 사용
	-->
</head>
<body>
	<h3>1.JSP 자바빈</h3>
	
	<h3>회원가입</h3>
	<form action="./5_2_UseBean.jsp" method="get">
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