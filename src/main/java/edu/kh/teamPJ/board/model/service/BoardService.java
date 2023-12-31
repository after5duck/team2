package edu.kh.teamPJ.board.model.service;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.teamPJ.board.model.dao.BoardDAO;
import edu.kh.teamPJ.board.model.dao.ModalPhotoDAO;
import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Modal;
import edu.kh.teamPJ.board.model.vo.ModalPhoto;
import edu.kh.teamPJ.board.model.vo.Pagination;
import edu.kh.teamPJ.board.model.vo.Photo;

/**
 * @author 이민주
 * 
 *         요일별 이미지, 모달창 이미지, 동영상 Service
 * @return modalList
 * @throws Exception
 */

public class BoardService {

	BoardDAO dao = new BoardDAO();
	ModalPhotoDAO mdao = new ModalPhotoDAO();

	public List<Modal> selectModalList() throws Exception {

		System.out.println("service시작");
		Connection conn = getConnection();

		List<Modal> modalList = dao.selectModalList(conn);

		close(conn);

		return modalList;
	}

	/**
	 * @author 이민주 메인페이지 로고 사진 Service
	 * 
	 * @return mainPhotoList
	 * @throws Exception
	 */

	public List<Photo> selectMainPhotoList() throws Exception {

		Connection conn = getConnection();

		List<Photo> mainPhotoList = dao.selectMainPhotoList(conn);

		close(conn);

		return mainPhotoList;
	}

	/**
	 * @author 이민주
	 * 
	 *         명장면 동영상 얻어오기 Service
	 * @return vList
	 * @throws Exception
	 */
	public List<Modal> selectVideoList() throws Exception {

		Connection conn = getConnection();

		List<Modal> vList = dao.selectVideoList(conn);

		close(conn);

		return vList;

	}

	/**
	 * @author 이민주
	 * 
	 *         이미지 얻어오는 Service
	 * @param boardNo
	 * @return pList
	 * @throws Exception
	 */

	public List<Photo> selectPhoto() throws Exception {

		Connection conn = getConnection();

		List<Photo> pList = dao.selectPhoto(conn);

		close(conn);

		return pList;
	}

	/**
	 * @author 이민주
	 * 
	 *         신작 애니메이션 조회 Service
	 *
	 */
	public List<Photo> selectNewAnimeList() throws Exception {

		Connection conn = getConnection();

		List<Photo> newAnimeList = dao.selectNewAnimeList(conn);

		close(conn);

		return newAnimeList;
	}

	/**
	 * 팬아트 모든 게시글 정보를 가져오는 Service
	 * 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectAllBoards() throws Exception {
		Connection conn = getConnection();

		List<Board> bList = dao.selectAllBoards(conn);

		close(conn);

		return bList;
	}

	/**
	 * 팬아트 게시글/이미지 정보 가져오는 Service
	 * 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardWithPhotos() throws Exception {

		Connection conn = getConnection();

		List<Board> boardList = dao.selectBoardWithPhotos(conn);

		close(conn);

		return boardList;
	}

	/**
	 * 팬아트 게시글 상세페이지 이미지 가져오기 Service
	 * 
	 * @param boardNo
	 * @param boardCode
	 * @param memberNo 
	 * @param type
	 * @return boardPhoto
	 * @throws Exception
	 */
	public Board selectBoardWithPhotos2(int boardNo, int boardCode, int memberNo) throws Exception {

		Connection conn = getConnection();

		Board board = dao.selectBoardWithPhotos2(conn, boardNo, boardCode, memberNo);

		close(conn);

		return board;
	}

	/**
	 * 팬아트 조회수 가져오기 Service
	 * 
	 * @param boardNo
	 * @param type
	 * @return boardPhoto
	 * @throws Exception
	 */
	public int selectBoardWithPhotosView(int boardNo) throws Exception {

		Connection conn = getConnection();

		int viewCount = dao.selectBoardWithPhotosView(conn, boardNo);

		close(conn);

		return viewCount;
	}

	/**
	 * 팬아트 조회수 증가 Service
	 * 
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateViewCount(int boardNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateViewCount(conn, boardNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	/**
	 * 팬아트 게시글 작성하기
	 * 
	 * @param boardDetail
	 * @param photos
	 * @param boardCode
	 * @param memberNo 
	 * @return
	 * @throws Exception
	 */
	public int insertBoard(Board boardDetail, List<Photo> photos, int boardCode, int memberNo) throws Exception {

		Connection conn = getConnection();

		int boardNo = dao.nextBoardNo(conn);

		boardDetail.setBoardNo(boardNo);

		int result = dao.insertBoard(conn, boardDetail, boardCode, memberNo);

		if (result > 0) {

			for (Photo pho : photos) {

				pho.setBoardNo(boardNo);

				result = dao.insertBoardImage(conn, pho, boardNo);

				if (result == 0) {
					break;

				}

			}

		}

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
			boardNo = 0;
		}

		close(conn);

		return boardNo;
	}

	/**
	 * 팬아트 게시판 수정하기
	 * 
	 * @param boardDetail
	 * @param photoList
	 * @param deleteList
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(Board boardDetail, List<Photo> photos, String deleteList) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateBoard(conn, boardDetail);

		if (result > 0) {

			for (Photo pho : photos) {

				pho.setBoardNo(boardDetail.getBoardNo());

				result = dao.updateBoardImage(conn, pho);

				if (result == 0) {
					result = dao.insertBoardImage(conn, pho, result);

				}

			}

			if (!deleteList.equals("")) {
				result = dao.deleteBoardImage(conn, deleteList, boardDetail.getBoardNo());

			}

		}

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/**
	 * 팬아트 게시글 삭제 Service
	 * 
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.deleteBoard(conn, boardNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/**
	 * 이동호 게시판 상세 조회 Service
	 * 
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception {

		Connection conn = getConnection();

		BoardDetail detail = dao.selectBoardDetail(conn, boardNo);

		close(conn);

		return detail;
	}

	/**
	 * 이동호 게시판 목록 조회 Service
	 * 
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(int type, int cp) throws Exception {

		Connection conn = getConnection();

		// 1. 게시판 이름 조회 DAO
		String boardName = dao.selectBoardName(conn, type);

		// 2. 특정 게시판 전체 게시글 수 조회 DAO
		int listCount = dao.getListCount(conn, type);

		Pagination pagination = new Pagination(cp, listCount);

		// 3. 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(conn, pagination, type);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);

		close(conn);

		return map;
	}

	/**
	 * 이동호 특정 게시글 목록 조회
	 * 
	 * @param type
	 * @param cp
	 * @param key
	 * @param query
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> searchBoardList(int type, int cp, String key, String query) throws Exception {

		Connection conn = getConnection();

		// 1. 게시판 이름 조회 DAO
		String boardName = dao.selectBoardName(conn, type);

		// 2. SQL 조건절에 추가될 구문 가공
		String condition = null;

		switch (key) {
		case "date":
			condition = " AND CREATE_DT '%" + query + "%' ";
			break;
		case "title":
			condition = " AND BOARD_TITLE LIKE '%" + query + "%' ";
			break;
		case "author":
			condition = " AND MEMBER_NICK LIKE '%" + query + "%' ";
			break;
		}

		// 3. 특정 게시판에서 조건을 만족하는 게시글 수 조회
		int listCount = dao.searchListCount(conn, type, condition);

		Pagination pagination = new Pagination(cp, listCount);

		// 4. 특정 게시판에서 조건을 만족하는 게시글 목록 조회
		List<Board> boardList = dao.searchBoardList(conn, pagination, type, condition);

		Map<String, Object> map = new HashMap<>();

		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);

		close(conn);

		return map;
	}

	/**
	 * 좋아요 수 증가
	 * 
	 * @param boardNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int updateLikeCount(int boardNo, int memberNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateLikeCount(conn, boardNo, memberNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;

	}

	/**
	 * 좋아요 수 조회 Service
	 * 
	 * @param boardNo
	 * @param memberNo 
	 * @return
	 * @throws Exception
	 */
	
	 public int selectLikeCount(int boardNo, int memberNo) throws Exception {
	  
	 Connection conn = getConnection();
	 
	 int likeCount = dao.selectLikeCount(boardNo, memberNo, conn);
	  
	 close(conn);
	 
	 return likeCount; }
	 
	
	/** 정연수 좋아요 삭제
	 * @param boardNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int likeDelete(int boardNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();

		int result = dao.likeDelete(conn, boardNo, memberNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/** 좋아요 수 조회(Board board)
	 * @param boardNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public Board selectListCount(int boardNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();

		Board boardLike = dao.selectListCount(boardNo, memberNo, conn);

		close(conn);

		return boardLike;
		
	}

	/**
	 * 이민주
	 * 
	 * 게시글 전체 조회 Service
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Board> searchBoard(String keyword) throws Exception {

		Connection conn = getConnection();

		BoardDAO dao = new BoardDAO();

		List<Board> searchResult = dao.searchBoard(conn, keyword);

		// 커넥션 반환
		conn.close();

		return searchResult;
	}

	/**
	 * 내가 쓴 게시글 조회
	 * 
	 * @param memberNo
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyContent(int memberNo) throws Exception {

		Connection conn = getConnection();

		List<Board> boardList = dao.selectMyContent(conn, memberNo);

		close(conn);

		return boardList;
	}	

	/**
	 * 이동호
	 * 
	 * 날짜 검색 Service
	 * 
	 * @param inputArea1
	 * @param inputArea2
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchInputDate(String inputArea1, String inputArea2) throws Exception {

		Connection conn = getConnection();

		List<Board> boardList = dao.searchInputDate(conn, inputArea1, inputArea2);

		close(conn);

		return boardList;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰게시판 가져오기 Service
	 * 
	 * @param boardNo
	 * @param boardCode
	 * @return
	 */
	public Board selectReviewWithPhotos(int boardNo, int type) throws Exception {

		Connection conn = getConnection();

		Board reviewBoardImg = dao.selectReviewWithPhotos(conn, boardNo, type);

		close(conn);

		return reviewBoardImg;
	}

	/**
	 * 이민주 리뷰 게시글 작성
	 * 
	 * @param reviewWrite
	 * @param type
	 * @return
	 */

	public int insertReviewBoard(Board reviewWrite, int type) throws Exception {

		Connection conn = getConnection();

		int boardNo = dao.nextReviewNo(conn);

		reviewWrite.setBoardNo(boardNo);

		int result = dao.insertReviewBoard(conn, reviewWrite, type);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
			boardNo = 0;
		}

		close(conn);

		return boardNo;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰 게시판 수정하기
	 * 
	 * @param reviewWrite
	 * @return result
	 * @throws Exception
	 */
	public int updateReviewBoard(Board reviewWrite) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateReviewBoard(conn, reviewWrite);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	/**
	 * 마이페이지 특정 게시글 검색
	 * 
	 * @param inputSearch
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchSearchArea(String inputSearch, int memberNo) throws Exception {

		Connection conn = getConnection();

		List<Board> boardList = dao.searchSearchArea(conn, inputSearch, memberNo);

		close(conn);

		return boardList;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰게시판 삭제
	 * 
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReviewBoard(int boardNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.deleteReviewBoard(conn, boardNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰게시판 조회수 관련
	 * 
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReadCount(int boardNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateReadCount(conn, boardNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
	
	/**
	 * 이민주
	 * 
	 * 리뷰게시판 조회수 관련
	 * 
	 * @param boardNo
	 * @return readCount
	 * @throws Exception
	 */
	public int selectReview(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		int readCount = dao.selectReview(conn, boardNo);
		
		close(conn);
		
		return readCount;
	}

	public List<Board> selectLikeList(int memberNo) {
		Connection conn = getConnection();
		
		List<Board> likeList = dao.selectLikeList(conn, memberNo);
		
		close(conn);
		
		return likeList;
	}

	

	
}
