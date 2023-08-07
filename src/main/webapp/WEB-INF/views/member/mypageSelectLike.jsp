<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="../resources/css/mypageLike.css">
    <script src="https://kit.fontawesome.com/2b36447307.js" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp"/>

    <main>


        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <section id="contentTitle">
                좋아요 목록
                <article>회원님이 누른 좋아요 목록입니다. 목록을 누르면 해당 게시글로 이동합니다.</article>
            </section>

            <!-- 프로필 변경 부분 -->
            <section id="contentProfile">

                <!-- 마이페이지 목록 -->
                <article id="menu">
                    <ul id="menu-ul">
                        <li><a href="${contextPath}/member/mypage/info">프로필</a></li>
                        <li><a href="${contextPath}/member/mypage/changeInfo">프로필 변경</a></li>
                        <li><a href="${contextPath}/member/mypage/changePw">비밀번호 변경</a></li>
                        <li><a href="${contextPath}/member/mypage/likeList">좋아요 목록</a></li>
                        <li><a href="${contextPath}/member/mypage/contentList">게시글 목록</a></li>
                        <li><a href="${contextPath}/member/mypage/secession">회원탈퇴</a></li>
                    </ul>
                </article>

                <article id="main-body">
                    <article id="dropDown">
                        <div>
                            <form action="#" onsubmit="selectDate()">
                                <input type="date" name="dateStart" class="inputDate">
                                <span>~</span>
                                <input type="date" name="dateEnd" class="inputDate">
                                <button id="btn-submit">조회</button>
                            </form>
                        </div>
                        <div>
                            <input type="search" id="inputSearch" placeholder="게시글 이름,내용 입력">
                        </div>
                    </article>

                    <article id="likeList">
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>
                        <nav class="likeContent">
                            <article class="fa-solid fa-heart"></article>
                            <article>게시글 이름</article>
                            <article>게시글 내용</article>
                            <article>게시글 날짜</article>
                        </nav>


                    </article>
                </article>


            </section>
        </section>
    </main>
    <!-- 공용 풋터 -->
    <footer>

        <div class="footer_first">
            <div>
                <img src="../resources/images/footer_logo.png">
            </div>
            <div>
                <h5><button type="button" id="btn"><strong>(주) 애니버스 사업자 정보</strong></button></h5>
                <div id="text_box">
                    <ul>
                        <li>상호 : 주식회사 애니버스 / 대표 : 아이육</li>
                        <li>주소 : 서울특별시 강남구 테헤란로 10길 9길</li>
                        <li>사업자등록번호 : 202-30-71018</li>
                        <li>이메일 : i6@aniverse.net / 대표전화 : 1588-1004</li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="footer_second">
            <div>
                <ul>
                    
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">고객센터</a></li>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">청소년보호정책</a></li>
                    <li><a href="#"><strong>개인정보 처리방침</strong></a></li>
                    <li><a href="#">저작권 표기</a></li>
                </ul>
            </div>
            <p>Copyright &copy; 2023.ANIVERSE.All right.reserved.</p>

        </div>
        <div class="footer_third">
            
            <i class="fa-brands fa-twitter fa-2xl"></i>
            <i class="fa-brands fa-instagram fa-2xl"></i>
            <i class="fa-brands fa-youtube fa-2xl"></i>
            <i class="fa-brands fa-facebook fa-2xl"></i>

        </div>
    </footer>
    
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <!-- mypageLike.js에서 사용할 전역변수 설정-->
    <script>

        // 최상위 주소
        const contextPath = "${contextPath}";

        // 게시글 번호
        const boardNo = "${detail.boardNo}";

        // 로그인한 회원 번호
        const loginMember = "${loginMember.memberNo}";
    </script>

    <!-- <script src="${contextPath}/resources/js/mypageLike.js"></script> -->
    
</body>
</html>