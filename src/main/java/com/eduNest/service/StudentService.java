package com.eduNest.service;

import java.sql.ResultSet;

public interface StudentService {

	public void connectDB();
	
	public boolean verifyLoginCredentials(String email, String password);
	
	public void saveStudentDetails(String firstName, String lastName, String email, String mobile, String city, String course, String userId);

	public String getUserIdByEmail(String sessionEmail);

	public ResultSet getRegistrationByUserId(String userId);

	public void deleteStudentDetails(int id);

	public ResultSet getStudentRegistrationById(int sId);

	public void updateStudentDetails(int id, String firstName, String lastName, String email, String mobile, String city,
			String course);
}
