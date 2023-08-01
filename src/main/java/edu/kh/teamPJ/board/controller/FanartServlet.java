package edu.kh.teamPJ.board.controller;

import java.io.IOException;
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
import edu.kh.teamPJ.board.model.vo.Pagination;
import edu.kh.teamPJ.board.model.vo.Photo;

@WebServlet("/board/fanart")
public class FanartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			BoardService service = new BoardService();

			
			List<Board> boardList = service.selectBoardWithPhotos();
			
			
			req.setAttribute("boardList", boardList);


			String path = "/WEB-INF/views/board/fanart.jsp";


			req.getRequestDispatcher(path).forward(req, resp);;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
