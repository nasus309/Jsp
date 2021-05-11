<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.farmstory1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	String group = request.getParameter("group");
	String cate  = request.getParameter("cate");
	
	String path = "./_aside_"+group+".jsp";
	
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");
	
	// 전송 데이터 수신
	String seq = request.getParameter("seq");
	
	// 세션 사용자 정보 가져오기
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// 1,2 단계
	Connection conn = DBConfig.getInstance().getConnection();

	// 3단계
	PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
	psmt.setString(1, seq);
	
	// 4단계
	ResultSet rs = psmt.executeQuery();
	
	// 5단계
	
	ArticleBean ab = new ArticleBean();
		
		if(rs.next()) {
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
		}
	// 6단계
	rs.close();
	psmt.close();
	conn.close();
%>
<jsp:include page="<%= path %>"></jsp:include>
<section id="board" class="view">
    <h3>글보기</h3>
    <table>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value="<%= ab.getTitle() %>" readonly/></td>
        </tr>
        <tr>
            <td>첨부파일</td>
            <td>
                <a href="#">2020년 상반기 매출자료.xls</a>
                <span>7회 다운로드</span>
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea name="content" readonly><%= ab.getContent() %>.</textarea>
            </td>
        </tr>
    </table>
    <div>
        <a href="#" class="btnDelete">삭제</a>
        <a href="./modify.html" class="btnModify">수정</a>
        <a href="./list.html" class="btnList">목록</a>
    </div>  
    
    <!-- 댓글리스트 -->
<section class="commentList">
    <h3>댓글목록</h3>
    <article class="comment">
        <span>
            <span>길동이</span>
            <span>20-05-13</span>
        </span>
        <textarea name="comment" readonly>댓글 샘플입니다.</textarea>
        <div>
            <a href="#">삭제</a>
            <a href="#">수정</a>
        </div>
    </article>
    <p class="empty">
        등록된 댓글이 없습니다.
    </p>
</section>

<!-- 댓글입력폼 -->
<section class="commentForm">
    <h3>댓글쓰기</h3>
    <form action="/Farmstory1/board/proc/comment.jsp">
    	<input type="hidden" name="group" value="<%= group %>" />
    	<input type="hidden" name="cate" value="<%= cate %>" />
    	<input type="hidden" name="seq" value="<%= ab.getSeq() %>" />
    	<input type="hidden" name="uid" value="<%= user.getUid() %>" />
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


