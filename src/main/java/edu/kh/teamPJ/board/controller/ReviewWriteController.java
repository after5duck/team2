/*
 * package edu.kh.teamPJ.board.controller;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.Enumeration; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.oreilly.servlet.MultipartRequest;
 * 
 * import edu.kh.teamPJ.board.model.service.BoardService; import
 * edu.kh.teamPJ.board.model.vo.BoardDetail; import
 * edu.kh.teamPJ.member.model.vo.Member;
 * 
 * 
 * // 컨트롤러 : 요청에 따라 알맞은 Service를 호출하고 결과에 따라 응답을 제어
 * 
 * @WebServlet("/board/review_write") public class ReviewWriteController extends
 * HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * try { String mode = req.getParameter("mode"); // insert / update 구분
 * 
 * // insert는 별도 처리 없이 jsp로 위임 // update는 기존 게시글 내용을 조회하는 처리가 필요함
 * if(mode.equals("update")) {
 * 
 * }
 * 
 * String path = "/WEB-INF/views/board/review_write.jsp";
 * req.getRequestDispatcher(path).forward(req, resp);
 * 
 * }catch(Exception e) { e.printStackTrace(); }
 * 
 * }
 * 
 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * try { // insert/update 구분없이 전달 받은 파라미터 모두 꺼내서 정리하기
 * 
 * // *** enctype="multipart/form-data" 인코딩 미지정 형식의 요청 *** // ->
 * HttpServletRequest로 파라미터 얻어오기 불가능함!! // ---> MultipartRequest를 이용 (cos.jar
 * 라이브러리에서 제공해줌) // ----> 업로드 최대 용량, 저장 실제 경로, 파일명 변경 정책, 문자 파라미터 인코딩 설정 필요
 * 
 * int maxSize = 1024 * 1024 * 100; // 업로드 최대 용량(100MB)
 * 
 * HttpSession session = req.getSession(); // session 얻어오는 것은 지장없음(사용가능) String
 * root = session.getServletContext().getRealPath("/"); // webapp 폴더까지 경로 String
 * filePath = root + folderPath;
 * 
 * String encoding = "UTF-8"; // 파라미터 중 파일 제외 파라미터(문자열)의 인코딩 지정
 * 
 * 
 * } }
 * 
 * // * 이미지를 제외한 게시글 관련 정보 * String boardTitle =
 * mpReq.getParameter("boardTitle"); String boardContent =
 * mpReq.getParameter("boardContent"); int boardCode =
 * Integer.parseInt(mpReq.getParameter("type")); // hidden
 * 
 * Member loginMember = (Member)session.getAttribute("loginMember"); int
 * memberNo = loginMember.getMemberNo(); // 회원 번호
 * 
 * // 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기 BoardDetail detail = new BoardDetail();
 * 
 * detail.setBoardTitle(boardTitle); detail.setBoardContent(boardContent);
 * detail.setMemberNo(memberNo); // boardCode는 별도 매개변수로 전달 예정
 * 
 * // ----------------------게시글 작성에 필요한 기본 파라미터 얻어오기 끝 --------------
 * 
 * BoardService service = new BoardService();
 * 
 * // 모드( insert/update)에 따라서 추가 파라미터 얻어오기 및 서비스 호출 String mode =
 * mpReq.getParameter("mode"); // hidden
 * 
 * 
 * if(mode.equals("insert")) { // 삽입
 * 
 * // 게시글 삽입 서비스 호출 후 결과 반환 받기 // -> 반환된 게시글 번호를 이용해서 상세조회로 리다이렉트 예정 int boardNo
 * = service.reviewInsertBoard(detail, boardCode);
 * 
 * String path = null;
 * 
 * if(boardNo > 0) { // 성공 session.setAttribute("message", "게시글이 등록되었습니다."); //
 * detail?no=2000&type=2 path = "detail?no="+ boardNo + "&type=" + boardCode;
 * 
 * 
 * } else { // 실패 session.setAttribute("message", "게시글 등록 실패");
 * 
 * // /write?mode=insert&type=2 path = "write?mode=" + mode + "&type" +
 * boardCode; }
 * 
 * resp.sendRedirect(path); // 리다이렉트 }
 * 
 * if(mode.equals("update")) { // 수정
 * 
 * }
 * 
 * 
 * 
 * }catch(Exception e) { e.printStackTrace(); } } }
 */