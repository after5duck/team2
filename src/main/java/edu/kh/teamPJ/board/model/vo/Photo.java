package edu.kh.teamPJ.board.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Photo {
	
	private String contentPath;
	private int boardNo;
	private String boardContent;
	private String boardTitle;
	
	private List<Modal> modals = new ArrayList<>(); 
	
	public List<Modal> getModals() {
		return modals;
	}
	public void setModals(List<Modal> modals) {
		this.modals = modals;
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
	
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	

}
