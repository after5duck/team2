package edu.kh.teamPJ.member.model.service;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.dao.MemberDAO;

import java.sql.Connection;
import java.util.List;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import edu.kh.teamPJ.member.model.vo.Member;


public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 */
	public Member login(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, member);
		
		close(conn);
		
		return loginMember;
	}

	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, memberId);
		
		close(conn);
		
		return result;
	}

	/** 닉네임 중복 검사 Service
	 * @param memberNick
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNick) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.nicknameDupCheck(conn, memberNick);
		
		close(conn);
		
		return result;
	}

	/** 회원가입 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}
	
	/** 이동호
	 * @author user1
	 *
	 */
	/** 좋아요 리스트 조회
	 * @param boardNo
	 * @return likeList
	 * @throws Exception
	 */
	public List<Board> selectLikeList(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Board> likeList = dao.selectLikeList(conn, boardNo);
		
		close(conn);
		
		return likeList;
	}

	/** 마이페이지 비밀번호 변경 Service
	 * @param inputPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 */
	public int changePw(String inputPw, String newPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.changePw(conn, inputPw, newPw, memberNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 프로필 이미지 변경 Service
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateProfileImage(conn, memberNo, profileImage);
		
		if(result > 0)commit(conn);
		else		  rollback(conn);
		
		close(conn);
		
		return result;
		
	}

	/** 회원 탈퇴 Service
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberNo, inputPw);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 닉네임 중복확인 Service
	 * @param memberNick
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public String checkDupNick(String memberNick, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		String result = dao.checkDupNick(conn, memberNick, memberNo);
		
		close(conn);
		
		return result;
	}

	/** 프로필 정보 수정 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int changeInfo(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.changeInfo(conn, member);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	


}
