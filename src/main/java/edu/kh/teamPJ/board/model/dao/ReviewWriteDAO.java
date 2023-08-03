package edu.kh.teamPJ.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.teamPJ.board.model.dao.BoardDAO;
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

	/**
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
}
