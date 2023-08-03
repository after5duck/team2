/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});


const inputEmail = document.getElementById("inputEmail")
const delEmail_btn = document.getElementById("btn-delEmail");

delEmail_btn.addEventListener("click",()=>{
    if(confirm("이메일주소를 삭제하시겠습니까?")){
        if(inputEmail.value.trim().length == 0){
            alert("이메일이 등록되어 있지 않습니다.")
        }else{
            inputEmail.value="";
        }
    }
})

function changeProfile(){

    if(!confirm("변경하시겠습니까?")){
        return false;
    }

    return true;
}

const checkBtn =  document.getElementById("btn-check");
const nickInfo = document.getElementById("nickInfo"); // 닉네임 input

const inputNickSpan = document.getElementById("inputNick");
const inputEmailSpan = document.getElementById("inputEmail");

nickInfo.addEventListener("input", function(){
   const regExp = /^[A-z0-9가-힣]{2,6}$/;

    if(!regExp.test(this.value)){
        inputNickSpan.innerText = "유효한 형식의 닉네임이 아닙니다.";
    }

})








/* 버튼이 클릭되었을 때 */
checkBtn.addEventListener("click", ()=>{

    console.log(nickInfo);
    // DB에 업데이트는 어떻게 하지??
    $.ajax({
        url : contextPath + "/member/mypage/checkDupNick",
        data : {"memberNick" : nickInfo.value,
                "memberEmail" : inputEmail.value,
                "memberNo" : memberNo},
        type : "post",

        success : function(res){ // 성공했을 때

         
            console.log(res + "중복확인");

            if(res != "null"){
                if(confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?")){
                }
            }else{
                alert("이미 사용중인 닉네임입니다.");
                nickInfo.value = "";
            }
        },
        error : function(){
            console.log("에러 발생");
        }

    })
    
});

function changeProfile(){
    
}
