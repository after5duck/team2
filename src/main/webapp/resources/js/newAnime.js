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
