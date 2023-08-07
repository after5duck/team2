/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});


const inputEmail = document.getElementById("inputEmail")
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

    if(nickInfo.value != loginMemberNick && count == 0){
        alert("아이디 중복확인을 먼저 해주세요!");
        return false;
    }

    if(inputEmail.value == loginMemberEmail){
        checkCount = 1;
    }

    if(inputEmail.value != loginMemberEmail && checkCount == 0){
        alert("먼저 이메일 인증을 진행해주세요");
        return false;
    }

    if( inputEmail.value != 0 && checkCount == 0){
        alert("먼저 이메일 인증을 진행해주세요");
        return false;
    }

    if(nickInfo.value == loginMemberNick && inputEmail.value == loginMemberEmail){
        alert("변경사항이 없습니다.");
        return false;
    }

    return true;
    
}

/* 이메일 인증받기 */

let ranCode;
let checkCount;

const btnCertify = document.getElementById("btn-cerEmail");

btnCertify.addEventListener("click", ()=>{
    $.ajax({

            url: contextPath + "/member/signUp/certificate",
            data : {"inputEmail" : inputEmail.value},
            type : "POST",
            success: function(res){

                if(res == 0){
                    alert("이미 사용중인 이메일 입니다.");
                   
                }else{
                    alert("해당 이메일로 인증번호를 전송했습니다.");
                    
                    ranCode = res;
                    console.log("ranCode = " + ranCode);
                   
                }
            },
            error : function(){
                console.log("에러 발생");   
            }
        })
})

const btnCheck = document.getElementById("btn-checkEmail");
const inputCheck = document.getElementById("inputCheck");


btnCheck.addEventListener("click",()=>{

    if(inputCheck.value.trim().length == 0 ){
        alert("인증번호를 입력해주세요");
    }else{

        $.ajax({
            url : contextPath + "/member/signUp/checkCode",
            data : {"inputCode" : inputCheck.value,
                    "ranCode" : ranCode},
            type : "post",
            success : function(res){

                if(res > 0){
                    alert("인증이 완료되었습니다.");
                    checkCount = 1;
                }else{
                    alert("인증번호가 일치하지 않습니다.");
                    inputCheck.value = "";
                    inputCheck.focus();
                    checkCount = 0;
                }
            },
            error : function(){
                console.log("에러 발생");
            }
        })
    }
})