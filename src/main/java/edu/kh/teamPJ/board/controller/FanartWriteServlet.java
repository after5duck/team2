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

@WebServlet("/board/fanart/write")
public class FanartWriteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String mode = req.getParameter("mode");

			if(mode.equals("update")) {
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				int boardCode = Integer.parseInt(req.getParameter("boardCode"));

				Board boardDetail = new BoardService().selectBoardWithPhotos2(boardNo, boardCode);

				req.setAttribute("boardDetail", boardDetail);

			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		String path = "/WEB-INF/views/board/fanart-writer.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// 사진 작은것만 가능...
			int maxSize = 1024 * 1024 * 100; 

			HttpSession session = req.getSession(); 
			String root = session.getServletContext().getRealPath("/");
			String folderPath ="resources/images/fanArt-images/"; 
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

			String boardTitle = mpReq.getParameter("boardTitle");

			String boardContent = mpReq.getParameter("boardContent");
			
			int boardCode = Integer.parseInt(mpReq.getParameter("boardCode"));

			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			Board boardDetail = new Board();

			boardDetail.setBoardTitle(boardTitle);
			boardDetail.setBoardContent(boardContent);
			boardDetail.setMemberNo(memberNo);


			BoardService service = new BoardService();

			String mode = mpReq.getParameter("mode");

			if(mode.equals("insert")) {

				int boardNo = service.insertBoard(boardDetail, photos, boardCode);
				
				String path = null;

				if(boardNo > 0) {
					session.setAttribute("message", "게시글이 등록되었습니다.");

					path=req.getContextPath()+"/board/fanart/detail?boardNo=" + boardNo + "&boardCode=" + boardCode;

				}else {
					session.setAttribute("message", "게시글 등록 실패 ㅠㅠ");

					path = "fanart/write?mode=" + mode + "&boardCode=" + boardCode;

				}

				resp.sendRedirect(path);

			}

			if(mode.equals("update")) {

				int boardNo = Integer.parseInt(mpReq.getParameter("boardNo"));

				String deleteList = mpReq.getParameter("deleteList");

				boardDetail.setBoardNo(boardNo);

				int result = service.updateBoard(boardDetail, photos, deleteList);
				
				String path = null;

				String message = null;

				if(result > 0) { // 성공

					path = "detail?boardNo=" + boardNo + "&boardCode=" + boardCode;
					message = "게시글이 수정되었습니다.";

				}else {

					path = req.getHeader("referer"); 

					message = "게시글 수정 실패";
				}

				session.setAttribute("message", message);
				resp.sendRedirect(path);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}