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


@WebServlet("/updateStudentReg")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email") != null) {
				
				session.setMaxInactiveInterval(20);
				
//				String sessionEmail = (String)session.getAttribute("email");
				
				int sId = Integer.parseInt(request.getParameter("id"));
				
				StudentServiceImpl ssi = new StudentServiceImpl();
				ssi.connectDB();
				
				ResultSet studentRegById = ssi.getStudentRegistrationById(sId);
				
				if(studentRegById.next()) {
					
					int id = studentRegById.getInt("id");
					String firstName = studentRegById.getString("first_name");
					String lastName = studentRegById.getString("last_name");
					String email = studentRegById.getString("email");
					String mobile = studentRegById.getString("mobile");
					String city = studentRegById.getString("city");
					String course = studentRegById.getString("course");
					
					request.setAttribute("id", id);
					request.setAttribute("firstName", firstName);
					request.setAttribute("lastName", lastName);
					request.setAttribute("email", email);
					request.setAttribute("mobile", mobile);
					request.setAttribute("city", city);
					request.setAttribute("course", course);
					
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateStudentReg.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("error", "Session expired!! Please Login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error", "Session expired!! Please Login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email") != null) {
				
				session.setMaxInactiveInterval(20);
				
				String sessionEmail = (String)session.getAttribute("email");
				
				int id = Integer.parseInt(request.getParameter("id"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String city = request.getParameter("city");
				String course = request.getParameter("course");
				
				StudentServiceImpl ssi = new StudentServiceImpl();
				ssi.connectDB();
				
				ssi.updateStudentDetails(id, firstName, lastName, email, mobile, city, course);
				
				request.setAttribute("msg", "Student Record Updated Successfully!!");
				
				String userId = ssi.getUserIdByEmail(sessionEmail);
				
				ResultSet studentRegistrations = ssi.getRegistrationByUserId(userId);
				
				request.setAttribute("result", studentRegistrations);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listStudentReg.jsp");
				rd.forward(request, response);
				
			}else {
				request.setAttribute("error", "Session expired!! Please Login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error", "Session expired!! Please Login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
	}

}
