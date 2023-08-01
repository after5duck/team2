package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.close;
import static edu.kh.teamPJ.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.dao.GoodsDAO;
import edu.kh.teamPJ.board.model.dao.ThemeDAO;
import edu.kh.teamPJ.board.model.vo.Board;

public class GoodsService {
	
	private GoodsDAO dao = new GoodsDAO();


	public List<Board> selectGoodsList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Board> goods = dao.selectGoodsList(conn);
		
		close(conn);
		
		return goods;
	}

}
