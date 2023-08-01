package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.ThemeDAO;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Photo;

public class ThemeService {

	private ThemeDAO dao = new ThemeDAO();

	public List<Board> selectThemeList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Board> list = dao.selectThemeList(conn);
		
		close(conn);
		
		return list;
	}

}
