// 검색어로 게시글 조회
document.getElementById("btn-submit").addEventListener("click", function(){

    const inputSearch = document.getElementById("inputSearch");
    const contentList = document.getElementById("contentList");

    $.ajax({

        url : "member/mypage/contentList",
                /* 게시글 내용, 제목으로 검색하는데 내가 쓴 게시글이어야 해서 세가지 가져옴 */
        data : {"boardContent" : inputSearch.value, "boardTitle" : inputSearch.value, "memberNo" : memberNo},
        type : "POST",
        dataType : "JSON",

        success : function(){

        },

        error : function(request, status, error){
            console.log("AJAX 에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }

    });

});
