// 전체 동의하기 체크박스 js 
let review_all = document.getElementById("review_all");
let review_agree = document.getElementsByName("review_agree");

review_all.addEventListener("click", function () {
    for (let i = 0; i < review_agree.length; i++) {
        review_agree[i].checked = this.checked;
    }
});

for (let i = 0; i < review_agree.length; i++) {
    review_agree[i].addEventListener("click", function () {
        if (!this.checked) {
            review_all.checked = false;
        } else {
            let allChecked = true;
            for (let j = 0; j < review_agree.length; j++) {
                if (!review_agree[j].checked) {
                    allChecked = false;
                    break;
                }
            }
            review_all.checked = allChecked;
        }
    });
}

// 필수 체크 안되어 있을때 제출 막기

document.getElementById("btn_review").addEventListener('click', function (event) {
    let essential = document.getElementById("essential");
    let title = document.getElementById("reviewTitle");
    let content = document.getElementById("review_content");

    if (!essential.checked) {
        alert('필수 선택사항을 체크해주세요.');
        event.preventDefault();
    } else if (title.value.trim() === "") {
        alert('제목은 필수 입력사항입니다.');
        event.preventDefault();
    } else if (content.value.trim() === "") {
        alert('내용은 필수 입력사항입니다.');
        event.preventDefault();
    }
});



//게시글 작성 유효성 검사
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

// 별점

// const drawStar = (target) => {
//     document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
// }



