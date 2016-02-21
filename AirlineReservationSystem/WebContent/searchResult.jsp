<%@page import="com.airline.beans.FlightBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session == null || session.getAttribute("userId")== null){
			response.sendRedirect("index.jsp");
		}
	%>
	<div align="right">
		Welcome <%=session.getAttribute("userId") %>|<a href="">Logout</a>
	</div>
	<h2>SEARCH RESULT PAGE:</h2>
	<form action="bookTicket">
		<table>
			<tr>
				<th>SELECT FLIGHT</th>
				<th>FLIGHT ID</th>
				<th>FLIGHT NAME</th>
				<th>SOURCE</th>
				<th>DESTINATION</th>
				<th>FARE</th>
				<th>.....</th>
			</tr>
			
			<%
				List<FlightBean> flights = (List<FlightBean>)request.getAttribute("listOfFlights");
				for(FlightBean bean : flights){
			%>
			<tr>
				<td><input type="radio" name="book"/></td>
				<td><%= bean.getFlightId() %></td>
				<td><%= bean.getFlightName() %></td>
				<td><%= bean.getSource() %></td>
				<td><%= bean.getDestination() %></td>
				<td><%= bean.getFare() %></td>
				<td><input type="submit" value="BOOK TICKET"/></td>
			</tr>
			<%		
				}
			%>
		</table>		
	</form>
</body>
</html>