package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.ReplyService;
import edu.kh.teamPJ.board.model.vo.Reply;

@WebServlet("/member/reply/*")
public class ReplyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/reply/").length());
		
		ReplyService service = new ReplyService();
		
		try {
			
			// 댓글 조회
			if(command.equals("selectReplyList")) {
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				List<Reply> replyList = service.selectReplyList(boardNo); 
				
				new Gson().toJson(replyList, resp.getWriter());
				
			}
			
			// 댓글 작성
			if(command.equals("insert")) {
				String replyContent = req.getParameter("replyContent");
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				int	memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				int result = service.insertReply(replyContent, boardNo, memberNo);
				
				resp.getWriter().print(result);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
