// 검색어로 게시글 조회
function selectContent(){

    const inputSearch = document.getElementById("inputSearch");
    $.ajax({

        url : "member/mypage/contentList",
        type : "post",
        success : function(bList){

            for( let b of bList){
                console.log(b);
            }

        },
        error : function(request, status, error){
            console.log("AJAX 에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }

    });
}

(()=>{
    selectContent();
})()


const inputSearch = document.getElementById("inputSearch");
const contentList = document.getElementById("contentList");

function searchValidate(){
    if(inputSearch.ariaValueMax.trim().length == 0){
        alert("검색어를 입력해주세요");
        return false;
    }
    return true;
}

// 검색어로 내가 쓴 글 조회하기
function searchArea(){

    $.ajax({

        url : contextPath + "member/search/searchArea",
        data : {"inputSearch" : inputSearch},
        type : "post",
        dataType : "JSON",
        success : function(sList){
            contentList.innerHTML = "";

            for(let i of sList){
                const writeContent = document.createElement("nav");
                writeContent.classList.add("writeContent");

                cosnt

            }


        },
        error : function(){

        }
    })
}