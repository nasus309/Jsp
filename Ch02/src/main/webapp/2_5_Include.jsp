<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_5_Include</title>
</head>
<body>
	<%--
		날짜 : 2021/03/23
		이름 : 김나현
		내용 : JSP 인클루드 실습하기
		
		include 지시자
		 -공통의 전역파일을 삽입하는 지시자
		 -일반적으로 UI 모듈, 공통전역 파일 변수를 삽입할 때 사용
		 -정적타임에 삽입, 참고) include 태그는 동적타임에 삽입
	--%>
	<h3>5.JSP 인클루드</h3>
	<%@ include file="./inc/_header.jsp" %>
	
	<main>
		<h1>페이지 컨텐츠 영역</h1>
	</main>
	
	<%@ include file="./inc/_footer.jsp" %>
</body>
</html>