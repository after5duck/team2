/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});


const inputEmail = document.getElementById("inputEmail")
const checkBtn =  document.getElementById("btn-check");
const nickInfo = document.getElementById("nickInfo"); // 닉네임 input



/* 중복확인 눌렀는지 확인 카운트 */
let flagCount = false;

/* 버튼이 클릭되었을 때 */
checkBtn.addEventListener("click", ()=>{
    const regExp = /^([A-z]|[0-9]|[가-힣]){2,6}$/;

    if(!regExp.test(nickInfo.value)){
        Swal.fire({
            icon: 'error',                        
            text: "올바르지 않은 닉네임 형식입니다!",  
        });
    }else{


        $.ajax({
            url : contextPath + "/member/mypage/checkDupNick",
            data : {"memberNick" : nickInfo.value,
                    "memberEmail" : inputEmail.value,
                    "memberNo" : memberNo,
                    },
            type : "post",
    
            success : function(res){ // 성공했을 때
                if(res != "null"){  
                    Swal.fire({
                        title: '사용가능한 닉네임입니다. 사용하시겠습니까?',
                        text: "다시 되돌릴 수 없습니다. 신중하세요.",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#13ac74',
                        cancelButtonColor: '#ac1313',
                        confirmButtonText: '승인',
                        cancelButtonText: '취소'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            Swal.fire(
                                '닉네임이 변경되었습니다.'
                                )
                                flagCount = true;
                            }
                        })
                }else{
                    Swal.fire({
                        icon: 'error',                         // Alert 타입
                        text: "이미 사용중인 닉네임입니다!",  // Alert 내용
                    });
                    nickInfo.value = loginMemberNick;
                }
            
    
            },
            error : function(){
                console.log("에러 발생");
            }
    
        })
    }

    
});




/* 이메일 인증받기 */

let ranCode;
let flagCheckCount = false;

const btnCertify = document.getElementById("btn-cerEmail");

btnCertify.addEventListener("click", ()=>{
    $.ajax({

            url: contextPath + "/member/signUp/certificate",
            data : {"inputEmail" : inputEmail.value},
            type : "POST",
            success: function(res){

                if(res == 0){
                    Swal.fire({
                        icon: 'error',                         // Alert 타입
                        text: "이미 사용중인 이메일 입니다!",  // Alert 내용
                    });
                   
                }else{
                    Swal.fire({
                        icon: 'info',                         // Alert 타입
                        title: "이메일을 확인해주세요!",
                        text: "해당 이메일로 인증번호를 전송했습니다.",  // Alert 내용

                        
                    });
                    
                    flagCheckCount = true;
                    ranCode = res;
                   
                }
            },
            error : function(){
                console.log("에러 발생");   
            }
        })
})

const btnCheck = document.getElementById("btn-checkEmail");
const inputCheck = document.getElementById("inputCheck");

/* 보안코드 유효성 검사 */

inputCheck.addEventListener("keyup", function(){

    regExp2 = /^\d{1,6}$/;

    if((this.value.trim().length != 0) && (!regExp2.test(inputCheck.value))){
        Swal.fire({
            icon: 'error',                        
            text: "숫자를 입력해주세요",  
        });
        this.value = "";
    }
})

/* 인증 번호 버튼 검사 */

let flagCodeCheck = false;

btnCheck.addEventListener("click",()=>{
    if(inputCheck.value.trim().length == 0 ){
        Swal.fire({
            icon: 'warning',                         
            text: "인증번호를 입력해주세요", 
        });
    }else{

        if(flagCheckCount == false){
            Swal.fire({
                icon: 'error',                         // Alert 타입
                text: "이메일 중복확인을 먼저 해주세요!",  // Alert 내용
            });
        }else{
            $.ajax({
                url : contextPath + "/member/signUp/checkCode",
                data : {"inputCode" : inputCheck.value,
                        "ranCode" : ranCode},
                type : "post",
                success : function(res){
    
                    if(res > 0){
                        Swal.fire({
                            icon: 'success',                        
                            text: "인증이 완료되었습니다!",  
                        });
                        flagCodeCheck = true;
                    }else{
                        Swal.fire({
                            icon: 'error',                        
                            text: "인증번호가 일치하지 않습니다...",  
                        });
                        inputCheck.value = "";
                        inputCheck.focus();
                    }
                },
                error : function(){
                    console.log("에러 발생");
                }
            })
        }

    }
})

/* 제출버튼 */

let flagValidate = false;

function changeProfile(){
    const regExp = /^([A-z][0-9][가-힣]){2,6}$/;
 

    if(nickInfo.value == loginMemberNick){
        flagValidate = true;
    }

    /* 닉네임 유효성 검사 */
    if(nickInfo.value != loginMemberNick && flagCount == false){
        if(!regExp.test(nickInfo.value)){
            Swal.fire({
                icon: 'error',                        
                text: "올바르지 않은 닉네임 형식입니다!",  
            });
        }

        if(flagCount == false){
            Swal.fire({
                icon: 'error',                         
                text: "닉네임 중복검사를 해주세요!",  
            });
        }
    }

    /* 이메일 중복 검사 */
    if(inputEmail.value != loginMemberEmail && flagCheckCount == false){
        Swal.fire({
            icon: 'error',                         // Alert 타입
            text: "이메일 중복확인을 먼저 해주세요!",  // Alert 내용
        });
        flagValidate = false;
    }

    if(inputEmail.value == loginMemberEmail){
        flagValidate = true;
    }

    /* 이메일 인증 번호 버튼 검사 */
    
    if( inputEmail.value != loginMemberEmail != 0 && flagCodeCheck == false){
        
        Swal.fire({
            icon: 'error',                         // Alert 타입
            text: "이메일 인증을 진행해주세요",  // Alert 내용
        });
        flagValidate = false;
        return false;
    }

    if(nickInfo.value == loginMemberNick && inputEmail.value == loginMemberEmail && flagCount == false && flagCodeCheck == false ){
        Swal.fire({
            icon: 'warning',                         // Alert 타입
            text: "변경사항이 없습니다.",  // Alert 내용
        });
        flagValidate = false;
        return false;
    }

    if(flagValidate == true){
        return true;
    }else{
        return false;
    }
    
}

nickInfo.addEventListener("input", function(){
   /* 닉네임 유효성 검사 */

   if(this.value.trim().length > 6){
       Swal.fire({
           icon: 'error',                         // Alert 타입
           title: '닉네임 길이 제한',         // Alert 제목
           text: '닉네임은 2~6자리로 설정해주세요',  // Alert 내용
        });
    }
})

