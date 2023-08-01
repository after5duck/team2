package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;

@WebServlet("/board/review")
public class BoardListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			BoardService service = new BoardService();
			
			Map<String, Object> map = null;
			
			if(req.getParameter("key") == null) {
				
				map = service.selectBoardList(type, cp);
				
			}else {
				String key = req.getParameter("key");
				String query = req.getParameter("query");
				
				
				map = service.searchBoardList(type, cp, key, query);
				
			}
			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/review.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
