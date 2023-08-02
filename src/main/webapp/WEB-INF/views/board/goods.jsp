<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>goods</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/goods.css">
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
            <div class="main_first">
                <div>굿즈</div>
                <div id="goods_kind">
                    <div>전체</div>
                    <div>진격의 거인</div>
                    <div>귀멸의 칼날</div>
                    <div>체인소맨</div>
                    <div>에반게리온</div>
                    <div>도쿄 리벤저스</div>
                    <div>나루토</div>
                    <div>강철의 연금술사</div>
                    <div>하이큐</div>
                    <div>원피스</div>
                </div>
            </div>
            <div class="main_second">좋아하는 작품의 굿즈들을 구경해보세요~!</div>

            <div class="main_third">
                <c:forEach var="goodsList" items="${goods}">
                    
                    <div class="goods">
                        <img id="goods_image" src="${contextPath}${goodsList.contentPath}">
                        <i name="icon" class="fa-regular fa-heart"></i></img>
                        <div class="goods_name">${goodsList.boardTitle}</div>
                    </div>
                    
                    
                </c:forEach>
            </div>
                    <!-- <div>
                        <div id="goods_image2"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                        <div class="goods_name">체인소맨 아키</div>
                    </div>
                    <div>
                        <div id="goods_image3"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                        <div class="goods_name">나루토 사스케</div>
                    </div>
                    <div>
                        <div id="goods_image4"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                        <div class="goods_name">귀멸의 칼날 렌코쿠</div>
                    </div> -->

                
           
            <!-- <div class="main_fourth">
                <div>
                    <div id="goods_image5"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">강철의 연금술사 로이 머스탱</div>
                </div>
                <div>
                    <div id="goods_image6"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">원피스 흰수염</div>
                </div>
                <div>
                    <div id="goods_image7"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">에반게리온 초호기</div>
                </div>
                <div>
                    <div id="goods_image8"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">주술회전 고죠 사토루</div>
                </div>
            </div>
            <div class="main_fifth">
                <div>
                    <div id="goods_image9"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">도쿄 리벤져스 마이키</div>
                </div>
                <div>
                    <div id="goods_image10"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">하이큐 카게야마</div>
                </div>
                <div>
                    <div id="goods_image11"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">귀멸의칼날 탄지로</div>
                </div>
                <div>
                    <div id="goods_image12"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">진격의 거인 리바이</div>
                </div>
            </div>
            <div class="main_sixth">
                <div>
                    <div id="goods_image13"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">나루토 카카시</div>
                </div>
                <div>
                    <div id="goods_image14"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">강철의 연금술사 엘릭형제</div>
                </div>
                <div>
                    <div id="goods_image15"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">도쿄 리벤저스 드라켄</div>
                </div>
                <div>
                    <div id="goods_image16"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">원피스 조로</div>
                </div>
            </div>
            <div class="main_seventh">
                <div>
                    <div id="goods_image17"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">체인소맨 덴지</div>
                </div>
                <div>
                    <div id="goods_image18"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">원피스 에이스</div>
                </div>
                <div>
                    <div id="goods_image19"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">나루토</div>
                </div>
                <div>
                    <div id="goods_image20"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">체인소맨 마키마</div>
                </div>
            </div>
            <div class="main_eighth">
                <div>
                    <div id="goods_image21"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">에반게리온 2호기</div>
                </div>
                <div>
                    <div id="goods_image22"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">하이큐 히나타</div>
                </div>
                <div>
                    <div id="goods_image23"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">귀멸의칼날 기유</div>
                </div>
                <div>
                    <div id="goods_image24"><i name="icon" class="fa-regular fa-heart"></i></button></div>
                    <div class="goods_name">진격의거인 갑옷거인</div>
                </div>
            </div> -->

        </div>
       
    </main>


    <!-- 공용 풋터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
        document.getElementById("btn").addEventListener("click", function(){
            const show = document.getElementById("text_box");
            show.style.display = "block";
        })

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