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
import edu.kh.teamPJ.board.model.vo.Theme;



public class ThemeDetailService {
  
private ThemeDetailDAO dao = new ThemeDetailDAO();



/**
 * @param boardNo 
 * @param boardCode 
 * @return sportsList
 * @throws Exception
 */
public List<Theme> selectSportsList(int boardNo, int boardCode) throws Exception{
	
	Connection conn = getConnection();
	
	List<Theme> sportsList = dao.selectSportsList(conn, boardNo, boardCode);
	
	
	
	close(conn);
	
	
	return sportsList;
}

/**
 * @param boardNo 
 * @param boardNo
 * @param boardCode
 * @return detail
 * @throws Exception
 */
public List<Theme> selectDetail(int boardCode) throws Exception{
	
	Connection conn = getConnection();

	List<Theme> detail = dao.selectDetail(conn, boardCode);
	
	close(conn);
	
	
	return detail;
}
  
  
  
}
 
