
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