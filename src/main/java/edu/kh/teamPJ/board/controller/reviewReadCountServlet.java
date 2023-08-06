package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;

@WebServlet("/board/detail/updateReadCount")
public class reviewReadCountServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			BoardService service = new BoardService();
			
			int result = service.updateReadCount(boardNo);
			
			if(result == 1) {
				
				int readCount = service.selectReview(boardNo);
				
				resp.getWriter().print(readCount);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
