package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
				
				Board board = service.selectBoardWithPhotosView(boardNo);
				
				
				new Gson().toJson(board, resp.getWriter());
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
