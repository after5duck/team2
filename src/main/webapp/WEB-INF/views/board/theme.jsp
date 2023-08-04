<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>theme</title>

<link rel="stylesheet" href="${contextPath}/resources/css/theme.css">

<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

/* 글꼴을 적용할 요소 선택자에 대한 스타일 지정 */
body {
	font-family: 'Pretendard-Regular';
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

	<main>
		<div class="main_container">


			<div class="main_first">테마추천</div>

			<div class="main_second">
				<c:forEach var="themeList" items="${list}">

					<div class="second">
						<a href="theme_detail?boardNo=${themeList.boardNo}&boardCode=${themeList.boardCode}" class="a_tag_theme">

							<div>
								<img name="theme_image"
									src="${contextPath}/resources/images/${themeList.contentPath}">
							</div>
							<div class="content">${themeList.boardTitle}</div>
							<div class="content">${themeList.boardContent}</div>

						</a>
					</div>

				</c:forEach>
			</div>


		</div>
	</main>


	<!-- 공용 풋터 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="../resources/js/footer.js"></script>


	<script>
        document.getElementById("footbtn").addEventListener("click", function(){
            const show = document.getElementById("text_box");
            show.style.display = "block";
        })
    </script>

</body>
</html>