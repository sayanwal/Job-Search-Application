<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign-Up</title>
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
			<h4 class = "text-danger">${error }</h4>
				<form action="EmployerController" method="post">
					<input type="hidden" name="action" class="form-control"
						value="createAccount"> User Name:<br> <input
						type="text" name="username" class="form-control"><br>
					Password:<br> <input type="password" name="password"
						class="form-control"><br> Company Name:<br> <input
						type="text" name="eName" class="form-control"><br>
					Address:<br> <input type="text" name="address"
						class="form-control"><br> Contact:<br> <input
						type="text" name="contact" class="form-control"><br>
					About us:<br>
					<textarea name="aboutUs" class="form-control"></textarea>
					<br> Website:<br> <input type="text" name="website"
						class="form-control"><br> <br> <input
						type="submit" class="btn btn-info" value="Sign Up">
				</form>
				<br>
			</div>
			<div class="col-sm-3"></div>
		</div>
		
		<!-- Footer -->
		<footer class="container-fluid bg-4 text-center">
		<p>PROG32758 Enterprise Java Development &copy; Sheridan College</p>
		</footer>
</body>
</html>
