<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Page</h2>
	
	<%
		String evt = request.getParameter("event");
		if(evt != null && evt.equals("loginFailed")){
   %>
   	<font color='red'>Login Failed. Please enter correct user Id and Password!!</font>
   	
   <%		
		}
	%>
	
	
	
	<form action="login" method="POST">
		User Id <input type="text" name="userId"/><br/>
		Password <input type="password"  name="pwd"/>
		<input type="submit" value="LOGIN"/>
	</form>
	
	<br/>
	New User <a href="register.html"/>Register here</a>
</body>
</html>