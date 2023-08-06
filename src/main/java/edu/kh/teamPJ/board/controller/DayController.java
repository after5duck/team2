package edu.kh.teamPJ.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.teamPJ.board.model.dao.DayDAO;
import edu.kh.teamPJ.board.model.vo.DayDTO;


@WebServlet("")
public class DayController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	try {
           
            // 리다이렉트
            
            String path = "/test";
            		
            // resp.sendRedirect(req.getContextPath() + "/index.jsp");
            resp.sendRedirect("test");
          
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
