package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;

@WebServlet("/board/updateViewCount")
public class BoardViewCount extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardService service = new BoardService();

		try {
			
			int updatedViewCount = service.updateViewCount(boardNo);

			if (updatedViewCount > 0) {
				
				Board board = service.selectBoardWithPhotosView(boardNo);;
				
				resp.getWriter().write(updatedViewCount);

				req.setAttribute("board", board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		String path = "/WEB-INF/views/board/fanart-detail.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}



}
