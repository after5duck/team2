package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.member.model.service.MemberService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path= "/WEB-INF/views/member/login.jsp";
		req.getRequestDispatcher(path).forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");

		System.out.println(inputId);
		System.out.println(inputPw);

		Member member = new Member();
		member.setMemberId(inputId);
		member.setMemberPw(inputPw);

		try {
			MemberService service = new MemberService();

			Member loginMember = service.login(member);

			HttpSession session = req.getSession();

			if(loginMember != null) {
			    session.setAttribute("loginMember", loginMember);
			    System.out.println(loginMember);
			    session.setMaxInactiveInterval(3600);

			    // 로그인에 성공하면 DayController로 리디렉션
			    resp.sendRedirect(req.getContextPath() + "/test");
			}else {
			    session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			    String path = "/WEB-INF/views/member/login.jsp";
			    RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			    dispatcher.forward(req, resp);
			}
			

			//resp.sendRedirect( req.getContextPath() );

		}catch (Exception e) {
			e.printStackTrace();
		}


	}




}
