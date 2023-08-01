<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 댓글 목록 -->
<article class="commentPart2">

    <c:forEach var="reply" items="${rList}">

        <div class="commentList">
            <p>
                <c:if test="${empty reply.profileImage}">
                    <img class="imgBorder" src="${contextPath}/resources/images/profile.png">
                </c:if>
                <c:if test="${!empty reply.profileImage}">
                    <img class="imgBorder" src="${contextPath}${reply.profileImage}">
                </c:if>
                
                <span>${reply.memberNickname}</span>
                <span>( ${reply.createDate} )</span>
            </p>

            <p class="commentBody">${reply.replyContent}</p>

            <c:if test="${loginMember.memberNo == reply.memberNo}">
                <div class="btn-comment">
                    <button type="button" class="btn-modify-comment">수정</button>
                    <button class="btn-delete-comment">삭제</button>
                </div>
            </c:if>
        </div>
    </c:forEach>
</article>



<!-- 댓글 작성 -->
<form action="#" method="post" id="commentPart">
    <div id="commentMain">
        <textarea id="comment">테스트 댓글 길이 제한을 한번 알아봐야겠다</textarea> 
    </div>
    <div id="commentWrite">
        <button id="btn-write">등록</button>
    </div>
</form> 