
/* 좋아요 목록 조회 */
function selectLikeList(){

    $.ajax({
        url : contextPath + "/mypage/likeList",
        data : {"boardNo" : boardNo},
        type : "get",
        dataType : "JSON",
        success(res){

            const likeList = document.getElementById("likeList");
            

        },
        error(){
            console.log("에러 발생");
        }
    })

}
