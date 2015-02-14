<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>Catch The Monkey</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">Catch The Monkey</a>
			</div>
			<c:if test="${not empty pageContext.session}">
				<div id="navbar" class="navbar-collapse collapse">
					<form:form action="loginform.html" method="POST" commandName="user"
						class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" placeholder="Email" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" placeholder="Password"
								class="form-control">
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
					</form:form>
				</div>
			</c:if>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1>Register!</h1>
			<p>Register to avail of Catch the Monkey's quantitative
				strategies, you can choose between low, medium and high risk
				strategies.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="register.html" role="button">Register
					&raquo;</a>
			</p>
			<p>
				<a class="btn btn-primary btn-lg" href="loginform.html"
					role="button">Log In &raquo;</a>
			</p>
		</div>
	</div>

	<div class="navbar navbar-default navbar-fixed-bottom">

		<div class="container">
			<p class="navbar-text pull-left">Site Built By Paul Benson</p>
			<a href="http://racingpost.com/"
				class="navbar-btn btn-danger btn pull-right">Racing Post</a>
		</div>

	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>