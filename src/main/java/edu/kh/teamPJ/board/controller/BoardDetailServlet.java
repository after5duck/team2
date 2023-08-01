package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.service.ReplyService;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Reply;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      try {
         BoardService service = new BoardService();
         
         // 게시글 번호 얻어오기
         int boardNo = Integer.parseInt(req.getParameter("no"));
         System.out.println(boardNo);
         // 게시글 정보 + 이미지 리스트 조회
         
         BoardDetail detail = service.selectBoardDetail(boardNo);
         
         // 게시글 상세조회된 내용이 있을 경우 댓글 목록 조회
         // + 댓글 개수 조회
         if(detail != null) {
            List<Reply> rList = new ReplyService().selectReplyList(boardNo);
            req.setAttribute("rList", rList);
            
            int commentCount = new ReplyService().commentCount(boardNo);
            req.setAttribute("commentCount", commentCount);
         }
         
         req.setAttribute("detail", detail);
         
         String path = "/WEB-INF/views/board/reviewDetail.jsp";
         
         req.getRequestDispatcher(path).forward(req, resp);
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      
   }
   
}