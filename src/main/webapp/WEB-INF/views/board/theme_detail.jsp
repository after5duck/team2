<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>theme_detail</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/theme_detail_1.css">
    <script src="https://kit.fontawesome.com/de9012b52d.js" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.12.4.min.js" crossorigin="anonymous"></script>

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
            z-index:9
        }

            .video-popup .video-wrapper {
            position: relative;
            width: 80%;
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
    <header>
        <div class="header_container">
            <div class="main_logo_img_container">
                <!-- 애니버스 로고 -->
                <img src="${contextPath}/resources/images/PJ2logo.png" alt="" class="main_logo">
            </div>
            <!-- 메뉴 리스트 테마추천, 팬아트 등 -->
            <div class="menu_list">
                <div class="menu_text_con"><a href="#" class="a_tag" id="theme">테마추천</a></div>
                <div class="menu_text_con"><a href="#" class="a_tag">팬아트</a></div>
                <div class="menu_text_con"><a href="#" class="a_tag">굿즈</a></div>
                <div class="menu_text_con"><a href="#" class="a_tag">리뷰</a></div>
            </div>
            <!-- 검색창 -->
            <div class="search_prop_con">
                <input type="text" class="search_prop" placeholder="애니 이름을 검색하세요">
            </div>
            <!-- 유저 정보 -->
            <div class="user_con">
                <div class="user_img"></div>
                <div class="user_id">닉네임</div>
            </div>
        </div>
    </header>
    <main>
        <div class="main_container">

            <c:forEach var="detailList" items="${detail}">

                <div class="main_first">
                    <div>${detailList.boardTitle}</div>
                    <div>${detailList.boardContent}</div>

                </div>
                <div class="main_content">
                    
                        <div><img name="detail_image" src="${contextPath}${detailList.contentPath}"></div>
                        <div>
                            <div class="detail_header">
                                <div class="detail_title">${detailList.boardTitle}</div>
                                <div><button name="like_btn"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                            </div>
                            <div class="detail_genre">${detailList.age} | ${detailList.genre}</div>
                            <div class="detail_explain">
                                ${detailList.boardContent}
                                <!-- 예고편 유튜브 팝업 -->
                                <div class="popupVideo">
                                    <a data-video="aKcWy9yPEaE"><button class="custom-btn btn-15"><i class="fa-brands fa-youtube"></i> preview</button></a>
                                    <div class="video-popup">
                                        <div class="video-popup-closer"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </c:forEach>
            <!-- <div class="main_content">
                <div><img name="detail_image" src="${contextPath}/resources/images/theme_detail_image2.png"></div>
                <div>
                    <div class="detail_header">
                        <div class="detail_title">짱구는 못말려 더 비기닝</div>
                        <div><button name="like_btn"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    </div>
                    <div class="detail_genre">일상·개그 | TVA·12세·완결</div>
                    <div class="detail_explain">
                        어린이든 어른이든 눈물을 흘릴 수 있는
                        공감할 수 있는 부분이 있는 작품.<br>

                        재미와 감동 두 마리 토끼를 모두 잡은<br>
                        유쾌한 짱구의 일상에 다시 한 번 동참해보시겠어요?
                        <div class="popupVideo">
                            <a data-video="XHMdIA6bEOE"><button class="custom-btn btn-15"><i class="fa-brands fa-youtube"></i> preview</button></a>
                            <div class="video-popup">
                                <div class="video-popup-closer"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main_content"> 
                <div><img name="detail_image" src="${contextPath}/resources/images/theme_detail_image3.png"></div>
                <div>
                    <div class="detail_header">
                        <div class="detail_title">슈가슈가룬 part 1</div>
                        <div><button name="like_btn"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    </div>
                    <div class="detail_genre">판타지·액션 | TVA·12세·완결</div>
                    <div class="detail_explain">
                        슈가슈가 룬~ 쇼코쇼코 룬~
                        피에르 하트
                        <div class="popupVideo">
                            <a data-video="Z10UMD-0RbY"><button class="custom-btn btn-15"><i class="fa-brands fa-youtube"></i> preview</button></a>
                            <div class="video-popup">
                                <div class="video-popup-closer"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main_content">
                <div><img name="detail_image" src="${contextPath}/resources/images/theme_detail_image4.png"></div>
                <div>
                    <div class="detail_header">
                        <div class="detail_title">아기공룡 둘리 : 얼음별 대모험</div>
                        <div><button name="like_btn"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    </div>
                    <div class="detail_genre">판타지·개그 | 극장판·전체</div>
                    <div class="detail_explain">
                        아아, 이 서늘하고도<br>
                        묵직한 감각. 2년만이구만.<br>
                        기나긴 모멸과 핍박의 시간.<br>
                        지긋지긋하던 차였다.<br>
                        이제 '검성' 고길동으로 돌아갈 때다.
                        <div class="popupVideo">
                            <a data-video="z1fOHi3y60U"><button class="custom-btn btn-15"><i class="fa-brands fa-youtube"></i> preview</button></a>
                            <div class="video-popup">
                                <div class="video-popup-closer"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
        </div>
            
       
    </main>


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
           <div>
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
  


    <script>
       document.getElementById("footer_btn").addEventListener("click", function(){
            const show = document.getElementById("text_box");
            show.style.display = "block";
        })
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
    </script>
    
</body>
</html>