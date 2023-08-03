package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.board.model.service.ReviewWriteService;


@WebServlet("/board/delete")
public class ReviewDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			int type = Integer.parseInt(req.getParameter("type"));
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			int result = new ReviewWriteService().deleteBoard(boardNo);
			
			HttpSession session = req.getSession();
			String path = null;
			String message = null;
			
			if(result > 0) { //성공
				message = "게시글이 삭제되었습니다.";
				path = "list?type=" + type; // 해당 게시판 목록 1페이지
					// list?type=2
						
			}else {// 실패
				message = "게시글 삭제에 실패했습니다.";
				path = req.getHeader("referer");
				// 상세 페이지 == 이전 요청 페이지 주소 == referer
				
			}
			
			session.setAttribute("message", message);
			
			resp.sendRedirect(path); 
			// -> 이건 언제 쓰는거지?!?!?! req.setAttribute(); 랑은 뭔 차이지???
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}

}
