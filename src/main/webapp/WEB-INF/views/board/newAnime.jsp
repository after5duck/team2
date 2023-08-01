<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>신작 애니</title>
<link rel="stylesheet" href="${contextPath}/resources/css/MAIN.css">
<link rel="stylesheet" href="${contextPath}/resources/css/Day.css">
</head>

<body>
	<header>

		<div class="header_container">
			<div class="main_logo_img_container">
				<!-- 애니버스 로고 -->
				<a href="${contextPath}/test"> <img
					src="${contextPath}/resources/images/PJ2logo.png" alt=""
					class="main_logo">
				</a>
			</div>
			<!-- 메뉴 리스트 테마추천, 팬아트 등 -->
			<div class="menu_list">

				<div class="menu_text_con">
					<a href="${contextPath}/board/newAnime" class="a_tag">요일별 애니</a>
				</div>
				<div class="menu_text_con">
					<a href="#" class="a_tag">테마추천</a>
				</div>
				<div class="menu_text_con">
					<a href="board/fanart" class="a_tag">팬아트</a>
				</div>
				<div class="menu_text_con">
					<a href="#" class="a_tag">굿즈</a>
				</div>
				<div class="menu_text_con">
					<a href="${contextPath}/board/review?type=6" class="a_tag">리뷰</a>
				</div>

				<!-- 검색창 -->
				<div class="search_prop_con">
					<input type="text" class="search_prop" placeholder="애니 이름을 검색하세요">
				</div>

				<c:choose>

					<c:when test="${ empty sessionScope.loginMember}">
						<!-- 회원가입/로그인 버튼-->
						<div class="login_con">
							<div class="login_move">
								<a href="${contextPath}/member/loginORsignup"><button
										class="login_move_btn">로그인 / 회원가입</button></a>
							</div>
						</div>
					</c:when>


					<c:otherwise>
						<div class="login_con">
							<div class="login_move">
								<button class="login_move_btn">
									<a href="#">마이페이지</a>
								</button>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
	</header>

	<!-- ********************************************************************************************************* -->

	<!-- 	<div class="big-item">
		<div class="image-container">
			<img src="../resources/images/modal-bgc.png">
		</div>
		<div class="text-container">
			<h2>애니 제목</h2>
			<div>
				<p>
					<strong>- 나츠메 우인장 1기</strong> 소년 나츠메 타카시는 죽은 할머니 레이코가 남긴 '우인장'을
					상속받게 됩니다. 이 장부에는 그녀가 영혼을 이용해 제압한 유령 '몬노케'들의 이름이 적혀 있습니다. 나츠메는 몬노케들과
					상호작용하며 그들의 문제를 해결하고, 각자의 이름을 돌려줍니다.
				</p>
			</div>
		</div>
	</div> -->
	<h1 class="new-title">신작 애니메이션</h1>
	<hr>
	<c:forEach var="newAnime" items="${newAnimeList}">
		<div class="big-item">
			<div class="image-container">
				<img src="${contextPath}/resources/images/${newAnime.contentPath}">
			</div>
			<div class="text-container">
				<h2>${newAnime.boardTitle}</h2>
				<div>
					<p>${newAnime.boardContent}</p>
				</div>
			</div>
		</div>
	</c:forEach>


</body>

</html>