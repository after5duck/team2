// 검색 유효성 검사(검색어를 입력했는지 확인)
function searchValidate() {
    const searchQuery = document.getElementById("search-query");

    if (searchQuery.value.trim().length == 0) { // 미작성
        alert("검색어를 입력하세요");
        searchQuery.value = "";
        searchQuery.focus();
        return false;
    }
    return true;
}

(function () {
    const goToListBtn = document.getElementById("btn-list");

    if (goToListBtn != null) {
        goToListBtn.addEventListener("click", function () {

            const pathname = location.pathname;
            let url = pathname.substring(0, pathname.indexOf("/", 1));

            url += "/board/review?";

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");

            let cp;

            if (params.get("cp") != "") {
                cp = "cp=" + params.get("cp");
            } else {
                cp = "cp=1";
            }

            url += type + "&" + cp;

            if (params.get("key") != null) {
                const key = "&key" + params.get("key");
                const query = "&query" + params.get("query");

                url += key + query;
            }

            location.href = url;
        })
    }
})();


// // 검색 이전 기록 반영
// (()=>{
//     const select = document.getElementById("sortSelect");
//     const input = document.getElementById("search-query");

//     const option = document.querySelectorAll("#sortSelect");

//     if(select != null){

//         // 현재 주소 쿼리스트링 얻어오기
//         const params = new URL(location.href).searchParams;

//         const key = params.get("key");
//         const query = params.get("query");

//         input.value = query;

//         if(option.value == "작성일"){
//             option.selected = true;
//         }else if(option.value == "제목"){
//             option.selected = true;
//         }else{
//             option.selected = true;
//         }
//     }
// })();


// 검색 유효성 검사
function searchValidate() {
    const searchQuery = document.getElementById("search-query");

    if (searchQuery.value.trim().length == 0) {
        alert("검색어를 입력하세요");
        searchQuery.value = "";
        searchQuery.focus();
        return false;
    }
    return true;
}

// 조회수 정렬

