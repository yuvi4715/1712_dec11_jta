<!DOCTYPE html>

<% 
	// Checks if there is an existing sessions, if there is, direct them home.
	// This keeps only one session from ever existing
	// You won't be able to Login as Employee A go to Home of A and then Login as B without first logging out of A
	// This also prevents you from being on Home of A, clicking the back button to bring you back to the login page.
	//		If you click the back button, it would bring you to login page, see that you're already logged in, then 
	//		bring you back to home
	if (session.getAttribute("loggedEmployee") != null) {		
		response.sendRedirect("../home.do");
		
	}

%>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">


</head>
<body class="container">

	<div style='max-width: 50%'>
		<form class="form-group" method="post" action="../login.do">
			<label class="container"> Email:
				<input class="form-control" type="email" name="email" placeholder="Email Address">

			</label>
			<label class="container"> Password:
				<input class="form-control" type="password" name="password" placeholder="Password">
			</label>							
			<div class="container">
				<input class="btn btn-default btn-primary" type="submit" value="Submit">	
				<button class="btn btn-default btn-danger" type="reset" value="Reset">Reset</button>
						
			</div>	
		</form>
		
	</div>	
</body>
</html>	