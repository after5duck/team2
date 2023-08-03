package edu.kh.teamPJ.member.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.dao.MyPageContentListDAO;


public class MyPageContentListService {
	
	MyPageContentListDAO dao = new MyPageContentListDAO();

	/** 내가쓴 게시글 목록 조회 채정은
	 * @param boardContent
	 * @param boardTitle
	 * @param memberNo
	 * @return cList
	 * @throws Exception
	 */
	public List<Board> MyPageContentList(String boardContent, String boardTitle, int memberNo) throws Exception {

		Connection conn = getConnection();
		
		List<Board> cList = dao.MyPageContentList(conn, boardContent, boardTitle, memberNo);
		
		close(conn);
		
		return cList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
