<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- 공용 헤더 -->
        <header>
            <div class="header_container">
                <div class="main_logo_img_container">
                    <!-- 애니버스 로고 -->
                    <a href="${contextPath}">
                        <img src="${contextPath }/resources/images/PJ2logo.png" alt="" class="main_logo">
                    </a>
                </div>
                <!-- 메뉴 리스트 테마추천, 팬아트 등 -->
                <div class="menu_list">
                    <div class="menu_text_con"><a href="#" class="a_tag">테마추천</a></div>
                    <div class="menu_text_con"><a href="board/fanart" class="a_tag">팬아트</a></div>
                    <div class="menu_text_con"><a href="#" class="a_tag">굿즈</a></div>
                    <div class="menu_text_con"><a href="board/Review" class="a_tag">리뷰</a>

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