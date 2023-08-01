package com.kh.main;

public class MainDTO {

	private String title;
	private String photo;
	
	public MainDTO() {}
	
	
	public MainDTO(String title, String photo) {
		super();
		this.title = title;
		this.photo = photo;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "MainDTO [title=" + title + ", photo=" + photo + "]";
	}
	
	
	
	
}
