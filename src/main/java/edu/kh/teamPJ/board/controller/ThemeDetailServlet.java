/*
 * package edu.kh.teamPJ.board.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import edu.kh.teamPJ.board.model.vo.BoardDetail; import
 * edu.kh.teamPJ.board.model.service.ThemeDetailService; import
 * edu.kh.teamPJ.board.model.service.ThemeService; import
 * edu.kh.teamPJ.board.model.vo.Board;
 * 
 * @WebServlet("/board/theme_detail") public class ThemeDetailServlet extends
 * HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * try {
 * 
 * // 파라미터 중 게시글 번호(no) 얻어오기 int boardNo =
 * Integer.parseInt(req.getParameter("boardNo"));
 * 
 * 
 * ThemeDetailService service = new ThemeDetailService();
 * 
 * // 게시글 정보 + 이미지 리스트 조회 BoardDetail detail =
 * service.selectBoardDetail(boardNo);
 * 
 * 
 * 
 * 
 * 
 * 
 * req.setAttribute("detail",detail);
 * 
 * 
 * 
 * 
 * }catch(Exception e) { e.printStackTrace(); }
 * 
 * 
 * 
 * String path = "/WEB-INF/views/board/theme_detail.jsp";
 * req.getRequestDispatcher(path).forward(req, resp); } }
 */