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

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.service.MyPageContentListService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/mypage/contentList")
public class MypageContentListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		String path= "/WEB-INF/views/member/mypageContentList.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String boardContent = req.getParameter("boardContent");
		String boardTitle = req.getParameter("boardTitle");
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		//int boardCode = Integer.parseInt(req.getParameter("boardCode"));
		
		try {
			MyPageContentListService service = new MyPageContentListService();
			
			// content list 약자 -mpcList 
			List<Board> cList = service.MyPageContentList(boardContent, boardTitle, memberNo);
			
			new Gson().toJson(cList, resp.getWriter());
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
		
	}

}
