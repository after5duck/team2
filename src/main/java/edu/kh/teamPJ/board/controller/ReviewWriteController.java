package edu.kh.teamPJ.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.teamPJ.board.model.service.ReviewWriteService;
import edu.kh.teamPJ.board.model.vo.BoardDetail;
import edu.kh.teamPJ.member.model.vo.Member;


@WebServlet("/board/review_write")
public class ReviewWriteController extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
         String mode = req.getParameter("mode"); // insert / update 구분

         // insert는 별도 처리 없이 jsp로 위임

         // update는 기존 게시글 내용을 조회하는 처리가 필요함
//         if(mode.equals("update")) {
//            
//         int boardNo = Integer.parseInt(req.getParameter("no"));
//
//         // 게시글 상세 조회 서비스를 이용해서 기존 내용 조회
//         // ( new BoardService() : 객체를 생성해서 변수에 저장 X -> 1회성 사용
//         BoardDetail write = new ReviewWriteService().selectBoardDetail(boardNo);
//         
//         // 개행 문자 처리 해제(<br> -> \n)
//         write.setBoardContent(write.getBoardContent().replaceAll("<br>", "\n")); 
//         
//         req.setAttribute("write", write); // jsp에서 사용할 수 있도록 req에 값 세팅   
//
//         }
         

         String path = "/WEB-INF/views/board/review_write.jsp";
         req.getRequestDispatcher(path).forward(req, resp);

      }catch (Exception e) {
         e.printStackTrace();
      }

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
         // insert/update 구분 없이 전달 받은 파라미터 모두 꺼내서 정리하기



         HttpSession session = req.getSession(); // session 얻어오는 것은 지장없음(사용 가능)
         String root = session.getServletContext().getRealPath("/"); // webapp 폴더까지 경로

         String encoding = "UTF-8"; // 파라미터 중 파일 제외 파라미터(문자열)의 인코딩 지정

         
         // * 이미지를 제외한 게시글 관련 정보 *
         String boardTitle = req.getParameter("boardTitle");
         String boardContent = req.getParameter("boardContent");
         int boardCode = Integer.parseInt( req.getParameter("type") ); // hidden

         Member loginMember = (Member)session.getAttribute("loginMember");
         int memberNo = loginMember.getMemberNo(); // 회원 번호

         // 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기
         BoardDetail write = new BoardDetail();

         write.setBoardTitle(boardTitle);
         write.setBoardContent(boardContent);
         write.setMemberNo(memberNo);
         // boardCode는 별도 매개변수로 전달 예정

         // ---------------------- 게시글 작성에 필요한 기본 파라미터 얻어오기 끝 --------------------

         ReviewWriteService service = new ReviewWriteService();

         // 모드 (insert/update)에 따라서 추가 파라미터 얻어오기 및 서비스 호출
         String mode = req.getParameter("mode"); // hidden

         if(mode.equals("insert")) { // 삽입

            // 게시글 삽입 서비스 호출 후 결과 반환 받기
            // -> 반환된 게시글 번호를 이용해서 상세조회로 리다이렉트 예정
            int boardNo = service.insertBoard(write, boardCode);
            
            String path = null;
            
            if(boardNo > 0) { // 성공
               session.setAttribute("message", "게시글이 등록되었습니다.");
               // detail?no=2000&type=2
               path = "detail?no=" + boardNo + "&type" + boardCode;
               
            }else { // 실패
               session.setAttribute("message", "게시글 등록 실패");
               
               // write?mode=insert&type=2
               path = "write?mode=" + mode + "&type=" + boardCode;
            }
            
            resp.sendRedirect(path); // 리다이렉트

         }

         if(mode.equals("update")) { // 수정
            // 앞선 코드는 동일(업로드된 이미지 저장, imageList 생성, 제목/내용 파라미터 동일)
            
            // + update일 때 추가된 내용
            // 어떤 게시글 수정 -> 파라미터 no
            // 나중에 목록으로 버튼 만들 때 사용할 현재 페이지 -> 파라미터 cp
            // 이미지 중 x버튼을 눌러서 삭제할 이미지 레벨 목록 -> 파라미터 deleteList
            int boardNo = Integer.parseInt( req.getParameter("no"));
            
            int cp = Integer.parseInt( req.getParameter("cp"));
            
            String deleteList = req.getParameter("deleteList"); // 1,2,3
            
            // 게시글 수정 서비스 호출 후 결과 반환 받기
            write.setBoardNo(boardNo);
            
            // detail, imageList, deleteList
            int result = service.updateBoard(write, deleteList);
           
            String path = null;
            String message = null;
            
            if(result > 0) { // 성공
               
              // detail?no=1000&type=1&cp=20
            path = "detail?no=" + boardNo + "&type=" + boardCode + "&cp=" + cp; // 상세조회 페이지 요청 주소

            message = "게시글이 수정되었습니다.";
               
            }else { // 실패
               
            // 수정화면으로 이동

            // 상세조회 -> 수정화면 -> 수정 -> (성공)상세조회
            // -> (실패)수정화면
               
               // write?mode=update&type=1
               path = req.getHeader("referer");
               // referer : HTTP 요청 흔적(요청 바로 이전 페이지 주소)

            message = "게시글 수정 실패";
            }
            
            session.setAttribute("message", message);
            resp.sendRedirect(path);
         }

      }catch (Exception e) {
         e.printStackTrace();
      }

   }


}