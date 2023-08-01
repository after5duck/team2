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

@WebServlet("/member/mypage/secession")
public class MypageSecessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/mypageSecession.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	// 회원 탈퇴
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo();
		
		try {
			MemberService service = new MemberService();
			String inputPw = req.getParameter("inputPw");
			
			System.out.println(memberNo);
			System.out.println(inputPw);
			
			int result = service.secession(memberNo, inputPw);
			
			String path = null;
			
			if(result > 0) {
				
				session.invalidate();
				
				session = req.getSession();
				session.setAttribute("message", "탈퇴되었습니다..");
						
				path = req.getContextPath();
			}else {
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
				
				path = "secession";
			}
			
			resp.sendRedirect(path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
