
package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.ThemeDetailService;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.board.model.vo.Theme;
// /board/theme_detail
@WebServlet("/board/theme/theme_detail")
public class ThemeDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		
//		String uri = req.getRequestURI();
//
//		String contextPath = req.getContextPath();
//
//		String command = uri.substring((contextPath + "/theme_detail/").length());
//
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		int boardCode = Integer.parseInt(req.getParameter("boardCode"));
		
		
		
		ThemeDetailService service = new ThemeDetailService();

		try {
			
//			if(command.equals("sports")) {
//				
//			}
			
			Theme detail = service.selectDetail(boardNo, boardCode);
			
			List<Theme> sportsList = service.selectSportsList();
			
			req.setAttribute("sportsList", sportsList);
			
			
			String path = "/WEB-INF/views/board/theme_detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
