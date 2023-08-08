<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>약관동의</title>

                <link rel="stylesheet" href="${contextPath}/resources/css/signUpAgree.css">

                <script src="https://kit.fontawesome.com/98acdabf0d.js" crossorigin="anonymous"></script>

            </head>

            <body>

                <section class="logo">
                    <a href="${contextPath}">
                        <img src="${contextPath}/resources/images/자른로고.png" id="logo">
                    </a>
                </section>

                <form action="signUp" method="get" name="signUpAgree-form" onsubmit="return agreeValidate()">
                    <section class="container">

                        <div style="font-size:45px; font-weight:bold; color: #000000;">약관동의</div>

                        <div>
                            <!-- 전체동의 약관 박스 -->
                            <input type="checkbox" id="check1" class="cbox" name="CHEBOX" onclick="selectAll(this)">
                            <label for="check1" style="font-size: xx-large;">전체 약관에 동의합니다.</label>
                        </div>
                        <div class="line1" style="padding:0 40px"></div>


                        <div class="content">

                            <!-- 1 애니버스 이용약관 동의 -->
                            <div class="smallContainer">
                                <div class="one">
                                    <div><input type="checkbox" id="check2" name="CHEBOX" class="req" required></div>
                                    <div><label>애니버스 이용약관 동의(필수)</label></div>
                                </div>
                                <!-- 약관 박스1 -->
                                <div class="agreeArea">
                                    <textarea id="agreeContent1" readonly>
제 1 장 총칙
제 1 조 (목적)
본 약관은 애니버스 (이하 "애니버스")이 제공하는 모든 서비스(이하 "서비스")의 이용조건 및 절차, 이용자와 애니버스의 권리, 의무, 책임사항과 기타 제반 사항을 규정함을 목적으로 합니다.

제 2 조 (약관의 명시와 개정)
1. 누리집은 이 약관의 내용과 주소지, 관리자의 성명, 개인정보보호 담당자의 성명, 연락처(전화, 팩스, 전자우편 주소 등) 등을 이용자가 알 수 있도록 누리집의 초기 서비스화면(전면)에 게시합니다.
2. 누리집은 약관의 규제에 관한 법률, 전자거래기본법, 전자서명법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.
3. 누리집이 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 누리집의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일 까지 공지합니다.
4. 이 약관에 동의하는 것은 정기적으로 웹을 방문하여 약관의 변경사항을 확인하는 것에 동의함을 의미합니다. 변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 누리집에서 책임지지 않습니다.
5. 회원은 변경된 약관에 동의하지 않을 경우 회원 탈퇴(해지)를 요청할 수 있으며, 변경된 약관의 효력 발생일로부터 7일 이후에도 거부의사를 표시하지 아니 하고 서비스를 계속 사용할 경우 약관의 변경 사항에 동의한 것으로 간주됩니다.
6. 본 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 및 기타 관련 법령의 규정에 의합니다.
제 3 조 (용어의 정의)
1. 본 약관에서 사용하는 용어의 정의는 다음과 같습니다.
① 이용계약: 서비스 이용과 관련하여 누리집과 이용자 간에 체결하는 계약
② 가입: 누리집이 제공하는 신청서 양식에 해당 정보를 기입하고, 본 약관에 동의하여 서비스 이용계약을 완료시키는 행위
③ 회원: 누리집에 회원가입에 필요한 개인 정보를 제공하여 회원 등록을 한 자로서, 누리집의 정보 및 서비스를 이용할 수 있는 자
④ 이용자번호(ID): 이용고객의 식별과 이용자가 서비스 이용을 위하여 이용자가 정하고 누리집이 승인하는 문자와 숫자의 조합
⑤ 비밀번호(PW): 이용자가 등록회원과 동일인인지 신원을 확인하고 통신상의 자신의 개인정보보호를 위하여 이용자 자신이 정한 문자와 숫자의 조합
⑥ 게시물: 회원이 서비스를 이용하면서 게시한 글, 이미지, 동영상 등 각종 파일과 링크 등
⑦ 탈퇴(해지): 서비스 또는 회원이 이용계약을 종료하는 행위
2. 본 약관에서 정의하지 않은 용어는 개별서비스에 대한 별도약관 및 이용규정에서 정의합니다.
제 2 장 이용계약의 성립 및 해지
제 4 조 (이용 계약의 성립)
1. 이용계약은 이용자가 본 이용약관 내용에 대한 동의와 이용신청에 대하여 누리집의 이용승낙으로 성립합니다.
2. 본 이용약관에 대한 동의는 이용신청 당시 해당 누리집의 '동의함' 버튼을 누름으로써 의사표시를 합니다.
제 5 조 (회원가입 및 탈퇴)
1. 회원가입은 신청자가 온라인으로 누리집에서 제공하는 소정의 가입신청 양식에서 요구하는 사항을 기록하여 가입을 완료하는 것으로 성립됩니다.
2. 누리집은 다음 각 호에 해당하는 회원에 대하여는 가입을 취소할 수 있습니다.
① 다른 사람의 명의를 사용하여 신청하였을 때
② 회원가입 신청서의 내용을 허위로 기재하였거나 신청하였을 때
③ 사회의 안녕 질서 혹은 미풍양속을 저해할 목적으로 신청하였을 때
④ 다른 사람의 누리집 서비스 이용을 방해하거나 그 정보를 도용하는 등의 행위를 하였을 때
⑤ 누리집을 이용하여 법령과 본 약관이 금지하는 행위를 하는 경우
⑥ 기타 누리집이 정한 회원가입 요건이 미비 되었을 때
3. 누리집은 다음 각 항에 해당하는 경우 그 사유가 해소될 때까지 이용계약 성립을 유보할 수 있습니다.
① 서비스 관련 제반 용량이 부족한 경우
② 기술상 장애 사유가 있는 경우
4. 누리집은 자체 개발하거나 다른 기관과 협의 등을 통해 일체의 서비스를 제공하며 변경 시 변경될 서비스의 내용을 이용자에게 공지하고 제공할 수 있습니다.
5. 회원은 등록사항에 변경이 있는 경우, 즉시 회원정보 수정 등 기타 방법으로 누리집에 대하여 그 변경사항을 알려야 합니다.
6. 회원은 가입 이후 누리집에서 제공하는 서비스를 제공받을 의사가 없는 등의 사유가 있을 경우에는 언제든지 회원탈퇴(해지)를 할 수 있습니다. 다만 타인에 의해 재 게시되거나, 게시판, 커뮤니티, 카페 등 공유 및 알림의 목적으로 등록된 게시물은 삭제되지 않으니 사전에 삭제 후 탈퇴하여야 합니다.
                        </textarea>
                                </div>
                            </div>


                            <!-- 2 개인정보 동의 -->
                            <div class="smallContainer">
                                <div class="one">
                                    <div><input type="checkbox" id="check3" name="CHEBOX" class="req" required></div>
                                    <div><label>개인정보 수집 및 이용에 대한 안내 (필수)</label></div>
                                </div>
                                <!-- 약관 박스2 -->
                                <div class="agreeArea">
                                    <textarea id="agreeContent2" readonly>
1. 수집하는 개인정보 항목
문화체육관광부 대표 누리집의 이용자 참여와 이용통계 분석 등의 서비스를 위해 회원 가입시 아래의 개인정보를 수집하고 있습니다.

가. 필수정보: 아이디, 이름, 성별, 출생년도, 비밀번호, 이메일
나. 서비스 이용 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
(접속로그, 접속IP정보, 쿠키, 방문 일시, 서비스 이용기록, 불량 이용 기록)
2. 대표 누리집에서 이용자 회원가입 시 직접 개인정보를 입력 및 수정하여 개인정보를 수집합니다.
3. 수집 개인정보의 이용목적
회원가입, 회원활동 실적 관리, 회원탈퇴 의사 확인 등 회원관리
제공되는 서비스 이용에 관한 인구통계학적 분석, 서비스 방문 및 이용기록 분석, 관심사에 기반한 맞춤형 서비스 등 제공
신규 서비스 개발 및 활성화, 홍보 및 이벤트, 전자우편 서비스 등 정보 전달
향후 법정 대리인 본인확인, 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달 등
4. 개인정보의 보유 및 이용기간
이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다.
따라서 문화체육관광부 대표누리집은 최종 로그인 후 2년이 경과하였거나 정보주체의 회원 탈퇴 신청 시 회원의 개인정보를 지체 없이 파기합니다.

동의 거부 권리 사실 및 불이익 내용
이용자는 동의를 거부할 권리가 있습니다. 동의를 거부할 경우에는 서비스 이용에 제한됨을 알려드립니다.
                        </textarea>
                                </div>
                            </div>



                            <!-- 3 이벤트 동의 -->
                            <div class="smallContainer">
                                <div class="one">
                                    <div><input type="checkbox" id="check4" name="CHEBOX"></div>
                                    <div><label>이벤트 소식 메일 수신(선택)</label></div>
                                </div>
                                <!-- 약관 박스3 -->
                                <div class="agreeArea">
                                    <textarea id="agreeContent3" readonly>
본 광고 서비스 이용약관(이하 “본 약관”이라 합니다)은 애니버스(이하 “회사”)가 
제공하는 서비스를 통하여 상품을 등록하고 펀딩을 통해 자금을 모으거나 또는 
판매하는 자(이하 “메이커”라 합니다)가 본 서비스를 제공하는 회사가 
운영 및 제공하는 인터넷 사이트(https://www.wadiz.kr, 이하 “사이트”라 합니다), 
모바일 애플리케이션 또는 모바일 웹에서 광고/마케팅 상품을 매수하여 
이를 시행함에 있어 회사와 메이커 간의 권리, 
의무 등 필요한 제반 사항을 규정함을 목적으로 합니다.
                        </textarea>
                                </div>
                            </div>
                        </div>

                        <!-- 다음 단계로 가기 버튼 -->
                        <button id="btn">다음 단계로 가기</button>

                    </section>

                </form>

                <c:if test="${ !empty sessionScope.message }">
                    <script>
                        alert("${message}");

                    </script>

                    <c:remove var="message" scope="session" />
                </c:if>


                <script src="${contextPath}/resources/js/test.js"></script>
                <!-- <script src="${contextPath}/resources/js/signUpAgree.js"></script> -->
                <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            </body>

            </html>