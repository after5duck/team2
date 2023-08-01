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


import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class GoodsDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public GoodsDAO() {
		try {
			prop = new Properties();
			
			String filePath = ThemeDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> selectGoodsList(Connection conn) throws Exception{
		
		List<Board> goods = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectGoodsList");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				
				List<Photo> goodsPhotoList = new ArrayList<>();
				
				Photo goodsList = new Photo();
				
				goodsList.setContentPath(rs.getString("CONTENT_PATH"));
				goodsPhotoList.add(goodsList);
				// 추가 완료!
				
				// 보드에 photo리스트 추가
				board.setPhotos(goodsPhotoList);
				
				// photo리스트가 추가되어 있는 board리스트 list에 추가
				goods.add(board);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return goods;
	}
}
