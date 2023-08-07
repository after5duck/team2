package edu.kh.teamPJ.board.model.dao;

import static edu.kh.teamPJ.common.JDBCTemplate.close;
import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Modal;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.board.model.vo.Theme;


public class ThemeDetailDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ThemeDetailDAO() {
		try {
			prop = new Properties();
			
			String filePath = ThemeDAO.class.getResource("/edu/kh/teamPJ/sql/PJH-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @param conn
	 * @param boardNo 
	 * @param boardCode 
	 * @return sportsList
	 * @throws Exception
	 */
	public List<Theme> selectSportsList(Connection conn, int boardNo, int boardCode) throws Exception{
		
		List<Theme> sportsList = new ArrayList<Theme>();
		
		try {
			
			String sql = prop.getProperty("selectSportsList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardCode);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				Theme sports = new Theme();

				sports.setContentPath(rs.getString("CONTENT_PATH"));
				sports.setBoardTitle(rs.getString("BOARD_TITLE"));
				sports.setBoardContent(rs.getString("BOARD_CONTENT"));
				sports.setAge(rs.getString("AGE"));
				sports.setGenre(rs.getString("GENRE"));
				sports.setVideoPath(rs.getString("VIDEO_PATH"));
								
				
				sportsList.add(sports);

			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return sportsList;
	}



}
