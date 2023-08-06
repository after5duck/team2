package edu.kh.teamPJ.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardDetail {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private int readCount;
	private int memberNo;
	private String memberNickname;
	private String profileImage;
	private String boardName;
	
	private String Image;
	
	
}
