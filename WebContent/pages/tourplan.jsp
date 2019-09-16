<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<div class="createTour">
			<input type="hidden" id="page" name="page" value="addTourPage">
			<div class="nameClass">
				<label name="tourNameLabel">Tour Name</label>
				<input type="text" name="tourNameBox" required>
			</div>
			<div class="startClass">
				<label name="startLocLabel">Starting Location</label>
				<input type="text" name="startLocBox">
			</div>
			<div class="poiClass">
				<label name="poiLabel">Places of Interest</label>
				<input type="text" name="poiBox" required>
			</div>
			<div class="costClass">
				<label name="costLabel">Tour Cost</label>
				<input type="text" name="costBox" required>
			</div>
			<div class="nodaysClass">
				<label name="nodaysLabel">Number of Days</label>
				<input type="text" name="nodaysBox" required>
			</div>
			<div class="availClass">
				<label name="">Discount available</label>
				<input type="radio" name="availRadio" value="yes"> YES
				<input type="radio" name="availRadio" value="no" selected> NO
			</div>
			<div class="discountClass">
				<label name="discountLabel">Discount</label>
				<input type="text" name="discountBox">
			</div>
			<div class="tourPlanBtns">
				<input type="submit" name="createTourSubmitBtn" value="Create Tour">
				<input type="reset" name="createTourClearBtn">
			</div>		
		</div>
	</form>
</body>
</html>