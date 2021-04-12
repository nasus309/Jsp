<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<c:if test="${requestScope.group == 'market'}"><jsp:include page="./_aside_market.jsp"/></c:if>
<c:if test="${group eq 'croptalk'}"><jsp:include page="./_aside_croptalk.jsp"/></c:if>
<c:if test="${group eq 'event'}"><jsp:include page="./_aside_event.jsp"/></c:if>
<c:if test="${group eq 'community'}"><jsp:include page="./_aside_community.jsp"/></c:if>
<section id="board" class="modify">
    <h3>글수정</h3>
    <article>
        <form action="#">
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content"></textarea>                                
                    </td>
                </tr>
                <tr>
                    <td>첨부</td>
                    <td><input type="file" name="file"/></td>
                </tr>
            </table>
            <div>
                <a href="/Farmstory2/board/list.do" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="수정완료">
            </div>
        </form>
    </article>
</section>
<jsp:include page="../_footer.jsp"></jsp:include>