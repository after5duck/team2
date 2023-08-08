<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <c:set var="boardName" value="${map.boardName}"></c:set>
        <c:set var="pagination" value="${map.pagination}"></c:set>
        <c:set var="boardList" value="${map.boardList}"></c:set>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>리뷰 게시판</title>
            <link rel="stylesheet" href="${contextPath}/resources/css/Review.css" ?after>

            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
            <!-- 추가: font-awesome 라이브러리 CDN -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
            <script src="https://kit.fontawesome.com/9c5650c683.js" crossorigin="anonymous"></script>

            <c:if test="${not empty sessionScope.message}">
                <script>alert('${sessionScope.message}');</script>
                <c:remove var="message" scope="session" /> <!-- 세션에서 메시지 제거 -->
            </c:if>

            <style>
                @font-face {
                    font-family: 'Pretendard-Regular' !important;
                    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff') !important;
                    font-weight: 400 !important;
                    font-style: normal !important;
                }

                /* 글꼴을 적용할 요소 선택자에 대한 스타일 지정 */
                body {
                    font-family: 'Pretendard-Regular' !important;
                }
            </style>

        </head>


        <body>
            <!-- 공용 헤더 -->
            <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

            <main>
                <div class="container">
                    <div class="row">
                        <h2 class="mr-auto">${boardName}</h2>
                        <div class="form-inline mb-3">

                            <!-- <label for="sortSelect" class="mr-2">정렬:</label> -->
                            <form action="review" onsubmit="return searchValidate()">
                                <input type="hidden" name="type" value="${param.type}">

                                <select id="sortSelect" name="key" class="form-control mr-2">
                                    <option value="readCount">조회수</option>
                                    <option value="title">제목</option>
                                    <option value="author">작성자</option>
                                </select>
                                <!-- <input type="date" class="form-control mr-2" placeholder="날짜로 검색"> -->
                                <input type="text" name="query" id="search-query" class="form-control mr-2"
                                    placeholder="검색어를 입력해주세요.">
                                <button class="btn btn-pink" id="searchPink">검색</button>

                            </form>
                        </div>
                    </div>


                    <div class="row mt-3">
                        <table class="table table-striped">
                            <thead>
                                <tr>

                                    <th>글번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                    <th>조회수</th>
                                    <!-- <th>추천수</th> -->
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${!empty boardList}">
                                        <c:forEach var="board" items="${boardList}">

                                            <tr>

                                                <td>${board.boardNo}</td>
                                                <td>
                                                    <a class="my-link"
                                                        href="${contextPath}/board/detail?boardNo=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">
                                                        ${board.boardTitle}
                                                    </a>

                                                </td>
                                                <td>${board.memberNickname}</td>
                                                <td>${board.createDate}</td>
                                                <td>${board.readCount}</td>
                                                <!-- <td>50</td> -->
                                            </tr>

                                        </c:forEach>

                                    </c:when>

                                    <c:otherwise>
                                        <tr>
                                            <th colspan="6">게시글이 존재하지 않습니다.</th>
                                        </tr>

                                    </c:otherwise>

                                </c:choose>
                            </tbody>
                        </table>
                    </div>

                    <c:if test="${!empty loginMember}">
                        <div class="row justify-content-end">
                            <a class="btn btn-pink" id="writePink"
                                onclick="location.href='review_write?mode=insert&type=${param.type}&cp=${param.cp}'">글쓰기</a>
                        </div>
                    </c:if>
                </div>

                <div class="pagination-area">

                    <c:set var="url" value="review?type=${param.type}&cp=" />

                    <ul class="pagination">
                        <li><a href=${url}1${sURL}>&lt;&lt;</a></li>
                        <li><a href=${url}${pagination.prevPage}${sURL}>&lt;</a></li>
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                            <c:choose>
                                <c:when test="${i == pagination.currentPage}">
                                    <li><a class="current">${i}</a></li>
                                </c:when>

                                <c:otherwise>
                                    <li><a href="${url}${i}${sURL}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>

                        <li><a href=${url}${pagination.nextPage}${sURL}>&gt;</a></li>
                        <li><a href=${url}${pagination.maxPage}${sURL}>&gt;&gt;</a></li>
                    </ul>

                </div>
            </main>
            <!-- Footer -->

            <%-- <jsp:include page="/WEB-INF/views/common/footer.jsp" /> --%>

            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="${contextPath}/resources/js/review.js"></script>

        </body>

        </html>