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


/*
 * public class ThemeDetailService {
 * 
 * private ThemeDetailDAO dao = new ThemeDetailDAO();
 * 
 * public BoardDetail selectBoardDetail(int boardNo) throws Exception{
 * 
 * Connection conn = getConnection();
 * 
 * // 1) 게시글(BOARD 테이블) 관련 내용만 조회 BoardDetail detail =
 * dao.selectBoardDetail(conn, boardNo);
 * 
 * if(detail != null) { // 게시글 상세 조회 결과가 있을 경우
 * 
 * // 2) 게시글에 첨부된 이미지(BOARD_IMG 테이블) 조회 List<Photo> photoList =
 * dao.selectPhotoList(conn, boardNo);
 * 
 * // -> 조회된 photoList를 BoardDetail 객체에 세팅 detail.setPhotoList(photoList); }
 * 
 * close(conn);
 * 
 * return detail; }
 * 
 * 
 * }
 */
