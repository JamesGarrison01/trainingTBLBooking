<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.beans.Tour"%>
<!DOCTYPE html>
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
		<div class="searchTour">
			<input type="hidden" id="page" name="page" value="searchTourPage">
			<div class="searchTourCostClass">
				<label name="searchTourCostLabel">Tour Cost</label>
				<input type="text" name="searchTourCostText">
			</div>
			<div class="searchPOIClass">
				<label name="searchPOILabel">Places of Interest</label>
				<input type="text" name="searchPOIText">
			</div>
			<div class="searchBtn">
				<input type="submit" name="searchSubmitBtn">
			</div>
		</div>
			</form>
			<form name="subscribeTour" action="<%=request.getContextPath()%>/TourServlet" method="post">
			<input type="hidden" id="page" name="page" value="subscribeTourPage">
			<div class="searchResultsClass">
				<br><br>
						<table name="searchResultsTable">
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Starting Location</th>
								<th>Places of Interest</th>
								<th>Tour Cost</th>
								<th>Discount</th>
								<th>Number of Days</th>
								<th>Subscribe</th>
							</tr>
							<%
							List<Tour> tourList = (List<Tour>)request.getAttribute("tourList");
							if(tourList != null) {
								int count = -1;
								for(Tour tour: tourList) {
									count++;
						%>
							<tr>
								<td><%= tour.getTourId() %></td>
								<td><%= tour.getTourName() %></td>
								<td><%= tour.getStartLoc() %></td>
								<td><%= tour.getPlaceInc() %></td>
								<td><%= tour.getTourCost() %></td>
								<td><%= tour.getDiscount() %></td>
								<td><%= tour.getTourDays() %></td>
								<td> <input type="radio" name="subscribe" value="<%= tour.getTourName() %>">
								</td>
							</tr>


							<%
								}
							}
						%>
					</table>
					<input type="submit" name="subSubmit" value="Subscribe to Tour">
			</div>
		</form>
</body>
</html>