<%@page import="Model.EmployerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Delete Confirmation</title>
<style>
a{
	text-decoration: none;
}
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
<%
EmployerBean em = (EmployerBean) request.getSession().getAttribute("employer");
String eName = em.getEName();
%>
<div class="container-fluid-body">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			<h1>You are the next innovator!</h1>
				<div class="container-fluid">
<h2>Are You Sure You Want to delete this job??</h2>
<h3><a href="JobController?action=deleteconfirmed&jobId=${jobdetail.jobId }"><span	class="glyphicon glyphicon-ok"></span> Yes, Delete </a></h3>
<h3><a href="EmployerController?action=afterupdate"><span	class="glyphicon glyphicon-remove"></span> No, Go back to Jobs Page</a></h3>
<h3>Company Detail</h3>

<h3>Job Detail</h3>
Name:<%=eName%><br>
<h4><u>Title:</u> ${jobdetail.title}</h4>
<u>Job Id:</u> ${jobdetail.jobId }<br>

<p>
<u>Description:</u>
${jobdetail.description } <br>
<u>Qualifications and Skills:</u><br>
${jobdetail.qualification }<br>
</p>

<p>
Number of Position: ${jobdetail.numOfPosition }<br>
Posting Date: ${jobdetail.postingDate }<br> 
Closing Date: ${jobdetail.closingDate }<br>
</p>

<p>
<u>Location:</u><br>
${jobdetail.address } <br>
<br>
</p>
</div>
<br>
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
