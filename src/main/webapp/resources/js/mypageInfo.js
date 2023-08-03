/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});


const inputEmail = document.getElementById("inputEmail")
const delEmail_btn = document.getElementById("btn-delEmail");

delEmail_btn.addEventListener("click",()=>{
    if(confirm("이메일주소를 삭제하시겠습니까?")){
        inputEmail.value="";
    }
})

function changeProfile(){

    if(!confirm("변경하시겠습니까?")){
        return false;
    }

    return true;
}


/* 닉네임 중복 확인 */
const checkBtn =  document.getElementById("btn-check");
const nickInfo = document.getElementById("nickInfo");
const memberNick = $('#nickInfo').val();

/* 버튼이 클릭되었을 때 */
checkBtn.addEventListener("click", ()=>{

    console.log(memberNick);
    // DB에 업데이트는 어떻게 하지??
    $.ajax({
        url : contextPath + "/member/mypage/checkDupNick",
        data : {"memberNick" : memberNick,
                "memberNo" : memberNo},
        type : "post",

        success : function(res){ // 성공했을 때

         
            console.log(res + "중복확인");

            if(res != null){
                if(confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?")){
                }
            }else{
                alert("이미 사용중인 닉네임입니다.")
            }
        },
        error : function(){
            console.log("에러 발생");
        }

    })
    
});

const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

