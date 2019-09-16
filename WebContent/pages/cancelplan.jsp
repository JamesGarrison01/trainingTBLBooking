<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="menuBar">
		<a href="<%=request.getContextPath()%>/pages/home.jsp">Home</a>
	</div>
	<form name="addTour" action="<%=request.getContextPath()%>/TourServlet" method="post">
		<div class="cancelTour">
			<p>${param.message}</p>
			<input type="hidden" id="page" name="page" value="cancelTourPage">
			<div class="cancelIDClass">
				<label name="cancelIDLabel">Booking ID</label>
				<input type="text" name="cancelIDBox" required>
			</div>
			<div class="cancelBtnClass">
				<input type="submit" name="cancelBtn" value="Cancel Tour">
			</div>
		</div>
	</form>
</body>
</html>