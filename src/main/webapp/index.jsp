<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<div align="center">
	<h3>Login Page</h3>
	
	<form action="login" method="post">
		<table>
			<tr>
				<td>Email ID</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<%
		if(request.getAttribute("error") != null) {
			
			out.println(request.getAttribute("error"));
		}
	%>
</div>
</body>
</html>