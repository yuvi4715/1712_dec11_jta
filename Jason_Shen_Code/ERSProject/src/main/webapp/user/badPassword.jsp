<% 
	// Checks if there is a user logged in
	// Non-logged in users shouldn't be able to reach this page.
	if (session.getAttribute("loggedEmployee") == null) {
		System.out.println("Invalid session state, redirecting...");
		response.sendRedirect("login.jsp");
	}

%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="3;url=updateInfo.do" />

<title>Insert title here</title>
</head>
<body>
	<p>Bad password, try again. Redirecting...</p>
</body>
</html>