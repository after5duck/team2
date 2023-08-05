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

</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

	<a href="#" class="scroll-top-btn">Top</a>

	<main>
		<div class="main_container">


			<div class="main_first"><h1>테마추천</h1></div>
			<hr>
			<div class="main_second">
				<c:forEach var="themeList" items="${list}">

					<div class="second">
						<a href="theme_detail?boardNo=${themeList.boardNo}&boardCode=${themeList.boardCode}" class="a_tag_theme">
							
							<div>
								<img name="theme_image" src="${contextPath}/resources/images/${themeList.contentPath}">
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

		/* 스크롤 함수 */
        document.addEventListener('DOMContentLoaded', function () {
            var scrollTopBtn = document.querySelector('.scroll-top-btn');

            window.addEventListener('scroll', function () {
                if (window.pageYOffset > 500) {
                    scrollTopBtn.classList.add('show');
                } else {
                    scrollTopBtn.classList.remove('show');
                }
            });

            scrollTopBtn.addEventListener('click', function (e) {
                e.preventDefault();
                window.scrollTo({
                    top: 0,
                    behavior: 'smooth'
                });
            });
        });
    </script>

</body>
</html>