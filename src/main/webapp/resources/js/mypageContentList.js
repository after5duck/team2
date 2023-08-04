// 검색어로 게시글 조회
function selectContent(){

    const inputSearch = document.getElementById("inputSearch");
    $.ajax({

        url : "member/mypage/contentList",
        success : function(bList){

            for( let b of bList){
                console.log(b);
            }

        },
        error : function(request, status, error){
            console.log("AJAX 에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }

    });
}

(()=>{
    selectContent();

    window.setInterval(selectContent, 10000); // 10초
})()

