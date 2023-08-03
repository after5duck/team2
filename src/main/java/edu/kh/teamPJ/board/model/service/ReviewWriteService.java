package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.teamPJ.board.model.dao.BoardDAO;
import edu.kh.teamPJ.board.model.dao.ModalPhotoDAO;
import edu.kh.teamPJ.board.model.dao.ReviewWriteDAO;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Modal;
import edu.kh.teamPJ.board.model.vo.ModalPhoto;
import edu.kh.teamPJ.board.model.vo.Pagination;
import edu.kh.teamPJ.board.model.vo.Photo;

public class ReviewWriteService {

	private ReviewWriteDAO dao = new ReviewWriteDAO();
	
	/** 게시글 상세 조회
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception{
		
		 Connection conn = getConnection();
	      
	      // 1) 게시글(BOARD 테이블) 관련 내용만 조회
	      BoardDetail write = dao.selectBoardDetail(conn, boardNo);
	      
		
	      close(conn);
	      
		return write;
	}

	/** 게시글 등록
	 * @param write
	 * @param boardCode
	 * @return
	 * @throws Exception
	 */
	public int insertBoard(BoardDetail write, int boardCode) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 게시글 수정
	 * @param write
	 * @param deleteList
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(BoardDetail write, String deleteList) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

}
