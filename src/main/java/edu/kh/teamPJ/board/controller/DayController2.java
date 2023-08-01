package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.board.model.dao.DayDAO;
import edu.kh.teamPJ.board.model.dao.ModalPhotoDAO;
import edu.kh.teamPJ.board.model.service.BoardService;
import edu.kh.teamPJ.board.model.vo.DayDTO;
import edu.kh.teamPJ.board.model.vo.Modal;
import edu.kh.teamPJ.board.model.vo.ModalPhoto;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/test")
public class DayController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        DayDAO dayDAO = new DayDAO();
	        BoardService service = new BoardService();
	    
	        // 메인로고 사진
	        List<Photo> mainPhotoList = service.selectMainPhotoList();
	        
	        // 요일별 사진
	        List<DayDTO> dayList = dayDAO.getDayList();
	        
	        // 모달창 사진
	        List<Modal> modalList = service.selectModalList();
	        
	        // 명장면 동영상
	        List<Modal> bestVideoList = service.selectVideoList();
	        
	        req.setAttribute("mainPhotoList", mainPhotoList);
	        req.setAttribute("dayList", dayList);
	        req.setAttribute("modalList", modalList);
	        req.setAttribute("bestVideoList", bestVideoList);

	        // 로그인 정보를 가져와 세션에 저장
	        Member loginMember = (Member) req.getAttribute("loginMember");
	        if(loginMember != null) {
	            HttpSession session = req.getSession();
	            session.setAttribute("loginMember", loginMember);
	        }

	        String path = "index.jsp";
	        req.getRequestDispatcher(path).forward(req, resp);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
