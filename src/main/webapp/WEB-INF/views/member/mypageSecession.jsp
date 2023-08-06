<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypageSecession.css">
    
    <script src="https://kit.fontawesome.com/9c5650c683.js" crossorigin="anonymous"></script>
</head>

<body>
     <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp"/>

    <main>
        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <section id="contentTitle">
                회원 탈퇴
                <article>비밀번호를 입력하여 회원탈퇴를 진행합니다.</article>
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
                        <li><a href="${contextPath}/member/mypage/contentList/all">게시글 목록</a></li>
            			<li><a href="${contextPath}/member/mypage/secession">회원탈퇴</a></li>
                    </ul>

                </article>

                <!-- 탈퇴할 회원 프로필 정보 -->
                <article id="main-body">
                    <article id="bodyProfile">

                        <c:if test="${empty loginMember.profileImage}">
                            <img src="${contextPath}/resources/images/user.png" id="bodyProfileImg">
                         </c:if>
                         <c:if test="${!empty loginMember.profileImage}">
                            <img src="${contextPath}${loginMember.profileImage}" id="bodyProfileImg">
                         </c:if>
                         
                        <table id="profile-info">
                            <tr>
                                <th>아이디</th>
                                <td>${loginMember.memberId}</td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>${loginMember.memberEmail }</td>
                            </tr>
                            <tr>
                                <th>핸드폰 번호</th>
                                <td>${loginMember.memberTel}</td>
                            </tr>
                        </table>
                    </article>  

                    <!-- 비밀번호 확인 -->
                    <article id="bodyTable">
                        <table class="bodyList">
                            <form action="secession" method="POST" onsubmit="return secession()">
                                <tr>
                                    <th>비밀번호 입력</th>
                                    <td class="td1"><input id="inputSecession" name="inputPw" type="password"></td>
                                    <td><span id="inputSecessionSpan"></span></td>
                                </tr>

                                <tr id="td-submit">
                                    <td colspan="3">
                                        <button id="btn-submit">회원 탈퇴</button>
                                    </td>
                                </tr>
                            </form>
                        </table>
                        </article>
                    </article>
                </article>
            </section>
        </section>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/mypageSecession.js"></script>
    <script src="${contextPath}/resources/js/footer.js"></script>

</body>


</html>