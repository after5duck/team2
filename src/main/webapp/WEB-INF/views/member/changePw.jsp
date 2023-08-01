<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/mypagePassword.css">
    <script src="https://kit.fontawesome.com/9c5650c683.js" crossorigin="anonymous"></script>
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/beforeHeader.jsp"/>

    <main>
        <!-- 핵심 내용 부분 -->
        <section id="content-main">

            <!-- 메인 제목 -->
            <section id="contentTitle">
                비밀번호 변경
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
                            <form action="changePw" method="POST" onsubmit="return changePassword(inputPw.value)">
                                <tr>
                                    <th>현재 비밀번호</th>
                                    <td class="td1"><input type="password" autocomplete="off" id="inputPw" required maxlength="20"></td>
                                    <td><span id="inputPwSpan"></span></td>
                                </tr>
                                <tr>

                                </tr>
                                <tr>
                                    <th>새 비밀번호</th>
                                    <td class="td1"><input type="password" autocomplete="off" id="newPw" maxlength="20"></td>
                                    <td><span id="newPwSpan"></span></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><span id="caution"></span></td>
                                </tr>
                                
                                <tr>
                                    <th>비밀번호 확인</th>
                                    <td class="td1"><input type="password" autocomplete="off" id="newPwConfirm" maxlength="20"></td>
                                    <td><span id="newPwConfirmSpan"></span></td>
                                </tr>
                                <tr id="td-submit">
                                    <td colspan="3">
                                        <button id="btn-submit">변경 완료</button>
                                    </td>
                                </tr>
                            </table>
                            
                            </article>
                    </article>
                </article>

            </section>

        </section>
    </main>

        <!-- 공용 풋터 -->
        <footer>

            <div class="footer_first">
                <div>
                    <img src="${contextPath}/resources/images/footer_logo.png">
                </div>
                <div>
                    <h5><button id="btn"><strong>(주) 애니버스 사업자 정보</strong></button></h5>
                    <div id="text_box">
                        <ul>
                            <li>상호 : 주식회사 애니버스 / 대표 : 아이육</li>
                            <li>주소 : 서울특별시 강남구 테헤란로 10길 9길</li>
                            <li>사업자등록번호 : 202-30-71018</li>
                            <li>이메일 : i6@aniverse.net / 대표전화 : 1588-1004</li>
                        </ul>
                    </div>
                </div>
    
            </div>
            <div class="footer_second">
                <div>
                    <ul>
                        
                        <li><a href="#">회사소개</a></li>
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">청소년보호정책</a></li>
                        <li><a href="#"><strong>개인정보 처리방침</strong></a></li>
                        <li><a href="#">저작권 표기</a></li>
                    </ul>
                </div>
                <p>Copyright &copy; 2023.ANIVERSE.All right.reserved.</p>
    
            </div>
            <div class="footer_third">
                
                <i class="fa-brands fa-twitter fa-2xl"></i>
                <i class="fa-brands fa-instagram fa-2xl"></i>
                <i class="fa-brands fa-youtube fa-2xl"></i>
                <i class="fa-brands fa-facebook fa-2xl"></i>
    
            </div>
        </footer>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/mypagePassword.js"></script>
    <script src="${contextPath}/resources/js/footer.js"></script>
</body>
</html>