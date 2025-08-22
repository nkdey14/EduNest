package com.eduNest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduNest.service.StudentServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		StudentServiceImpl ssi = new StudentServiceImpl();
		ssi.connectDB();
		
		boolean status = ssi.verifyLoginCredentials(email, password);
		
		if(status) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
			session.setMaxInactiveInterval(20);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/studentReg.jsp");
			rd.forward(request, response);
		}else {
			
			request.setAttribute("error", "Invalid email/password!! Please try again");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
