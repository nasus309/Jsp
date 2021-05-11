<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3_2_Response</title>
	<!--
		날짜 : 2021/03/23
		이름 : 김나현
		내용 : JSP response 내장객체 실습하기
		
		response 내장객체
		 - Client에서 Server로 요청한 처리 결과를 응답해주는 응답객체
		 - Server에서 Client 로 전달되는 객체
		
		redirect(response 객체의 기능)
		 - Server에서 Client로 다시 요청(request)를 명령하는 response의 기능
		 - 최종 요청에 대한 주소가 반영
		 - 시스템에 변화가 생기는 요청(회원가입, 글쓰기 등)의 경우
		
		forward(pageContext 객체의 기능)
		 - 서버 시스템 내에서 페이지 요청을 처리하는 pageContext의 기능
		 - 최초 요청에 대한 주소가 반영
		 - 요청정보가 그대로 유지
		 - 시스템에 변화가 생기지 않는 단순 조회 요청(글 목록 보기, 검색)의 경우  사용
	-->
</head>
<body>
	<h3>2.JSP Response 내장객체</h3>
	
	<a href="./proc/redirectProc.jsp">리다이렉트 페이지 요청</a>
	<br>
	<a href="./proc/forwardProc.jsp">포워드 페이지 요청</a>
	
</body>
</html>