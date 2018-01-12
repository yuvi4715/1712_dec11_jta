<!DOCTYPE html>
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