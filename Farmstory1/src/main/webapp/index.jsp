<%@page import="kr.co.farmstory1.config.Sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.farmstory1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<%
	// 1,2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_LATEST);
	psmt.executeUpdate();
	
	// 4단계
	
	// 5단계
	// 6단계
%>

<main>
    <div class="slider">

        <ul>
            <li><img src="/Farmstory1/img/main_slide_img1.jpg" alt="슬라이더1"></li>
            <li><img src="/Farmstory1/img/main_slide_img2.jpg" alt="슬라이더2"></li>
            <li><img src="/Farmstory1/img/main_slide_img3.jpg" alt="슬라이더3"></li>
        </ul>

        <img src="/Farmstory1/img/main_slide_img_tit.png" alt="사람과 자연을 사랑하는 팜스토리"/>

        <div class="banner">
            <img src="/Farmstory1/img/main_banner_txt.png" alt="GRAND OPEN"/>
            <img src="/Farmstory1/img/main_banner_tit.png" alt="팜스토리 오픈기념 30% 할인 이벤트"/>
            <img src="/Farmstory1/img/main_banner_img.png" alt="과일"/>
        </div>
    </div>

    <div class="quick">
        <a href="#"><img src="/Farmstory1/img/main_banner_sub1_tit.png" alt="오늘의 식단"></a>
        <a href="#"><img src="/Farmstory1/img/main_banner_sub2_tit.png" alt="나도 요리사"></a>                
    </div>

    <div class="latest">
        <div>
            <a href="#"><img src="/Farmstory1/img/main_latest1_tit.png" alt="텃밭 가꾸기"/></a>
            <img src="/Farmstory1/img/main_latest1_img.jpg" alt="이미지"/>
            <table border="0">
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
            </table>
        </div>
        <div>
            <a href="#"><img src="/Farmstory1/img/main_latest2_tit.png" alt="귀농학교"/></a>
            <img src="/Farmstory1/img/main_latest2_img.jpg" alt="이미지"/>
            <table border="0">
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
            </table>
        </div>
        <div>
            <a href="#"><img src="/Farmstory1/img/main_latest3_tit.png" alt="농작물 이야기"/></a>
            <img src="/Farmstory1/img/main_latest3_img.jpg" alt="이미지"/>
            <table border="0">
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
                <tr>
                    <td>></td>
                    <td><a href="#">토마토! 건강하게 길러서 안심하고 먹자</a></td>
                    <td>20-12-22</td>
                </tr>
            </table>
        </div>
        
    </div>

    <div class="info">
        <div>
            <img src="/Farmstory1/img/main_sub2_cs_tit.png" class="tit" alt="고객센터 안내"/>

        </div>
        <div>
            <img src="/Farmstory1/img/main_sub2_account_tit.png" class="tit" alt="계좌안내"/>
            <p class="account">
                기업은행 123-456789-01-01-012<br />
                국민은행 01-1234-56789<br />
                우리은행 123-456789-01-01-012<br />
                하나은행 123-456789-01-01<br />
                예 금 주 (주)팜스토리
            </p>
        </div>
        <div>
            <div id="tabs">
                <ul>
                    <li><a href="#tabs-1">공지사항</a></li>
                    <li><a href="#tabs-2">1:1 고객문의</a></li>
                    <li><a href="#tabs-3">자주묻는 질문</a></li>
                </ul>
                <div id="tabs-1">
                    <ul>
                        <li>· 홈페이지 오픈 기념 이벤트를 진행합니다.</li>
                        <li>· 홈페이지 오픈 기념 이벤트를 진행합니다.</li>
                        <li>· 홈페이지 오픈 기념 이벤트를 진행합니다.</li>
                    </ul>
                </div>
                <div id="tabs-2">
                    <ul>
                        <li>· 홈페이지 이용 관련 불편사항을 들려주세요.</li>
                        <li>· 홈페이지 이용 관련 불편사항을 들려주세요.</li>
                        <li>· 홈페이지 이용 관련 불편사항을 들려주세요.</li>
                    </ul>
                </div>
                <div id="tabs-3">
                    <ul>
                        <li>· 홈페이지를 오픈하였습니다.</li>
                        <li>· 홈페이지를 오픈하였습니다.</li>
                        <li>· 홈페이지를 오픈하였습니다.</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="./_footer.jsp" %>