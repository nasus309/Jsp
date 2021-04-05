<%@page import="kr.co.jboard1.bean.FileBean"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String seq = request.getParameter("seq");
	
	// 세션 사용자 정보 가져오기
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// 데이터베이스 처리 - 조회수 업데이트
	ArticleDao dao = ArticleDao.getInstance();
	dao.updateArticelHit(seq);
	// 데이터베이스 처리 - 게시물 가져오기
	ArticleBean ab = dao.selectArticle(seq);
	
	// 데이터베이스 처리 댓글 가져오기
	List<ArticleBean> comments = dao.selectComments(seq);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <section id="board" class="view">
            <h3>글보기</h3>
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="<%= ab.getTitle() %>" readonly/></td>
                </tr>
                <% if(ab.getFile() > 0) { 
                	FileBean fb = ab.getFb();
                %>
                <tr>
                    <td>첨부파일</td>
                    <td>
                        <a href="#"><%= ab.getFb().getOldName() %></a>
                        <span><%= ab.getFb().getDownload() %></span>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content" readonly><%= ab.getContent() %></textarea>
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
                <% if(ab.getComment() > 0){ %>
                	<% for(ArticleBean comment : comments) { %>
		                <article class="comment">
		                    <span>
		                        <span><%= comment.getNick() %></span>
		                        <span><%= comment.getRdate().substring(2, 10) %></span>
		                    </span>
		                    <textarea name="comment" readonly><%= comment.getContent() %></textarea>
		                    <div>
		                    	<% if(uid.equals(comment.getUid())) {%> <!-- 현재 로그인 사용자와 해당 댓글 사용자가 같을 경우 삭제버튼 활성화 -->
		                        <a href="/Jboard1/proc/deleteComment.jsp?seq=<%= comment.getSeq() %>&parent=<%= comment.getParent() %>">삭제</a> <!-- 코멘트의 글번호  -->
		                        <% } %>		                   
		                    </div>
		                </article>
	                <% } %>
                <% }else{ %>
	                <p class="empty">
	                    등록된 댓글이 없습니다.
	                </p>
	            <% } %>
            </section>

            <!-- 댓글입력폼 -->
            <section class="commentForm">
                <h3>댓글쓰기</h3>
                <form action="/Jboard1/proc/comment.jsp" method="post">
                	<input type="hidden" name="seq" value="<%= ab.getSeq() %>"/> <!-- 글번호가 화면에 나올 필요가 없으니까 type을 hidden으로 -->
                    <textarea name="comment" required></textarea> <!-- require는 값이 없이 제출시 알려주는 기능 -->
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