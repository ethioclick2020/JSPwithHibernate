<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page import="com.ethioclicks.entity.StudentInfo"%>
<%@ page import="com.ethioclicks.entity.Department"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="css/Style.css" rel="stylesheet">
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
				<li class="nav-item"><a class="nav-link"
					href="RegisterStudent.jsp">Register Student</a></li>
				<li class="nav-item active"><a class="nav-link" href="/HibernateExampleWithJSP/ViewStudent">View Student</a></li>
				<li class="nav-item"><a class="nav-link" href="/HibernateExampleWithJSP/SearchStudent">Search</a></li>
				<li class="nav-item"><a class="nav-link" href="Logout.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<!-- ======= End Navbar ======= -->
	<div class="row" style="float: right"></div>
	<h1>List of Students</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Batch</th>
			<th>Registration Date</th>
		</tr>
		<%
        List<StudentInfo> listOfStudent = (List<StudentInfo>)request.getSession().getAttribute("List");
		for (StudentInfo student: listOfStudent){
		%>
		<tr>
			<td><%= student.getId() %></td>
			<td><%= student.getFirstName() %></td>
			<td><%= student.getLastName() %></td>
			<td><%= student.getGender() %></td>
			<td><%= student.getDepartment().getDepartmentName() %></td>
			<td><%= student.getBatch() %></td>
			<td><%= student.getTimeStamp() %></td>
		</tr>
		<%
		}
		%>

	</table>
	<!-- ======= footer ======= -->
	<footer style="margin-top: 50vh;"> © Copyright 2021 Ethio Clicks . </footer>
	<!-- ======= End footer ======= -->
</body>
</html>