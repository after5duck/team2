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
import edu.kh.teamPJ.board.model.vo.Theme;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Theme> selectThemeList(Connection conn) throws Exception {

		List<Theme> list = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectThemeList");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Theme theme = new Theme();

				theme.setContentPath(rs.getString("CONTENT_PATH"));
				theme.setBoardTitle(rs.getString("BOARD_TITLE"));
				theme.setBoardContent(rs.getString("BOARD_CONTENT"));
				theme.setBoardNo(rs.getInt("BOARD_NO"));
				theme.setBoardCode(rs.getInt("BOARD_CD"));

				list.add(theme);

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

}