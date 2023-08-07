<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <link rel="stylesheet" href="${contextPath}/resources/css/boardSearchList.css">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                <!-- 추가: font-awesome 라이브러리 CDN -->
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
                <title>Insert title here</title>
            </head>

            <body>

                <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

                <div class="container">

                    <div class="keywordRs">

                        <h2>"${map.keyword}"</h2>
                        <h2>검색 결과</h2>

                    </div>

                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th class="nowrap">게시판</th>
                                <th class="nowrap">번호</th>
                                <th>제목</th>
                                <th>내용</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${fn:length(map.searchResult) == 0}">
                                    <tr>
                                        <td colspan="5" class="content">검색결과가 없습니다.</td>
                                    </tr>

                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="board" items="${map.searchResult}">
                                        <tr>
                                            <td class="boardCd">
                                                <c:choose>
                                                    <c:when test="${board.boardName == '메인'}">
                                                        <a href="${contextPath}/test">${board.boardName}</a>
                                                    </c:when>
                                                    <c:when test="${board.boardName == '신작애니'}">
                                                        <a href="${contextPath}/board/newAnime">${board.boardName}</a>
                                                    </c:when>
                                                    <c:when test="${board.boardName == '테마추천'}">
                                                        <a href="${contextPath}/board/theme">${board.boardName}</a>
                                                    </c:when>
                                                    <c:when test="${board.boardName == '테마추천상세'}">
                                                        <a href="${contextPath}/board/theme">${board.boardName}</a>
                                                    </c:when>

                                                    <c:when test="${board.boardName == '팬아트'}">
                                                        <a
                                                            href="${contextPath}/board/fanart?boardCode=4">${board.boardName}</a>
                                                    </c:when>
                                                    <c:when test="${board.boardName == '굿즈'}">
                                                        <a href="${contextPath}/board/goods">${board.boardName}</a>
                                                    </c:when>
                                                    <c:when test="${board.boardName == '리뷰'}">
                                                        <a
                                                            href="${contextPath}/board/review?type=6">${board.boardName}</a>
                                                    </c:when>
                                                </c:choose>

                                            </td>

                                            <!-- **************** **************** **************** **************** **************** **************** -->

                                            <td class="No">${board.boardNo}</td>

                                            <c:choose>
                                                <c:when test="${board.boardCode == 1}">
                                                    <td class="title">
                                                        <a href="${contextPath}/test">
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
                                                </c:when>
                                                <c:when test="${board.boardCode == 2}">
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/newAnime?boardNo=${board.boardNo}">
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
                                                </c:when>
                                                <c:when test="${board.boardCode == 4}">
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/fanart/detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}">
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
                                                </c:when>
                                                <c:when test="${board.boardCode == 5}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/goods?boardNo=${board.boardNo}">
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
                                                </c:when>

                                                <c:when test="${board.boardCode == 6}">
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/detail?boardNo=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 53 and board.boardNo <= 56}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=44">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 57 and board.boardNo <= 60}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=45">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 61 and board.boardNo <= 66}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=46">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 67 and board.boardNo <= 73}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=47">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 74 and board.boardNo <= 77}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=48">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 78 and board.boardNo <= 82}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=49">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 83 and board.boardNo <= 86}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=50">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 87 and board.boardNo <= 91}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=51">
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
                                                </c:when>

                                                <c:when test="${board.boardNo >= 92 and board.boardNo <= 98}">
                                                    <td class="title">
                                                        <a href="${contextPath}/board/theme_detail?boardNo=52">
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
                                                </c:when>

                                                <c:otherwise>

                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/theme_detail?boardNo=${board.boardNo}">
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

                                                </c:otherwise>
                                            </c:choose>


                                            <!-- **************** **************** **************** **************** **************** **************** -->

                                            <c:choose>
                                                <c:when test="${empty board.boardContent}">
                                                    <td class="content">내용이 없습니다.</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="contentLength"
                                                        value="${fn:length(board.boardContent)}" />
                                                    <c:choose>
                                                        <c:when test="${contentLength > 50}">
                                                            <c:set var="shortContent"
                                                                value="${fn:substring(board.boardContent, 0, 50)}..." />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:set var="shortContent" value="${board.boardContent}" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <td class="content">${shortContent}</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td class="createDt">${fn:substring(board.createDate, 0, 10)}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>



                        </tbody>
                    </table>

                </div>
            </body>

            </html>