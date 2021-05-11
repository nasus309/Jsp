<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="kr.co.farmstory1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	String group = request.getParameter("group");
	String cate  = request.getParameter("cate");
	String seq  = request.getParameter("seq");

	String path = "./_aside_"+group+".jsp";
	
	// 1,2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
	psmt.setString(1, seq);
	
	// 4단계
	ResultSet rs = psmt.executeQuery();
	
	// 5단계
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
	
	
	
	if(request.getMethod().equals("POST")){
		
		psmt = conn.prepareStatement(Sql.SELECT_COMMNETS);
		psmt.setString(1, seq);
		rs = psmt.executeQuery();
		List<ArticleBean> comments = new ArrayList<>();
		
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
			
			comments.add(ab);
		}
		
	}
	
	// 6단계
	psmt.close();
	conn.close();
	rs.close();

	
%>
<jsp:include page="<%= path %>"></jsp:include>
<section id="board" class="view">
    <h3>글보기</h3>
    <table>
    	<% for(ArticleBean article : articles) { %>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value="<%= article.getTitle() %>" readonly/></td>
        </tr>
        <tr>
            <td>첨부파일</td>
            <td>
                <a href="#"><%= article.getFile() %></a>
                <span><%= article.getHit() %>회 다운로드</span>
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea name="content" readonly><%= article.getContent() %></textarea>
            </td>
        </tr>
        <% } %>
    </table>
    <div>
        <a href="#" class="btnDelete">삭제</a>
        <a href="./modify.html" class="btnModify">수정</a>
        <a href="/Farmstory1/board/list.jsp?group=<%= group %>&cate=<%= cate %>" class="btnList">목록</a>
    </div>  
    
    <!-- 댓글리스트 -->
    <section class="commentList">
        <h3>댓글목록</h3>
        <article class="comment">
            <% for(ArticleBean comment : comments) { %>
            <span>
                <span>길동이</span>
                <span>20-05-13</span>
            </span>
            <textarea name="comment" readonly>댓글 샘플입니다.</textarea>
            <div>
                <a href="#">삭제</a>
                <a href="#">수정</a>
            </div>
            <% } %>
        </article>
        <p class="empty">
            등록된 댓글이 없습니다.
        </p>
    </section>

    <!-- 댓글입력폼 -->
    <section class="commentForm">
        <h3>댓글쓰기</h3>
        <form action="/Farmstory1/board/view.jsp" method="post">
            <textarea name="comment"></textarea>
            <div>
                <a href="#" class="btnCancel">취소</a>
                <input type="submit" class="btnWrite" value="작성완료"/>
            </div>
        </form>
    </section>

</section>
    </div>    
</body>
</html>