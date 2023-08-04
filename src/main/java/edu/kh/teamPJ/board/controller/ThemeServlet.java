package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.ThemeService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.board.model.vo.Theme;

@WebServlet("/board/theme")
public class ThemeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			ThemeService service = new ThemeService();

			List<Theme> list = service.selectThemeList();

			req.setAttribute("list", list);

			String path = "/WEB-INF/views/board/theme.jsp";

			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
