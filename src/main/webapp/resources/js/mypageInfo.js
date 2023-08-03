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



/* 중복확인 눌렀는지 확인 카운트 */
let count = 0;

/* 버튼이 클릭되었을 때 */
checkBtn.addEventListener("click", ()=>{
    
    $.ajax({
        url : contextPath + "/member/mypage/checkDupNick",
        data : {"memberNick" : nickInfo.value,
                "memberEmail" : inputEmail.value,
                "memberNo" : memberNo,
                },
        type : "post",

        success : function(res){ // 성공했을 때

            if(nickInfo.value.trim().length > 6 || nickInfo.value.trim().length < 2){
                alert("유효한 닉네임 형식이 아닙니다");
                nickInfo.value = loginMemberNick;
            }else{

                if(res != "null"){
                    if(confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?")){
                        count = 1;
                    }
                }else{
                    alert("이미 사용중인 닉네임입니다.");
                    nickInfo.value = loginMemberNick;
                }
            }

        },
        error : function(){
            console.log("에러 발생");
        }

    })
    
});

function changeProfile(){

    if(nickInfo.value == loginMemberNick){
        count = 1;
    }

    if(count == 0){
        alert("아이디 중복확인을 먼저 해주세요!");
        return false;
    }

    return true;
    
}
