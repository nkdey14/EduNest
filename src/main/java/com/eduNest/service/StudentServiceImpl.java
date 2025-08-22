package com.eduNest.service;

import java.sql.*;

public class StudentServiceImpl implements StudentService {
	
	private Connection con;
	private Statement stmt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_1", "root", "nitin");
			
			stmt = con.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyLoginCredentials(String email, String password) {
		try {
			ResultSet result = stmt.executeQuery("select * from admin where email = '"+email+"' and password = '"+password+"'");
			
			return  result.next();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveStudentDetails(String firstName, String lastName, String email, String mobile, String city,
			String course, String userId) {
		try {
			stmt.executeUpdate("insert into student_registration(first_name, last_name, email, mobile, city, course, userid) values ('"+firstName+"', '"+lastName+"', '"+email+"', '"+mobile+"', '"+city+"', '"+course+"', '"+userId+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getUserIdByEmail(String sessionEmail) {
		try {
			ResultSet result = stmt.executeQuery("select * from admin where email = '"+sessionEmail+"'");
			
			if(result.next()) {
				
				return result.getString("userid");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ResultSet getRegistrationByUserId(String userId) {
		try {
			ResultSet result = stmt.executeQuery("select * from student_registration where userid = '"+userId+"'");
			
			return result;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deleteStudentDetails(int id) {
		try {
			stmt.executeUpdate("delete from student_registration where id = '"+id+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getStudentRegistrationById(int sId) {
		try {
			ResultSet result = stmt.executeQuery("select * from student_registration where id = '"+sId+"'");
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStudentDetails(int id, String firstName, String lastName, String email, String mobile,
			String city, String course) {
		try {
			stmt.executeUpdate("update student_registration set first_name = '"+firstName+"', last_name = '"+lastName+"', email = '"+email+"', mobile = '"+mobile+"', city = '"+city+"', course = '"+course+"' where id = '"+id+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
