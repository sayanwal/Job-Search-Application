<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Job List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"	rel="stylesheet">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.bg-4 {
	background-color: #2f2f2f; /* Black Gray */
	color: #fff;
}
.container-fluid {
	padding-top: 40px;
	padding-bottom: 40px;
}
body {
	text-align: center;
}
p {
	font-size: 16px;
}
th{
	text-align: center;
}
.container-fluid-body{
	padding-top: 0px;
	padding-bottom: 0px;
}
</style>
</head>
<body>
	<!-- navigation -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="emCreateAccount.jsp"><span	class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="emLogin.jsp"><span	class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid-body">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6">
			<h1>You are the next innovator!</h1>
				<div class="container-fluid">
					<table class="table table-hover" >
						<thead>
							<tr>
								<th>Job ID</th>
								<th>Job Title</th>
								<th>City</th>
								<th>Posting Date</th>
								<th>Closing Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${jobs}" var="jobs">
								<tr>
									<td>
										<a href="JobController?action=detail&jobId=${jobs.jobId}">
										<c:out value="${jobs.jobId}"></c:out>
										</a>
									</td>
									<td><c:out value="${jobs.title}"></c:out></td>
									<td><c:out value="${jobs.city}"></c:out></td>
									<td><c:out value="${jobs.postingDate}"></c:out></td>
									<td><c:out value="${jobs.closingDate}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="col-sm-3"></div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center">
	<p>PROG32758 Enterprise Java Development &copy; Sheridan College</p>
	</footer>
</body>
</html>
