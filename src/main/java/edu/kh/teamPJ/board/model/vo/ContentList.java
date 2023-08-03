package edu.kh.teamPJ.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ContentList {
	
	private String boardName;
	private String boardTitle;
	private String createDate;
	private char boardStatus;
	
	private int memberNo;
	

}
