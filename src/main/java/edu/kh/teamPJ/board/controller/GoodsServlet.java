package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.GoodsService;
import edu.kh.teamPJ.board.model.service.ThemeService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Theme;

@WebServlet("/board/goods")
public class GoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		try {
			GoodsService service = new GoodsService();
			
			List<Theme> goods = service.selectGoodsList();
			
			
//			String goodsSelect = req.getParameter("goods");
			
			req.setAttribute("goods", goods);
	         new Gson().toJson(goods , resp.getWriter());

			
			String path = "/WEB-INF/views/board/goods.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try {
//			GoodsService service = new GoodsService();
//			
//			List<Theme> goods = service.selectGoodsList();
//			
//			
////			String goodsSelect = req.getParameter("goods");
//			
//			req.setAttribute("goods", goods);
//	         new Gson().toJson(goods , resp.getWriter());
//			
//			System.out.println(goodsSelect);
//
//			
//			String path = "/WEB-INF/views/board/goods.jsp";
//			req.getRequestDispatcher(path).forward(req, resp);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//}
