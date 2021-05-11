<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<c:if test="${requestScope.group == 'market'}"><jsp:include page="./_aside_market.jsp"/></c:if>
<c:if test="${group eq 'croptalk'}"><jsp:include page="./_aside_croptalk.jsp"/></c:if>
<c:if test="${group eq 'event'}"><jsp:include page="./_aside_event.jsp"/></c:if>
<c:if test="${group eq 'community'}"><jsp:include page="./_aside_community.jsp"/></c:if>
<script>

 	$(function(){
		
 		$('.commentdelete').one('click',function(){
 			
 			var comment_seq = $('input[name="comment_seq"]').val();
 			var seq = $('input[name="seq"]').val();
 			$.ajax({
 				type:"post",
 				dataType:"text",
 				url:"/Farmstory2/board/commentDelete.do",
 				data: {
 					"comment_seq" : comment_seq,
 					"seq" : seq
 				},
 				success : function(data){
 					
 				}
 			});
 		});
 		
 		$('.btnDelete').on('click',function(){
 			
 			if(confirm('정말 삭제 하시겠습니까?')){
 				
 				var seq = $('input[name="seq"]').val();
 	 			var cate = $('input[name="cate"]').val();
 	 			var group = $('input[name="group"]').val();
 	 			$.ajax({
 	 				type:"post",
 	 				dataType:"json",
 	 				url:"/Farmstory2/board/articleDelete.do",
 	 				data: {
 	 					"seq" : seq,
 	 					"cate" : cate,
 	 				},
 	 				success : function(data){
 	 					if(data.result == 1){
 	 						alert('삭제가 완료 되었습니다.');
 	 						location.href = '/Farmstory2/board/list.do?group='+group+'&cate='+cate;
 	 					}
 	 				}
 	 			});
 				
 				
 			}
 			
 		});
		
		
	}); 
	
	
</script>
<section id="board" class="view">
    <h3>글보기</h3>
    <table>
    	<input type="hidden" name="seq" value="${vo.seq}"/>
		<input type="hidden" name="cate" value="${cate}"/>
		<input type="hidden" name="group" value="${group}"/>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value="${vo.title}" readonly/></td>
        	
        </tr>
        <tr>
            <td>첨부파일</td>
            <td>
                <a href="/Farmstory2/board/download.do?seq=${vo.fb.seq}">${vo.fb.oldName}</a>
                <span>${vo.fb.download}회 다운로드</span>
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea name="content" readonly>${vo.content}</textarea>
            </td>
        </tr>
    </table>
    <div>
        <a href="#" class="btnDelete">삭제</a>
        <a href="/Farmstory2/board/modify.do?group=${group}&cate=${cate}&seq=${vo.seq}" class="btnModify">수정</a>
        <a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}" class="btnList">목록</a>
    </div>  
    
    <!-- 댓글리스트 -->
    <section class="commentList">
        <h3>댓글목록</h3>
        <c:forEach var="comment" items="${comments}">
	        <article class="comment">
	        	<%-- <input type="hidden" name="comment_seq" value="${comment.seq}" /> --%>
	            <span>
	                <span>${comment.nick}</span>
	                <span>${comment.rdate.substring(2,16)}</span>
	            </span>
	            <textarea name="comment" readonly>${comment.content}</textarea>
	            <div>
	            	<input type="hidden" name="comment_seq" value="${comment.seq}"/>
	            	<input type="hidden" name="seq" value="${vo.seq}"/>
	                <a href="/Farmstory2/board/view.do?group=${group}&cate=${cate}&seq=${vo.seq}" class="commentdelete">삭제</a>
	                <%-- <a href="/Farmstory2/board/modify.do?group=${group}&cate=${cate}&seq=${vo.seq}" class="commentmodify">수정</a> --%>
	            </div>           
	        </article>
        </c:forEach> 
        <c:if test="${vo.comment eq 0}">
	        <p class="empty">
	            	등록된 댓글이 없습니다.
	        </p>
        </c:if>
    </section>

    <!-- 댓글입력폼 -->
    <section class="commentForm">
        <h3>댓글쓰기</h3>
        <form action="/Farmstory2/board/view.do?group=${group}&cate=${cate}&seq=${vo.seq}" method="post">
            <textarea name="comment"></textarea>
            <div>
                <input type="submit" class="btnWrite" value="작성완료"/>
            </div>
        </form>
    </section>

</section>
<jsp:include page="../_footer.jsp"></jsp:include>