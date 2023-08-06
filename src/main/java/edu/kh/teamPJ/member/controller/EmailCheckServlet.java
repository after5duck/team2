package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.common.SHA256;

@WebServlet("/member/signUp/checkCode")
public class EmailCheckServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int result = 0;
		
		String inputCheckNumber = req.getParameter("email2");
		String code = req.getParameter("code");
		
		boolean isRight = new SHA256().getSHA256(inputCheckNumber).equals(code) ? true : false;
		
		if(isRight == true) {
			result = 1;
		}else {
			result = 0;
		}
		
		resp.getWriter().print(result);		
		
	}
}
