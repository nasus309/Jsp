<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
<section id="user" class="terms">
    <table>
        <caption>사이트 이용약관</caption>
        <tr>
            <td>
                <textarea readonly>${vo.terms}</textarea>
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
                <textarea readonly>${vo.privacy}</textarea>
                <p>
                    <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                </p>
            </td>
        </tr>
    </table>
    <div>
        <a href="/Farmstory2/user/login.do">취소</a>
        <a href="/Farmstory2/user/register.do">다음</a>
    </div>
</section>
<jsp:include page="../_footer.jsp"></jsp:include>