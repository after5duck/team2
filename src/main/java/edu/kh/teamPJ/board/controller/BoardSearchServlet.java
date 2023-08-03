package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;

@WebServlet("/board/search")
public class BoardSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			String keyword = req.getParameter("keyword");
			
			
			BoardService service = new BoardService();
			
			List<Board> searchResult = service.searchBoard(keyword); 
			
			Map<String, Object> map = new HashMap<>();
			map.put("searchResult", searchResult);
			map.put("keyword", keyword); 
			
			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/boardSearchList.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
