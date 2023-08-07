<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${detail.boardName}</title>

            <link rel="stylesheet" href="${contextPath}/resources/css/reviewDetail.css">
            <script src="https://kit.fontawesome.com/2b36447307.js" crossorigin="anonymous"></script>
        </head>

        <body>

            <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />
            <main>
                <!-- 핵심 내용 부분 -->
                <section id="content-main">

                    <!-- 메인 제목 -->
                    <article id="aniTitle">
                        <span>${detail.boardTitle}</span> <span id="boardType"> &nbsp; - &nbsp;
                            ${detail.boardName}</span>
                    </article>

                    <!-- 작성자 글 -->
                    <section id="contentTitle">

                        <article id="reviewProfile">
                            <div id="reviewProfileImage">
                                <c:if test="${empty detail.profileImage}">
                                    <img id="contentProfileImg" src="${contextPath}/resources/images/user.png">
                                </c:if>
                                <c:if test="${!empty detail.profileImage}">
                                    <img id="contentProfileImg" src="${contextPath}${detail.profileImage}">
                                </c:if>
                            </div>

                            <div id="reviewContent">
                                <div id="reviewWriter">
                                    <div>${detail.memberNickname}</div>
                                    <div>${detail.createDate}</div>
                                    ${reviewWrite}
                                    <c:if test="${loginMember.memberNo == detail.memberNo}">
                                        <button id="btn-modify"
                                            onclick="location.href='review_write?mode=update&boardNo=${param.boardNo}&type=${param.type}'">수정</button>
                                        <button id="btn-delete">삭제</button>
                                    </c:if>
                                </div>
                                <div>
                                    <!-- 별점을 출력하는 라디오 버튼 -->
                                    <c:forEach var="i" begin="1" end="5">
                                        <c:choose>
                                            <c:when test="${i <= detail.score}">
                                                <!-- 점수 이하의 별은 채워짐 -->
                                                <input type="radio" name="reviewStar" value="${i}" id="rate${i}"
                                                    checked><label for="rate${i}">★</label>
                                            </c:when>
                                            <c:otherwise>
                                                <!-- 점수 초과의 별은 비어있음 -->
                                                <input type="radio" name="reviewStar" value="${i}" id="rate${i}"><label
                                                    for="rate${i}">★</label>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <!-- <span class="star">
                                        ★★★★★
                                        <span>★★★★★</span>
                                        <input type="range" oninput="drawStar(this)" value="1" step="1" min="0"
                                            max="10">
                                    </span> -->
                                    <!-- <form class="mb-3" name="myform" id="myform" method="post">
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
                                    </form> -->
                                    <c:forEach var="i" begin="1" end="${score}">
                                        ★
                                    </c:forEach>

                                </div>
                            </div>
                            <div id="reviewCount">
                                <div>
                                    <i class="fa-solid fa-eye fa-sm">
                                        <span id="readCount"></span>
                                    </i>

                                </div>
                                <div>

                                </div>
                            </div>
                        </article>

                        <article id="reviewPart">
                            <p id="reviewTextarea">${detail.boardContent}</p>

                            <div id="reviewPart2">
                                <div id="commentCount">댓글&nbsp; &nbsp; <p id="countNo">${commentCount}</p>
                                </div>

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
                        <jsp:include page="/WEB-INF/views/board/reviewDetailReply.jsp" />


                    </section>

                </section>
                <!-- 동작 구분 -->
                <input type="hidden" name="mode" value="${param.mode}">

                <!-- 게시판 구분 -->
                <input type="hidden" name="type" value="${param.type}">

                <!-- 게시글 번호 -->
                <input type="hidden" name="boardNo" value="${param.boardNo}">

                <!-- 현재 페이지 -->
                <input type="hidden" name="cp" value="${param.cp}">
            </main>


            <!-- 공용 풋터 -->
            <jsp:include page="/WEB-INF/views/common/footer.jsp" />

            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <script src="${contextPath}/resources/js/review.js"></script>
            <script>

                const contextPath = "${contextPath}";

                const boardNo = "${detail.boardNo}";

                const loginMemberNo = "${loginMember.memberNo}";

            </script>

            <script src="${contextPath}/resources/js/reviewReply.js"></script>
            <script src="${contextPath}/resources/js/reviewDetail.js"></script>
        </body>

        </html>