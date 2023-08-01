package edu.kh.teamPJ.board.model.vo;

public class ModalPhoto {

	private int boardNo;
	private String contentPath;
	private String type;
	private String videoPath;

	public ModalPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModalPhoto(int boardNo, String contentPath, String type, String videoPath) {
		super();
		this.boardNo = boardNo;
		this.contentPath = contentPath;
		this.type = type;
		this.videoPath = videoPath;
	}

	@Override
	public String toString() {
		return "ModalPhoto [boardNo=" + boardNo + ", contentPath=" + contentPath + ", type=" + type + ", videoPath="
				+ videoPath + "]";
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
