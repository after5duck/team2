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
public class MypageContentListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		String path = "/WEB-INF/views/member/myPageContentList.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}

	// 마이페이지에서 검색어로 검색했을때.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
