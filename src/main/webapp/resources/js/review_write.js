
// 전체 동의하기 체크박스 js 
const review_all = document.getElementById("review_all");
const review_agree = document.getElementsByName("review_agree");
review_all.addEventListener("click", function () {

    for (let i = 0; i < review_agree.length; i++) {
        review_agree[i].checked = review_all.checked;
    }
})
this.addEventListener("click", function (e) {
    for (let i = 0; i < review_agree.length; i++) {

        if (e.target == review_agree[i]) {

            // 취미가 전부 선택 안되어 있을 시 전체선택 체크박스 해제하기

            if (!this.checked && review_all.checked) {
                //전체선택이 체크되어 있으면서 현재 클릭한 체크박스가 해제되는 경우
                review_all.checked = false;

            }

            // 취미가 전부 선택이 되어 있을 시 전체선택 체크박스 체크하기
            let flag = true;
            for (let j = 0; j < review_agree.length; j++) {//전부 체크 됐는지 확인하기 위한 for문
                if (!review_agree[j].checked) { //하나라도 체크가 안되어 있을 때
                    flag = false;

                }
            }
            // 전체선택 체크박스가 체크되어 있지 않으면서
            // 취미가 전부 선택이 되어있는 경우
            if (!review_all.checked && flag) {
                review_all.checked = true;
            }
        }

    }

})
function reviewValidate() {
    const essential = document.getElementById("essential");

    if (essential.checked == false) {

        alert("필수 항목을 체크 해주세요!");

        return false;
    }

    return true;
}

// 게시글 작성 유효성 검사
function reviewValidate() {
    const reviewTitle = document.getElementById("reviewTitle");
    const review_content = document.getElementById("review_content")


    if (reviewTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요!");
        reviewTitle.value = "";
        reviewTitle.focus();
        return false;
    }
    if (review_content.value.trim().length == 0) {
        alert("내용을 입력해주세요!");
        review_content.value = "";
        review_content.focus();
        return false;
    }



    return true;
}

(function () {
    const deleteBtn = document.getElementById("btn-delete"); // 존재하지 않으면 null

    if (deleteBtn != null) { // 버튼이 화면에 존재할 때
        deleteBtn.addEventListener("click", function () {

            let url = "delete";


            // 1) 쿼리스트링에 존재하는 파라미터 모두 얻어오기
            const params = new URL(location.href).searchParams;

            // 2) 원하는 파라미터만 얻어와 변수에 저장
            const no = "?no=" + params.get("no"); // ?no=1562

            const type = "&type=" + params.get("type"); // &type=1

            // url에 쿼리스트링 추가
            url += no + type; // delete?no=1562&type=1

            if (confirm("정말로 삭제 하시겠습니까?")) {

                location.href = url;
            }
        });

    }
})();

// const inputImage = document.getElementById('img1');
// const preview = document.getElementById('preview_img'); // ID를 'preview_img'로 변경
// const deleteImage = document.getElementById('deleteImage');
// const deleteSet = new Set();

// inputImage.addEventListener("change", function () {
//     if (this.files[0] != undefined) {
//         const reader = new FileReader();

//         reader.readAsDataURL(this.files[0]);

//         reader.onload = function (e) {
//             preview.setAttribute("src", e.target.result);
//             deleteSet.delete(0);
//         };
//     } else {
//         preview.removeAttribute("src");
//     }
// });

// deleteImage.addEventListener("click", function () {
//     if (preview.getAttribute("src") != "") {
//         preview.removeAttribute("src");
//         inputImage.value = "";
//         deleteSet.add(0);
//     }
// });
function previewImage() {
    const preview = document.getElementById('preview_img');
    const fileInput = document.getElementById('img1');
    const file = fileInput.files[0];
    const reader = new FileReader();

    reader.onload = function (e) {
        preview.src = e.target.result;
        preview.style.display = 'block'; // 이미지 첨부하면 보이게 함
    }

    if (file) {
        reader.readAsDataURL(file);
    }
}
