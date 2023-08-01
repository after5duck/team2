package edu.kh.teamPJ.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.service.MemberService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/mypage/likeList")
public class SelectLikeListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = new MemberService();
		
		try {
			// 게시판 번호 매개변수로 전달하기 위해 파라미터 얻어오기
			int boardNo = Integer.parseInt( req.getParameter("boardNo"));
			
			// 좋아요 리스트 뽑아오기
			List<Board> likeList = service.selectLikeList(boardNo);
			
			req.setAttribute("likeList", likeList);

			// req에 정보를 담아서 해당 jsp로 위임
			String path = "${contextPath}/member/mypageSelectLike.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
