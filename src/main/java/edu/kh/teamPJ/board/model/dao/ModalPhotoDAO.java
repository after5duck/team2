package edu.kh.teamPJ.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.teamPJ.common.JDBCTemplate.*;

import edu.kh.teamPJ.board.model.vo.ModalPhoto;

public class ModalPhotoDAO {
	
	private ModalPhoto modalPhoto;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Properties prop;
	
	public ModalPhotoDAO(ModalPhoto modalPhoto) {
		this.modalPhoto = modalPhoto;
	}
	
	  public ModalPhotoDAO() {
	        try {
	            prop = new Properties();
	            String filePath = DayDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
	            prop.loadFromXML(new FileInputStream(filePath));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	public List<ModalPhoto> getPhotoList(Connection conn) throws SQLException{
		List<ModalPhoto> photoList = new ArrayList<>();
		
		try {
			
			  String sql = prop.getProperty("selectModalList");
			  
		      pstmt = conn.prepareStatement(sql);
		      
		      rs = pstmt.executeQuery();

		        while (rs.next()) {
		           ModalPhoto mp = new ModalPhoto();
		           mp.setContentPath(rs.getString("CONTENT_PATH"));

		           photoList.add(mp);
		        }
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return photoList;
	}
	
	

}
