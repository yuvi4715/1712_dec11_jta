<% 
	// Checks if there is a user logged in
	// Non-logged in users shouldn't be able to reach this page.
	if (session.getAttribute("loggedEmployee") == null) {
		System.out.println("Invalid session state, redirecting...");
		response.sendRedirect("login.jsp");
	}
	// User is trying to logout, so we invalidate this session and redirect.
	else {
		session.invalidate();
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="3;url=user/login.jsp" />

<title>Insert title here</title>
</head>
<body>
	<p>You are now logged out. Redirecting...</p>
</body>
</html>