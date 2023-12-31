package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;

@WebServlet("/board/fanart/detail/likeCount")
public class BoardLikeListServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
         
         int boardNo = Integer.parseInt(req.getParameter("boardNo"));
         
         int memberNo = Integer.parseInt(req.getParameter("memberNo"));
         
         BoardService service = new BoardService();
         
         int result = service.updateLikeCount(boardNo, memberNo);
         
         
         if(result == 1) {
            
            //int likeCount = service.selectLikeCount(boardNo, memberNo);
            
            Board boardLike = service.selectListCount(boardNo, memberNo);
            
            new Gson().toJson(boardLike, resp.getWriter());
            
            //resp.getWriter().print(likeCount);
            
         }
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}