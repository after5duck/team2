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
	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

	<!-- ********************************************************************************************************* -->


	<div class="big-con">

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
	</div>

	<div id="myModal${loop.index+1}" class="modal">
		<div class="modal-content">
			<div class="close" onclick="closeModal(${loop.index+1})">&times;
			</div>
			<div class="modal-div">
				<div id="modal-left">
					<iframe width="650" height="330"
						src="${newAnimeList.modalPhotoList[0].videoPath}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
					<div>
						<div class="modal-right-text">스토리</div>
						<div class="modal-right-innerText">${newAnimeList.story}</div>
						<div class="modal-right-text">작화</div>
						<div class="modal-right-innerText">${newAnimeList.drawing}</div>
						<div class="modal-right-text">출시</div>
						<div class="modal-right-innerText">${newAnimeList.releaseDate}</div>
						<div class="modal-right-text">연령</div>
						<div class="modal-right-innerText">${newAnimeList.age}</div>
					</div>
				</div>
				<hr>
				<div id="modal-right">
					<div class="summary-title">> 줄거리</div>
					<div class="summary">${newAnimeList.boardContent}</div>
				</div>
			</div>
		</div>
	</div>




	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="../resources/js/footer.js"></script>


</body>

</html>