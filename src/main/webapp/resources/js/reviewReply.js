// 댓글 목록 조회
function selectReplyList(){

    $.ajax({
        url : contextPath + "/reply/selectReplyList",
        data : {"boardNo" : boardNo},
        type : "get",
        dataType : "JSON",
        success : function(rList){
         
            const commentPart2 = document.getElementsByClassName("commentPart2")[0];
            commentPart2.innerHTML ="";

            for(let reply of rList){
                const commentList = document.createElement("li");
                commentList.classList.add("commentList");

                const replyWriter = document.createElement("p");

                const profileImage = document.createElement("img");
                profileImage.classList.add("imgBorder");

                if(reply.profileImage != null){
                    profileImage.setAttribute("src", contextPath + reply.profileImage)
                }else{
                    profileImage.setAttribute("src", contextPath + "/resources/images/user.png");
                }

                // 작성자
                const memberNickname = document.createElement("span");
                memberNickname.innerHTML = reply.memberNickname;

                // 작성날짜
                const replyDate = document.createElement("span");
                replyDate.innerHTML = "(" + reply.createDate +")";

                replyWriter.append(profileImage, memberNickname, replyDate );

                // 댓글내용
                const replyContent = document.createElement("p");
                replyContent.classList.add("commentBody");
                replyContent.innerHTML = reply.replyContent;

                commentList.append(replyWriter, replyContent);

                if(loginMemberNo == reply.memberNo){
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("btn-comment");

                    const updateBtn = document.createElement("button");
                    updateBtn.classList.add("btn-modify-comment");
                    updateBtn.setAttribute("onclick","showUpdateReply(" + reply.replyNo + " , this");
                    updateBtn.innerText = "수정";

                    const deleteBtn = document.createElement("button");
                    deleteBtn.classList.add("btn-delete-comment");
                    deleteBtn.setAttribute("onclick","deleteReply("+ reply.replyNo +")")
                    deleteBtn.innerText = "삭제";

                    replyBtnArea.append(updateBtn, deleteBtn);

                    commentList.append(replyBtnArea);
                }

                commentPart2.append(commentList);
            }

        },
        error : function(req, status, error){
            console.log("실패");
            console.log(req.responseText);
        }
    });
}

// 댓글 등록
const addComment = document.getElementById("btn-write");
const comment = document.getElementById("comment");

addComment.addEventListener("click", function(){

    // 로그인 확인
    if(loginMemberNo == "" ){
        alert("로그인 후 이용해주세요");

        comment.value = "";
        return;
    }

    // 댓글 내용 확인
    if(comment.value.trim().length == 0){
        alert("댓글을 작성해주세요")

        comment.value = "";
        comment.focus();
        return;
    }

    $.ajax({

        url : contextPath + "/reply/insert",
        data : {"replyContent" : comment.value,
                "memberNo"  : loginMemberNo,
                "boardNo"   : boardNo},
        type : "post",
        success : function(result){

            if(result > 0){
                alert("댓글이 등록되었습니다.");

                comment.value = "";
                
                selectReplyList();
            }else{
                alert("댓글 등록 실패");
            }

        },
        error : function(req, status, error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }
    })
})

// 댓글 삭제
function deleteReply(replyNo){
    if(confirm("정말 삭제하시겠습니까?")){
        $.ajax({
            url : contextPath + "/reply/delete",
            data : {"replyNo" : replyNo},
            type : "get",
            success : function(result){

                if(result > 0){
                    alert("댓글이 삭제되었습니다.");

                    selectReplyList();

                }else{
                    alert("댓글 삭제에 실패했습니다.");
                }
            },
            error : function(){
                console.log("에러 발생");
            }
        });
    }
}


// 댓글 수정

let beforeComment;

function showUpdateReply(replyNo, btn){

    const temp = document.getElementsByClassName("update-textarea");
    if(temp.length > 0){
        if(confirm("다른 댓글 수정 중입니다. 현재 댓글을 수정하시겠습니까?")){
            temp[0].parentElement.innerHTML = beforeComment;
        }else{
            return;
        }
    }

    const replyRow = btn.parentElement.parentElement;

    beforeReplyRow = replyRow.innerHTML;
    
    let beforeComment = replyRow.children[1].innerHTML;

    replyRow.innerHTML = "";

    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    beforeComment = beforeComment.replaceAll("&amp;", "&");
    beforeComment = beforeComment.replaceAll("&lt;", "<");
    beforeComment = beforeComment.replaceAll("&gt;", ">");
    beforeComment = beforeComment.replaceAll("&quot;", "\"");

    beforeComment = beforeComment.replaceAll("<br>", "\n");

    textarea.value = beforeComment;

    replyRow.append(textarea);

    const replyBtnArea = document.createElement("div");
    replyBtnArea.classList.add("btn-comment");

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.classList.add("btn-modify-comment");
    updateBtn.setAttribute("onclick", "updateReply(" +  replyNo + ", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.classList.add("btn-cancel-comment")
    cancelBtn.setAttribute("onclick", "cancelReply(this)");

    replyBtnArea.append(updateBtn, cancelBtn);
    replyRow.append(replyBtnArea);
}

function cancelReply(btn){
    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = beforeReplyRow;
    }else{
        return;
    }
}

function updateReply(replyNo, btn){
    const replyContent = btn.parentElement.previousElementSibling.value;

    $.ajax({
        url : contextPath + "/reply/update",
        data : {"replyNo" : replyNo,
                "replyContent" : replyContent},
        tyoe : "post",
        success : function(result){
            if(result > 0){
                alert("댓글 수정 성공");
                selectReplyList();
            }else{
                alert("댓글 수정 실패")
            }
        },
        error : function(req, status, error){
            console.log("댓글 수정 실패");
            console.log(req.responseText);
        }
    });
}