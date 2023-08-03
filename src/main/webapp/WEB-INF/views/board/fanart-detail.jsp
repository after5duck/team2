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

	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

	

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
			<div id="like-count"></div>

			
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
				<i class="fa-solid fa-plus"></i><button id="fanartGoToBtn">목록으로</button>
			</div>
		</section>

		<section id="fanartList">
			<c:forEach var="board" items="${boardList}" varStatus="boardStatus" begin="0"  end="3">
					<div class="fanartList-first">
					<!-- <c:out value="${board.boardTitle}" />
					<c:out value="${board.boardContent}" />
					<c:out value="${board.createDate}" />
					<c:out value="${board.memberNickname}" /> -->
					
					<c:set var="photos" value="${board.photos}" />
					<c:forEach var="photo" items="${photos}" varStatus="photoStatus" begin="0" end="3">
						<div>
							게시글 제목 : <span class="fanartList-title">${board.boardTitle}</span>

						</div>
						<div>
							<i class="fa-solid fa-eye fa-sm"></i> <span>${board.readCount}</span>

						</div>
							<div class="fanartListInfo">
								<div>
									<a href="detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}">
										<img src="${contextPath}/resources/images/fanArt-images/${photo.contentPath}" class="fanart-img">
									</a>
								</div>
								<div>
									<span>${board.memberNickname}</span>
									<span>${board.createDate}</span>
								</div>
			
							</div>
					</c:forEach>
				</div>
			</c:forEach>


		</section>

	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script>
		const boardNo1 = "${board.boardNo}";
		const memberNo1 = "${board.memberNo}";
		const contextPath = "${contextPath}";

	</script>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/fanart.js"></script>

	
	<script src="${contextPath}/resources/js/fanart-detail.js"></script>

</body>
</html>