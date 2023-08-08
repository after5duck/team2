package edu.kh.teamPJ.board.model.dao;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.teamPJ.board.model.dao.BoardDAO;
import edu.kh.teamPJ.board.model.vo.Reply;

public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReplyDAO() {
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/edu/kh/teamPJ/sql/reply-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 이동호 
	 * 
	 * 게시글 댓글 목록 조회
	 * @param conn
	 * @param boardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{
		
		List<Reply> rList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectReplyList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply();
				
				reply.setReplyNo(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setCreateDate(rs.getString(3));
				reply.setBoardNo(rs.getInt(4));
				reply.setMemberNo(rs.getInt(5));
				reply.setMemberNickname(rs.getString(6));
				reply.setProfileImage(rs.getString(7));
				
				rList.add(reply);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return rList;
	}

	/** 댓글 수 조회 이동호
	    * @param conn
	    * @param boardNo
	    * @return result
	    * @throws Exception
	    */
	   public int commentCount(Connection conn, int boardNo) throws Exception{
	      
	      int result = 0;
	      
	      try {
	         String sql = prop.getProperty("commentCount1");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, boardNo);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            result = rs.getInt(1);
	         }
	         
	      }finally {
	         close(rs);
	         close(pstmt);
	      }

	      return result;
	   }

	/** 댓글 작성 DAO
	 * @param conn
	 * @param replyContent
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result = pstmt.executeUpdate();			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 댓글 삭제 DAO
	 * @param conn
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, int replyNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 댓글 수정 DAO
	 * @param conn
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Connection conn, int replyNo, String replyContent) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateReply");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int countComment(Connection conn, int boardNo) throws Exception{
		
		int countComment = 0;
		
		try {
			
			String sql = prop.getProperty("commentCount1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			countComment = rs.getInt(1);
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return 0;
	}
	
}
