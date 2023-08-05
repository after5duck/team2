package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.board.model.service.BoardService;

@WebServlet("/board/review/delete")
public class ReviewDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int boardNo = Integer.parseInt(req.getParameter("boardNo"));

			int type = Integer.parseInt(req.getParameter("type"));

			int result = new BoardService().deleteReviewBoard(boardNo);

			HttpSession session = req.getSession();

			String path = null;

			String message = null;

			if(result > 0) {
				message = "게시글이 삭제 되었습니다.";
				path = req.getContextPath()+ "/board/review?boardCode=6";

			}else {

				message = "게시글 삭제에 실패했습니다.";
				path = req.getContextPath(); 
			}

			session.setAttribute("message", message);

			resp.sendRedirect(path);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
