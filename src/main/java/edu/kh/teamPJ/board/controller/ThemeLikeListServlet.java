package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.service.ThemeDetailService;
import edu.kh.teamPJ.board.model.vo.Board;

@WebServlet("/board/theme_detail/like")
public class ThemeLikeListServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
         int boardNo = Integer.parseInt(req.getParameter("boardNo"));
         
         int memberNo = Integer.parseInt(req.getParameter("memberNo"));
         
         ThemeDetailService service = new ThemeDetailService();
         
         int result = service.updateThemeLikeCount(boardNo, memberNo);
         
         
            
         new Gson().toJson(result, resp.getWriter());

            
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}