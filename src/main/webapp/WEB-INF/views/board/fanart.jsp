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
<title>팬아트 게시판</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />
	
	<a href="#" class="scroll-top-btn">Top</a>
	
	



	<main>
		<section class="fanArt-text-orderlist">
			<div class="fanArt-text">
				<div>팬아트</div>
				<c:if test="${!empty loginMember}">
					<button id='fanart-write-btn' onclick="location.href='fanart/write?mode=insert&boardCode=${param.boardCode}'">
						글쓰기
					</button>
				</c:if>
			</div>

			<div>
				<select name="orderlist" id="orderlist">
					<option value="1">최신순</option>
					<option value="2">조회수순</option>
				</select>
			</div>
		</section>

		<!-- 팬아트 사진 가져오기~~!!! -->
		<c:set var="maxPhotos" value="18" />

		<section class="fanArt-img">
			<div class="fanart-grid">
				<c:forEach var="board" items="${boardList}">
					<c:set var="photos" value="${board.photos}" />
					<c:forEach var="photo" items="${photos}" varStatus="photoStatus">
						<a href="fanart/detail?boardNo=${board.boardNo}&boardCode=${board.boardCode}">
							<div class="grid-item">
								<img src="../resources/images/fanArt-images/${photo.contentPath}"
									class="fanart-img">
								<div>
									
									<span class="fanart-title">${board.boardTitle}</span>
									
								</div>
							</div>
						</a>
						<c:if test="${photoStatus.count % 3 == 0}">
							<div class="clear"></div>
						</c:if>
					</c:forEach>
				</c:forEach>
			</div>
		</section>


		<section class="fanart-page">
			<ul class="page-num">
				<li><a href="#">1</a></li>
			</ul>

		</section>

		<!-- 로그인한 회원만 보이게 하기 -->
		<!-- <c:if test="${!empty loginMember}">
	
			<div class="fanart-write">
				<button id='fanart-write-btn' onclick="location.href='fanart/write?mode=insert&boardCode=${param.boardCode}'">
					글쓰기
				</button>
			</div>
	
		</c:if> -->


	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script>
		const boardNo1 = "${board.boardNo}";
		const contextPath = "${contextPath}";

	</script>

	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

	<script src="${contextPath}/resources/js/fanart.js"></script>
	

</body>
</html>
