

/* 첫번째 약관 */
/* document.getElementById("agreeContent1").style.display="none";

const pbtn1 = document.getElementById("btn1");

pbtn1.addEventListener("click", function(){
    document.getElementById("agreeContent1").style.display = "block";
}) */




/* 두번째 약관 */
/* document.getElementById("agreeContent2").style.display="none";

const pbtn2 = document.getElementById("btn2");

pbtn2.addEventListener("click", function(){
    document.getElementById("agreeContent2").style.display = "block";
})
 */


/* 세번째 약관 */


/* document.getElementById("agreeContent3").style.display="none";

const pbtn3 = document.getElementById("btn3");

pbtn3.addEventListener("click", function(){
    document.getElementById("agreeContent3").style.display = "block";
}) */

/* 박스들 얻어오기 */
const check1 = document.getElementById("check1"); // 전체선택 박스
const checkList = document.getElementsByName("CHEBOX");


// 약관 동의 체크 검사

/* 전체선택약관 선택시 전체 선택 되게함 */
function selectAll(selectAll){
    const checkboxes = document.getElementsByName("CHEBOX");

    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAll.checked;
    })
}


/* 필수속성 체크 안됐을때 안넘어가게 */

/* function agreeValidate(){

    const req = document.getElementsByClassName("req")[0];

    for(let i=0; i<req.length; i++){
        if(!req[i].checked){
            return printAlert(req, "체크하고해");
        }
    }
    return true;
} */






/* document.getElementById("btn").addEventListener("click", function(){

    const req = document.getElementsByClassName("req")[0];

    for(let i = 0; i<req.length; i++){ 
        if(req[i].checked === true){
            return;
            alert("체크조ㅓㅁ해라");
        }
        

    }

}) */


/* for( let i = 0; i<checkbbb.length; i++ ){
    if(checkbbb[i].checkd === ture) 
    return true;
}
alert("체크해"); */


/* 체크 박스 체크 안되어있으면 검사 */
/* document.getElementById("btn").addEventListener("click",function(){
    const check2 = document.getElementById("check2");

    if(!check2.checked){
        alert("체크해라");
    }
    
})


document.getElementById("btn").addEventListener("click",function(){
    const check3 = document.getElementById("check3");

    if(!check3.checked){
        alert("체크하라고");
    }
    
}) */








/* function signUpAgreeValidate(){


    if(!check2.checked){
        alert("필수동의 항목을 체크해주세요");
        return false;
    }

    return true;

    
    

} */

/*
const btn = document.getElementById("btn"); // 다음 단계로 가기 버튼

btn.addEventListener("click", (e) =>{
    e.preventDefault();
    AlertCheckbox();
})

function AlertCheckbox(){
    const req = document.querySelector(".req");
    const checkbbb = req.querySelector("input");

    for( let i = 0; i<checkbbb.length; i++ ){
        if(checkbbb[i].checkd === ture) 
        return true;
    }
    alert("체크해");
}
*/







