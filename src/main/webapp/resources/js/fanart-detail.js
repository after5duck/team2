

/* 조회수 증가 */
function updateViewCount() {

    $.ajax({

        url: contextPath + "/board/fanart/detail/updateViewCount", 

        data: { "boardNo" : boardNo1},

        type: "get",
    
        success: function (data) {

            document.getElementById("viewCount").innerText = data;
        },

        error: function () {

            console.log("조회수 업데이트에 실패했습니다ㅜㅜㅜㅜㅜㅜ");
        },
    });
}
(function(){

    updateViewCount();

})(); 





if(loginMemberNo != null){

    const heartIcon = document.getElementById('fanart-heartClick');
    heartIcon.addEventListener('click', function() {

        if (heartIcon.classList.contains('fa-regular')) {
            heartIcon.classList.remove('fa-regular');
            heartIcon.classList.add('fa-solid');
        } else {
            heartIcon.classList.remove('fa-solid');
            heartIcon.classList.add('fa-regular');
        }

    });


    /* 좋아요 수 증가 */
    const fanartHeartClick = document.getElementById("fanart-heartClick");

    fanartHeartClick.addEventListener("click", function(){

        $.ajax({

            url : contextPath + "/board/fanart/detail/likeCount",
            
            type : "get",

            data : {"boardNo" : boardNo1,
                        "memberNo" : memberNo1},


            success : function(data){
                document.getElementById("like-count").innerText = data;

            },
            error : function(req, status, error){

                console.log("좋아요 등록 실패");
                console.log(req.responseText);

            }
        });
    })
}


function is_checked() {

    const checkbox = document.getElementById("likeCount");
    const isChecked = checkbox.checked;

    if(isChecked){

        alert("좋아요 체크됨");



    }


}