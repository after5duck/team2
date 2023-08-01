// 검색 유효성 검사(검색어를 입력했는지 확인)
function searchValidate(){
    const searchQuery = document.getElementById("search-query");

    if(searchQuery.value.trim().length == 0){ // 미작성
        alert("검색어를 입력하세요");
        searchQuery.value = "";
        searchQuery.focus();
        return false;
    }
    return true;
}