<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.beans.Tour"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="loginTour" action="<%=request.getContextPath()%>/LoginServlet" method="post">
		<div class="bodies">
			<div class="login">
				<label name="loginLabel">
					Login ID:
				</label>
				<input type="text" name="loginTextBox">
			</div>
			<div class="password">
				<label name="passwordLabel">
					Password:
				</label>
				<input type="password" name="passwordBox">
			</div>
			<div class="userType">
				<label name="userLabel">
					User Type:
				</label>
				<select name="userSelectDrop">
					<option value="admin">Admin</option>
					<option value="member">Member</option>
				</select>
			</div>
			<div class="loginBtn">
				<input type="submit" name="loginSubmitButn" value="Login">
			</div>
		</div>
	
	</form>
</body>
</html>