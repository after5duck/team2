const checkObj = {
    "memberId" :false,
    "memberPw" :false,
    "memberPwConfirm" :false,
    "memberNick" :false,
    "memberTel" : false,
};


/* 인풋들 */
const memberId = document.getElementById("memberId");
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const memberNick = document.getElementById("memberNick");
const memberTel = document.getElementById("memberTel");
const memberEmail = document.getElementById("memberEmail");

const email2 = document.getElementById("email2");
/* 메세지들 */
const idm = document.getElementById("idm");
const pwm = document.getElementById("pwm");
const nickm = document.getElementById("nickm");
const telm = document.getElementById("telm");
const emailm = document.getElementById("emailm");

/* 아이디 */
memberId.addEventListener("input", function(){

    if(memberId.value.trim().length == 0){
        idm.innerText = "영어/숫자 5~20글자 사이로 작성해주세요.";
        idm.classList.remove("confirm", "error");

        checkObj.memberId = false;
        return;
    }

    const regExp = /^[a-zA-Z0-9]{5,20}$/;

    if(regExp.test(memberId.value)){

        $.ajax({
            url : "idDupCheck",
            data :{ "memberId" : memberId.value},
            type : "GET",

            success : function(result){

                if(result == 1){
                    idm.innerText = "이미 사용중인 아이디 입니다.";
                    idm.classList.add("error");
                    idm.classList.remove("confirm");

                    checkObj.memberId = false;
                }else{
                    idm.innerText = "사용가능한 아이디 입니다.";
                    idm.classList.add("confirm");
                    idm.classList.remove("error");

                    checkObj.memberId = true;
                }
            },

            error : function(){
                console.log("에러 발생");
            }
        });
    }else{
        idm.innerText = "아이디 형식이 올바르지 않습니다.";
        idm.classList.add("error");
        idm.classList.remove("confirm");
        checkObj.memberId = false;
    }
});



/* 비밀번호 */

memberPw.addEventListener("input", function(){

    if(memberPw.value.trim().length == 0){
        pwm.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        pwm.classList.remove("confirm", "error");
        checkObj.memberPw = false;
        return;
    }

    const regExp = /^[\w!@#_-]{6,30}$/;

    if(regExp.test(memberPw.value)){

        checkObj.memberPw = true;

        if(memberPwConfirm.value.trim().length == 0){
            pwm.innerText = "유효한 비밀번호 형식입니다.";
            pwm.classList.add("confirm");
            pwm.classList.remove("error");

        }else{
            checkPw();
        }

    }else{
        pwm.innerText = "비밀번호 형식이 유효하지 않습니다.";
        pwm.classList.add("error");
        pwm.classList.remove("confirm");
        checkObj.memberPw = false;
    }

});

/* 비번 확인 */
memberPwConfirm.addEventListener("input", checkPw);
function checkPw(){

    if(memberPwConfirm.value == memberPw.value){
        pwm.innerText = "비밀번호가 일치합니다.";
        pwm.classList.add("confirm");
        pwm.classList.remove("error");
        checkObj.memberPwConfirm = true;

    }else{
        pwm.innerText = "비밀번호가 일치하지 않습니다.";
        pwm.classList.add("error");
        pwm.classList.remove("confirm");
        checkObj.memberPwConfirm = false;
    }
}



/* 닉네임 */
memberNick.addEventListener("input", function(){

    if(memberNick.value.trim().length == 0){
        nickm.innerText ="영어/숫자/한글 2~10글자 사이로 작성해주세요.";
        nickm.classList.remove("confirm", "error");
        checkObj.memberNick = false;
        return;
    }
    
    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;

    if(regExp.test(memberNick.value)){

        $.ajax({
            
            url : "nicknameDupCheck",
            data : {"memberNick" : memberNick.value},
            type : "GET",
            
            success : function(result){
                
                if(result == 0){
                    nickm.innerText = "사용 가능한 닉네임 입니다.";
                    nickm.classList.add("confirm");
                    nickm.classList.remove("error");
                    checkObj.memberNick = true;
                }else{
                    nickm.innerText = "이미 사용중인 닉네임 입니다.";
                    nickm.classList.add("error");
                    nickm.classList.remove("confirm");
                    checkObj.memberNick = false;
                }
            },
            
            error : function(){
                console.log("에러 발생");
            }
        });
        
    } else{
        nickm.innerText = "닉네임 형식이 유효하지 않습니다.";
        nickm.classList.add("error");
        nickm.classList.remove("confirm");
        checkObj.memberNick = false;
    }

});


/* 전화번호 */
memberTel.addEventListener("input", function(){
    if(memberTel.value.length == 0){
        telm.innerText ="전화번호를 입력해주세요.(-제외)";
        telm.classList("confirm", "error");

        checkObj.memberTel = false;
        return;

    }
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(regExp.test(memberTel.value)){
        telm.innerText = "유효한 전화번호 형식입니다.";
        telm.classList.add("confirm");
        telm.classList.remove("error");
        checkObj.memberTel = true;
    }else{
        telm.innerText = "전화번호 형식이 올바르지 않습니다.";
        telm.classList.add("error");
        telm.classList.remove("confirm");
        checkObj.memberTel = false;
    }
});


/* 이메일 */


/* memberEmail.addEventListener("input", function(){

    if(memberEmail.value.trim().length == 0){
        emailm.innerText = "이메일을 입력해주세요.";
        emailm.classList.remove("confirm", "error");

        checkObj.memberEmail = false;
        return;
    }

    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if(regExp == memberEmail.value){
        emailm.innerText="사용 가능한 이메일 입니다.";
        emailm.classList.add("confirm");
        emailm.classList.remove("error");
        checkObj.memberEmail = true;

    }else{
        emailm.innerText="이메일 형식이 올바르지 않습니다.";
        emailm.classList.add("error");
        emailm.classList.remove("confirm");
    }

}); */


/* 이메일 인증 */

let ranCode = 0;


const emailCertificateBtn = document.getElementById("emailBtn");

emailCertificateBtn.addEventListener("click", ()=>{
    if(memberEmail.value.trim().length == 0){
        alert("이메일을 입력해주세요");
    }else{
        $.ajax({

            url: contextPath + "/member/signUp/certificate",
            data : {"inputEmail" : memberEmail.value},
            type : "POST",
            success: function(res){

                if(res == 0){
                    alert("이미 사용중인 아이디 입니다.");
                   
                }else{
                    alert("해당 이메일로 인증번호를 전송했습니다.");
                    emailm.innerText = "인증번호 수신을 확인해주세요";
                    
                    ranCode = res;
                   
                }
            },
            error : function(){
                console.log("에러 발생");   
            }
        })
    }
})


/* 이메일 인증 확인 */

let count = 0;
const email2Btn = document.getElementById("email2Btn");

email2Btn.addEventListener("click", function(){


    if(email2.value.trim().length == 0 ){
        alert("인증번호를 입력해주세요");
    }else{

        if(ranCode == 0){
            alert("인증번호를 먼저 전송해주세요");
        }else{

            $.ajax({
                url : contextPath + "/member/signUp/checkCode",
                data : {"inputCode" : email2.value,
                        "ranCode" : ranCode},
                type : "post",
                success : function(res){
    
                    if(res > 0){
                        alert("인증이 완료되었습니다.");
                        count = 1;
                    }else{
                        alert("인증번호가 일치하지 않습니다.");
                        email2.value = "";
                        email2.focus();
                        count = 0;
                    }
                },
                error : function(){
                    console.log("에러 발생");
                }
            });
        }

    }
})


function signUpValidate(){

    let str;

    if(memberEmail.value.trim().length != 0){
        if(count == 0){
            alert("이메일 등록 시 이메일 인증을 진행해주세요.");
            return false;
        }
    }

    for( let key in checkObj){

        if(!checkObj[key]){

            switch(key){
                case "memberId" : str="아이디가"; break;
                case "memberPw" : str="비밀번호가"; break;
                case "memberPwConfirm" : str="비밀번호 확인이"; break;
                case "memberNick" : str="닉네임이"; break;
                case "memberTel" : str="전화번호가"; break;
            }

            str += "유효하지 않음.";

            alert(str);

            document.getElementById(key).focus();
            return false;

        }
    }
    return true;
}
