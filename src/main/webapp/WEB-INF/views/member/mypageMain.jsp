<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypageProfileMain.css">
    <script src="https://kit.fontawesome.com/9c5650c683.js" crossorigin="anonymous"></script>
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp"/>
    <main>
        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <section id="contentTitle">
                프로필 변경
                <article>회원님의 정보를 수정할 수 있습니다.</article>
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

                <!-- 프로필 사진 변경 -->
                <article id="main-body">
                    <article id="bodyProfile">
                        <form action="info" method="post" enctype="multipart/form-data" onsubmit="return profileValidate()">

                            <div class="profile-image-area">
                                <c:if test="${empty loginMember.profileImage}">
                                    <img src="${contextPath}/resources/images/user.png" id="bodyProfileImg">
                                </c:if>
                                <c:if test="${!empty loginMember.profileImage}">
                                    <img src="${contextPath}${loginMember.profileImage}" id="bodyProfileImg">
                                </c:if>
                             
                            </div>
                            <div class="profile-btn-area">
                                <label for="search-image">이미지 찾기</label>
                                <input type="file" name="profileImage" id="search-image">
                                <button id="btn-changeProfile">프로필 변경</button>
                            </div>

                        </form>
                    </article>  

                    <article id="bodyTable">
                        <table class="bodyList">
                                <tr>
                                    <th>닉네임</th>
                                    <td class="td1" colspan="2">${loginMember.memberNickname}</td>
                                    <td></td>
                                </tr>
                                <tr>
                                <tr>
                                    <th>가입일</th>
                                    <td class="td1" colspan="2">${loginMember.enrollDate}</td>
                                    <td></td>
                                </tr>
                         </table>
                    </article>
                </article>

            </section>

        </section>
    </main>

        <!-- 공용 풋터 -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/mypageProfileMain.js"></script>
    <script src="${contextPath}/resources/js/footer.js"></script>
</body>
</html>