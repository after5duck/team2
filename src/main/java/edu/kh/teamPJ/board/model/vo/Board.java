package edu.kh.teamPJ.board.model.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private int readCount;
	private char boardStatus;
	
	private int boardCode;
	private int memberNo;
	private String memberNickname;

	private List<Photo> photos = new ArrayList<>(); 
	
	
	public Board(int boardNo, String boardTitle, String boardContent, String createDate, int readCount, char boardStatus,
			int boardCode, int memberNo, String memberNick, List<Photo> photos) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.readCount = readCount;
		this.boardStatus = boardStatus;
		this.boardCode = boardCode;
		this.memberNo = memberNo;
		this.memberNickname = memberNick;
		this.photos = photos;
	}





	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", createDate=" + createDate + ", readCount=" + readCount + ", boardStatus=" + boardStatus
				+ ", boardCode=" + boardCode + ", memberNo=" + memberNo + ", memberNickname=" + memberNickname + "]";
	}





	public int getBoardNo() {
		return boardNo;
	}





	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}





	public String getBoardTitle() {
		return boardTitle;
	}





	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}





	public String getBoardContent() {
		return boardContent;
	}





	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}





	public String getCreateDate() {
		return createDate;
	}





	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}





	public int getReadCount() {
		return readCount;
	}





	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}





	public char getBoardStatus() {
		return boardStatus;
	}





	public void setBoardStatus(char boardStatus) {
		this.boardStatus = boardStatus;
	}





	public int getBoardCode() {
		return boardCode;
	}





	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}





	public int getMemberNo() {
		return memberNo;
	}





	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}





	public String getMemberNickname() {
		return memberNickname;
	}





	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}





	public List<Photo> getPhotos() {
		return photos;
	}





	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}





	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}



}
