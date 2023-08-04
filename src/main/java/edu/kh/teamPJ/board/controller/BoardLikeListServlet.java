package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;

@WebServlet("/board/fanart/detail/likeCount")
public class BoardLikeListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

// 연수꺼 주석

//		try {
//			
//			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
//			
//			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
//			
//			BoardService service = new BoardService();
//			
//			int result = service.updateLikeCount(boardNo, memberNo);
//			
//			
//			if(result == 1) {
//				
//				int likeCount = service.selectLikeCount(boardNo);
//				
//				resp.getWriter().print(likeCount);
//				
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {

			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));

			BoardService service = new BoardService();
			int result = service.updateLikeCount(boardNo, memberNo);

			if (result == 1) {
				int likeCount = service.selectLikeCount(boardNo);
				resp.getWriter().print(likeCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "오류가 발생했습니다.");
		}
	}
}
