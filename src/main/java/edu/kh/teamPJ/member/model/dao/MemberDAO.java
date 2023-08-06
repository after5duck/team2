package edu.kh.teamPJ.member.model.dao;

import static edu.kh.teamPJ.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.teamPJ.board.model.vo.Board;
import edu.kh.teamPJ.member.model.dao.MemberDAO;
import edu.kh.teamPJ.member.model.vo.Member;


public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public MemberDAO() {
		try {
			prop = new Properties();

			String filePath =  MemberDAO.class.getResource("/edu/kh/teamPJ/sql/member-sql.xml").getPath(); 

			prop.loadFromXML(new FileInputStream (filePath));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/** 로그인 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public Member login(Connection conn, Member member) throws Exception{
		Member loginMember = null;

		try {
			String sql = prop.getProperty("login");
			System.out.println("sql");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				loginMember = new Member();

				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
				loginMember.setMemberNickname(rs.getString("MEMBER_NICK"));
				loginMember.setProfileImage(rs.getString("PROFILE_IMG"));
				loginMember.setEnrollDate(rs.getString("ENROLL_DATE"));
				loginMember.setSecessionFlag(rs.getString("SECESSION_FL"));
				loginMember.setAdmin(rs.getString("ADMIN"));
			}
		}finally {
			close(rs);
			close(pstmt);

		}

		return loginMember;
	}

	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String memberId) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("idDupCheck");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberId);

			rs=pstmt.executeQuery();

			if(rs.next()) {
				result = rs.getInt(1);
			}

		}finally {
			close(rs);
			close(pstmt);

		}
		return result;
	}

	/** 닉네임 중복검사 DAO
	 * @param conn
	 * @param memberNick
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String memberNick) throws Exception{

		int result = 0;

		try {

			String sql = prop.getProperty("nicknameDupCheck");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberNick);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				result = rs.getInt(1);
			}

		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/** 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("signUp");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberNickname());

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);

		}

		return result;
	}



	/** 이동호
	 * @author user1
	 *
	 */

	/** 좋아요 목록 조회
	 * @param conn
	 * @param boardNo
	 * @return likeList
	 * @throws Exception
	 */
	public List<Board> selectLikeList(Connection conn, int boardNo) {

		List<Board> likeList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectLikeList");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Board b = new Board();

				b.setBoardNo(rs.getInt(1));
				b.setBoardTitle(rs.getString(2));
				b.setBoardContent(rs.getString(3));
				b.setCreateDate(rs.getString(4));

			}


		}catch(Exception e) {
			e.printStackTrace();
		}

		return likeList;
	}

	/** 마이페이지 비밀번호 변경
	 * @param conn
	 * @param inputPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String inputPw, String newPw, int memberNo) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("changePw");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, inputPw);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 프로필 이미지 변경 DAO
	 * @param conn
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("updateProfileImage");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profileImage);
			pstmt.setInt(2, memberNo);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);

		}

		return result;
	}

	/** 회원탈퇴 DAO
	 * @param conn
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo, String inputPw) throws Exception{

		int result = 0;

		try {

			String sql = prop.getProperty("secessionMember");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);
			pstmt.setString(2, inputPw);

			result = pstmt.executeUpdate();

		}finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/** 닉네임 중복 확인 DAO
	 * @param conn
	 * @param memberNick
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public String checkDupNick(Connection conn, String memberNick, int memberNo) throws Exception{

		String result = memberNick;

		try {

			String sql = prop.getProperty("checkDupNick");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberNick);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				result = null;
			}

		}finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/** 프로필 정보 수정 DAO
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int changeInfo(Connection conn, Member member) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("changeInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberNickname());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setInt(3, member.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이메일 중복 확인 DAO
	 * @param conn
	 * @param inputEmail
	 * @return result
	 */
	public int searchEmail(Connection conn, String inputEmail) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("searchEmail");
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}




}
