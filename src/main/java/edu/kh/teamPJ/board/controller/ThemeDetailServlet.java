
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
@WebServlet("/board/theme_detail")
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
		

		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			int boardCode = 0;
			
			switch(boardNo) {
			
			case 44: boardCode = 7; break;
			case 45: boardCode = 8; break;
			case 46: boardCode = 9; break;
			case 47: boardCode = 10; break;
			case 48: boardCode = 11; break;
			case 49: boardCode = 12; break;
			case 50: boardCode = 13; break;
			case 51: boardCode = 14; break;
			case 52: boardCode = 15; break;
			
//			case 99 : boardCode = 16; break;
//			case 100: boardCode = 17; break;
//			case 101: boardCode = 18; break;
//			case 102: boardCode = 19; break;
//			case 103: boardCode = 20; break;
//			case 104: boardCode = 21; break;
//			case 105: boardCode = 22; break;
//			case 106: boardCode = 23; break;
//			case 107: boardCode = 24; break;
			}
			
			ThemeDetailService service = new ThemeDetailService();
			
//			if(command.equals("sports")) {
//				
//			}
			
//			List<Theme> head = service.selectDetail(boardNo, boardCode);
			
				
			List<Theme> sportsList = service.selectSportsList(boardNo, boardCode);
			
//			req.setAttribute("head", head);
			req.setAttribute("sportsList", sportsList);

			
			
			
			String path = "/WEB-INF/views/board/theme_detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
