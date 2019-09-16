<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.beans.Login"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.navbar a:hover{
  background-color: red;
}


</style>
</head>
<body>
	<div class="navBar">
		<%
			Cookie[] cookies = null;
			cookies = request.getCookies();
			
			if(cookies != null){
				int count = 0;
				for(; count < cookies.length; count++ ){
					if(cookies[count].getName().equals("userType")){
						break;
					}
				}
				if(cookies[count].getValue().equals("admin")){
		%>
					<a href="<%=request.getContextPath()%>/pages/tourplan.jsp">Create Tour Plan</a>
					<a href="<%=request.getContextPath()%>/pages/cancelplan.jsp">Cancel Tour Subscription</a>
		<%
				}
				else{
		%>
						<a href="<%=request.getContextPath()%>/pages/searchplan.jsp">Search For Tour Plan</a>
						<a href="<%=request.getContextPath()%>/pages/cancelplan.jsp">Cancel Tour Subscription</a>	
		<%
				}
			}
			else{
				out.println("<h2>No cookies founds</h2>");
			}
		%>
	</div>
</body>
</html>