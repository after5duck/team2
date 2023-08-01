const heartIcon = document.getElementById('fanart-heartClick');
heartIcon.addEventListener('click', function() {

    if (heartIcon.classList.contains('fa-regular')) {
        heartIcon.classList.remove('fa-regular');
        heartIcon.classList.add('fa-solid');
    } else {
        heartIcon.classList.remove('fa-solid');
        heartIcon.classList.add('fa-regular');
    }

/*     $.ajax({

        url : "member/like",

        data : {"memberNo" : memberNo},

        type : "get",

        success : function(){



        },

        error : function(){

        }
    }); */

});

/* 조회수 증가 */
function updateViewCount() {

    $.ajax({
        url: "updateViewCount", 

        type: "get",
      
        data: { "boardNo" : boardNo},
        
        success: function (result) {

            if(result > 0){

                location.reload();

                document.getElementById("viewCount").innerText = result.updatedViewCount;

            }


      },

      error: function () {

        console.log("조회수 업데이트에 실패했습니다..");
      },
    });
}
(function(){

    updateViewCount();

})(); 






