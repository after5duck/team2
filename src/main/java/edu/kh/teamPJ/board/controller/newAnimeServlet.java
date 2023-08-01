package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Photo;

@WebServlet("/board/newAnime")
public class newAnimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
		
			BoardService service = new BoardService();
			
			// 신작 애니메이션 리스트
			List<Photo> newAnimeList = service.selectNewAnimeList();
			
			req.setAttribute("newAnimeList", newAnimeList);
			
			String path = "/WEB-INF/views/board/newAnime.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
