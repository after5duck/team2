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

import edu.kh.community.common.MyRenamePolicy;
import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.service.ReviewWriteService;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/board/review_write")
public class ReviewWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String mode = req.getParameter("mode"); // insert / update 구분

			if (mode.equals("update")) {

				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				int boardCode = Integer.parseInt(req.getParameter("boardCode"));

				BoardDetail write = new ReviewWriteService().selectBoardDetail(boardNo, boardCode);

				// 개행 문자 처리 해제(<br> -> \n)
				write.setBoardContent(write.getBoardContent().replaceAll("<br>", "\n"));

				req.setAttribute("reviewWrite", reviewWrite);

			}

			String path = "/WEB-INF/views/board/review_write.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);

			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// insert/update 구분 없이 전달 받은 파라미터 모두 꺼내서 정리하기
			int maxSize = 1024 * 1024 * 100; 
			
			HttpSession session = req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath ="resources/images/review-images/"; 
			String filePath = root + folderPath;
			
			String encoding = "UTF-8";

			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			Enumeration<String> files = mpReq.getFileNames();
			
			List<Photo> photos = new ArrayList<Photo>();
			
			while(files.hasMoreElements()) { 
				
				String name = files.nextElement(); 

				String rename = mpReq.getFilesystemName(name);

				if(rename != null) {

					Photo photo = new Photo();

					photo.setContentPath(rename);
					
					photos.add(photo);

				}
			}
			
		
			String boardTitle = req.getParameter("boardTitle");
			
			String boardContent = req.getParameter("boardContent");
			
			int boardCode = Integer.parseInt(mpReq.getParameter("boardCode"));

			Member loginMember = (Member) session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo(); // 회원 번호

			Board reviewWrite = new Board();

			reviewWrite.setBoardTitle(boardTitle);
			reviewWrite.setBoardContent(boardContent);
			reviewWrite.setMemberNo(memberNo);
			
			BoardService service = new BoardService();
			
			String mode = mpReq.getParameter("mode");
			
			if(mode.equals("insert")) {
				
				int boardNo = service.insertReviewBoard(reviewWrite, photos, boardCode);
				
				String path = null;
				
				if(boardNo > 0) {
					session.setAttribute("message", "리뷰가 등록되었습니다");
					path=req.getContextPath()+"/board/review_write?boardNo=" + boardNo + "&boardCode=" + boardCode;
				
				}else {
					
					session.setAttribute("message", "리뷰 작성 실패ㅠㅠ");
					
					path = req.getHeader("referer");
				}
					
				}
				
			}

			// ---------------------- 게시글 작성에 필요한 기본 파라미터 얻어오기 끝 --------------------

			
			
			
			// ---------------------------------------------------------------------------------------------------------
			
		 catch (Exception e) {
			e.printStackTrace();
		}

	}
