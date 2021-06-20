<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="css/Style.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
   <div id="register">
		<div class="container">
			<div id="register-row"
				class="row justify-content-center align-items-center">
				<div id="register-column" class="col-md-6">
					<div id="register-box" class="col-md-12">
						<form action="/HibernateExampleWithJSP/Register" method="POST" id="register-form" class="form">
							<h1 class="text-center">Registration Form</h1>
							<div class="form-group">
								<label for="firstname" class="text-info">First Name:</label><br>
								<input type="text" name="fname"  class="form-control" required>
							</div>
							<div class="form-group">
								<label for="lastname" class="text-info">Last Name:</label><br>
								<input type="text" name="lname"  class="form-control" required>
							</div>
							<div class="form-group">
								<label for="email" class="text-info">Email:</label><br>
								<input type="email" name="email"  class="form-control" required>
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" class="form-control" required>
							</div><br>
							<div class="form-group">
								 <input type="submit" name="register" class="btn btn-info btn-md" value="Register">
							<div id="login-link">
								I already have an account?<a href="Login.jsp" class="text-info"> Login</a>
							</div>	
							</div>				
						</form>
					</div>
				</div>
			</div>
		</div>
	</div></body>
</html>