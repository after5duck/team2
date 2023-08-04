// 검색어로 게시글 조회
(()=>{
    const inputSearch = document.getElementById("inputSearch");
    $.ajax({

        url : "member/mypage/contentList",
        data : {"boardName" : boardName,
                "boardTitle" : inputSearch.value,
                "memberNo" : memberNo},
        type : "POST",
        dataType : "JSON",
        success : function(bList){

            console.log(bList);

        },
        error : function(request, status, error){
            console.log("AJAX 에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }

    });
})();

// document.getElementById("btn-submit").addEventListener("click", function(){

//     const contentList = document.getElementById("contentList");
    
    

// });



