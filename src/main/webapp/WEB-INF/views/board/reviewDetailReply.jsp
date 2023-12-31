<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 댓글 목록 -->
<ul class="commentPart2">

    <c:forEach var="reply" items="${rList}">

        <li class="commentList">
            <p>
                <c:if test="${empty reply.profileImage}">
                    <img class="imgBorder" src="${contextPath}/resources/images/user.png">
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
                    <button onclick="showUpdateReply(${reply.replyNo}, this)" class="btn-modify-comment">수정</button>
                    <button onclick="deleteReply(${reply.replyNo})" class="btn-delete-comment">삭제</button>
                </div>
            </c:if>
        </li>
    </c:forEach>
</ul>



<!-- 댓글 작성 -->
<div id="commentPart">
    <div id="commentMain">
        <c:if test="${empty loginMember.memberNo}">
            <textarea id="comment" placeholder="로그인 후 이용해주세요."></textarea> 
        </c:if>
        <c:if test="${!empty loginMember.memberNo}">
            <textarea id="comment" placeholder="댓글을 입력해주세요."></textarea> 
        </c:if>
    </div>
    <div id="commentWrite">
        <button id="btn-write">등록</button>
    </div>
</div> 