package edu.kh.teamPJ.board.model.dao;

import static edu.kh.teamPJ.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.teamPJ.board.model.vo.BoardDetail;

public class ReviewWriteDAO {
	
	private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   private Properties prop;
	   
	   public ReviewWriteDAO() {
	      try {
	         prop = new Properties();
	         
	         String filePath = BoardDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
	         
	         prop.loadFromXML(new FileInputStream(filePath));
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }

	   }

	/** 게시글 상세 조회 dao
	 * @param conn
	 * @param boardNo
	 * @return write
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception{
		
		BoardDetail write = null;
	      
	      try {
	         
	         String sql = prop.getProperty("selectBoardDetail");
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, boardNo);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            write = new BoardDetail();
	               
	               write.setBoardNo(rs.getInt(1));
	               write.setBoardTitle(rs.getString(2));
	               write.setBoardContent(rs.getString(3));
	               write.setCreateDate(rs.getString(4));
	               write.setReadCount(rs.getInt(5));
	               write.setMemberNickname(rs.getString(6));
	               write.setProfileImage(rs.getString(7));
	               write.setMemberNo(rs.getInt(8));
	         }
	      }finally {
	         close(rs);
	         close(pstmt);
	      }
		return write;
	}

	/** 다음 게시글 번호 조회 dao
	 * @param conn
	 * @return boardNo
	 */
	public int nextBoardNo(Connection conn) throws Exception {
		
		int boardNo = 0;
	      
	      try {
	         String sql = prop.getProperty("nextBoardNo");
	         
	         stmt = conn.createStatement();
	         
	         rs = stmt.executeQuery(sql);
	         
	         if(rs.next()) {
	            boardNo = rs.getInt(1);
	         }
	         
	      }finally {
	         close(rs);
	         close(stmt);
	      }
	      
		
		return boardNo;
	}

	/** 게시글 삽입 DAO
	 * @param conn
	 * @param write
	 * @param boardCode
	 * @return result
	 */
	public int insertBoard(Connection conn, BoardDetail write, int boardCode) throws Exception{
		
		int result = 0;
	      
	      try {
	    	  	String sql = prop.getProperty("insertBoard");
	         
	         	pstmt = conn.prepareStatement(sql);
	         	
	         	pstmt.setInt(1, write.getBoardNo());
	         	pstmt.setString(2, write.getBoardTitle());
	          	pstmt.setString(3, write.getBoardContent());
	          	pstmt.setInt(4, write.getMemberNo());
	          	
	          	result = pstmt.executeUpdate();
	          	
	      }finally {
	    	  	close(pstmt);
	      }
		
	      return result;
	}

	/** 게시글 수정 dao
	 * @param conn
	 * @param write
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, BoardDetail write) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, write.getBoardTitle());
			pstmt.setString(2, write.getBoardContent());
			pstmt.setInt(3, write.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 게시글 삭제 dao
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		
		return result;
	}
}
