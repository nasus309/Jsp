<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5_2_UseBean</title>
</head>
<body>
	<h3>2.usebean 태그 실습</h3>
	<%
		// 전송데이터 수신 (getter,setter 이용하면 필요없음.)
		/* String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String addr = request.getParameter("addr"); */
	%>
	<!-- jsp에서 필드를 프로퍼티라고 함. -->
	<!-- useBean액션태그 : 자바빈 파일을 사용한다고 명시 -->
	<!-- MemberBean(class속성) member(id속성) = new MemberBean(); 과 같은 의미 -->
	<jsp:useBean id="member" class="sub1.MemberBean">  
		<jsp:setProperty name="member" property="name" /> <!-- setProperty : setter 메서드를 사용하기 위해 -->
		<jsp:setProperty name="member" property="gender" />
		<jsp:setProperty name="member" property="hobby" />
		<jsp:setProperty name="member" property="addr" />
	</jsp:useBean>
	
	<p>
		이름 : <%= member.getName() %>
		성별 : <%= member.getGender() %>
		취미 : 
		<%
			for(String hobby : member.getHobby()){
				out.print(hobby+", ");
			}
		%><br />
		주소 : <%= member.getAddr() %><br />
	</p>
</body>
</html>