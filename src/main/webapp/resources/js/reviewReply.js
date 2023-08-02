// 댓글 목록 조회
function selectReplyList(){
    $.ajax({

        url : context + "reply/selectReply",
        data : {"boardNo" : boardNo},
        type : "get",
        dataType : "JSON",
        sucess : function(){

        },
        error : function(){
            console.log("에러 발생")
        }




    })
}