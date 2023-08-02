<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/reviewDetail.css">
    <script src="https://kit.fontawesome.com/2b36447307.js" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <main>
        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <article id="aniTitle">
                <span>${detail.boardTitle}</span> - <span>${detail.boardName}</span>
            </article>

            <!-- 작성자 글 -->
            <section id="contentTitle">

                <article id="reviewProfile">
                    <div id="reviewProfileImage">
                        <c:if test="${empty detail.profileImage}">
                            <img id="contentProfileImg" src="${contextPath}/resources/images/profile.png">
                        </c:if>
                        <c:if test="${!empty detail.profileImage}">
                            <img id="contentProfileImg" src="${contextPath}${loginMember.profileImage}">
                        </c:if>
                    </div>

                    <div id="reviewContent">
                        <div id="reviewWriter">
                            <div>${detail.memberNickname}</div>   
                            <div>${detail.createDate}</div>
                            <c:if test="${loginMember.memberNo == detail.memberNo}">
                                <button id="btn-modify">수정</button>
                                <button id="btn-delete">삭제</button>
                            </c:if>
                        </div>
                        <div>
                            <form class="mb-3" name="myform" id="myform" method="post">
                                <input type="radio" name="reviewStar" value="1" id="rate5"><label
                                    for="rate5">★</label>
                                <input type="radio" name="reviewStar" value="3" id="rate3"><label
                                    for="rate4">★</label>
                                <input type="radio" name="reviewStar" value="2" id="rate4"><label
                                    for="rate3">★</label>
                                <input type="radio" name="reviewStar" value="4" id="rate2"><label
                                    for="rate2">★</label>
                                <input type="radio" name="reviewStar" value="5" id="rate1"><label
                                    for="rate1">★</label>
                            </form>
                        </div>
                    </div>
                </article>

                <article id="reviewPart">
                    <p id="reviewTextarea">${detail.boardContent}</p>
                    
                    <div id="reviewPart2">
                        <div id="commentCount">댓글&nbsp; &nbsp;  <p id="countNo">${commentCount}</p></div>

                        <div id="commentBtn">
                            <!-- <c:if test="${loginMember.memberNo == reply.memberNo}">
                                <button type="button" id="btn-back">이전으로</button>
                                <button id="btn-review" onsubmit="return reviewValidate()">작성</button>
                            </c:if>
                            <c:if test="${loginMember.memberNo != reply.memberNo}">
                            </c:if> -->
                                <button type="button" id="btn-list">목록으로</button>
                        </div>
                    </div>
                </article>


                <!-- 댓글 -->
                <jsp:include page="/WEB-INF/views/board/reviewDetailReply.jsp"/>


            </section>

        </section>
    </main>
    
    <!-- 공용 풋터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="${contextPath}/resources/js/reviewReply.js"></script>
    <script>

        const contextPath = "${contextPath}";

        const boardNo = "${detail.boardNo}";

        const loginMember = "${loginMember.memberNo}";

    </script>

    <script src="${contextPath}/resources/js/reviewReply.js"></script>

</body>
</html>