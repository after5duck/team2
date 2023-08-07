

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


/* 좋아요 눌렀을때 상태 */
/* const heartIcon = document.getElementById('fanart-heartClick');
heartIcon.addEventListener('click', function() {

    if (heartIcon.classList.contains('fa-regular')) {
        heartIcon.classList.remove('fa-regular');
        heartIcon.classList.add('fa-solid');
    } else {
        heartIcon.classList.remove('fa-solid');
        heartIcon.classList.add('fa-regular');
    }

}); */
 

/* 좋아요 수 증가 */
const heartIcon = document.getElementById('fanart-heartClick');

heartIcon.addEventListener('click', function(){

    /* 좋아요 하지 않은 상태 */
    if(heartIcon.classList.contains('fa-regular')){

        alert("눌러따");

        $.ajax({

            url : contextPath + "/board/fanart/detail/likeCount",

            type : "get",

            data : {"boardNo" : boardNo1,
                    "memberNo" : loginMemberNo},

            success : function(data){

                heartIcon.classList.remove('fa-regular');
                heartIcon.classList.add('fa-solid');
                
                document.getElementById("like-count").innerText = data;


            },

            error : function(req, status, error){

                console.log("좋아요 등록 실패");
                console.log(req.responseText);
    
            }

        });

    }else{

        console.log("왜 안돼");

        alert("해제했당");

        $.ajax({

            url : contextPath + "/board/fanart/detail/likeCountDelete",

            type : "get",

            data : {"boardNo" : boardNo1,
                    "memberNo" : loginMemberNo},

            success : function(data){

                heartIcon.classList.remove('fa-solid');
                heartIcon.classList.add('fa-regular');
                
                document.getElementById("like-count").innerText = data;

            },

            error : function(req, status, error){

                console.log("좋아요 해제 실패");
                console.log(req.responseText);
            }

        });

    }
})


/* 이민주 test */
/* 좋아요 수 증가 + 하트 채워짐  */

/*const heartIcon = document.getElementById('fanart-heartClick');
heartIcon.addEventListener('click', function() {

    if (heartIcon.classList.contains('fa-regular')) {
        heartIcon.classList.remove('fa-regular');
        heartIcon.classList.add('fa-solid');
    } else {
        heartIcon.classList.remove('fa-solid');
        heartIcon.classList.add('fa-regular');
    }

});*/





/* test 끝 */






