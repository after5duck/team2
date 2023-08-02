// 목록으로 가기 버튼
(function() {
	const fanartGoToBtn = document.getElementById("fanartGoToBtn");
	if (fanartGoToBtn != null) {

		fanartGoToBtn.addEventListener("click", function() {


			const pathname = location.pathname; 

			let url = pathname.substring(0, pathname.indexOf("/", 1));

			url += "/board/fanart?" 

			const params = new URL(location.href).searchParams;

			const boardCode = "boardCode=" + params.get("boardCode"); 

			url += boardCode;
			
			location.href = url;
		});
	}
})();



// 게시글 삭제하는 js
(function(){

    const fanartDeleteBtn = document.getElementById("fanartDeleteBtn");

    if(fanartDeleteBtn != null){

        fanartDeleteBtn.addEventListener("click", function(){

            let url = "delete";

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

