<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ page import="edu.kh.teamPJ.board.model.vo.DayDTO" %>
			<%@ page import="edu.kh.teamPJ.board.model.dao.DayDAO" %>
				<%@ page import="edu.kh.teamPJ.board.controller.DayController" %>
					<%@ page import="java.util.List" %>

						<!DOCTYPE html>
						<html lang="en">

						<head>
							<meta charset="UTF-8">
							<meta http-equiv="X-UA-Compatible" content="IE=edge">
							<meta name="viewport" content="width=device-width, initial-scale=1.0">
							<title>ANIVERSE</title>

							<!-- 메인 css -->
							<link rel="stylesheet" href="resources/css/MAIN.css">


							<!-- 부트스트랩 -->
							<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
								rel="stylesheet">
							<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
							<script
								src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

							<!-- 풋터 아이콘 -->
							<script src="https://kit.fontawesome.com/9c5650c683.js" crossorigin="anonymous"></script>


						</head>

						<body>

							<!-- 공용 헤더 -->
							<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />


							<!-- ********************************************************************************************************* -->

							<main>

								<a href="#" class="scroll-top-btn">Top</a>
								<!-- 스크롤 TOP -->

								<div class="carot">
									<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
										<div class="carousel-indicators">
											<button type="button" data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="0" class="active" aria-current="true"
												aria-label="Slide 1"></button>
											<button type="button" data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="1" aria-label="Slide 2"></button>
											<button type="button" data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="2" aria-label="Slide 3"></button>
										</div>

										<div class="carousel-inner">

											<c:forEach var="mainPhoto" items="${mainPhotoList}" varStatus="status">
												<div class="carousel-item ${status.count == 1 ? 'active' : ''}">

													<div class="con${status.count}"
														style="background-image: url('${contextPath}/resources/images/${mainPhoto.contentPath}')">

														<!-- 로고 텍스트 -->
														<div class="con${status.count}_text"
															style="background-image: url('${contextPath}/resources/images/${mainPhoto.boardContent}')">
															<!-- contentPath 대신 boardContent 사용 -->
														</div>
														<!-- <button class="bannar-btn i-btn">보러가기 ></button> -->
													</div>
												</div>
											</c:forEach>


										</div>
										<button class="carousel-control-prev" type="button"
											data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
											<span class="carousel-control-prev-icon" aria-hidden="true"></span>
											<span class="visually-hidden">Previous</span>
										</button>
										<button class="carousel-control-next" type="button"
											data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
											<span class="carousel-control-next-icon" aria-hidden="true"></span>
											<span class="visually-hidden">Next</span>
										</button>
									</div>
								</div>

								<!-- ********************************************************************************************************* -->

								<!-- 요일별 신작 -->

								<div class="date_container">
									<div class="day_con">
										<div class="day-move-con">
											<div id="day">요일별 신작</div>
											<a href="${contextPath}/board/newAnime" class="day-move">신작 애니 예고편 >보러가기</a>
										</div>

										<br>
										<div class="big_con" id="big">
											<div class="date-con2">
												<c:forEach var="dayDTO" items="${dayList}" varStatus="status">
													<div class="date-div">
														<c:choose>
															<c:when test="${status.index == 0}">
																<div class="date-div-text">월</div>
															</c:when>
															<c:when test="${status.index == 1}">
																<div class="date-div-text">화</div>
															</c:when>
															<c:when test="${status.index == 2}">
																<div class="date-div-text">수</div>
															</c:when>
															<c:when test="${status.index == 3}">
																<div class="date-div-text">목</div>
															</c:when>
															<c:when test="${status.index == 4}">
																<div class="date-div-text">금</div>
															</c:when>
														</c:choose>
														<div class="mini_con">
															<div id="photo">
																<img src="${contextPath}/resources/images/${dayDTO.contentPath}"
																	id="photo_${status.index + 1}">
															</div>
															<div class="photo_text" id="photo_text_${status.index + 1}">
																${dayDTO.boardTitle}</div>
														</div>
													</div>
												</c:forEach>
												<c:if test="${empty dayList}">
													<p>왜 데이터를 못 가져오니...</p>
													<img src="${contextPath}/resources/images/i.png">
												</c:if>
											</div>
										</div>
									</div>
								</div>


								<!-- 요일별 신작 끝 -->


								<!-- ********************************************************************************************************* -->

								<!-- 추천, 역대 컨테이너 시작 -->

								<div class="container1">
									<!-- 감싸는 큰 div -->


									<div></div>
									<div id="best">애니버스 인기애니</div>

									<div class="select_btn_con">
										<button type="button" class="select_btn">추천</button>
										<button type="button" class="select_btn">분기</button>
										<!-- 			<button type="button" class="select_btn">역대</button>
				<button type="button" class="select_btn">이번주</button> -->
									</div>

									<div class="container2">

										<!------------------------------------------------------------------------------------------------------------------------------------------------------------>

										<c:forEach var="list" items="${modalList}" varStatus="loop">
											<div class="list_container">

												<div>
													<div class="img_con">
														<img src="${contextPath}/resources/images/${list.modalPhotoList[0].contentPath}"
															id="best-2" class="img_size"
															onclick="openModal(${loop.index})">
													</div>

													<div class="text_con">
														<div class="rank">${loop.index+1}</div>
														<div class="title_con">
															<div class="title" id="title-2">${list.boardTitle}</div>
															<div class="category" id="category-2">${list.genre}</div>
														</div>
													</div>
												</div>

												<div id="myModal${loop.index+1}" class="modal">
													<div class="modal-content">
														<div class="close" onclick="closeModal(${loop.index+1})">&times;
														</div>
														<div class="modal-div">
															<div id="modal-left">
																<iframe width="650" height="330"
																	src="${list.modalPhotoList[0].videoPath}"
																	title="YouTube video player" frameborder="0"
																	allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
																	allowfullscreen></iframe>
																<div>
																	<div class="modal-right-text">스토리</div>
																	<div class="modal-right-innerText">${list.story}
																	</div>
																	<div class="modal-right-text">작화</div>
																	<div class="modal-right-innerText">${list.drawing}
																	</div>
																	<div class="modal-right-text">출시</div>
																	<div class="modal-right-innerText">
																		${list.releaseDate}</div>
																	<div class="modal-right-text">연령</div>
																	<div class="modal-right-innerText">${list.age}</div>
																</div>
															</div>
															<hr>
															<div id="modal-right">
																<div class="summary-title">> 줄거리</div>
																<div class="summary">${list.boardContent}</div>
															</div>
														</div>
													</div>
												</div>

											</div>
										</c:forEach>
										<!------------------------------------------------------------------------------------------------------------------------------------------------------------>

									</div>
									<!-- 모달 창 컨테이너 끝 -->



									<!-- 추천, 역대 컨테이너 끝  -->

									<!-- ********************************************************************************************************* -->

									<!-- 꼭 봐야할 애니 명장면 시작 -->


									<div class="video_container">
										<div class="video_text">
											<span id="video_sp">꼭! 봐야할 애니 명장면 & OST</span>
										</div>

										<div class="video_con">
											<div class="video_flex">
												<c:forEach var="video" items="${bestVideoList}">
													<div class="video_con2">
														<iframe width="580" height="330" src="${video.videoPath}"
															title="YouTube video player" frameborder="0"
															allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
															allowfullscreen></iframe>
														<p id="video_p">${video.boardTitle}</p>
													</div>
												</c:forEach>
											</div>
										</div>
									</div>


									<!-- 꼭 봐야할 애니 명장면 끝 -->

									<!-- ********************************************************************************************************* -->

									<!-- 팬아트 시작 -->

									<div class="container3">

										<div class="fanArt_text">
											<span id="fan_sp">인기 팬아트</span>
										</div>

										<div class="container4">

											<!-- 정연수 팬아트 사진 불러오기 ~~ -->
	
											<c:forEach var="fanart" items="${boardList }" begin="0" end="9">
												<c:set var="photos" value="${fanart.photos}" />
												<c:forEach var="photo" items="${photos}" varStatus="pStatus" begin="0"
													end="9">
													<a href="board/fanart/detail?boardNo=${fanart.boardNo}&boardCode=${fanart.boardCode}">
													<div class="list_container">
														<div class="img_con">
															<img src="${contextPath }/resources/images/fanArt-images/${photo.contentPath}"
																class="img_size" id="fanArt_img">
														</div>
														<div class="fanArt_text_con">
															<div class="title_2">${fanart.boardTitle }</div>
														</div>

													</div>
													</a>

												</c:forEach>
											</c:forEach>


										</div>

										<!-- 팬아트 첫번째 리스트 끝 -->

										<div class="container5">

										</div>
									</div>
								</div>

								<div id="myModalModal" class="modal">
									<div class="modal-content">
										<span class="close" onclick="closeModal()">&times;</span>
										<p>모달 내용을 여기에 입력하세요.</p>
									</div>
								</div>

								<!-- 감싸는 큰 div 닫는태그 -->
							</main>

							<!-- 풋터 시작 -->

							<jsp:include page="/WEB-INF/views/common/footer.jsp" />

							<c:if test="${ !empty sessionScope.message }">
								<script>
									alert("${message}");

								</script>

								<c:remove var="message" scope="session" />
							</c:if>

							<!-- 풋터 끝 -->
							<script src="resources/js/MainPage.js"></script>
							<script src="resources/js/footer.js"></script>
						</body>

						</html>