package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.ThemeDAO;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.Photo;
import edu.kh.teamPJ.board.model.vo.Theme;

public class ThemeService {

	private ThemeDAO dao = new ThemeDAO();

	public List<Theme> selectThemeList() throws Exception {

		Connection conn = getConnection();

		List<Theme> list = dao.selectThemeList(conn);

		close(conn);

		return list;
	}

}
