package edu.kh.teamPJ.board.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Modal {

	private String boardTitle;
	private String boardContent;
	private String story;
	private String drawing;
	private String releaseDate;
	private String age;
	private String genre;
	private String boardCode;
	private String videoPath;
	
	
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	
	private List<ModalPhoto> modalPhotoList = new ArrayList<>();
	
	public Modal() {
		super();
	}
	public Modal(String boardTitle, String boardContent, String story, String drawing, String releaseDate, String age,
			String genre, String boardCode) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.story = story;
		this.drawing = drawing;
		this.releaseDate = releaseDate;
		this.age = age;
		this.genre = genre;
		this.boardCode = boardCode;
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
	
	public String getStory() {
		return story;
	}
	
	public void setStory(String story) {
		this.story = story;
	}
	
	public String getDrawing() {
		return drawing;
	}
	
	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public List<ModalPhoto> getModalPhotoList() {
		return modalPhotoList;
	}
	public void setModalPhotoList(List<ModalPhoto> modalPhoto) {
		this.modalPhotoList = modalPhoto;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getBoardCode() {
		return boardCode;
	}
	
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	
	@Override
	public String toString() {
		return "Modal [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", story=" + story + ", drawing="
				+ drawing + ", releaseDate=" + releaseDate + ", age=" + age + ", genre=" + genre + ", boardCode="
				+ boardCode + "]";
	}

	
	
}