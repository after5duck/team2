<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>리뷰작성</title>

            <link rel="stylesheet" href="${contextPath}/resources/css/review_write.css">
            <script src="https://kit.fontawesome.com/de9012b52d.js" crossorigin="anonymous"></script>

            <style>
                @font-face {
                    font-family: 'Pretendard-Regular';
                    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
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
                    <form action="/after5duck/board/review_write" method="post" onsubmit="return reviewValidate()">

                        <fieldset>
                            <legend>
                                <h1>리뷰작성</h1>
                            </legend>

                            <div class="test">
                                <div class="main_second">
                                    <div><i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i></div>
                                    <div>애니 제목</div>
                                    <div class="inputTitle">
                                        <input id="reviewTitle" name="boardTitle" type="text" placeholder="제목을 입력해 주세요."
                                            value="${reviewWrite.boardTitle}">
                                    </div>
                                </div>
                                <div class="main_third">
                                    <div><i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i></div>

                                    <div>별점</div>

                                    <!-- <form action="/board/review_write" class="mb-3" name="myform" id="myform" method="post"> -->
                                    <div id="stars">
                                        <input type="radio" name="reviewStar" value="1" id="rate1"><label
                                            for="rate1">★</label>
                                        <input type="radio" name="reviewStar" value="2" id="rate2"><label
                                            for="rate2">★</label>
                                        <input type="radio" name="reviewStar" value="3" id="rate3"><label
                                            for="rate3">★</label>
                                        <input type="radio" name="reviewStar" value="4" id="rate4"><label
                                            for="rate4">★</label>
                                        <input type="radio" name="reviewStar" value="5" id="rate5"><label
                                            for="rate5">★</label>

                                    </div>


                                    <!-- </form> -->
                                </div>

                                <p class="clickStar">별점을 클릭해주세요</p>

                                <div class="main_fourth">
                                    <div>
                                        <div class="insertContent">
                                            <div class="left-content">
                                                <i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i>
                                                <div>작성란</div>
                                            </div>

                                        </div>

                                        <div class="main_fifth">
                                            <textarea id="review_content" name="boardContent"
                                                placeholder="내용을 입력해 주세요">${reviewWrite.boardContent}</textarea>

                                        </div>
                                        <br>
                                        <div class="main_sixth">

                                            <div><input type="checkbox" id="review_all"> 전체 동의하기</div> <br>
                                            <div><input type="checkbox" name="review_agree" id="essential"> 작성된 리뷰는 애니버스
                                                홍보
                                                콘텐츠로
                                                사용될 수 있습니다.(필수) </div><br>
                                            <div><input type="checkbox" name="review_agree" id="check"> 보다 나은 리뷰 서비스 제공을
                                                위해 개인 정보
                                                수집∙이용에
                                                동의합니다.(선택)</div>
                                        </div>
                                        <div class="main_last"><button id="btn_review">등 록</button></div>
                                    </div>
                                </div>
                        </fieldset>



                        <!-- 숨겨진 값(hidden) -->
                        <!-- 동작 구분 -->
                        <input type="hidden" name="mode" value="${param.mode}">

                        <!-- 게시판 구분 -->
                        <input type="hidden" name="type" value="${param.type}">

                        <!-- 게시글 번호 -->
                        <input type="hidden" name="boardNo" value="${param.boardNo}">

                        <!-- 현재 페이지 -->
                        <input type="hidden" name="cp" value="${param.cp}">
                </div>
                </form>
                </div>

            </main>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/review_write.js"></script>



        </body>

        </html>