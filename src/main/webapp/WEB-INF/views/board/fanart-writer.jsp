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
<link rel="stylesheet" href="${contextPath}/resources/css/fanart-write.css">
<title>팬아트 게시판 - 작성하기</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

	<main>

		<section class="fanArt-text">팬아트</section>
		
		<form action="write" enctype="multipart/form-data" method="post" onsubmit="return insertValidate()">

			<c:set var="img1" value="/after5duck/resources/images/fanArt-images/${boardDetail.photos[0].contentPath}" />

			<section id="fanartTitle">
				<input type="text" id="fanartWriteTitle" placeholder="제목을 작성해주세요." value="${boardDetail.boardTitle}" name="boardTitle">
				
				<article id="fanart">
					<div>
						<label for="img1">👇 이미지 첨부</label>
							<img class="preview" src="${img1}">
						
						<input class="inputImage" type="file" id="img1" name="1" accept="image/*"></input>
						
					</div>
					<div>
						<div class="writeContent">💗 내용 작성</div>

						<textarea id="fanart-plus-write" name="boardContent">${boardDetail.boardContent}</textarea>

					</div>
	
				</article>
	
			</section>


			<input type="hidden" name="boardCode" value="${param.boardCode}">
			<input type="hidden" name="boardNo" value="${param.boardNo}">
			<input type="hidden" name="mode" value="${param.mode}">
			<input type="hidden" name="deleteList" id="deleteList" value="">
	
			<!-- 팬아트 작성란 -->
			<div id="fanart-write">
				<!-- <div id="addFanart">
					<input type="file"></input>
				</div> -->
				<button type="submit" id="fanartWriteBtn">등록</button>
			</div>

		</form>


		<!-- 팬아트 게시판 작성글 몇개 리스트 -->
		<section id="fanartList-header">
			<div>팬아트 게시판 작성글</div>
			<div>
				<i class="fa-solid fa-plus"></i><button id="fanartGoToBtn">이전으로</button>
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


	<script src="${contextPath}/resources/js/fanart-write.js"></script>

</body>
</html>