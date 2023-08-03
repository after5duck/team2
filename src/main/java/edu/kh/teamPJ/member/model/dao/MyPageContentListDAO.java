package edu.kh.teamPJ.member.model.dao;

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


public class MyPageContentListDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MyPageContentListDAO() {
		try {
			prop = new Properties();
			
			String filePath = MyPageContentListDAO.class.getResource("/edu/kh/teamPJ/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 내가 쓴 게시글 목록 조회
	 * @author 채정은
	 *
	 */
	
	
	
	

}
