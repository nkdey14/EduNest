<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.ResultSet" %>
<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Student Registrations</title>
</head>
<body>
<div align="center">
	<h3>List Student Registrations</h3>
	
	<table border='1' cellpadding='10'>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email ID</th>
			<th>Mob No.</th>
			<th>City</th>
			<th>Course</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<%
			ResultSet data = (ResultSet)request.getAttribute("result");
		
			while(data.next()) {
		%>
		
		<tr>
			<td><%=data.getInt("id") %></td>
			<td><%=data.getString("first_name") %></td>
			<td><%=data.getString("last_name") %></td>
			<td><%=data.getString("email") %></td>
			<td><%=data.getString("mobile") %></td>
			<td><%=data.getString("city") %></td>
			<td><%=data.getString("course") %></td>
			<td><a href="deleteStudentReg?id=<%=data.getInt("id") %>"><input type="button" value="Delete"></a></td>
			<td><a href="updateStudentReg?id=<%=data.getInt("id") %>"><input type="button" value="Update"></a></td>
		</tr>
		<% } %>
	</table>
	
	<br>
	
		<%
			if(request.getAttribute("msg") != null) {
				
				out.println(request.getAttribute("msg"));
			}
		%>
</div>
</body>
</html>