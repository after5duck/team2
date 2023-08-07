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
	var modal = document.getElementById("myModal" + (index + 1));
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
		closeModalById("myModal1");
		closeModalById("myModal2");
		closeModalById("myModal3");
		closeModalById("myModal4");
		closeModalById("myModal5");
		closeModalById("myModal6");
	}
};


// 모달 창을 닫는 함수
function closeModal(index) {
	const modal = document.getElementById('myModal' + index);
	modal.style.display = 'none';
}





