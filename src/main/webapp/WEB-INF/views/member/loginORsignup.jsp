<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인or회원가입</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/loginORsignup.css">
</head>
<body>
    <!--  -->
    <main class="infinite-photo-grid">
    <!--  -->
    <section id="body">

        <article id="loginORsignup">
            <img src="${contextPath}/resources/images/aniverse로고4.png" id="logo">
    
            <div class="textarea">
                <div>신작부터 역대 인기 작품까지</div>
                <div>애니메이션을 한 곳에서 편-안하게 추천받으세요!</div>
            </div>
            
            <div>
                <a href="${contextPath}/member/login" id="btn1" name="btn1">아이디로 로그인</a>
            </div>
    
            <div class="btn23">
                <a href="${contextPath}" id="btn2" name="btn2">돌아가기</a>
                <a href="${contextPath}/member/signUpAgree" id="btn3" name="btn3">가입하기</a>
            </div>

        </article>
    </section>
</main>

    <c:if test="${ !empty sessionScope.message }">
		<script>
			alert("${message}");
			
		</script>

		<c:remove var="message" scope="session" />
	</c:if>

</body>
</html>