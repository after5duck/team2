<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://kit.fontawesome.com/9c5650c683.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="${contextPath}/resources/css/fanart-main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${contextPath}/resources/css/fanart-detail.css">
<title>팬아트 게시판</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	

	<main>

		<section class="fanArt-text">팬아트</section>

		<section id="fanartTitle2">
			<div>
				<div class="fanartTitle-view">
					${board.boardTitle}
					<div id="viewCount">
						<i class="fa-solid fa-eye fa-xl"></i>${board.readCount }
					</div>
				</div>
				<div id="fanartDate2">게시일 : ${board.createDate }</div>
				<div id="fanart-memberNick">작성자 : ${board.memberNickname}</div>
			</div>

			<div id="fanart2">
				<c:forEach var="photo" items="${board.photos}">
					<img src="${contextPath}/resources/images/fanArt-images/${photo.contentPath}">
				</c:forEach>
				<div>
					<textarea id="fanartWriteExplain" cols="80" rows="12">${board.boardContent}</textarea>
				</div>
			</div>
		</section>

		<section class="fanart-heartClick">
			<div>좋아요</div>
			<i id="fanart-heartClick" class="fa-regular fa-heart fa-2xl"></i>
			<!-- 조회수 영역 -->
			<div id="like-count">${board.readCount }</div>

			
		</section>

		<c:if test="${loginMember.memberNo == board.memberNo}">

			<div class="update-delete">
				<button id="fanartUpdateBtn" onclick="location.href='write?mode=update&boardNo=${param.boardNo}&boardCode=${param.boardCode}'">수정</button>
				<button id="fanartDeleteBtn">삭제</button>
			</div>

		</c:if>
		


		<section id="fanartList-header">
			<div>팬아트 게시판 작성글</div>
			<div>
				<i class="fa-solid fa-plus"></i><a href="#"> 목록가기</a>
			</div>
		</section>

		<section id="fanartList">
			<div class="fanartList-first">
				<div>
					게시글 제목 : <span class="fanartList-title">귀멸의 칼날 - 렌코쿠</span>
				</div>
				<div class="fanartListInfo">
					<div>
						<img src="${contextPath}/resources/images/profileImg.png">
					</div>
					<div>
						<span>user01*** </span> <i class="fa-solid fa-eye fa-sm"></i> <span>23</span>
						<span> | 2023.07.01 | 16:23</span>
					</div>

				</div>
			</div>

			<div class="fanartList-first">
				<div>
					게시글 제목 : <span class="fanartList-title">체인소맨 - 덴지</span>
				</div>
				<div class="fanartListInfo">
					<div>
						<img src="${contextPath}/resources/images/profileImg.png">
					</div>
					<div>
						<span>user11**** </span> <i class="fa-solid fa-eye fa-sm"></i> <span>43</span>
						<span> | 2023.07.02 | 12:10</span>
					</div>

				</div>
			</div>

			<div class="fanartList-first">
				<div>
					게시글 제목 : <span class="fanartList-title">이누야사 - 이누야사</span>
				</div>
				<div class="fanartListInfo">
					<div>
						<img src="${contextPath}/resources/images/profileImg.png">
					</div>
					<div>
						<span>user33*** </span> <i class="fa-solid fa-eye fa-sm"></i> <span>100</span>
						<span> | 2023.01.01 | 10:10</span>
					</div>

				</div>
			</div>

		</section>

	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/fanart.js"></script>

	<script>
		const boardNo = "${board.boardNo}";

	</script>
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/fanart-detail.js"></script>
	<script src="${contextPath}/resources/js/footer.js"></script>

</body>
</html>