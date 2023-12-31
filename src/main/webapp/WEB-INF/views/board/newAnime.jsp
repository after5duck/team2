<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			<!-- 스크롤 함수 -->
			<a href="#" class="scroll-top-btn">Top</a>

			<div class="big-con">
				<div class="new-title">
					<h1>신작 애니메이션</h1>
				</div>
				<hr>
				<c:forEach var="newAnime" items="${newAnimeList}" varStatus="loop">
					<div class="big-item">
						<div class="image-container">
							<img src="${contextPath}/resources/images/${newAnime.contentPath}"
								onclick="openModal(${loop.index + 1})">
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

			<c:forEach var="newAnime" items="${newAnimeList}" varStatus="loop">
				<div id="myModal${loop.index+1}" class="modal">
					<div class="modal-content2">
						<div class="close" onclick="closeModal(${loop.index+1})">&times;</div>
						<div class="modal-div">
							<div id="modal-left">
								<iframe width="650" height="330" src="${newAnime.modals[0].videoPath}"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									allowfullscreen></iframe>
								<div>
									<div class="modal-right-text">스토리</div>
									<div class="modal-right-innerText">${newAnime.modals[0].story}</div>
									<div class="modal-right-text">작화</div>
									<div class="modal-right-innerText">${newAnime.modals[0].drawing}</div>
									<div class="modal-right-text">출시</div>
									<div class="modal-right-innerText">${newAnime.modals[0].releaseDate}</div>
									<div class="modal-right-text">연령</div>
									<div class="modal-right-innerText">${newAnime.modals[0].age}</div>
								</div>
							</div>

							<div id="modal-right">
								<div class="line"></div>
								<div class="summary-title">> 줄거리</div>
								<div class="summary">${newAnime.boardContent}</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

			<jsp:include page="/WEB-INF/views/common/footer.jsp" />
			<script src="../resources/js/footer.js"></script>
			<script src="../resources/js/newAnime.js"></script>

		</body>

		</html>