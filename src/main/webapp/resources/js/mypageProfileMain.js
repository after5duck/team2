/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});

const searchImage = document.getElementById("search-image");

if( searchImage != null){

    searchImage.addEventListener("change", function(){
        
        if(this.files[0] != undefined){ // 파일이 선택되었을 때
            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // - 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]);
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료되면 result 속성 data:에
            //   읽어온 파일의 위치를 나타내는 URL이 포함된다.
            // -> 해당 URL을 이용해서 브라우저에 이미지를 볼 수 있다.

            // FileReader.onload = function(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행
            reader.onload = function(e){ // 고전 이벤트 모델
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const bodyProfileImg = document.getElementById("bodyProfileImg");

                bodyProfileImg.setAttribute("src",e.target.result);
                // -> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기

                document.getElementById("delete").value = 0;
            }
        }
    })
}

function profileValidate(){
    const searchImage = document.getElementById("searchImage");
    const del = document.getElementById("delete");

    if(searchImage.value == "" && del.value == 0){
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요")
        return false;
    }
    return true;
}

document.getElementById("delete-image").addEventListener("click", function(){

    const del = document.getElementById("delete");

    if(del.value == 0){
        document.getElementById("bodyProfileImg").setAttribute("src", contextPath + "/resources/images/user.png");
    
        document.getElementById("search-image").value = "";
    
        del.value = 1;
    }


})