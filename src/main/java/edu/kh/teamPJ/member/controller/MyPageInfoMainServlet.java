package edu.kh.teamPJ.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.teamPJ.common.MyRenamePolicy;
import edu.kh.teamPJ.member.model.service.MemberService;
import edu.kh.teamPJ.member.model.vo.Member;

@WebServlet("/member/mypage/info")
public class MyPageInfoMainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		String path = "/WEB-INF/views/member/mypageMain.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int maxSize = 1024 * 1024 * 20;
			HttpSession session = req.getSession();
			
			
			String root = session.getServletContext().getRealPath("/");			
			
			String folderPath = "/resources/images/memberProfile/";
			
			String filePath = root + folderPath;
			
			String encoding = "UTF-8";
			
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			// 조합된 이미지 경로
			String profileImage = folderPath + mpReq.getFilesystemName("profileImage");
			int delete = Integer.parseInt(mpReq.getParameter("delete"));
			
			if(delete == 1) {
				profileImage = null;
			}
			
			MemberService service = new MemberService();
			
			int result = service.updateProfileImage(memberNo, profileImage);
			
			if(result > 0) {
				session.setAttribute("message", "프로필 이미지 변경 완료");
				
				// 동기화
				loginMember.setProfileImage(profileImage);
				
			}else {
				session.setAttribute("message", "프로필 이미지 변경 실패");
			}
			
			resp.sendRedirect("info");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
