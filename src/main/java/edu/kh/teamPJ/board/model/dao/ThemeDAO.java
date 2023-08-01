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
import edu.kh.teamPJ.board.model.vo.Photo;


public class ThemeDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ThemeDAO() {
		try {
			prop = new Properties();
			
			String filePath = ThemeDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> selectThemeList(Connection conn) throws Exception{
		
		List<Board> list = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectThemeList");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				// 보드 리스트
				Board board = new Board();				
				
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				
				// photo 리스트 
				List<Photo> themePhotoList = new ArrayList<>();
				
				Photo photoList = new Photo();
				
				photoList.setContentPath(rs.getString("CONTENT_PATH"));
				themePhotoList.add(photoList);
				// 추가 완료!
				
				// 보드에 photo리스트 추가
				board.setPhotos(themePhotoList);
				
				// photo리스트가 추가되어 있는 board리스트 list에 추가
				list.add(board);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}