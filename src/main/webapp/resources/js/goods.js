
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
