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
		Welcome <%=session.getAttribute("userId") %>|<a href="logout">Logout</a>
	</div>
	<h2>FLIGHT SEARCH PAGE:</h2>
  <form action="search" method="post">
  	Select source : 
  	<select name="source">
  		<option>PUNE</option>
  		<option>MUMBAI</option>
  		<option>DELHI</option>
  		<option>CHENNAI</option>
  	</select>
  	Select Destination:
  	<select name="destination">
  		<option>MUMBAI</option>
  		<option>PUNE</option>
  		<option>DELHI</option>
  		<option>CHENNAI</option>
  	</select>
  	<input type="submit" value="SEARCH FLIGHT"/>
  </form>
</body>
</html>