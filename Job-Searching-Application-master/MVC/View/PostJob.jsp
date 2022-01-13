<%@page import="Model.EmployerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Posting</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.bg-4 {
	background-color: #2f2f2f; /* Black Gray */
	color: #fff;
}
.container-fluid {
	padding-top: 40px;
	padding-bottom: 40px;
}
p {
	font-size: 16px;
}
</style>
</head>
<body>
<%
EmployerBean em = (EmployerBean) request.getSession().getAttribute("employer");
String eName = em.getEName();
int eId = em.getEmployerId();
%>
<!-- navigation -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.html"><span
					class="glyphicon glyphicon-home"></span> Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="emCreateAccount.jsp"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="EmployerController?action=logout"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
	</nav>

	<div class="container-fluid-body">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
<h1>Welcome <%=eName%></h1>
<h2>EmployerId <%=eId%></h2>
<h2>Please Post a Job</h2>
<form action = "JobController"  method ="Post">
<input type="hidden" name="action" value="post" class="form-control">
<input type="hidden" class="form-control" name="employerId" value="${employer.employerId}">
<label>Title</label><br>
<input type = "text" class="form-control" name = "title"/><br>
<label>City</label><br>
<select name="city" class="form-control">
  	<option value="Mississauga">Mississauga</option>
  	<option value="Oakville">Oakville</option>
  	<option value="Brampton">Brampton</option>
  	<option value="Toronto">Toronto</option>
</select><br>
<label>Address</label></br>
<input type = "text" class="form-control" name = "address"/></br>
<label>Number of Positions</label></br>
<select name="numOfPosition" class="form-control">
  	<option value="1">1</option>
  	<option value="2">2</option>
  	<option value="3">3</option>
  	<option value="4">4</option>
  	<option value="5">5</option>
  	<option value="6">6</option>
  	<option value="7">7</option>
  	<option value="8">8</option>
  	<option value="9">9<option>
  	<option value="10">10</option>
</select><br>
<label>Description</label><br>
<input type = "text" class="form-control" name = "description"/><br>
<label>Qualifications</label></br>
<input type = "text" class="form-control" name = "qualification"/><br>
<label>Note</label></br>
<input type = "text" class="form-control" name = "note"/><br>
<label>Posting Date</label><br>
<input type = "text" class="form-control" name = "postingdate"/><br>
<label>Closing Date</label><br>
<input type = "text" class="form-control" name = "closingdate"/><br><br>
<input type = "submit" class="btn btn-info" value = "Post Job"/>
</form>
</div>
			<div class="col-sm-3"></div>
		</div></div>
		<br>
		<!-- Footer -->
		<footer class="container-fluid bg-4 text-center">
		<p>PROG32758 Enterprise Java Development &copy; Sheridan College</p>
		</footer>
</body>
</html>
