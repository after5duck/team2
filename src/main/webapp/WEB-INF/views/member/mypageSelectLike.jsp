<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지-좋아요 목록</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypageLike.css">
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
                        <c:forEach var="list" items="${likeList}">
                            <nav class="likeContent">
                                <article class="fa-solid fa-heart"></article>
                                <article>${list.boardName}</article>
                                <article>
                                    <c:if test="${board.boardCode == 4}">
                                            <td class="title">
                                                <a
                                                    href="${contextPath}/board/fanart/detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}&memberNo=${board.memberNo}">
                                                    <c:choose>
                                                        <c:when test="${fn:length(board.boardTitle) > 25}">
                                                            ${fn:substring(board.boardTitle, 0, 25)}...
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${board.boardTitle}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </a>
                                            </td>
                                        </c:if>

                                        <c:if test="${board.boardCode == 6}">
                                            <td class="title">
                                                <a
                                                    href="${contextPath}/board/detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}">
                                                    <c:choose>
                                                        <c:when test="${fn:length(board.boardTitle) > 25}">
                                                            ${fn:substring(board.boardTitle, 0, 25)}...
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${board.boardTitle}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </a>
                                            </td>
                                        </c:if>
                                </article>
                                <article>${list.createDate}</article>
                            </nav>

                        </c:forEach>
                    </article>
                </article>


            </section>
        </section>
    </main>
    <!-- 공용 풋터 -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
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