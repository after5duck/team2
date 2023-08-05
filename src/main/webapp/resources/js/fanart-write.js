const inputImage = document.querySelector(".inputImage");
const preview = document.querySelector(".preview");
const deleteImage = document.getElementById("delete-image");

const deleteList = document.getElementById("deleteList");
const deleteSet = new Set();


inputImage.addEventListener("change", function(){

    if(this.files[0] != undefined){
        const reader = new FileReader();

        reader.readAsDataURL(this.files[0]);

        reader.onload = function(e){

            preview.setAttribute("src", e.target.result);

            deleteSet.delete(0);

        }

    }else{
        preview.removeAttribute("src");
    }

})

deleteImage.addEventListener("click", function(){

    if(preview.getAttribute("src") != ""){

        preview.removeAttribute("src");

        inputImage.value = "";

        deleteSet.add(0);

    }

})

function insertValidate(){


    const fanartWriteTitle = document.getElementById("fanartWriteTitle");

    const fanartPlusWrite = document.getElementById("fanart-plus-write");

    if(fanartWriteTitle.value.trim().length == 0){
        alert("제목을 입력해주세요~!");
        fanartWriteTitle.value = "";
        fanartWriteTitle.focus();

        return false;
    }

    if(fanartPlusWrite.value.trim().length == 0){
        alert("내용을 입력해주세요~!");
        fanartPlusWrite.value = "";
        fanartPlusWrite.focus();

        return false;
    }

    deleteList.value = Array.from(deleteSet);

    return true;
}