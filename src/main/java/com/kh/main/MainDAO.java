package com.kh.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainDAO {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "lmj";
            String pass = "lmj1234";

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

    // 요일별 애니 출력.
    public ArrayList<MainDTO> getImgList() {
    	
        ArrayList<MainDTO> mdtoList = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM LIST";
            
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
//            System.out.println("값 추가되기 전.");
            while (rs.next()) {
            	
                MainDTO mdto = new MainDTO();

                mdto.setTitle(rs.getString("TITLE"));
                mdto.setPhoto(rs.getString("PHOTO"));

                mdtoList.add(mdto);
                System.out.println("값이 추가되었습니다.");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResources();
        }
        System.out.println("값 추가 구문 후.");
        return mdtoList;
    }
    
    // 인기 애니 출력.
    public ArrayList<MainDTO> getBestAniList() {
        ArrayList<MainDTO> mdtoList = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM LIST";
            
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("값 추가되기 전.");
            while (rs.next()) {
            	
                MainDTO mdto = new MainDTO();

                mdto.setTitle(rs.getString("TITLE"));
                mdto.setPhoto(rs.getString("PHOTO"));

                mdtoList.add(mdto);
                System.out.println("값이 추가되었습니다.");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResources();
        }
        System.out.println("값 추가 구문 후.");
        return mdtoList;
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
}
