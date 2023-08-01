<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인창</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/login.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <!-- ANIVERSE 로고 -->
    <section class="logo">
    	<a href="${contextPath }">
	        <img src="${contextPath}/resources/images/자른로고.png" id="lo">
    	</a>
    </section>
    
    <div class="container">

        <!-- 로그인 영역 -->
        <form action="login" method="POST" name="login-form" onsubmit="return loginValidate()">

            <!-- 로그인 문구 -->
            <div id="text1">아이디로 로그인</div>

            <!-- 아이디 -->
            <div class="texts">아이디</div>
            <div class="inputarea">
                <input type="text" class="inputbox" id="inputId" name="inputId">
            </div>

            <!-- 아이디가 이상할 경우 -->
            <!-- <span></span> -->
    
            <!-- 비번 -->
            <div class="texts">비밀번호</div>
            <div class="inputarea">
                <input type="password" class="inputbox" id="inputPw" name="inputPw">
            </div>
    
            <!-- 비번 찾기 영역 -->
            <div class="findPw">
                <a href="#" id="Pwsearch">비밀번호 찾기</a>
            </div>
    
            <!-- 로그인 버튼 -->
            <div class="btnarea">
                <button type="submit" id="btn">로그인</button>
            </div>

        </form>

    </div>
    
    
    <c:if test="${ !empty sessionScope.message }">
		<script>
			alert("${message}");
			
		</script>

		<c:remove var="message" scope="session" />
	</c:if>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/login.js"></script>
</body>
</html>