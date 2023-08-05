package edu.kh.teamPJ.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/search/*")
public class MyPageSearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/search/").length());
		
		BoardService service = new BoardService();
		
		try {
			
			if(command.equals("contentList")) {
				
				//List<Board> boardList = service.searchContentList();
				
				/*
				 * if(boardList != null) {
				 * 
				 * }else {
				 */
				
			}
			
			if(command.equals("searchArea")) {
				
				try {
					HttpSession session = req.getSession();		
					
					Member loginMember = (Member)session.getAttribute("loginMember"); 
					
					int memberNo = loginMember.getMemberNo();
					
					String inputSearch = req.getParameter("inputSearch");
					
					List<Board> boardList = service.searchSearchArea(inputSearch, memberNo);
					
					new Gson().toJson(boardList, resp.getWriter());
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
}
