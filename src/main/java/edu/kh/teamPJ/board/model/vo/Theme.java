package edu.kh.teamPJ.board.model.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Theme {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String contentPath;
	private String videoPath;
	private String age;
	private String genre;
	private String boardCode;
	
	private List<Theme> sportsList = new ArrayList<>();

	
	

}
