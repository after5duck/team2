<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>회원가입</title>
                <link rel="stylesheet" href="${contextPath}/resources/css/signUp.css">
            </head>

            <body>
            	<section class="logo">
        			<a href="${contextPath}">
            			<img src="${contextPath}/resources/images/자른로고.png" id="logo">
        			</a>
    			</section>

                <section class="signUp-content">
                    <form action="signUp" method="POST" name="signUp-form" onsubmit="return signUpValidate()">

                        <div class="ddack">딱 이것만 작성하면 가입 완료!</div>
                        <div class="ddack2">
                            <div>*</div>는 필수입력 항목입니다.
                        </div>

                        <!-- ============================= 아이디 영역 ============================== -->
                        <label for="memberId">
                            <span class="required">*</span>아이디
                        </label>

                        <!-- 아이디 입력 영역 -->
                        <div class="signUp-input-area">
                            <input type="text" id="memberId" name="memberId" placeholder="아이디" maxlength="30"
                                autocomplete="off" required>

                        </div>

                        <!-- 아이디 메세지 -->
                        <span class="signUp-message" id="idm">영어/숫자 5~20글자 사이로 작성해주세요.</span>



                        <!-- ============================= 비밀번호 영역 ================================ -->
                        <label for="memberPw">
                            <span class="required">*</span>비밀번호
                        </label>
                        <!-- 비밀번호 입력 영역 -->
                        <div class="signUp-input-area">
                            <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호"
                                maxlength="30">
                        </div>
                        <!-- 비밀번호 확인 영역 -->
                        <div class="signUp-input-area">
                            <input type="password" id="memberPwConfirm" placeholder="비밀번호 확인"
                                maxlength="30">
                        </div>

                        <!-- 비번 메세지 -->
                        <span class="signUp-message" id="pwm">영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.</span>



                        <!-- ============================= 닉네임 영역 ============================== -->
                        <label for="memberNick">
                            <span class="required">*</span>닉네임
                        </label>
                        <!-- 아이디 입력 영역 -->
                        <div class="signUp-input-area">
                            <input type="text" id="memberNick" name="memberNick" placeholder="닉네임"
                                maxlength="30" autocomplete="off" required>

                        </div>

                        <!-- 닉네임 메세지 -->
                        <span class="signUp-message" id="nickm">영어/숫자/한글 2~10글자 사이로 작성해주세요.</span>



                        <!-- =============================== 핸드폰 번호 영역 ============================= -->
                        <label for="memberTel">
                            <span class="required">*</span>핸드폰 번호
                        </label>

                        <!-- 핸드폰 번호 입력 영역 -->
                        <div class="signUp-input-area">
                            <input type="text" id="memberTel" name="memberTel" placeholder="핸드폰 번호 입력"
                                autocomplete="off" maxlength="11">

                            <!-- <form action="sendSms" method="post"> -->
                                <!-- <button type="submit">인증하기</button> -->
                            <!-- </form>  -->
                        </div>

                        <!-- 핸드폰 메세지 -->
                        <span class="signUp-message" id="telm">전화번호를 입력해주세요( -제외)</span>




                        <!-- ============================ 이메일 영역 =================================-->
                        <label for="memberEmail">이메일</label>

                        <!-- 이메일 입력 영역 -->
                        <div class="signUp-input-area">
                            <input type="email" id="memberEmail" name="memberEmail" placeholder="이메일(선택 입력)"
                                maxlength="30" autocomplete="off">
                            <button type="button" id="emailBtn">인증번호 발송</button>
                        </div>

                        <!-- 이메일 메세지 -->
                        <span class="signUp-message" id="emailm">메일을 받을 이메일을 입력해주세요.</span>


                        <!-- 이메일 인증 영역 -->
                        <div class="signUp-input-area">
                            <input type="text" id="email2" name="email2" placeholder="인증번호 입력" autocomplete="off">
                            <button type="button" id="email2Btn">인증번호 확인</button>
                        </div>
                        <!-- 이메일 인증 메세지 -->
                        <span class="signUp-message" id="emailm">인증번호를 입력해주세요.</span>


                        <button id="btn">버튼만 누르면 가입완료!</button>
                    </form>

                </section>
                <!-- 가입하기 버튼 -->

                
                <c:if test="${ !empty sessionScope.message }">
                    <script>
                        alert("${message}");

                    </script>

                    <c:remove var="message" scope="session" />
                </c:if>

                <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>


                <script>

                    const contextPath = "${contextPath}";

                </script>

                <script src="${contextPath}/resources/js/signUp.js"></script>

            </body>

            </html>