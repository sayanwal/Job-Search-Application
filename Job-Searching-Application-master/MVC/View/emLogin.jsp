<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
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
			<h1>You are the next innovator!</h1>
	<form action="EmployerController" method="post">
	<input type="hidden" name="action" class="form-control" value="login">
		User name: <input type="text" class="form-control" name="username"><br>
		Password: <input type="password" class="form-control" name="password"><br> 
		<input type="submit" class="btn btn-info" value="Sign In">
	</form>
	<br>
	<form action="EmployerController" method="post">
	<input type="hidden" class="form-control" name="action" value="newAccount">
		You don't have an account yet? 
		<input type="submit" class="btn btn-info" value="Create an account">
	</form>
	</div>
			<div class="col-sm-3"></div>
		</div>
		</div>
		<br>
		<!-- Footer -->
		<footer class="container-fluid bg-4 text-center">
		<p>PROG32758 Enterprise Java Development &copy; Sheridan College</p>
		</footer>
</body>
</html>
