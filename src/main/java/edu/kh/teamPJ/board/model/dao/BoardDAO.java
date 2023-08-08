package edu.kh.teamPJ.board.model.dao;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.teamPJ.common.JDBCTemplate.*;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.board.model.vo.Modal;
import edu.kh.teamPJ.board.model.vo.ModalPhoto;
import edu.kh.teamPJ.board.model.vo.Pagination;
import edu.kh.teamPJ.board.model.vo.Photo;

public class BoardDAO {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Properties prop;

	public BoardDAO() {

		try {
			prop = new Properties();
			String filePath = DayDAO.class.getResource("/edu/kh/teamPJ/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * @author 이민주
	 * 
	 *         요일별 이미지, 모달창 이미지, 동영상 Service
	 * @param conn
	 * @return modalList
	 * @throws Exception
	 */
	// BoardService 클래스의 selectModalList() 메서드 수정
	public List<Modal> selectModalList(Connection conn) throws Exception {
		List<Modal> modalList = new ArrayList<>();

		try {
		
			String sql = prop.getProperty("selectModalList");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Modal modal = new Modal();
				modal.setBoardTitle(rs.getString("BOARD_TITLE"));
				modal.setGenre(rs.getString("GENRE"));
				modal.setBoardContent(rs.getString("BOARD_CONTENT"));
				modal.setStory(rs.getString("STORY"));
				modal.setDrawing(rs.getString("DRAWING"));
				modal.setReleaseDate(rs.getString("RELEASE_DT"));
				modal.setAge(rs.getString("AGE"));

				// 기존 코드와 그대로 유지...
				// Modal 객체에 해당하는 ModalPhoto 리스트를 생성
				List<ModalPhoto> modalPhotoList = new ArrayList<>();

				// ModalPhoto 정보를 가져와서 ModalPhoto 객체 생성 후 리스트에 추가

				ModalPhoto modalPhoto = new ModalPhoto();
				modalPhoto.setContentPath(rs.getString("CONTENT_PATH"));
				modalPhoto.setVideoPath(rs.getString("VIDEO_PATH"));

				modalPhotoList.add(modalPhoto);

				// ModalPhoto 리스트를 Modal 객체에 설정
				modal.setModalPhotoList(modalPhotoList);

				// 모든 ModalPhoto를 추가한 Modal을 modalList에 추가
				modalList.add(modal);

			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return modalList;
	}

	/**
	 * @author 이민주
	 * 
	 *         메인로고 사진 DAO
	 * @param conn
	 * @return mainPhotoList
	 * @throws Exception
	 */
	public List<Photo> selectMainPhotoList(Connection conn) throws Exception {
		List<Photo> mainPhotoList = new ArrayList<Photo>();
		try {
			String sql = prop.getProperty("selectMainPhotoList");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Photo mainPhoto = new Photo();

				mainPhoto.setContentPath(rs.getString("CONTENT_PATH"));
				mainPhoto.setBoardContent(rs.getString("BOARD_CONTENT"));

				mainPhotoList.add(mainPhoto);
				
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return mainPhotoList;
	}

	/**
	 * @author 이민주
	 * 
	 *         명장면 동영상 얻어오기 DAO
	 * @param conn
	 * @return vList
	 * @throws Exception
	 * 
	 */

	public List<Modal> selectVideoList(Connection conn) throws Exception {

		List<Modal> vList = new ArrayList<Modal>();

		try {

			String sql = prop.getProperty("selectVideoList");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Modal videoModal = new Modal();

				videoModal.setBoardTitle(rs.getString("BOARD_TITLE"));
				videoModal.setVideoPath(rs.getString("VIDEO_PATH"));

				vList.add(videoModal);

				
			}

		} finally {

			close(rs);
			close(pstmt);
		}

		return vList;
	}

	/**
	 * 이민주
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Photo> selectNewAnimeList(Connection conn) throws Exception {

		List<Photo> newAnimeList = new ArrayList<Photo>();

		try {

			String sql = prop.getProperty("selectNewAnimeList");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Photo newAnimePhoto = new Photo();

				newAnimePhoto.setContentPath(rs.getString("CONTENT_PATH"));
				newAnimePhoto.setBoardTitle(rs.getString("BOARD_TITLE"));
				newAnimePhoto.setBoardContent(rs.getString("BOARD_CONTENT"));

				//

				List<Modal> newAnimeModalList = new ArrayList<Modal>();

				Modal newAnimemodal = new Modal();

				newAnimemodal.setVideoPath(rs.getString("VIDEO_PATH"));
				newAnimemodal.setStory(rs.getString("STORY"));
				newAnimemodal.setDrawing(rs.getString("DRAWING"));
				newAnimemodal.setReleaseDate(rs.getString("RELEASE_DT"));
				newAnimemodal.setAge(rs.getString("AGE"));

				// modal리스트 추가
				newAnimeModalList.add(newAnimemodal);

				// photo에 modal리스트 추가
				newAnimePhoto.setModals(newAnimeModalList);

				// newAnimeList에 photo 추가
				newAnimeList.add(newAnimePhoto);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return newAnimeList;
	}

	/**
	 * 이민주 이미지 정보 얻어오는 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return pList
	 * @throws Exception
	 */

	public List<Photo> selectPhoto(Connection conn) throws Exception {

		List<Photo> pList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectPhoto");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Photo photo = new Photo();
				// photo.setImgPath(rs.getString("IMG_PATH"));
				photo.setBoardNo(rs.getInt("BOARD_NO"));

				pList.add(photo);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return pList;
	}

	/**
	 * 팬아트 모든 게시글 정보를 가져오는 DAO
	 * 
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoards(Connection conn) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectAllBoards");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReadCount(rs.getInt("READ_COUNT"));

				boardList.add(board);
			}

		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}

	/**
	 * 팬아트 게시글/이미지 정보 가져오는 DAO
	 * 
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardWithPhotos(Connection conn) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectBoardWithPhotos");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int boardNo = rs.getInt("BOARD_NO");

				Board board = new Board();
				board.setBoardNo(boardNo);
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setBoardCode(rs.getInt("BOARD_CD"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));

				if (rs.getString("CONTENT_PATH") != null) {

					Photo photo = new Photo();

					photo.setContentPath(rs.getString("CONTENT_PATH"));
					board.getPhotos().add(photo);
				}

				boardList.add(board);
			}

		} finally {

			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	/**
	 * 팬아트 게시글/이미지 정보 가져오는 DAO(boardNo 가져옴)
	 * 
	 * @param conn
	 * @param boardNo
	 * @param memberNo 
	 * @param type
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoardWithPhotos2(Connection conn, int boardNo, int boardCode, int memberNo) throws Exception {

		Board board = null;

		try {

			String sql = prop.getProperty("selectBoardWithPhotos2");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			

			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (board == null) {

					board = new Board();

					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setBoardContent(rs.getString("BOARD_CONTENT"));
					board.setCreateDate(rs.getString("CREATE_DT"));
					board.setReadCount(rs.getInt("READ_COUNT"));
					board.setMemberNickname(rs.getString("MEMBER_NICK"));
					board.setBoardCode(rs.getInt("BOARD_CD"));
					board.setMemberNo(rs.getInt("MEMBER_NO"));
				}

				String contentPath = rs.getString("CONTENT_PATH");

				if (contentPath != null) {

					Photo photo = new Photo();

					photo.setContentPath(contentPath);

					board.getPhotos().add(photo);
				}
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return board;
	}

	/**
	 * 팬아트 조회수 증가/게시글 정보 가져오기
	 * 
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int selectBoardWithPhotosView(Connection conn, int boardNo) throws Exception {

		int viewCount = 0;

		try {

			String sql = prop.getProperty("selectUpdateViewCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				viewCount = rs.getInt(1);

			}

		} finally {

			close(rs);
			close(pstmt);

		}

		return viewCount;
	}

	/**
	 * 팬아트 조회수 증가 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateViewCount(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("updateViewCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
	}

	/**
	 * 팬아트 게시글 다음번호 얻어오기
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception {

		int boardNo = 0;

		try {

			String sql = prop.getProperty("nextBoardNo");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardNo = rs.getInt(1);

			}

		} finally {

			close(rs);
			close(pstmt);
		}
		return boardNo;
	}

	/**
	 * 팬아트 게시판 작성하기
	 * 
	 * @param conn
	 * @param boardDetail
	 * @param boardCode
	 * @param memberNo 
	 * @return
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board boardDetail, int boardCode, int memberNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("fanartInsertBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardDetail.getBoardNo());
			pstmt.setString(2, boardDetail.getBoardTitle());
			pstmt.setString(3, boardDetail.getBoardContent());
			pstmt.setInt(4, boardDetail.getMemberNo());
			pstmt.setInt(5, boardCode);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;

	}

	/**
	 * 팬아트 게시판 등록 (이미지)
	 * 
	 * @param conn
	 * @param photos
	 * @return
	 * @throws Exception
	 */
	public int insertBoardImage(Connection conn, Photo pho, int boardNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("insertBoardImage");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			pstmt.setString(2, pho.getContentPath());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;

	}

	/**
	 * 팬아트 게시판 수정하기
	 * 
	 * @param conn
	 * @param boardDetail
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, Board boardDetail) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("fanartUpdateBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardDetail.getBoardTitle());
			pstmt.setString(2, boardDetail.getBoardContent());
			pstmt.setInt(3, boardDetail.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;

	}

	/**
	 * 팬아트 게시판 이미지 수정하기
	 * 
	 * @param conn
	 * @param pho
	 * @return
	 * @throws Exception
	 */
	public int updateBoardImage(Connection conn, Photo pho) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("fanartUpdateBoardImage");

			System.out.println("이미지 DAO");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pho.getContentPath());
			pstmt.setInt(2, pho.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 팬아트 게시판 이미지 삭제하기
	 * 
	 * @param conn
	 * @param deleteList
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoardImage(Connection conn, String deleteList, int boardNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("fanartDeleteBoardImage");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 팬아트 게시글 삭제 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("fanartDeleteBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}
		return result;

	}

	/**
	 * 이동호 이민주 게시글 상세 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception {

		BoardDetail detail = new BoardDetail();

		try {

			String sql = prop.getProperty("selectBoardDetail");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				detail.setBoardNo(rs.getInt(1));
				detail.setBoardTitle(rs.getString(2));
				detail.setBoardContent(rs.getString(3));
				detail.setCreateDate(rs.getString(4));
				detail.setReadCount(rs.getInt(5));
				detail.setMemberNo(rs.getInt(6));
				detail.setMemberNickname(rs.getString(7));
				detail.setProfileImage(rs.getString(8));
				detail.setBoardName(rs.getString(9));
				detail.setScore(rs.getInt(10));
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return detail;
	}

	/**
	 * 이동호 게시판 이름 조회
	 * 
	 * @param conn
	 * @param type
	 * @return result
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int type) throws Exception {

		String result = null;

		try {

			String sql = prop.getProperty("selectBoardName");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getString(1);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 이동호 특정 게시판 게시글 수 조회
	 * 
	 * @param conn
	 * @param type
	 * @return result
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("getListCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 이동호 게시글 목록 조회
	 * 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectBoardList");

			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + (pagination.getLimit()) - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickname(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));

				boardList.add(board);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	/**
	 * 이동호 특정 게시판에서 조건을 만족하는 게시글 수 조회 DAO
	 * 
	 * @param conn
	 * @param type
	 * @param condition
	 * @return result
	 * @throws Exception
	 */
	public int searchListCount(Connection conn, int type, String condition) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("searchListCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 이동호 특정 조건을 만족하는 게시글 조회
	 * 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param condition
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Connection conn, Pagination pagination, int type, String condition)
			throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {
			String sql = prop.getProperty("searchBoardList1") + condition + prop.getProperty("searchBoardList2");

			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start * pagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickname(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));

				boardList.add(board);

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	/**
	 * 좋아요 수 증가 DAO
	 * 
	 * @param boardNo
	 * @param memberNo
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int updateLikeCount(Connection conn, int boardNo, int memberNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("updateLikeCount");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);

			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 좋아요 수 조회 DAO
	 * 
	 * @param boardNo
	 * @param memberNo 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Board selectListCount(int boardNo, int memberNo, Connection conn) throws Exception {

		Board boardLike = new Board();

		try {

			String sql = prop.getProperty("selectLikeCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardLike.setBoardNo(boardNo);
				boardLike.setMemberNo(memberNo);
			}

		} finally {

			close(rs);
			close(pstmt);

		}

		return boardLike;
	}
	
	public int selectLikeCount(int boardNo, int memberNo, Connection conn) throws Exception {

		int likeCount = 0;

		try {

			String sql = prop.getProperty("selectLikeCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				likeCount = rs.getInt(1);
			}

		} finally {

			close(rs);
			close(pstmt);

		}

		return likeCount;
	}
	
	

	public List<Board> searchSearchArea(Connection conn, String inputSearch, int memberNo) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectMyContent") + " AND BOARD_TITLE LIKE %'" + inputSearch + "'%";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardName(rs.getString(1));
				board.setBoardTitle(rs.getString(2));
				board.setCreateDate(rs.getString(3));
			}

		} finally {

		}
		return boardList;
	}

	/**
	 * 날짜 검색 DAO
	 * 
	 * @param conn
	 * @param inputArea1
	 * @param inputArea2
	 * @return boardList
	 */
	public List<Board> searchInputDate(Connection conn, String inputArea1, String inputArea2) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("searchInputDate");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inputArea1);
			pstmt.setString(2, inputArea2);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardName(rs.getString(1));
				board.setBoardTitle(rs.getString(2));
				board.setCreateDate(rs.getString(3));

				boardList.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	

	/**
	 * 이민주
	 * 
	 * 게시글 전체 조회 DAO
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Board> searchBoard(Connection conn, String keyword) throws Exception {

		List<Board> searchResult = new ArrayList<>();

		try {

			String sql = prop.getProperty("searchKeywordBoards");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + keyword + "%"); // BOARD_TITLE 검색
			pstmt.setString(2, "%" + keyword + "%"); // BOARD_CONTENT 검색

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setBoardCode(rs.getInt("BOARD_CD"));
				board.setBoardName(rs.getString("BOARD_NM"));
				
				searchResult.add(board);

			}

		} finally {

			close(rs);
			close(pstmt);
		}

		return searchResult;
	}

	/**
	 * 마이페이지 내가 쓴 게시글 조회 DAO
	 * 
	 * @param conn
	 * @param memberNo
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyContent(Connection conn, int memberNo) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectMyContent");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt(1));
				board.setBoardName(rs.getString(2));
				board.setBoardTitle(rs.getString(3));
				board.setCreateDate(rs.getString(4));
				board.setBoardCode(rs.getInt(5));
				board.setMemberNo(rs.getInt(6));	

				boardList.add(board);
			}
			System.out.println(boardList);

		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰 게시글/이미지 정보 가져오는 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @param type
	 * @return
	 */
	public Board selectReviewWithPhotos(Connection conn, int boardNo, int type) throws Exception {

		Board reviewBoardImg = null;

		try {

			String sql = prop.getProperty("selectReviewWithPhotos");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (reviewBoardImg == null) {

					reviewBoardImg = new Board();

					reviewBoardImg.setBoardNo(rs.getInt("BOARD_NO"));
					reviewBoardImg.setBoardTitle(rs.getString("BOARD_TITLE"));
					reviewBoardImg.setBoardContent(rs.getString("BOARD_CONTENT"));
					reviewBoardImg.setCreateDate(rs.getString("CREATE_DT"));
					reviewBoardImg.setMemberNickname(rs.getString("MEMBER_NICK"));
					reviewBoardImg.setBoardCode(rs.getInt("BOARD_CD"));
					reviewBoardImg.setMemberNo(rs.getInt("MEMBER_NO"));

				}

				String reviewContentPath = rs.getString("CONTENT_PATH");

				if (reviewContentPath != null) {

					Photo reviewPhoto = new Photo();

					reviewPhoto.setContentPath(reviewContentPath);

					reviewBoardImg.getPhotos().add(reviewPhoto);
				}

			}

		} finally {

			close(rs);
			close(pstmt);

		}

		return reviewBoardImg;

	}

	/**
	 * 이민주 리뷰게시판 다음번호 얻어오기
	 * 
	 * @param conn
	 * @return
	 */
	public int nextReviewNo(Connection conn) throws Exception {

		int boardNo = 0;

		try {

			String sql = prop.getProperty("nextReviewNo");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardNo = rs.getInt(1);

			}
		} finally {

			close(rs);
			close(pstmt);
		}

		return boardNo;
	}

	/**
	 * 이민주 리뷰게시판 게시글 작성하기
	 * 
	 * @param conn
	 * @param reviewWrite
	 * @param type
	 * @return
	 */

	public int insertReviewBoard(Connection conn, Board reviewWrite, int type) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("reviewInsertBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reviewWrite.getBoardNo());
			pstmt.setString(2, reviewWrite.getBoardTitle());
			pstmt.setString(3, reviewWrite.getBoardContent());
			pstmt.setInt(4, reviewWrite.getMemberNo());
			pstmt.setInt(5, type);
			pstmt.setInt(6, reviewWrite.getScore());

			result = pstmt.executeUpdate();

		} finally {

		}
		return result;
	}

	/**
	 * 이민주 리뷰게시판 이미지 등록
	 * 
	 * @param conn
	 * @param reviewPh
	 * @param boardNo
	 * @return result
	 */
	public int insertReviewBoardImg(Connection conn, Photo reviewPh, int boardNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("insertReviewImage");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			pstmt.setString(2, reviewPh.getContentPath());

			result = pstmt.executeUpdate();

		} finally {

		}

		return result;

	}

	/**
	 * 이민주 리뷰게시판 수정하기
	 * 
	 * @param conn
	 * @param reviewWrite
	 * @return result
	 */

	public int updateReviewBoard(Connection conn, Board reviewWrite) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("reviewUpdateBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reviewWrite.getBoardTitle());
			pstmt.setString(2, reviewWrite.getBoardContent());
			pstmt.setInt(3, reviewWrite.getBoardNo());

			result = pstmt.executeUpdate();

			System.out.println("result의 값 : " + result);

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰게시판 이미지 수정하기
	 * 
	 * @param conn
	 * @param reviewPh
	 * @return
	 */
	public int updateReviewImg(Connection conn, Photo reviewPh) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("reviewUpdateBoardImg");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reviewPh.getContentPath());
			pstmt.setInt(2, reviewPh.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {

		}

		return result;
	}

	/**
	 * 이민주
	 * 
	 * 리뷰 게시판 이미지 삭제하기
	 * 
	 * @param conn
	 * @param deleteReviewList
	 * @param boardNo
	 * @return
	 */
	public int deleteReviewBoardImg(Connection conn, String deleteReviewList, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("reviewDeleteBoardImg");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
	}

	
	/**
	 * 이민주
	 * 
	 * 리뷰 게시판 삭제
	 * 
	 * @param conn
	 * @param boardNo
	 * @return result
	 */

	public int deleteReviewBoard(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("deleteReviewBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}
		return result;
	}
	
	/** 리뷰게시판 조회수
	 * 
	 * @param conn
	 * @param boardNo
	 * @return
	 */

	public int updateReadCount(Connection conn, int boardNo) throws Exception{

		int result = 0;
		
		try {
			
	
			String sql = prop.getProperty("updateReadCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally{
			
			close(pstmt);
		}
		
		return result;
	}

	public int selectReview(Connection conn, int boardNo) throws Exception{
		
		int readCount = 0;
		
		try {
			
			String sql = prop.getProperty("selectUpdateReadCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				readCount = rs.getInt(1);
			}
			
		}finally{
		
			close(rs);
			close(pstmt);
		}
		return readCount;
	}

	/** 팬아트 좋아요 해제 DAO
	 * @param conn
	 * @param boardNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int likeDelete(Connection conn, int boardNo, int memberNo) throws Exception{
		
		int result = 0;

		try {
			String sql = prop.getProperty("likeDelete");

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);

			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}

		return result;
	}

}
