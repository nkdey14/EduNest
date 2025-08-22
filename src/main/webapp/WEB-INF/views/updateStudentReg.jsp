<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Registration</title>
</head>
<body>
<div align="center">
	<h3>Update Student Registration</h3>
	
	<form action="updateStudentReg" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="id" value="${id}" required></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="${firstName}" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="${lastName}" required></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="email" name="email" value="${email}"required></td>
			</tr>
			<tr>
				<td>Mob No.</td>
				<td><input type="text" name="mobile" value="${mobile}" required></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value="${city}" required></td>
			</tr>
			<tr>
                <td>Course</td>
                <td>
                    <select name="course">
					    <option value="">--Select--</option>
					    <option value="Java FullStack" ${course == 'Java FullStack' ? 'selected' : ''}>Java FullStack</option>
					    <option value="DevOps" ${course == 'DevOps' ? 'selected' : ''}>DevOps</option>
					    <option value="Testing" ${course == 'Testing' ? 'selected' : ''}>Testing</option>
					    <option value="Java FullStack + DevOps" ${course == 'Java FullStack + DevOps' ? 'selected' : ''}>Java FullStack + DevOps</option>
					</select>
                </td>
            </tr>
			<tr>
				<td><input type="submit" value="Update"></td>
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