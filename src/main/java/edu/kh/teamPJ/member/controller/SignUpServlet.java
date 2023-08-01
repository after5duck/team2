package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.member.model.service.MemberService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path= "/WEB-INF/views/member/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * String path = "/WEB-INF/views/member/signUp.jsp";
		 * req.getRequestDispatcher(path).forward(req, resp);
		 */
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberNick = req.getParameter("memberNick");
		String memberTel = req.getParameter("memberTel");
		String memberEmail = req.getParameter("memberEmail");
		
		Member member = new Member();
		
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberNickname(memberNick);
		member.setMemberTel(memberTel);
		member.setMemberEmail(memberEmail);
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.signUp(member);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				session.setAttribute("message", "회원 가입 성공");
				
			}else {
				session.setAttribute("message", "회원 가입 실패");
			}
			
			
			resp.sendRedirect( req.getContextPath() );
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
