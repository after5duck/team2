<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <main>
        <div class="main_container">
        
          
            <div class="main_first">테마추천</div>
            
            <div class="main_second">
                <c:forEach var="themeList" items="${list}">
                
                    <div class="second">
                        <a href="theme_detail" class="a_tag_theme">
                           
                            <div>
                                <img name="theme_image" src="${contextPath}/resources/images/${themeList.contentPath}">
                            </div>
                            <div class="content">${themeList.boardTitle}</div>
                            <div class="content">${themeList.boardContent}</div>
    
                        </a>
                    </div>
                    
                </c:forEach>
            </div>


            <!-- <div class="main_third">
                <div class="third">
                    <a href="html/theme_detail_4.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image4.png"></div>
                        <div>아련한 추억의 한켠, 디지몬</div>
                        <div>명실상부 최고의 추억 소환 애니메이션! 2000년대, 대한민국을 휩쓴 절대강자! 2020년에도 그 인기는 현재 진행중! 디지몬 시리즈의 역사가 담긴 작품들을 모았습니다.</div>
                    </a>
                </div>
                <div class="third">
                    <a href="html/theme_detail_5.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image5.png"></div>
                        <div>기동전사 건담 시리즈</div>
                        <div>"그대는 시대의 눈물을 본다" 로봇하면 바로 생각나는 그 작품 기동전사 건담 시리즈를 한 자리에 모았습니다.</div>
                    </a>
                </div>
                <div class="third">
                    <a href="html/theme_detail_6.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image6.png"></div>
                        <div>진격의 거인 시리즈</div>
                        <div>그 날, 인류는 떠올렸다. 놈들에게 지배당해 왔던 공포를${contextPath}. 새장 속에서 갇혀만 살았었던 굴욕을${contextPath}.</div>
                    </a>
                </div>
                
            </div>
            <div class="main_fourth">
                <div class="fourth">
                    <a href="html/theme_detail_7.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image7.png"></div>
                        <div>ost가 좋은 애니 추천</div>
                        <div>애니를 보는데 귀가 행복해진다${contextPath}.! 본격 OST가 명반인 애니메이션 추천!</div>
                    </a>
                </div>
                <div class="fourth">
                    <a href="html/theme_detail_8.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image8.png"></div>
                        <div>하이큐 애니 전체 시리즈 씹어먹기!</div>
                        <div>두 말 필요 없는 차세대 스포츠 만화의 패왕!</div>
                    </a>
                </div>
                <div class="fourth">
                    <a href="html/theme_detail_9.html" class="a_tag_theme">
                        <div><img name="theme_image" src="${contextPath}/resources/images/theme_image9.png"></div>
                        <div>짱구 극장판!</div>
                        <div>남녀노소 가리지않고 사랑받는 짱구의 극장판을 한 곳에 정리했습니다!</div>
                    </a>
                </div>
                
            </div> -->
          
        </div>
    </main>


    <!-- 공용 풋터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  

    <script>
        document.getElementById("footbtn").addEventListener("click", function(){
            const show = document.getElementById("text_box");
            show.style.display = "block";
        })
    </script>
    
</body>
</html>