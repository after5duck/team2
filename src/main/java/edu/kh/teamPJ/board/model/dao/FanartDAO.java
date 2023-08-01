package edu.kh.teamPJ.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.teamPJ.board.model.vo.FanartDTO;

public class FanartDAO {

   private Connection conn = null;
   private ResultSet rs = null;
   private PreparedStatement pstmt = null;


   public Connection getConnection() {
      try {

         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "fanart";
         String pass = "fanart1234";

         conn = DriverManager.getConnection(url, user, pass);

         if (conn != null) {
            System.out.println("UserDAO DB 연결 성공");
         }

      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 에러");
         e.printStackTrace();

      } catch (SQLException e) {
         System.out.println("연결 에러");
         e.printStackTrace();
      }
      return conn;
   }

   public List<FanartDTO> getFanartList() {

      List<FanartDTO> fanartList = new ArrayList<>();

      try {

         conn = getConnection();

         String sql = "SELECT * FROM FANART";

         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();


         while (rs.next()) {
            // FanartDTO 객체 생성 및 필드 값 설정
            FanartDTO fanart = new FanartDTO();

            fanart.setPhotoNo(rs.getInt("PHOTO_NO"));
            fanart.setTitle(rs.getString("FANART_TITLE"));
            fanart.setPhoto(rs.getString("FANART_PHOTO"));

            fanartList.add(fanart);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         closeResources();
      }

      return fanartList; // FanartDTO 객체의 리스트 반환
   }

   private void closeResources() {
      try {
         if (rs != null) {
            rs.close();
         }
         if (pstmt != null) {
            pstmt.close();
         }
         if (conn != null) {
            conn.close();
         }
      } catch (SQLException e) {
         System.out.println("자원 해제 에러");
         e.printStackTrace();
      }
   }
   
   
   public FanartDTO getFanartDetail(int photoNo) {
       FanartDTO fanartDetail = null;
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           conn = getConnection();
           String sql = "SELECT * FROM FANART WHERE PHOTO_NO = ?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, photoNo);
           rs = pstmt.executeQuery();

           if (rs.next()) {
               int retrievedPhotoNo = rs.getInt("PHOTO_NO");
               String title = rs.getString("FANART_TITLE");
               String photo = rs.getString("FANART_PHOTO");

               // FanartDTO 객체 생성
               fanartDetail = new FanartDTO(retrievedPhotoNo, title, photo);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           closeResources();
       }

       return fanartDetail;
   }


}