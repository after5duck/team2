package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// session 얻어오기
		HttpSession session = req.getSession();
		
		// 세션 무효화
		session.invalidate();
		
		// 메인페이지로 돌아감.
		resp.sendRedirect(req.getContextPath());
		
	
	}
}
