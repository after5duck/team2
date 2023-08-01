/* 검색창 확장 */
$("#slide_header_btn").on('click',function(){
    $("#header_btn").toggleClass('open');
});
const inputPw = document.getElementById("inputPw");
const inputPwSpan = document.getElementById("inputPwSpan");

const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

const newPwSpan = document.getElementById("newPwSpan");
const newPwConfirmSpan = document.getElementById("newPwConfirmSpan");



newPw.addEventListener("input",function(){
    if(inputPw.value.trim().length < 6){
        alert("현재 비밀번호를 확인 후 진행해주세요");
        newPw.value = "";
        inputPw.focus();
    }
    /* 비밀번호 정규식 */
    const regExp = /^[0-9A-z]{6,20}$/;
    if(regExp.test(newPw.value)){
        newPwSpan.innerText = "올바른 비밀번호 형식입니다.";
        newPwSpan.classList.add("confirm");
        newPwSpan.classList.remove("error");
    }else{
        newPwSpan.innerText = "올바르지 않은 비밀번호 형식입니다.";
        newPwSpan.classList.add("error");
        newPwSpan.classList.remove("confirm");
    }
    if(newPw.value ==""){
        newPwSpan.innerText = "";
    }

})

newPw.addEventListener("focusin", ()=>{
    const caution = document.getElementById("caution");
    caution.innerText = "* 영어, 숫자, 특수문자(!,@,#,-,_) 8~20글자 사이로 작성해주세요."
})
newPw.addEventListener("focusout", ()=>{
    const caution = document.getElementById("caution");
    caution.innerText = "";
})


newPwConfirm.addEventListener("input", function(){
    if(newPw.value.trim().length == 0){
        alert("새 비밀번호를 먼저 입력해주세요");
        newPwConfirmSpan.value = "";
        newPw.focus();
    }

    if(newPw.value == newPwConfirm.value){
        newPwConfirmSpan.innerText = "비밀번호가 일치합니다."
        newPwConfirmSpan.classList.add("confirm");
        newPwConfirmSpan.classList.remove("error");
    }else{
        newPwConfirmSpan.innerText = "비밀번호가 일치하지 않습니다."
        newPwConfirmSpan.classList.add("error");
        newPwConfirmSpan.classList.remove("confirm");
    }

})


function changePassword() {

    if(newPw.value != newPwConfirm.value){
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    if(confirm("비밀번호를 변경하시겠습니까?")){
        return true;
    }else{
        newPw.value = "";
        newPwConfirm.value = "";
        return false;
        
    }
    
}