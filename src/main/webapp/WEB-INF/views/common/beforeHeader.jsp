<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<head>

			<!-- beforeHeaderCss -->
			<link rel="stylesheet" href="${contextPath}/resources/css/beforeHeader.css">
		</head>

		<!-- 공용 헤더 -->
		<header>

			<div class="header_container">
				<div class="main_logo_img_container">
					<!-- 애니버스 로고 -->
					<a href="${contextPath}/test"> <img src="${contextPath}/resources/images/PJ2logo.png" alt=""
							class="main_logo">
					</a>
				</div>
				<!-- 메뉴 리스트 테마추천, 팬아트 등 -->
				<div class="menu_list">

					<div class="menu_text_con">
						<a href="${contextPath}/board/newAnime" class="a_tag">요일별 애니</a>
					</div>
					<div class="menu_text_con">
						<a href="${contextPath}/board/theme" class="a_tag">테마추천</a>
					</div>
					<div class="menu_text_con">
						<a href="${contextPath}/board/fanart" class="a_tag">팬아트</a>
					</div>
					<div class="menu_text_con">
						<a href="${contextPath}/board/goods" class="a_tag">굿즈</a>
					</div>
					<div class="menu_text_con">
						<a href="${contextPath}/board/review?type=6" class="a_tag">리뷰</a>
					</div>

					<!-- 검색창 -->
					<form action="${contextPath}/board/search" method="get" name="search-form">
						<div class="search_prop_con">
							<input type="text" name="keyword" class="search_prop" placeholder="이름, 제목을 검색하세요">
							<input type="submit" value="검색" class="search-input">
						</div>
					</form>

					<!-- 정은 언니 주석 -->
					<!-- 조건문 걸어줄거임 로그인 안했을때와 했을때 -->

					<c:choose>

						<c:when test="${ empty sessionScope.loginMember}">
							<!-- 회원가입/로그인 버튼-->
							<div class="login_con">
								<div class="login_move">
									<a href="${contextPath}/member/loginORsignup"><button class="login_move_btn">로그인 /
											회원가입</button></a>
								</div>
							</div>
						</c:when>

						<c:otherwise>
							<div class="login_con">
								<div class="login_move">
									<c:if test="${empty loginMember.profileImage}">
										<img src="${contextPath}/resources/images/user.png" style="width: 50px;">
									</c:if>
									<c:if test="${!empty loginMember.profileImage}">
										<img src="${contextPath}${loginMember.profileImage}" style="width: 50px;">
									</c:if>
									<a href="${contextPath}/member/mypage/info">
										<button class="after_login_btn ">${loginMember.memberNickname}</button>
									</a>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
		</header>