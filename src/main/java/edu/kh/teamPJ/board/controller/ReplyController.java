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

@WebServlet("/reply/*")
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
				
				int commentCount = service.commentCount(boardNo);
				
				new Gson().toJson(replyList, resp.getWriter());
				
			}
			
			// 댓글 작성
			if(command.equals("insert")) {
				String replyContent = req.getParameter("replyContent");
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				int	memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				Reply reply = new Reply();
				reply.setReplyContent(replyContent);
				reply.setBoardNo(boardNo);
				reply.setMemberNo(memberNo);
				
				int result = service.insertReply(reply);
				
				System.out.println(result);
				
				resp.getWriter().print(result);
			}
			
			// 댓글 삭제
			if(command.equals("delete")) {
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				
				int result = service.deleteReply(replyNo);
				
				resp.getWriter().print(result);
			}
			
			// 댓글 수정
			if(command.equals("update")) {
				
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				String replyContent = req.getParameter("replyContent");
				
				int result = service.updateReply(replyNo, replyContent);
				
				resp.getWriter().print(result);
			}
			
			// 댓글 개수
			if(command.equals("countComment")) {

				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				int countComment = service.countReply(boardNo);
				
				resp.getWriter().print(countComment);
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
