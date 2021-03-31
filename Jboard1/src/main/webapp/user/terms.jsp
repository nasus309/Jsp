<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@page import="kr.co.jboard1.bean.TermsBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터베이스 처리 1~6단계
	
	// 1,2 단계
	/* DBConfig db = DBConfig.getInstance();
	Connection conn = db.getConnection(); */
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	Statement stmt = conn.createStatement();
	
	// 4단계
	String sql = "SELECT * FROM `JBOARD_TERMS`;";
	ResultSet rs = stmt.executeQuery(sql);
	
	// 5단계
	TermsBean tb = new TermsBean();
	
	if(rs.next()){
		tb.setTerms(rs.getString(1));
		tb.setPrivacy(rs.getString(2));
	};
	
	
	
	// 6단계
	rs.close();
	stmt.close();
	conn.close();
	
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>약관</title>
    <link rel="stylesheet" href="../css/style.css"/>  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    	$(function(){
    		
    		var btnNext = $('#user > div > a:eq(1)');
    		
    		
    		
    		btnNext.click(function(){
    			
    			var isOkchk1 = $('input[name=chk1]').is(':checked');
        		var isOkchk2 = $('input[name=chk2]').is(':checked');
        		// 밖에 내면 check가 false라서 click 이벤트 안에 넣어줌
    			
    			if(isOkchk1 && isOkchk2){
    				return true;
    			}else{
    				alert("동의를 체크하셔야 합니다.")
    				return false; // 페이지를 넘기지 않음!
    			}
 			
    			
    		});
    	});
    </script>  
</head>
<body>
    <div id="wrapper">
        <section id="user" class="terms">
            <table>
                <caption>사이트 이용약관</caption>
                <tr>
                    <td>
                        <textarea readonly><%= tb.getTerms() %></textarea>
                        <p>
                            <label><input type="checkbox" name="chk1"/>동의합니다.</label>
                        </p>
                    </td>
                </tr>
            </table>
            <table>
                <caption>개인정보 취급방침</caption>
                <tr>
                    <td>
                        <textarea readonly><%= tb.getPrivacy() %></textarea>
                        <p>
                            <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                        </p>
                    </td>
                </tr>
            </table>
            <div>
                <a href="/Jboard1/user/login.jsp">취소</a>
                <a href="/Jboard1/user/register.jsp">다음</a>
            </div>
        </section>
    </div>
    
</body>
</html>