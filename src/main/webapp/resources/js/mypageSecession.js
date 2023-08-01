/************** 회원 탈퇴 js  ****************/  

const inputSecession = document.getElementById("inputSecession");
const inputSecessionSpan = document.getElementById("inputSecessionSpan");

inputSecession.addEventListener("input",function(){
    if( this.value.trim().length < 6){
        inputSecessionSpan.innerText = "비밀번호 형식이 올바르지 않습니다.";
    }else{
        inputSecessionSpan.innerText = "";
    }

    if( this.value == ""){
        inputSecessionSpan.innerText = "";
    }
})


function secession(){

    if(inputSecession.value.trim().length == 0){
        return printAlert(inputSecession, "비밀번호를 입력해주세요");
    }
    if(inputSecession.value.trim().length < 6){
        return printAlert(inputSecession, "비밀번호 형식이 올바르지 않습니다.")
    }
    if(!confirm("정말 탈퇴하시겠습니까?")){
        inputSecession.value = "";
        return false;
    }

    return true;
}

// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el은 요소

    alert(message);
    el.value = "";
    el.focus();
    return false;
}
