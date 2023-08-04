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
 * @return sportsList
 * @throws Exception
 */
public List<Theme> selectSportsList(int boardNo) throws Exception{
	
	Connection conn = getConnection();
	
	List<Theme> sportsList = dao.selectSportsList(conn, boardNo);
	
	
	
	close(conn);
	
	
	return sportsList;
}

/**
 * @param boardNo
 * @param boardCode
 * @return detail
 * @throws Exception
 */
public List<Theme> selectDetail() throws Exception{
	
	Connection conn = getConnection();

	List<Theme> detail = dao.selectDetail(conn);
	
	close(conn);
	
	
	return detail;
}
  
  
  
}
 
