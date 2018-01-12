<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">


</head>
<body class="container">

	<div style='max-width: 50%'>
		<form name="registerform" class="form-group" method="post" action="../register.do" onsubmit="return matchingPasswords()">
		<p id="formerror" class="container" style="color: red"></p>
			<label class="container"> First name:
				<input class="form-control" type="text" name="firstname" placeholder="First Name" required>
			</label>
			<label class="container"> Last name:
				<input class="form-control" type="text" name="lastname" placeholder="Last Name" required>
			</label>
			<label class="container"> Email:
				<input class="form-control" type="email" name="email" placeholder="Email Address" required>
				<!-- <input type="submit" value="Submit" name="B1"> -->
			</label>				
			<label class="container"> Password:
				<input class="form-control" type="password" name="password" placeholder="Password" required>
			</label>
			<label class="container"> Confirm Password:
				<input class="form-control" type="password" name="passwordconfirm" placeholder="Password" required>
				
			</label>							
			<div class="container">
				<input class="btn btn-default btn-primary" type="submit" value="Submit">	
				<button class="btn btn-default btn-danger" type="submit">Reset</button>		
			</div>	
		</form>

	</div>	

</body>
</html>