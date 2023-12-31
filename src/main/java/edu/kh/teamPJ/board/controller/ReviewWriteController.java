package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.teamPJ.board.model.service.BoardService;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.common.MyRenamePolicy;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/board/review_write")
public class ReviewWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String mode = req.getParameter("mode"); // insert / update 구분

			if (mode.equals("update")) {

				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				int type = Integer.parseInt(req.getParameter("type"));

				Board reviewWrite = new BoardService().selectReviewWithPhotos(boardNo, type);

				// 개행 문자 처리 해제(<br> -> \n)
				reviewWrite.setBoardContent(reviewWrite.getBoardContent().replaceAll("<br>", "\n"));

				req.setAttribute("reviewWrite", reviewWrite);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String path = "/WEB-INF/views/board/review_write.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);

		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			
			String boardTitle = req.getParameter("boardTitle");
	        String boardContent = req.getParameter("boardContent");
	        String reviewStar = req.getParameter("reviewStar");
	        
	        int score = 0;

	        if (reviewStar != null) {
	            score = Integer.parseInt(reviewStar);
	            System.out.println("score에 담음");
	        }

	        int type = Integer.parseInt(req.getParameter("type"));

	        HttpSession session = req.getSession();

	        Member loginMember = (Member) session.getAttribute("loginMember");
	        int memberNo = loginMember.getMemberNo(); // 회원 번호
			Board reviewWrite = new Board();

			reviewWrite.setBoardTitle(boardTitle);
			reviewWrite.setBoardContent(boardContent);
			reviewWrite.setMemberNo(memberNo);
			reviewWrite.setScore(score);

			BoardService service = new BoardService();

			 String mode = req.getParameter("mode");
			 if (mode.equals("insert")) {

		            int boardNo = service.insertReviewBoard(reviewWrite, type);

		            String path = null;

		            if (boardNo > 0) {
		                
		                session.setAttribute("message", "리뷰가 등록되었습니다");
		                
		                resp.sendRedirect(req.getContextPath() + "/board/detail?boardNo="+boardNo+"&type=" + type);
		        
		            } else {

		                session.setAttribute("message", "리뷰 작성 실패ㅠㅠ");

		                path = req.getHeader("referer");
		                
		                resp.sendRedirect(path);
		            }
			}

			 if (mode.equals("update")) {

				    int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				    reviewWrite.setBoardNo(boardNo);

				    int result = service.updateReviewBoard(reviewWrite);

				    String path = null;

				    String message = null;

				    if (result > 0) {

				        path = req.getContextPath() +"/board/detail?boardNo="+boardNo+"&type=" + type;

				        message = "리뷰게시글이 수정되었습니다.";

				    } else {

				        path = req.getHeader("referer");

				        message = "리뷰 수정 실패ㅠㅠ";
				    }
				    session.setAttribute("message", message);
				    resp.sendRedirect(path);
				}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
