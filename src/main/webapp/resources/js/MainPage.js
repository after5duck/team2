/*const photo_1 = document.getElementById("photo_1");
const photo_2 = document.getElementById("photo_2");
const photo_3 = document.getElementById("photo_3");
const photo_4 = document.getElementById("photo_4");
const photo_5 = document.getElementById("photo_5");

const photo_Text_1 = document.getElementById("photo_text_1");
const photo_Text_2 = document.getElementById("photo_text_2");
const photo_Text_3 = document.getElementById("photo_text_3");
const photo_Text_4 = document.getElementById("photo_text_4");
const photo_Text_5 = document.getElementById("photo_text_5");

const monday = document.getElementById("monday");
const tue = document.getElementById("tuesday");
const wed = document.getElementById("wednesday");
const thu = document.getElementById("thursday");
const fri = document.getElementById("friday");
const sat = document.getElementById("saturday");
const sun = document.getElementById("sunday");

const buttons = document.querySelectorAll(".date_btn");

// 추천 애니 버튼 함수
const re_btn = document.getElementById("re_btn");
const quar_btn = document.getElementById("quar_btn");
const allTime_btn = document.getElementById("allTime_btn");
const week_btn = document.getElementById("week_btn");

// 사진
const best_1 = document.getElementById("best-1");
const best_2 = document.getElementById("best-2");
const best_3 = document.getElementById("best-3");
const best_4 = document.getElementById("best-4");
const best_5 = document.getElementById("best-5");

// 제목
const title_1 = document.getElementById("title-1");
const title_2 = document.getElementById("title-2");
const title_3 = document.getElementById("title-3");
const title_4 = document.getElementById("title-4");
const title_5 = document.getElementById("title-5");

// 장르
const category_1 = document.getElementById("category-1");
const category_2 = document.getElementById("category-2");
const category_3 = document.getElementById("category-3");
const category_4 = document.getElementById("category-4");
const category_5 = document.getElementById("category-5");


// 요일별로 사진 보여주는 버튼
function showContent(selectedDay) {
	buttons.forEach(function (button) {
		if (button.id === selectedDay) {
			button.style.backgroundColor = "rgb(237, 21, 93)";
		} else {
			button.style.backgroundColor = "rgba(149, 149, 149, 0.544)";
		}
	});

	// 클릭된 버튼에 따라 해당 컨텐츠를 보여주는 함수 호출
	switch (selectedDay) {
		case "monday":
			showMondayContent();
			break;
		case "tuesday":
			showTuesdayContent();
			break;
		case "wednesday":
			showWednesdayContent();
			break;
		case "thursday":
			showThursdayContent();
			break;
		case "friday":
			showFridayContent();
			break;
		case "saturday":
			showSaturdayContent();
			break;
		case "sunday":
			showSundayContent();
			break;
		default:
			break;
	}
}
const bigCon = $("#big");

monday.addEventListener("click", function () {
	$.ajax({
		url: "/getDayList",
		type: "GET",
		dataType: "JSON",
		success: function (response) {
			// 요청 성공 시 처리할 로직
			console.log(response); // 서버에서 반환한 JSON 데이터 출력
			// 원하는 동작을 이곳에 구현
			bigCon.empty();

			for (let dayDTO of response) {
				const miniCon = $("<div>").addClass("mini_con");
				const photo = $("<div>").attr("id", "photo");
				const img = $("<img>").attr("src", dayDTO.imgPath).attr("id", "photo_" + (i + 1));
				photo.append(img);
				const photoText = $("<div>").addClass("photo_text").attr("id", "photo_text_" + (i + 1)).text(dayDTO.imgText);
				miniCon.append(photo, photoText);
				bigCon.append(miniCon);
			}

			if (response.length === 0) {
				bigCon.append($("<p>").text("왜 데이터를 못 가져오니..."));
			}
		},
		error: function (xhr, status, error) {
			// 요청 실패 시 처리할 로직
			console.log(error); // 오류 메시지 출력
		}
	});
});

function showMondayContent() {

	photo_1.src = "resources/images/natsume.png";
	photo_2.src = "resources/images/glass.png";
	photo_3.src = "resources/images/yohane.png";
	photo_4.src = "resources/images/magic rotation2.png";
	photo_5.src = "resources/images/Monday_5.png";

	photo_Text_1.textContent = "나츠메 우인장 1기";
	photo_Text_2.textContent = "좋아하는 애가 안경을 깜박했다";
	photo_Text_3.textContent = "환일의 요하네 SUNSHINE in the MIR..";
	photo_Text_4.textContent = "주술회전 part 2";
	photo_Text_5.textContent = "극장판 주술회전 0";

}
function showTuesdayContent() {

	photo_1.src = "resources/images/demon.png";
	photo_2.src = "resources/images/gintama.png";
	photo_3.src = "resources/images/ayakashi.png";
	photo_4.src = "resources/images/i.png";
	photo_5.src = "resources/images/zoom.png";

	photo_Text_1.textContent = "귀멸의 칼날 3기 : 도공마을편";
	photo_Text_2.textContent = "은혼 1기";
	photo_Text_3.textContent = "아야카시 트라이앵글";
	photo_Text_4.textContent = "최애의아이";
	photo_Text_5.textContent = "좀100";

}
function showWednesdayContent() {

	photo_1.src = "resources/images/moozic.png";
	photo_2.src = "resources/images/hori.png";
	photo_3.src = "resources/images/gatari.png";
	photo_4.src = "resources/images/lizar.png";
	photo_5.src = "resources/images/4.png";

	photo_Text_1.textContent = "무직전생2 이세계에 갔으면 최선을 다한다";
	photo_Text_2.textContent = "호리미야";
	photo_Text_3.textContent = "모노노가타리 제2장";
	photo_Text_4.textContent = "라이자의 아틀리에~";
	photo_Text_5.textContent = "월간순정 노자키군";

}
function showThursdayContent() {

	photo_1.src = "resources/images/Thursday_1.png";
	photo_2.src = "resources/images/Thursday_2.png";
	photo_3.src = "resources/images/Thursday_3.png";
	photo_4.src = "resources/images/Thursday_4.png";
	photo_5.src = "resources/images/Thursday_5.png";


	photo_Text_1.textContent = "쓰레기의 본망";
	photo_Text_2.textContent = "제물공주와 짐승의 왕";
	photo_Text_3.textContent = "문호 스트레이독스 5기";
	photo_Text_4.textContent = "마사무네의 리벤지 R";
	photo_Text_5.textContent = "(자막) 기동전사 건담 수성의 마녀 part 2";
}
function showFridayContent() {

	photo_1.src = "resources/images/Friday_1.png";
	photo_2.src = "resources/images/Friday_2.png";
	photo_3.src = "resources/images/Friday_3.png";
	photo_4.src = "resources/images/Friday_4.png";
	photo_5.src = "resources/images/Friday_5.png";


	photo_Text_1.textContent = "유희왕 1기";
	photo_Text_2.textContent = "주술회전 2기 : 회옥.옥절";
	photo_Text_3.textContent = "니어:오토마다 Ver1.1a";
	photo_Text_4.textContent = "이누야시키";
	photo_Text_5.textContent = "4월은 너의 거짓말";

}
function showSaturdayContent() {

	photo_1.src = "resources/images/Saturday_1.png";
	photo_2.src = "resources/images/Saturday_2.png";
	photo_3.src = "resources/images/Saturday_3.png";
	photo_4.src = "resources/images/Saturday_4.png";
	photo_5.src = "resources/images/Saturday_5.png";


	photo_Text_1.textContent = "아즈망가 대왕";
	photo_Text_2.textContent = "유녀사장 R";
	photo_Text_3.textContent = "유녀사장";
	photo_Text_4.textContent = "레벨 1이지만 유니크 스킬로 최강입니다";
	photo_Text_5.textContent = "바람의 검심 -메이지 검객 낭만기-"

}
function showSundayContent() {

	photo_1.src = "resources/images/Sunday_1.png";
	photo_2.src = "resources/images/Sunday_2.png";
	photo_3.src = "resources/images/Sunday_3.png";
	photo_4.src = "resources/images/Sunday_4.png";
	photo_5.src = "resources/images/Sunday_5.png";


	photo_Text_1.textContent = "호리미야 -piece-";
	photo_Text_2.textContent = "라이어 라이어";
	photo_Text_3.textContent = "야무진 고양이는 오늘도 우울";
	photo_Text_4.textContent = "오버로드 4기";
	photo_Text_5.textContent = "카구야 님은 고백받고 싶어~천재들의 연애.."

}*/

// -------------------------- 스크롤 함수 --------------------------


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


// -------------------------- 스크롤 함수 끝 --------------------------


// -------------------------- 애니버스 인기애니 버튼 --------------------------
// function changeBtn(selectedBtn) {
// 	buttons.forEach(function (button) {
// 		if (button.id === selectedBtn) {
// 			button.style.backgroundColor = "rgb(237, 21, 93)";
// 			button.style.color = "#fff";
// 		} else {
// 			button.style.backgroundColor = "rgba(149, 149, 149, 0.544)";
// 			button.style.color = "#505050";
// 		}
// 	});
// }


function changeBtn(btnId) {
	const buttons = document.querySelectorAll(".select_btn");

	buttons.forEach(function (button) {
		if (button.id === btnId) {
			button.classList.add("selected");

		} else {
			button.classList.remove("selected");
		}
	});
}



// -------------------------- 애니버스 인기애니 버튼 끝--------------------------


// ----------------------------- 모달창 ---------------------------------

// 모달(Modal) 열기
function openModal(index) {
	var modal = document.getElementById("myModal" +(index+1));
	modal.style.display = "block";
}

// 모달(Modal) 닫기
function closeModal(index) {
	var modal = document.getElementById("myModal" + index);
	modal.style.display = "none";
}



// 모달 ID 받아서 창 닫는 일반 (함수 1)
function closeModalById(modalId) {
	var modal = document.getElementById(modalId);
	if (modal) {
		modal.style.display = "none";
	}
}

// 클릭 이벤트 핸들러로 클릭하면 창 닫히게 하는 (함수 2)
window.onclick = function (event) {
	switch (event.target.id) {
		case "myModal":
		case "myModal2":
		case "myModal3":
		case "myModal4":
		case "myModal5":
			closeModalById(event.target.id);
			break;
		default:
			// 다른 요소를 클릭하면 아무 동작도 하지 않음
			break;
	}
};

// onkeydown 이벤트 핸들러 추가, ESC키 눌러도 창 닫히게 추가 (함수3)
window.onkeydown = function (event) {
	if (event.key === "Escape") {
		closeModalById("myModal");
		closeModalById("myModal2");
		closeModalById("myModal3");
		closeModalById("myModal4");
		closeModalById("myModal5");
	}
};
// ----------------------------- 모달창 끝 ---------------------------------

// 메인페이지 요일별 즉시실행 함수

// function selectDayList() {

// 	$.ajax({

// 		url : "getDayList",
// 		type : "GET",
// 		dataType : "JSON",

// 		success : function(imageList){

// 			const div1 = document.createElement("div");

// 			const div2 = document.createElement

// 		}



// 	});



// }


// function selectDayList() {

// 	console.log("즉시실행 함수 시작");

// 	$.ajax({
// 		url: "main/getDayList",
// 		type: "GET",
// 		dataType: "JSON",
// 		success: function (imageList) {
// 			const first = document.getElementById("first"); // 예시로 사용하는 부모 요소의 id

// 			console.log("비동기 데이터 받아옴");
			// 이미지 리스트(imageList)를 순회하면서 화면에 출력
			// imageList.forEach(function (dayDTO, index) {
			// 	const div1 = document.createElement("div");
			// 	const div2 = document.createElement("div");
			// 	const img = document.createElement("img");
			// 	const textDiv = document.createElement("div");

			// 	div1.classList.add("mini_con");
			// 	div2.setAttribute("id", "photo");
			// 	img.setAttribute("src", `resources/images/${dayDTO.imgPath}`);
			// 	img.setAttribute("id", `photo_${index + 1}`);
			// 	textDiv.classList.add("photo_text");
			// 	textDiv.setAttribute("id", `photo_text_${index + 1}`);
			// 	textDiv.textContent = dayDTO.subTitle;

			// 	div2.appendChild(img);
			// 	div1.appendChild(div2);
			// 	div1.appendChild(textDiv);

			// 	first.appendChild(div1); // 예시로 사용하는 부모 요소에 추가 (여기서는 first라는 id를 가진 요소를 사용)
			// });


// 			for (let item of imageList) {
// 				const div = document.createElement("div"); // div 요소 생성

// 				const img = document.createElement("img"); // 이미지 요소 생성
// 				img.src = "resources/images/" + item.imgPath; // 이미지 URL 할당

// 				const p1 = document.createElement("p"); // 첫 번째 단락 요소 생성
// 				p1.innerText = item.imgText;

// 				console.log("포문ㄸ끝");

// 				// div 안에 이미지와 단락 요소들을 추가
// 				div.appendChild(img);
// 				div.appendChild(p1);


// 				// div를 문서의 body에 추가
// 				document.body.appendChild(div);
// 			}
// 		},
// 		error: function (xhr, status, error) {
// 			console.error("Error while fetching data:", error);
// 		},
// 	});
// }
// (function () {

// 	selectDayList();
// })();





