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

@WebServlet("/member/mypage/changePw")
public class ChangePwServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp); 
	}
	
	// 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputPw = req.getParameter("inputPw");
		String newPw = req.getParameter("newPw");
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo();
		
		String path = null;
		
		try {

			MemberService service = new MemberService();

			int result = service.changePw(inputPw, newPw, memberNo);

			if (result > 0) {
				System.out.println("비밀번호 변경 성공");

				loginMember.setMemberPw(newPw);

				path = "info";
				
			} else {
				System.out.println("변경 실패");
				
				path = "changePw";
			}

			resp.sendRedirect(path);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
