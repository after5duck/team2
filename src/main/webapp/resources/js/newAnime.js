// 모달(Modal) 열기
function openModal(index) {
	var modal = document.getElementById("myModal" + index);
	if (modal) {
		modal.style.display = "block";
	}
}

// 모달(Modal) 닫기
function closeModal(index) {
	var modal = document.getElementById("myModal" + index);
	if (modal) {
		modal.style.display = "none";
	}
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
	if (event.target.className === "modal") {
		closeModalById(event.target.id);
	}
};

// onkeydown 이벤트 핸들러 추가, ESC키 눌러도 창 닫히게 추가 (함수3)
window.onkeydown = function (event) {
	if (event.key === "Escape") {
		var modalList = document.getElementsByClassName('modal');
		for (var i = 0; i < modalList.length; i++) {
			closeModalById(modalList[i].id);
		}
	}
};

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

// function changeBtn(btnId) {
// 	const buttons = document.querySelectorAll(".select_btn");

// 	buttons.forEach(function (button) {
// 		if (button.id === btnId) {
// 			button.classList.add("selected");

// 		} else {
// 			button.classList.remove("selected");
// 		}
// 	});
// }
