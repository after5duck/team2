<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지-나의 게시글 목록</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypageContentList.css">
    <script src="https://kit.fontawesome.com/2b36447307.js" crossorigin="anonymous"></script>
</head>

<body>
    <!-- 공통 헤더 -->
    <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp"/>
    
    <main>
        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <section id="contentTitle">
                게시글 목록
                <article>회원님이 작성한 글을 조회할 수 있습니다. 목록을 누르면 해당 게시글로 이동합니다.</article>
            </section>

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
                        
                        <!-- 날짜로 내가 쓴 글 조회하기 -->
                        <div>
                            <form action="contentList" method="get" name="contentList">
                                <input type="date" name="dateStart" class="inputDate">
                                <span>~</span>
                                <input type="date" name="dateEnd" class="inputDate">
                                <button id="btn-submit">조회</button>
                            </form>
                        </div>


                        <!-- 검색어로 내가 쓴 글 조회하기 -->
                            <div class="searcharea">
                                <input type="search" id="inputSearch" placeholder="게시글 이름, 내용 입력">
                                <button id="btn-submit">검색</button>
                            </div>

                    </article>

                    <article id="contentList">
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                        <nav class="writeContent">
                            <article class="contentTitle">게시판 이름</article>
                            <article class="contentDetail">게시글 제목</article>
                            <article class="contentDate">게시글 날짜</article>
                        </nav>
                       
                        
                    </article>
                </article>
            </section>

        </section>
    </main>
    
    <!-- 공용 풋터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/mypageContentList.js"></script>


</body>
</html>