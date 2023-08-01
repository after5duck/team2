package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.member.model.service.MemberService;

// 닉네임 중복확인 Servlet
@WebServlet("/member/mypage/checkDupNick")
public class CheckDupNick extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNick = req.getParameter("memberNick");
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		
		MemberService service = new MemberService(); 
		
		try {
			
			String result = service.checkDupNick(memberNick, memberNo);
			
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
