<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
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