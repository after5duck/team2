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
import edu.kh.teamPJ.board.model.vo.Photo;


public class ThemeDetailDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ThemeDetailDAO() {
		try {
			prop = new Properties();
			
			String filePath = ThemeDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Photo> selectSportsList(Connection conn) throws Exception{
		
		List<Photo> sportsList = new ArrayList<Photo>();
		
		try {
			
			String sql = prop.getProperty("selectSportsList");
			
			pstmt = conn.prepareStatement(sql);
			
			
		}finally {
			
		}
		
		
		return sportsList;
	}

}
