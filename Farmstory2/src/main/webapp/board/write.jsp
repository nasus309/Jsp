<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
<jsp:include page="./_aside_${group}.jsp"></jsp:include>
<section id="board" class="write">
    <h3>글쓰기</h3>
    <article>
        <form action="/Farmstory2/board/write.do" method="post" enctype="multipart/form-data">
	        <input type="hidden" name="uid" value="${sessionScope.suser.uid}"/>
	        <input type="hidden" name="group" value="${group}"/>
	        <input type="hidden" name="cate" value="${cate}"/>
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
                <a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="작성완료">
            </div>
        </form>
    </article>
</section>
<jsp:include page="../_footer.jsp"></jsp:include>