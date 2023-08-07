<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypageProfile.css"?after>
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
                    <article id="bodyTable">
                        <table class="bodyList">
                            <form action="changeInfo" method="POST" onsubmit="return changeProfile()">
                                <tr>
                                    <th>아이디</th>
                                    <td class="td1">${loginMember.memberId}</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>닉네임</th>
                                    <td class="td1"><input id="nickInfo" type="text" name="memberNickname" value="${loginMember.memberNickname}" required></td>
                                    <td><button type="button" id="btn-check">중복확인</button></td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td class="td1"><input type="email" id="inputEmail" name="memberEmail" value="${loginMember.memberEmail}"></td>
                                    <td><button type="button" id="btn-cerEmail">인증번호 발송</button></td>
                                </tr>
                                <tr>
                                    <th>인증번호</th>
                                    <td class="td1"><input type="text" id="inputCheck"></td>
                                    <td><button type="button" id="btn-checkEmail">인증번호 확인</button></td>
                                </tr>
                                <tr>
                                    <th>핸드폰 번호</th>
                                    <td class="td1">${loginMember.memberTel}</td>
                                    <td></td>
                                </tr>
                                <tr id="td-submit">
                                    <td colspan="3">
                                        <button id="btn-submit">변경 완료</button>
                                    </td>
                                </tr>
                            </form>
                        </table>
                    </article>
                </article>
            </section>

        </section>
    </main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script>
        const contextPath = "${contextPath}";

        const memberNo = "${loginMember.memberNo}";

        const loginMemberNick = "${loginMember.memberNickname}";

        const loginMemberEmail = "${loginMember.memberEmail}"

    </script>
    
    <script src="${contextPath}/resources/js/mypageInfo.js"></script>

    <script src="${contextPath}/resources/js/footer.js"></script>
</body>
</html>