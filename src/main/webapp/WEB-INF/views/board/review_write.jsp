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
                    <form action="/after5duck/board/review_write" enctype="multipart/form-data" method="post" onsubmit="return reviewValidate()">
                        <div class="main_first">리뷰작성</div>
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
                            <div>별점을 주세요😉</div>
                            <div>
                                별이 다섯개
                            </div>
                        </div>
                        <div class="main_fourth">
                            <div>
                                <div class="insertContent">
                                    <div class="left-content">
                                        <i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i>
                                        <div>작성란</div>
                                    </div>
                                    <div class="image-upload-wrap">
                                        <label for="img1" class="imgFile">이미지 첨부</label>
                                        <input class="inputImg" type="file" id="img1" name="1" accept="image/*"
                                            onchange="previewImage();"></input>
                                        <button id="deleteImage">이미지 삭제</button>
                                        <div class="image-box"> <!-- 이미지가 뜰 네모 박스 -->
                                            <img class="preview" id="preview_img" src="${img1}">
                                        </div>
                                    </div>
                                </div>

                                <div class="main_fifth">
                                    <textarea id="review_content" name="boardContent"
                                        placeholder="내용을 입력해 주세요">${reviewWrite.boardContent}</textarea>
                    
                                </div>
                                <br>
                                <div class="main_sixth">
                                    <div><input type="checkbox" id="review_all"> 전체 동의하기</div> <br>
                                    <div><input type="checkbox" name="review_agree" id="essential"> 작성된 리뷰는 애니버스 홍보 콘텐츠로
                                        사용될 수 있습니다.(필수) </div><br>
                                    <div><input type="checkbox" name="review_agree"> 보다 나은 리뷰 서비스 제공을 위해 개인 정보 수집∙이용에
                                        동의합니다.(선택)</div>
                                </div>
                                <div class="main_last"><button id="btn_review">등 록</button></div>



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

            <script src="${contextPath}/resources/js/review_write.js"></script>



        </body>

        </html>