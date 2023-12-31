package edu.kh.teamPJ.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.teamPJ.common.JDBCTemplate.*;
import edu.kh.teamPJ.board.model.vo.DayDTO;
import edu.kh.teamPJ.board.model.vo.boardDTO;

public class DayDAO {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Properties prop;

	public DayDAO() {
		try {
			prop = new Properties();
			String filePath = DayDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 요일별 게시글 이미지 리스트 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return imageList
	 * @throws Exception
	 * 
	 */
	public List<DayDTO> getDayList() {

		List<DayDTO> imageList = new ArrayList<>();

		try {

			Connection conn = getConnection();

			String sql = prop.getProperty("getDayList");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				DayDTO dayDTO = new DayDTO();

				dayDTO.setContentPath(rs.getString("CONTENT_PATH"));
				dayDTO.setBoardTitle(rs.getString("BOARD_TITLE"));

				imageList.add(dayDTO);

				if (imageList == null) {

				} else {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return imageList; // imageList 반환

	}

	// 자원반환 메소드

	private void closeResources() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("자원 해제 에러");
			e.printStackTrace();
		}
	}
}
