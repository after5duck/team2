<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>theme_detail</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/theme_detail.css">
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
        /* 예고편 유튜브 팝업 */
        .video-popup.reveal {
            display: flex;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            justify-content: center;
            align-items: center;
            z-index: 9;

            display: flex;
            

        }

            .video-popup .video-wrapper {
            position: relative;
            width: 70%;
            padding-bottom: 45%;

            z-index: 10
        }

            .video-popup .video-wrapper iframe {
            position: absolute;
            width: 100%;
            height: 100%;
            border: none;
            border-radius: 30px;
        }

            .video-popup.reveal .video-popup-closer {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0,0,0,0.1);
            z-index: 9
        } 
    </style>
    
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/beforeHeader.jsp" />

    <a href="#" class="scroll-top-btn">Top</a>


    <main>
        <div class="main_container">
            

                <div class="main_first">
                    <div><img src="${contextPath}/resources/images/${sportsList[0].contentPath}"></div>
                    <div>${sportsList[0].boardTitle}</div>
                    <div>${sportsList[0].boardContent}</div>
    
                </div>
                    
            <c:forEach var="sportsList" items="${sportsList}" begin="1">
                <div class="main_content">
                            
                    <div><img name="detail_image" src="${contextPath}/resources/images/${sportsList.contentPath}"></div>
                    <div>
                        <div class="detail_header">
                            <div class="detail_title">${sportsList.boardTitle}</div>
                            <div><button name="like_btn"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                        </div>
                        <div class="detail_genre">${sportsList.age} | ${sportsList.genre}</div>
                        <div class="detail_explain">${sportsList.boardContent}
                            <!-- 예고편 유튜브 팝업 -->
                            <div class="popupVideo">
                                <a data-video="${sportsList.videoPath}"><button class="custom-btn btn-15"><i class="fa-brands fa-youtube"></i> preview</button></a>
                                <div class="video-popup">
                                    <div class="video-popup-closer"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            
        </div>
            
       
    </main>


    <!-- 공용 풋터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script>
       
        /* 예고편 유튜브 팝업 */
        $(".popupVideo a").click(function() {
            $(".video-popup").addClass("reveal"),
            $(".video-popup .video-wrapper").remove(),
            $(".video-popup").append("<div class='video-wrapper'><iframe width='560' height='315' src='https://youtube.com/embed/" + $(this).data("video") + "?rel=0&playsinline=1&autoplay=1' allow='autoplay; encrypted-media' allowfullscreen></iframe></div>")
        });
        $(".video-popup-closer").click(function() {
            $(".video-popup .video-wrapper").remove(),
            $(".video-popup").removeClass("reveal")
        });

        /* 좋아요 버튼 */
        const icon = document.getElementsByName('icon');

        for(let i = 0; i < icon.length ; i++){
        
            icon[i].addEventListener('click', function() {

                if (icon[i].classList.contains('fa-regular')) {
                    icon[i].classList.remove('fa-regular');
                    icon[i].classList.add('fa-solid');
                } else {
                    icon[i].classList.remove('fa-solid');
                    icon[i].classList.add('fa-regular');
                }
            });
        }

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