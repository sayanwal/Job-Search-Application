<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Model.EmployerBean"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
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

<%
EmployerBean em = (EmployerBean)request.getSession().getAttribute("employer");
String eName = em.getEName();
int eId = em.getEmployerId();
%>

<!-- navigation -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="emCreateAccount.jsp"><span	class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="EmployerController?action=logout"><span	class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>

<div class="container-fluid-body">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6">
			<h1>You are the next innovator!</h1>
				<div class="container-fluid">
<h2>Welcome <%=eName%></h2>
<h3>EmployerId <%=eId%></h3>
<h3>You Already Posted These Jobs</h3>
<table class="table table-hover">
		<thead>
			<tr>
				<th>JobID</th>
				<th>JobTitle</th>
				<th>City</th>
				<th>PostingDate</th>
				<th>ClosingDate</th>
				<th>EditJobs</th>
				<th>DeleteJobs</th>
			</tr>
		</thead>
		<%
			//set attribute named jobs in previous file
			// to list all the jobs
		%>
		<tbody>
			<c:forEach items="${jobs}" var="jobs">
				<tr>
					<td><c:out value="${jobs.jobId}"></c:out></td>
					<td><c:out value="${jobs.title}"></c:out></td>
					<td><c:out value="${jobs.city}"></c:out></td>
					<td><c:out value="${jobs.postingDate}"></c:out></td>
					<td><c:out value="${jobs.closingDate}"></c:out></td>
					<td><a href="JobController?action=edit&jobId=${jobs.jobId}">Edit</a></td>
					<td><a href="JobController?action=delete&jobId=${jobs.jobId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<h2><a href="PostJob.jsp">Click here to Post A Job!</a></h2>
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
