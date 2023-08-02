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

/* 조회수 증가 */
function updateViewCount() {

    $.ajax({

        url: "updateViewCount", 

        data: { "boardNo" : boardNo1},

        type: "get",
    
        dataType : 'JSON',
        
        success: function (data) {

            document.getElementById("viewCount").textContent = data;

        },

        error: function () {

            console.log("조회수 업데이트에 실패했습니다ㅜㅜㅜㅜㅜㅜ");
        },
    });
}
(function(){

    updateViewCount();

})(); 


/* 좋아요 수 증가 */
const fanartHeartClick = document.getElementById("fanart-heartClick");

fanartHeartClick.addEventListener("click", function(){

    $.ajax({

        url : "likeCount",

        data : {"boardNo" : boardNo1,
                    "memberNo" : memberNo1},

        type : "get",


        success : function(data){

            lo

        },
        error : function(){
            console.log("좋아요 수 업데이트에 실패함");
        }

    });

})
