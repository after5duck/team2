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

const inputSearch = document.getElementById("inputSearch");
const contentList = document.getElementById("contentList");

function searchValidate(){
    if(inputSearch.value.trim().length == 0){
        alert("검색어를 입력해주세요");
        inputSearch.focus();
        return false;
    }
    return true;
}

// 검색어로 내가 쓴 글 조회하기
function searchArea(){

    $.ajax({

        url : contextPath + "/member/searchList/searchArea",
        data : {"inputSearch" : inputSearch},
        type : "post",
        dataType : "JSON",
        success : function(sList){
            contentList.innerHTML = "";

            if(sList != null){

                for(let i of sList){
                    const writeContent = document.createElement("nav");
                    writeContent.classList.add("writeContent");
    
                    const writeArticle1 = document.createElement("article");
                    writeArticle1.classList.add("contentTitle");
                    writeArticle1.innerHTML = i.boardname;
    
                    const writeArticle2 = document.createElement("article");
                    writeArticle2.classList.add("contentDetail");
                    writeArticle2.innerHTML = i.boardTitle;
    
                    const writeArticle3 = document.createElement("article");
                    writeArticle3.classList.add("contentDate");
                    writeArticle3.innerHTML = i.createDate;
                    
                    writeContent.append(writeArticle1, writeArticle2, writeArticle3);
                }

                contentList.append(writeContent);

            }else{
                const writePtag = document.createElement("p")
                writePtag.innerText = "게시글이 없습니다."

            }

        },
        error : function(){
            console.log("에러발생");
        }
    })
}

// const dateStart = document.getElementsByClassName("dateStart")[0];
// const dateEnd = document.getElementsByClassName("dateEnd")[0];


// function listValidate(){

//     console.log(dateStart.value);
//     console.log(dateEnd.value);


//     if(dateStart.value == "" || dateEnd.value == ""){
//         alert("날짜를 설정해주세요");
//         return false;
//     }

//     if(dateStart.value > dateEnd.value){
//         alert("범위를 다시 설정해주세요");
//         return false;
//     }

//     return true;
// }

// function changeProfile(){

//     if(!confirm("변경하시겠습니까?")){
//         return false;
//     }

//     return true;
// }