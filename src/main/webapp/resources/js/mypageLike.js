function selectDate(){
    const dateStart = document.getElementsByName("dateStart")[0];
    const dateEnd = document.getElementsByName("dateEnd")[0];

    if(dateStart.value =="" || dateEnd.value==""){
        alert("날짜 정보를 입럭하세요.");
        return false;
    }

    if(dateStart.value > dateEnd.value){
        alert("날짜 형식이 올바르지 않습니다.");
        return false;
    }
    return true;
}

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
