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
		int inputCheckNumber = Integer.parseInt(req.getParameter("inputCode"));
		int checkCode = Integer.parseInt(req.getParameter("ranCode")); 

		System.out.println("체크 난수 " +	checkCode);
		System.out.println(inputCheckNumber);
		
		boolean isRight = (checkCode == inputCheckNumber ? true : false);
		
		System.out.println("확인" + isRight);
		
		if(isRight == true) {
			result = 1;
		}else {
			result = 0;
		}
		
		resp.getWriter().print(result);		
		
	}
}
