package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.ReplyDAO;
import edu.kh.teamPJ.board.model.vo.Reply;

public class ReplyService {
	public ReplyDAO dao = new ReplyDAO();

	public List<Reply> selectReplyList(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Reply> rList = dao.selectReplyList(conn, boardNo);
		
		close(conn);
		
		return rList;
		
	}

	  /** 댓글 수 조회 이동호
    * @param boardNo
    * @return commnetCount
    * @throws Exception
    */
   public int commentCount(int boardNo) throws Exception{
      
      Connection conn = getConnection();
      
      int commentCount = dao.commentCount(conn, boardNo);
      
      close(conn);
      
      return commentCount;
   }

	/** 댓글 작성 Service
	 * @param replyContent
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(String replyContent, int boardNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertReply(conn, replyContent, boardNo, memberNo);
		
		close(conn);
		
		return result;
	}
   
	
}
