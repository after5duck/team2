package edu.kh.teamPJ.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.common.Gmail;
import edu.kh.teamPJ.common.SHA256;
import edu.kh.teamPJ.member.model.service.MemberService;

@WebServlet("/member/signUp/certificate")
public class emailCertificateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		MemberService service = new MemberService();

		try{
		    
		    // 1. DB에 이미 저장되어 있는 이메일인지 확인
		    String inputEmail = req.getParameter("inputEmail");
		    
		    int result = service.searchEmail(inputEmail);
		    
		    if( result > 0) {
		    	
		    }else {
				
				String host = "http://localhost:8080/after5duck-ldh/";
				String from = "hwabyreTest@gmail.com";
				String to = req.getParameter("inputEmail");
				String subject = "이메일 인증 메일";
				String content = "다음 링크에 접속하여 이메일 확인을 진행하세요." +
						"<a href='" + host + "member/signUp?code=" + new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";
				
				
				System.out.println("메일 전송 주소 : " + to);
				
				
				// 이메일 전송 : SMTP 이용을 위함
				Properties p = new Properties();
				p.put("mail.smtp.user", from);
				p.put("mail.smtp.host", "smtp.googlemail.com"); // google SMTP 주소
				p.put("mail.smtp.port", "465");
				p.put("mail.smtp.starttls.enable", "true");
				p.put("mail.smtp.auth", "true");
				p.put("mail.smtp.debug", "true");
				p.put("mail.smtp.socketFactory.port", "465");
				p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				p.put("mail.smtp.socketFactory.fallback", "false");
				p.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 추가된 코드
				p.put("mail.smtp.ssl.enable", "true");  // 추가된 코드

				Authenticator auth = new Gmail();
				
				Session ses = Session.getInstance(p, auth);
				ses.setDebug(true);
				MimeMessage msg = new MimeMessage(ses);
				msg.setSubject(subject);
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr);
				Address toAddr = new InternetAddress(to);
				msg.addRecipient(Message.RecipientType.TO, toAddr);
				msg.setContent(content, "text/html;charset=UTF8");
				Transport.send(msg);
				
				String code = req.getParameter("code");
				
				if( code != null) {
					boolean isRight = new SHA256().getSHA256(inputEmail).equals(code) ? true : false;
					
					if(isRight == true) {
						System.out.println("인증성공");
					}else {
						System.out.println("인증실패");
					}
					
				}
				

				
		    }
		    
		    resp.getWriter().print(result);
		    
		    
		    
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}
