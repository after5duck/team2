// 게시글 삭제하는 js
(function () {

	const btnDelete = document.getElementById("btn-delete");

	if (btnDelete != null) {

		btnDelete.addEventListener("click", function () {

			let url = contextPath + "/board/review/delete";

			const params = new URL(location.href).searchParams;

			const boardNo = "?boardNo=" + params.get("boardNo");

			const type = "&type=" + params.get("type");

			url += boardNo + type;

			if (confirm("정말로 삭제하시겠습니까??")) {
				location.href = url;

			}

		});
	}
})();


/* 조회수 증가 */
function updateReadCount() {

	$.ajax({

		url: contextPath + "/board/detail/updateReadCount",

		data: { "boardNo": boardNo },

		type: "get",

		success: function (data) {

			document.getElementById("readCount").innerText = data;
		},

		error: function () {

			console.log("조회수 업데이트 실패");
		},
	});
}
(function () {

	updateReadCount();

})();


