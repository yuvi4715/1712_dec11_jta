<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class= "container">
  <h2>Login</h2>
  <form action="login.do" method="post">
    <div class="form-group">
      <label for="username">User Name:</label>
      <input type="text" class="form-control" name="username" placeholder="Enter username" size= "45">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="password" placeholder="Enter password" size ="45">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
  </form>
</div>

</body>
</html>
