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
        
        success: function (board) {

            document.getElementById("viewCount").innerText = board.readCount;;

        },

        error: function () {

            console.log("조회수 업데이트에 실패했습니다..");
        },
    });
}
(function(){

    updateViewCount();

})(); 
