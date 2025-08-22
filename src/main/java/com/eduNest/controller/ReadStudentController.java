package com.eduNest.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduNest.service.StudentServiceImpl;

@WebServlet("/getStudentReg")
public class ReadStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReadStudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email") != null) {
				
				session.setMaxInactiveInterval(90);
				
				String sessionEmail = (String)session.getAttribute("email");
				System.out.println("Session Email is: "+ sessionEmail);
				
				StudentServiceImpl ssi = new StudentServiceImpl();
				ssi.connectDB();
				
				String userId = ssi.getUserIdByEmail(sessionEmail);
				
				ResultSet studentRegistrations = ssi.getRegistrationByUserId(userId);
				
				request.setAttribute("result", studentRegistrations);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listStudentReg.jsp");
				rd.forward(request, response);
			}else {
				
				request.setAttribute("error", "Session expired!! Please login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Session expired!! Please Login again");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
