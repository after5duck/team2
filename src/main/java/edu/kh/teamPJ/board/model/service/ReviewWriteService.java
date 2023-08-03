package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.commit;
import static edu.kh.teamPJ.common.JDBCTemplate.getConnection;
import static edu.kh.teamPJ.common.JDBCTemplate.rollback;

import java.sql.Connection;

import static edu.kh.teamPJ.common.JDBCTemplate.close;

import edu.kh.teamPJ.common.Util;
import edu.kh.teamPJ.board.model.dao.ReviewWriteDAO;
import edu.kh.teamPJ.board.model.vo.BoardDetail;

public class ReviewWriteService {

	private ReviewWriteDAO dao = new ReviewWriteDAO();
	
	/** 게시글 상세 조회
	 * @param boardNo
	 * @return write
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
	 * @return boardNo
	 * @throws Exception
	 */
	public int insertBoard(BoardDetail write, int boardCode) throws Exception{
		
		Connection conn = getConnection();
	      
	      // 1. 다음 작성할 게시글 번호 얻어오기
	      // -> BOARD 테이블 INSERT / BOARD_IMG 테이블 INSERT / 반환값 (상세조회 번호)
	      int boardNo = dao.nextBoardNo(conn);
	      
	      // 2. 게시글 부분만 삽입(detail, boardCode 사용)
	      write.setBoardNo(boardNo); // 조회된 다음 게시글 번호 세팅
	      
	      // 1) XSS 방지 처리(제목/내용)
	      write.setBoardTitle(Util.XSSHandling(write.getBoardTitle()));
	      write.setBoardContent(Util.XSSHandling(write.getBoardContent()));
	      
	      // 2) 개행 문자 처리(내용)
	      write.setBoardContent( Util.newLineHandling(write.getBoardContent()));
	      
	      int result = dao.insertBoard(conn, write, boardCode);
	 
	      
	      
	      if(result > 0) {
	         commit(conn);
	      }else { // 2, 3번에서 한 번이라도 실패한 경우
	         rollback(conn);
	         boardNo = 0; // 게시글 번호를 0으로 바꿔서 실패했음을 컨트롤러로 전달
	      }
	      
		
		return boardNo;
	}

	/** 게시글 수정 service
	 * @param write
	 * @param deleteList
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(BoardDetail write, String deleteList) throws Exception{
		
		Connection conn = getConnection();
	      
	      // 1. 게시글 부분(제목, 내용, 마지막 수정일) 수정
	      //    1) XSS 방지 처리(제목, 내용)
	      write.setBoardTitle(Util.XSSHandling(write.getBoardTitle()));
	      write.setBoardContent(Util.XSSHandling(write.getBoardContent()));
	      
	      //    2) 개행문자 처리(내용)
	      write.setBoardContent(Util.newLineHandling(write.getBoardContent()));
	      
	      //    3) DAO 호출
	      int result = dao.updateBoard(conn, write);
	      
	      
	      if(result > 0) commit(conn);
	      else         rollback(conn);
	      
	      close(conn);
	      
		
		return result;
	}

	/** 게시글 삭제 서비스 
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		
		return result;
	}

}
