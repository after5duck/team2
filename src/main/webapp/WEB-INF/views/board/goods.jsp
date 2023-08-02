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
                        <img id="goods_image" src="${contextPath}/resources/images/${goodsList.contentPath}">
                        <i name="icon" class="fa-regular fa-heart"></i></img>
                        <div class="goods_name">${goodsList.boardTitle}</div>
                    </div>
                    
                    
                </c:forEach>
            </div>

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