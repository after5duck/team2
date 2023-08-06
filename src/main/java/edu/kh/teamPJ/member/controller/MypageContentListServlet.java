package edu.kh.teamPJ.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
		
//		String uri = req.getRequestURI();
//		String contextPath = req.getContextPath();
//		String command = uri.substring((contextPath + "/member/mypage/searchList/").length());
		
		
		BoardService service = new BoardService();
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember"); 
		
		int memberNo = loginMember.getMemberNo();
		
		try {
			
			
			List<Board> boardList = service.selectMyContent(memberNo);
			System.out.println(boardList);

			req.setAttribute("bList", boardList);

			String path = "/WEB-INF/views/member/myPageContentList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

	//			if(command.equals("list")) {
	//				
	//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	//				
	//				String inputArea1 = req.getParameter("dateStart");
	//				String inputArea2 = req.getParameter("dateEnd");
	//				
	//				List<Board> boardList = service.searchInputDate(inputArea1, inputArea2);
	//				
	//				resp.getWriter().print(boardList);
	//				
	//			}
	//			
	//			if(command.equals("searchArea")) {
	//				
	//				
	//				String inputSearch = req.getParameter("inputSearch");
	//				
	//				List<Board> boardList = service.searchSearchArea(inputSearch, memberNo);
	//				
	//				new Gson().toJson(boardList, resp.getWriter());
	//				
	//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
