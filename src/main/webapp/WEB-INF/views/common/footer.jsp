<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- ******************************** 풋터  ****** **************************-->
        <footer>
            <div class="footer_first">
                <div>
                    <img src="${contextPath }/resources/images/footer_logo.png">
                </div>
                <div>
                    <h5><button id="footer_btn"><strong>(주) 애니버스 사업자 정보</strong></button></h5>
                    <div id="text_box">
                        상호 : 주식회사 애니버스 / 대표 : 아이육<br>
                        주소 : 서울특별시 강남구 테헤란로 10길 9길<br>
                        사업자등록번호 : 202-30-71018
                        이메일 : i6@aniverse.net / 대표전화 : 1588-1004
                    </div>
                </div>

            </div>
            <div class="footer_second">
                <div>
                    <a href="#">회사소개</a>
                    <a href="#">고객센터</a>
                    <a href="#">공지사항</a>
                    <a href="#">이용약관</a>
                    <a href="#">청소년보호정책</a>
                    <a href="#"><strong>개인정보 처리방침</strong></a>
                    <a href="#">저작권 표기</a>
                </div>
                <p>Copyright &copy; 2023.ANIVERSE.All right.reserved.</p>

            </div>
            <div class="footer_third">
                <i class="fa-brands fa-twitter fa-2xl"></i>
                <i class="fa-brands fa-instagram fa-2xl"></i>
                <i class="fa-brands fa-youtube fa-2xl"></i>
                <i class="fa-brands fa-facebook fa-2xl"></i>
            </div>
        </footer>
        
        <%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
<c:if test="${ !empty sessionScope.message }">
   <script>
      alert("${message}")
      
      // EL 작성 시 scope를 지정하지 않으면
      // page > request > session > application 순서로 검색하여
      // 일치하는 속성이 있으면 출력
   </script>
   
   <%-- message 1회 출력 후 session에서 제거 --%>
   <c:remove var="message" scope="session"/>
   
</c:if>
        
        