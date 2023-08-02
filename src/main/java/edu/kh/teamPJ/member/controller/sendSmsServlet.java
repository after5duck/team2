//package edu.kh.teamPJ.member.controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import net.nurigo.java_sdk.Coolsms;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.simple.JSONObject;
//
//@WebServlet("/sendSms")
//public class sendSmsServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String api_key = "NS52A122851C04F";
//        String api_secret = "8B2A5A6923C9BE081920A085BFB835A";
//        coolsms coolsms = new coolsms(api_key, api_secret);
//
//        HashMap<String, String> set = new HashMap<String, String>();
//        set.put("to", "01000000000");
//        set.put("from", "029302266");
//        set.put("text", "Test Message");
//        set.put("type", "sms");
//
//        JSONObject result = coolsms.send(set);
//        if (result.get("status") == true) {
//            response.getWriter().write("성공");
//        } else {
//            response.getWriter().write("실패: " + result.get("message"));
//        }
//    }
//}
////위 코드는 HTML 버튼을 누르면 sendSms URL로 POST 요청을 보내고, 서블릿이 이 요청을 처리하여 문자 메시지를 보냅니다.
//
////참고: 이 예시는 간단한 설명을 위한 것으로, 실제 프로덕션 환경에서는 보안, 에러 처리, 로깅, 사용자 입력 검증 등을 추가로 고려해야 할 수 있습니다.
//
//
//
//
//
