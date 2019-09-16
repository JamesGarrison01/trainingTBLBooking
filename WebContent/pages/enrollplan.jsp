<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.beans.Tour, java.util.ArrayList, com.dao.TourUserDAO, com.dao.TourData, com.dao.TourDaoFactory"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="menuBar">
		<a href="<%=request.getContextPath()%>/pages/home.jsp">Home</a>
	</div>
	<form name="enrollTour" action="<%=request.getContextPath()%>/TourServlet" method="post">
		<div class="enrollClass">
			<input type="hidden" id="page" name="page" value="enrollTourPage">
			<div class="nameClass">
				<label name="tourNameLabel">Tour Name</label>
				<select name="tourSelect">
					<%
						List<String> tourList = new ArrayList<String>();
						TourData tourDao = TourDaoFactory.getTourFactoryInstance().getTourStorage("basic");
						tourList = tourDao.getTours();
						
						for(String arrayName : tourList){
							if(arrayName.equals(request.getAttribute("answer"))){
					%>
								<option selected><%= arrayName %></option>
					<%
							}
							else{
					%>
								<option><%= arrayName %></option>
					<%
							}
						}
					%>
				</select>
			</div>
			<div class="memberClass">
				<label name="memberLabel">Member Name</label>
				<input type="text" name="memberBox">
			</div>
			<div class="noPassClass">
				<label name="noPassLabel">Number of Passengers</label>
				<input type="text" name="noPassBox">
			</div>
			<div class="costClass">
				<label name="costLabel">Tour Cost</label>
				<input type="text" name="costBox" required>
			</div>
			<div class="startDateClass">
				<label name="startDateLabel">Number of Days</label>
				<input type="Date" name="startDateBox" required>
			</div>
			<div class="remarksClass">
				<label name="remarksLabel">Remarks</label>
				<textarea name="remarksTextArea" rows="4" cols="50">
				</textarea>
			</div>
			<div class="enrollBtns">
				<input type="submit" name="enrollTourSubmitBtn" value="Enroll Tour">
			</div>		
		</div>
	</form>
</body>
</html>