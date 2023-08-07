
/* 좋아요 버튼 */
const icon = document.getElementsByName('icon');

for(let i = 0; i < icon.length ; i++){

    icon[i].addEventListener('click', function() {

        if (icon[i].classList.contains('fa-regular')) {
            icon[i].classList.remove('fa-regular');
            icon[i].classList.add('fa-solid');
        } else {
            icon[i].classList.remove('fa-solid');
            icon[i].classList.add('fa-regular');
        }
    });
}

/* 스크롤 함수 */
document.addEventListener('DOMContentLoaded', function () {
    var scrollTopBtn = document.querySelector('.scroll-top-btn');

    window.addEventListener('scroll', function () {
        if (window.pageYOffset > 500) {
            scrollTopBtn.classList.add('show');
        } else {
            scrollTopBtn.classList.remove('show');
        }
    });

    scrollTopBtn.addEventListener('click', function (e) {
        e.preventDefault();
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    });
});

// /* 굿즈 정렬 */

// const goods_kind = document.getElementById("goods_kind");
// // const goods_select = $("#goods_kind").children("div");

// $("#goods_kind").children("div").addEventListener("click",function(){

//     console.log(goods_select.value);

//     $.ajax({
        
//         url : contextPath + "/board/goods",
//         data : { "goods" : goods_select.value }, 
//         type : "POST",
//         dataType : "JSON", // dataType : 응답데이터 형식 을 지정
//                             // -> "JSON"으로 지정 시 자동으로 JS 객체로 변환

//         success : function(member){
//             console.log(member); // JS 객체 형태 문자열

//             //JSON.parse(문자열) : 문자열 -> JS 객체로 변환
//             //console.log(JSON.parse(member));

//             // 1) div에 작성된 내용 모두 삭제
//             div.innerHTML = "";

//             if(member != null){ // 회원 정보 존재 O


//                 // 2) ul 요소 생성
//                 const ul = document.createElement("ul");

//                 // 3) li 요소 생성 * 5 + 내용 추가
//                 const li1 = document.createElement("li");
//                 li1.innerHTML = "이메일 : " + member.memberEmail;

//                 const li2 = document.createElement("li");
//                 li2.innerHTML = "닉네임 : " + member.memberNickname;

//                 const li3 = document.createElement("li");
//                 li3.innerHTML = "전화번호 : " + member.memberTel;

//                 const li4 = document.createElement("li");
//                 li4.innerHTML = "주소 : " + member.memberAddress;

//                 const li5 = document.createElement("li");
//                 li5.innerHTML = "가입일 : " + member.enrollDate;

//                 // 4) ul에 li를 순서대로 추가
//                 ul.append(li1, li2, li3, li4, li5);

//                 // 5) div에 ul 추가
//                 div.append(ul);


//             } else {// 회원 정보 존재 X

//                 // 1) h4 요소 생성
//                 const h4 = document.createElement("h4");
//                 // 2) 내용 추가
//                 h4.innerHTML = " 회원 정보가 존재하지 않습니다."
//                 // 3) 색 추가
//                 h4.style.color = "red";
//                 // 4) div에 추가
//                 div.append(h4);
//             }

//         },
//         error : function(request, status, error){
//             console.log("AJAX 에러 발생")

//             console.log("상태코드 : " + request.status); // 404, 500

//             console.log(request.responseText); // 에러 메세지

//             console.log(error); // 에러 객체 출력
//         }

//     });

// });