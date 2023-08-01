(function(){

    const fanartDeleteBtn = document.getElementById("fanartDeleteBtn");

    if(fanartDeleteBtn != null){

        fanartDeleteBtn.addEventListener("click", function(){

            let url = "fanart/delete";

            const params = new URL(location.href).searchParams;

            const boardNo = "?boardNo=" + params.get("boardNo");

            const boardCode = "&boardCode=" + params.get("boardCode");

            url += boardNo + boardCode;

            if(confirm("정말로 삭제하시겠습니까??")){
                location.href = url;

            }

        });

    }

})();