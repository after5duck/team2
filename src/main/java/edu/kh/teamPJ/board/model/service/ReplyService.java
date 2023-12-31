package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.ReplyDAO;
import edu.kh.teamPJ.board.model.vo.Reply;
import edu.kh.teamPJ.common.Util;

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
	public int insertReply(Reply reply) throws Exception{
		
		Connection conn = getConnection();
		
		reply.setReplyContent(Util.XSSHandling(reply.getReplyContent()));
		reply.setReplyContent(Util.newLineHandling(reply.getReplyContent()));
		
		int result = dao.insertReply(conn, reply);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 삭제 Service
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(int replyNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 댓글 수정 Service
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateReply(conn, replyNo, replyContent);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int countReply(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		int countComment = dao.countComment(conn, boardNo);
		
		close(conn);
		
		return countComment;
	}
   
	
}
