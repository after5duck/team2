const inputId = document.getElementById("inputId");

const inputPw = document.getElementById("inputPw");

inputPw.addEventListener("input", function(){

    if(inputId.value.trim().length == 0){
        alert("아이디를 입력해주세요.");
        inputPw.value="";
        inputId.focus();
    }
});

function loginValidate(){

    if(inputId.value.trim().length == 0){
        alert("아이디를 입력해주세요.");
        inputId.value="";
        inputId.focus();
        return false;

    }

    if(inputPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        inputPw.value ="";
        inputPw.focus();
        return false;
    }
    return true;
}

