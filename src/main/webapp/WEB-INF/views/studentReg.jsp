<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student Registration</title>
</head>
<body>
<div align="center">
	<h3>New Student Registration</h3>
	
	<form action="saveStudentReg" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" required></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Mob No.</td>
				<td><input type="text" name="mobile" required></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" required></td>
			</tr>
			<tr>
				<td>Course</td>
				<td>
					<select name="course">
					  <option value="">--Select--</option>
					  <option value="Java FullStack">Java FullStack</option>
					  <option value="DevOps">DevOps</option>
					  <option value="Testing">Testing</option>
					  <option value="Java FullStack + DevOps">Java FullStack + DevOps</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
	
	<br>
	
		<%
			if(request.getAttribute("msg") != null) {
				
				out.println(request.getAttribute("msg"));
			}
		%>
</div>
</body>
</html>