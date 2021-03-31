<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 세션 사용자 정보 가져오기
	UserBean user = (UserBean) session.getAttribute("suser");

	if(user == null){
		// 로그인 안하고 게시판 목록을 요청했을 경우
		response.sendRedirect("/Jboard1/user/login.jsp?result=2");
		return; // 프로그램(페이지) 종료
	}
	
	// 전송데이터 수신
	String pg = request.getParameter("pg"); //page
	
	
	// 페이지 관련 변수 
	ArticleDao dao = ArticleDao.getInstance();
	
	int total = dao.selectCountArticle();
	int lastPageNum = dao.getLastPageNum(total);
	int start = dao.getLimitStart(pg); //limit용 start 변수
	
	// 데이터베이스 처리
	List<ArticleBean> articles = ArticleDao.getInstance().selectArticles(start);
	
	/*
	// 1,2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	String sqlCount = "SELECT COUNT(*) FROM `JBOARD_ARTICLE`;";
	Statement stmt = conn.createStatement();
	
	String sql  = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a ";
		   sql += "JOIN `JBOARD_USER` AS b ON a.uid = b.uid ";
		   sql += "ORDER BY `seq` DESC ";
		   sql += "LIMIT ?, 10;"; // LIMIT : (index,개수) index부터 몇개?
		   
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setInt(1, start);
	
	// 4단계
	ResultSet rsCount = stmt.executeQuery(sqlCount);
	ResultSet rs = psmt.executeQuery();
	
	// 5단계
	if(rsCount.next()){
		total = rsCount.getInt(1);
	}
	
	
	List<ArticleBean> articles = new ArrayList<>();
	
	while(rs.next()){
		ArticleBean ab = new ArticleBean();
		ab.setSeq(rs.getInt(1));
		ab.setParent(rs.getInt(2));
		ab.setComment(rs.getInt(3));
		ab.setCate(rs.getString(4));
		ab.setTitle(rs.getString(5));
		ab.setContent(rs.getString(6));
		ab.setFile(rs.getInt(7));
		ab.setHit(rs.getInt(8));
		ab.setUid(rs.getString(9));
		ab.setRegip(rs.getString(10));
		ab.setRdate(rs.getString(11));
		ab.setNick(rs.getString(12));
		
		articles.add(ab);
	}
	
	// 6단계
	rs.close();
	psmt.close();
	conn.close();
	*/
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/Jboard1/css/style.css">    
</head>
<body>
    <div id="wrapper">
        <section id="board" class="list">
            <h3>글목록</h3>
            <article>
                <p>
                    <%= user.getNick() %>님 반갑습니다.
                    <a href="/Jboard1/user/proc/logout.jsp" class="logout">[로그아웃]</a>
                </p>
                <table border="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <% for(ArticleBean ab: articles) { %>
                    <tr>
                        <td><%= ab.getSeq() %></td>
                        <td><a href="/Jboard1/view.html"><%= ab.getTitle() %></a>&nbsp;[3]</td>
                        <td><%= ab.getNick() %></td>
                        <td><%= ab.getRdate().substring(2,10) %></td>
                        <td><%= ab.getHit() %></td>
                    </tr>
                   	<% } %>
                </table>
            </article>

            <!-- 페이지 네비게이션 -->
            <div class="paging">
                <a href="#" class="prev">이전</a>
                <% for(int i=1; i<lastPageNum;i++){ %>
                	<a href="/Jboard1/list.jsp?pg=<%= i %>" class="num"><%= i %></a>                
                <% } %>              
                <a href="#" class="next">다음</a>
            </div>

            <!-- 글쓰기 버튼 -->
            <a href="/Jboard1/write.jsp" class="btnWrite">글쓰기</a>

        </section>
    </div>    
</body>
</html>