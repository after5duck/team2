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

@WebServlet("/member/mypage/changeInfo")
public class MypageInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/mypageInfo.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = new MemberService();
		
		String memberNickname = req.getParameter("memberNickname");
		String memberEmail = req.getParameter("memberEmail");
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo();
		
		try {
			String path = null;
			
			Member member = new Member();
			
			member.setMemberNickname(memberNickname);
			member.setMemberEmail(memberEmail);
			member.setMemberNo(memberNo);
			
			int result = service.changeInfo(member);{
				if(result > 0) {
					session.setAttribute("message", "프로필 변경 완료");
					
					loginMember.setMemberNickname(memberNickname);
					loginMember.setMemberEmail(memberEmail);
					
					path = "info"; 
					
				}else {
					session.setAttribute("message", "프로필 변경 실패..");
					
					path = "changeInfo";
				}
				
				resp.sendRedirect(path);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
