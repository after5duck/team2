package edu.kh.teamPJ.board.model.vo;


public class DayDTO {

	private int boardNo;
	private String contentPath;
	private String boardTitle;
	
	
	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public DayDTO() {
		super();
	}


	public DayDTO(int boardNo, String contentPath, String boardTitle) {
		super();
		this.boardNo = boardNo;
		this.contentPath = contentPath;
		this.boardTitle = boardTitle;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getContentPath() {
		return contentPath;
	}


	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}


	@Override
	public String toString() {
		return "DayDTO [boardNo=" + boardNo + ", contentPath=" + contentPath + ", boardTitle=" + boardTitle + "]";
	}





}
