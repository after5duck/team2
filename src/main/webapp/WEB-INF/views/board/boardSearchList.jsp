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
                                            <td class="boardCd">${board.boardName}&nbsp;게시판</td>
                                            <td class="No">${board.boardNo}</td>

                                            <c:choose>
                                                <c:when test="${board.boardCode == 2}">
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/newAnime?boardNo=${board.boardNo}">${board.boardTitle}</a>
                                                    </td>
                                                </c:when>
                                                <c:when test="${board.boardCode == 4}">
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/fanart/detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}">${board.boardTitle}</a>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td class="title">
                                                        <a
                                                            href="${contextPath}/board/detail?boardNo=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}">${board.boardTitle}</a>
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