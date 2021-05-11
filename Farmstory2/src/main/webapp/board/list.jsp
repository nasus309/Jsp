<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<c:if test="${requestScope.group == 'market'}"><jsp:include page="./_aside_market.jsp"/></c:if>
<c:if test="${group eq 'croptalk'}"><jsp:include page="./_aside_croptalk.jsp"/></c:if>
<c:if test="${group eq 'event'}"><jsp:include page="./_aside_event.jsp"/></c:if>
<c:if test="${group eq 'community'}"><jsp:include page="./_aside_community.jsp"/></c:if>

<section id="board" class="list">
    <h3>글목록</h3>
    <article>
        <p>
            ${suser.nick}님 반갑습니다.
            <a href="/Farmstory2/user/login.do" class="logout">[로그아웃]</a>
        </p>
        <table border="0">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>
            <c:forEach var="article" items="${articles}">
	            <tr>
	                <td>${listStartNum = listStartNum -1}</td>
	                <td><a href="/Farmstory2/board/view.do?group=${group}&cate=${cate}&seq=${article.seq}">${article.title}</a>&nbsp;[${article.comment}]</td>
	                <td>${article.nick}</td>
	                <td>${article.rdate.substring(2,10)}</td>
	                <td>${article.hit}</td>
	            </tr>
            </c:forEach>
        </table>
    </article>

    <!-- 페이지 네비게이션 -->
    <div class="paging">
    	<c:if test="${groups[0] > 1}">
        	<a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}&pg=${groups[0] - 1}" class="prev">이전</a>
        </c:if>
        <c:forEach var="i" begin="${groups[0]}" end="${groups[1]}">
        	<a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}&pg=${i}" class="num ${currentPage == i ? 'current':'off'}">${i}</a> 
        </c:forEach>
        <c:if test="${groups[1] < lastPageNum}">       
        	<a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}&pg=${groups[1] + 1}" class="next">다음</a>
        </c:if>
    </div>

    <!-- 글쓰기 버튼 -->
    <a href="/Farmstory2/board/write.do?group=${group}&cate=${cate}" class="btnWrite">글쓰기</a>
</section>

            <!-- 내용 끝 -->

        </article>
    </section>
</div> 
<jsp:include page="../_footer.jsp"></jsp:include>