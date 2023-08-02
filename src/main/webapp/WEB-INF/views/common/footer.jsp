<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ******************************** 풋터  ****** **************************-->

<head>
<!-- 풋터 아이콘 -->
<script src="https://kit.fontawesome.com/9c5650c683.js"
	crossorigin="anonymous"></script>

</head>
<footer>
	<div class="footer_first">
		<div>
			<img src="${contextPath}/resources/images/footer_logo.png">
		</div>
		<div>
			<h5>
				<button id="footer_btn">
					<strong>(주) 애니버스 사업자 정보</strong>
				</button>
			</h5>
			<div id="text_box">
				상호 : 주식회사 애니버스 / 대표 : 아이육<br> 주소 : 서울특별시 강남구 테헤란로 10길 9길<br>
				사업자등록번호 : 202-30-71018 이메일 : i6@aniverse.net / 대표전화 : 1588-1004
			</div>
		</div>

	</div>
	<div class="footer_second">
		<div class="footer_nav">
			<a href="#">회사소개</a> <a href="#">고객센터</a> <a href="#">공지사항</a> <a
				href="#">이용약관</a> <a href="#">청소년보호정책</a> <a href="#"><strong>개인정보
					처리방침</strong></a> <a href="#">저작권 표기</a>
		</div>
		<p>Copyright &copy; 2023.ANIVERSE.All right.reserved.</p>

	</div>
	<div class="footer_third">
		<i class="fa-brands fa-twitter fa-2xl"></i> <i
			class="fa-brands fa-instagram fa-2xl"></i> <i
			class="fa-brands fa-youtube fa-2xl"></i> <i
			class="fa-brands fa-facebook fa-2xl"></i>

	</div>
</footer>

<c:if test="${ !empty sessionScope.message }">
	<script>
			alert("${message}");
			
		</script>

	<c:remove var="message" scope="session" />
	<script src="resources/js/footer.js"></script>
</c:if>

