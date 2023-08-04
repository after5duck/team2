package edu.kh.teamPJ.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.service.MyPageContentListService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/mypage/contentList")
public class MypageContentListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService service = new BoardService();
		
		try {
			
			HttpSession session = req.getSession();

			Member loginMember = (Member)session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo(); 
			
			List<Board> boardList = service.selectMyContent(memberNo);
			System.out.println(boardList);
			
			req.setAttribute("bList", boardList);
			
			String path = "/WEB-INF/views/member/myPageContentList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
