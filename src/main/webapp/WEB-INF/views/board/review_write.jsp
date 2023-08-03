<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>review_write</title>

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
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <main>
        <div class="main_container">
            <form action="review_write" method="POST" name="review_form" onsubmit="return reviewValidate()">
                <div class="main_first">리뷰작성</div>
                <div class="main_second">
                    <div><i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i> 애니 제목</div>
                    <div>
                        <input id="ani_name" type="text" placeholder="제목을 입력해 주세요.">
                    </div>
                </div>
                <div class="main_third">
                    <div><i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i> 별점을 주세요😉</div>
                    <div>
                        별이 다섯개
                    </div>
                </div>
                <div class="main_fourth"><i class="fa-solid fa-play" style="color:rgb(237, 21, 93)"></i>&nbsp;작성란</div>
                <div class="main_fifth"><textarea id="review_content" placeholder="내용을 입력해 주세요"></textarea></div>
                <br>
                <div class="main_sixth">
                    <div><input type="checkbox" id="review_all"> 전체 동의하기</div><br>
                    <div><input type="checkbox" name="review_agree" id="essential"> 작성된 리뷰는 애니버스 홍보 콘텐츠로 사용될 수 있습니다.(필수) </div><br>
                    <div><input type="checkbox" name="review_agree"> 보다 나은 리뷰 서비스 제공을 위해 개인 정보 수집∙이용에 동의합니다.(선택)</div>
                </div>
                <div class="main_last"><button id="btn_review">등 록</button></div>



                <!-- 숨겨진 값(hidden) -->
                <!-- 동작 구분 -->
                <input type="hidden" name="mode" value="${param.mode}">

                <!-- 게시판 구분 -->
                <input type="hidden" name="type" value="${param.type}">
                
                <!-- 게시글 번호 -->
                <input type="hidden" name="no" value="${param.no}">
                
                <!-- 현재 페이지 -->
                <input type="hidden" name="cp" value="${param.cp}">

                <!-- 존재하던 이미지가 제거되었음을 기록하여 전달하는 input -->
                <!-- value에 제거된 이미지의 레벨을 기록 -->
                <input type="hidden" name="deleteList" id="deleteList" value="">

            </form>
        </div>
       
    </main>



    <script>
        document.getElementById("btn").addEventListener("click", function(){
            const show = document.getElementById("text_box");
            show.style.display = "block";
        })

        // 전체 동의하기 체크박스 js 
        const review_all = document.getElementById("review_all");
        const review_agree = document.getElementsByName("review_agree");
        review_all.addEventListener("click",function(){

            for(let i = 0; i < review_agree.length; i ++){
                review_agree[i].checked = review_all.checked;
            }
        })
        this.addEventListener("click",function(e){
            for(let i = 0; i<review_agree.length; i ++){

                if(e.target == review_agree[i]){

                    // 취미가 전부 선택 안되어 있을 시 전체선택 체크박스 해제하기

                    if(!this.checked && review_all.checked){
                        //전체선택이 체크되어 있으면서 현재 클릭한 체크박스가 해제되는 경우
                        review_all.checked = false;

                    }

                    // 취미가 전부 선택이 되어 있을 시 전체선택 체크박스 체크하기
                    let flag = true;
                    for(let j = 0 ; j < review_agree.length; j ++){//전부 체크 됐는지 확인하기 위한 for문
                        if(!review_agree[j].checked){ //하나라도 체크가 안되어 있을 때
                            flag = false;

                        }
                    }
                    // 전체선택 체크박스가 체크되어 있지 않으면서
                    // 취미가 전부 선택이 되어있는 경우
                    if(!review_all.checked && flag){
                        review_all.checked = true;
                    }
                }
                
            }

        })
        function reviewValidate(){  
            const essential = document.getElementById("essential");

            if(essential.checked == false){

                alert("필수 항목을 체크 해주세요!");
                
                return false;
            }

            return true;
        }

        // 게시글 작성 유효성 검사
        function reviewValidate(){
            const aniName = document.getElementById("ani_name");
            const reviewContent = document.getElementById("review_content")

            if(aniName.value.trim().length == 0){
                alert("제목을 입력해주세요!");
                aniName.value = "";
                aniName.focus();
                return false;
            }
            if(reviewContent.value.trim().length == 0){
                alert("내용을 입력해주세요!");
                reviewContent.value = "";
                reviewContent.focus();
                return false;
            }



            return true;
        }

        (function(){
        const deleteBtn = document.getElementById("btn-delete"); // 존재하지 않으면 null

        if(deleteBtn != null){ // 버튼이 화면에 존재할 때
        deleteBtn.addEventListener("click",function(){

            let url = "delete"; 

        
            // 1) 쿼리스트링에 존재하는 파라미터 모두 얻어오기
            const params = new URL(location.href).searchParams;

            // 2) 원하는 파라미터만 얻어와 변수에 저장
            const no = "?no=" + params.get("no"); // ?no=1562

            const type = "&type=" + params.get("type"); // &type=1

            // url에 쿼리스트링 추가
            url += no + type; // delete?no=1562&type=1

            if(confirm("정말로 삭제 하시겠습니까?")){
                
                location.href = url;
            }
        });

            }
        })();

    </script>
    
</body>
</html>