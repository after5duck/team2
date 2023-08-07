package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Photo;

@WebServlet("/board/fanart/detail")
public class FanartDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			int boardCode = Integer.parseInt(req.getParameter("boardCode"));
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			System.out.println(memberNo);
	
			
			BoardService service = new BoardService();
			
			Board board = service.selectBoardWithPhotos2(boardNo, boardCode, memberNo);
			
			List<Board> boardList = service.selectBoardWithPhotos();
			
			//int likeCount = service.selectLikeCount(boardNo, memberNo);
			
			Board boardLike = service.selectListCount(boardNo, memberNo);

			req.setAttribute("board", board);
			req.setAttribute("boardList", boardList);
			req.setAttribute("boardLike", boardLike);
			//req.setAttribute("likeCount", likeCount);
			
			String path = "/WEB-INF/views/board/fanart-detail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
