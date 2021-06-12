<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="css/Style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- ======= Navbar ======= -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="#">SIMS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="RegisterStudent.jsp">Register Student</a></li>
				<li class="nav-item"><a class="nav-link" href="/HibernateExampleWithJSP/ViewStudent">View Student</a></li>
				<li class="nav-item"><a class="nav-link" href="/HibernateExampleWithJSP/SearchStudent">Search</a></li>
				<li class="nav-item"><a class="nav-link" href="Logout.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
	<!-- End NavBar -->

	<!-- =======  Section ======= -->
	<div class="container">
		<h2 id="h">Registration Form</h2>
		<hr>
		<br>
		<form action="/HibernateExampleWithJSP/RegisterStudentHandler" method="POST" class="form">
			<div class="form-group">
				<label for="firstname" class="text-info">First Name:</label><br>
				<input type="text" name="firstname" id="firstname" class="form-control" placeholder="Please enter firstname" required>
			</div>
			<div class="form-group">
				<label for="lastname" class="text-info">Last Name:</label><br>
				<input type="text" name="lastname" id="lastname" class="form-control" placeholder="Please enter lastname" required>
			</div>
			<div class="form-group">
				<label for="gender" class="text-info">Gender:</label><br> 
				<select name="gender" id="gender" class="form-control">
				    <option>Please Select Gender</option>
					<option>Male</option>
					<option>Female</option>
				</select>
			</div>
			<div class="form-group">
				<label for="department" class="text-info">Department:</label><br>
				 <select name="department" id="department" class="form-control">
				    <option>Please Select Department</option>
					<option>Software Engineering</option>
					<option>Computer Science</option>
					<option>Information System</option>
					<option>Information Technology</option>
				</select>
			</div>
			<div class="form-group">
				<label for="batch" class="text-info">Batch:</label><br> 
				 <select name="batch" id="batch" class="form-control">
				    <option>Please Select Batch</option>
					<option>1 Year</option>
					<option>2 Year</option>
					<option>3 Year</option>
					<option>4 Year</option>
					<option>5 Year</option>
				</select>
			</div>
			<div class="form-group">
				<label for="description" class="text-info">Description:</label><br>
				<textarea name="description" rows="3" class="form-control" placeholder="Description" required></textarea>
			</div>
			<br>
			<div class="form-group">
				<input type="submit" name="Add" class="btn btn-info btn-md" value="Add">
			</div>

		</form>
	</div>
	<footer> All Right Reserved. </footer>
</body>
</html>