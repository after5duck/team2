package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.close;
import static edu.kh.teamPJ.common.JDBCTemplate.getConnection;
import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.ThemeDAO;
import edu.kh.teamPJ.board.model.dao.ThemeDetailDAO;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Photo;



public class ThemeDetailService {
  
private ThemeDetailDAO dao = new ThemeDetailDAO();

public List<Photo> selectSportsList() throws Exception{
	
	Connection conn = getConnection();
	
	List<Photo> sportsList = dao.selectSportsList(conn);
	
	close(conn);
	
	
	return null;
}
  
  
  
}
 
