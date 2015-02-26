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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.1', {
		packages : [ 'line' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = new google.visualization.DataTable();
		data.addColumn('number', 'Days');
		data.addColumn('number', 'Strategy 1');
		data.addColumn('number', 'Strategy 2');
		data.addColumn('number', 'Strategy 3');

		data.addRows([ [ 1, 37.8, 80.8, 41.8 ], [ 2, 30.9, 69.5, 32.4 ],
				[ 3, 25.4, 57, 25.7 ], [ 4, 11.7, 18.8, 10.5 ],
				[ 5, 11.9, 17.6, 10.4 ], [ 6, 8.8, 13.6, 7.7 ],
				[ 7, 7.6, 12.3, 9.6 ], [ 8, 12.3, 29.2, 10.6 ],
				[ 9, 16.9, 42.9, 14.8 ], [ 10, 12.8, 30.9, 11.6 ],
				[ 11, 5.3, 7.9, 4.7 ], [ 12, 6.6, 8.4, 5.2 ],
				[ 13, 4.8, 6.3, 3.6 ], [ 14, 4.2, 6.2, 3.4 ] ]);

		var options = {
			chart : {
				title : 'Strategy Performance',
				subtitle : 'return per 100 Euro'
			},
			width : 900,
			height : 500
		};

		var chart = new google.charts.Line(document
				.getElementById('linechart_material'));

		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/index.html">Catch The
					Monkey</a>
			</div>
			<c:if test="${empty sessionScope.user}">
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
			<c:if test="${not empty sessionScope.user}">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" role="button"
						data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
							${sessionScope.user.firstName} <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="">My Profile</a></li>
							<li><a href="updateBalance.html">Add Cash</a></li>
						</ul></li>
					<li><a href="#">Wallet: <i class="glyphicon glyphicon-euro"></i>${sessionScope.user.account.balance}</a></li>
					<li><a href="${pageContext.request.contextPath}/logout.html"><i class="glyphicon glyphicon-lock"></i>Logout</a></li>
				</ul>
			</div>
			</c:if>
		</div>
	</div>

	<div class="container theme-showcase" role="main">

		<div class="jumbotron ">
			<div class="container">
				<h1>Register!</h1>
				<p>Register to avail of Catch the Monkey's quantitative
					strategies, you can choose between low, medium and high risk
					strategies.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="register.html"
						role="button">Register &raquo;</a>
				</p>
				<p>
					<a class="btn btn-primary btn-lg" href="loginform.html"
						role="button">Log In &raquo;</a>
				</p>
			</div>
		</div>

		<div class="jumbotron">
			<div class="container">
				<div id="linechart_material"></div>
			</div>
		</div>

		<div class="jumbotron ">
			<div class="container">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="http://placehold.it/1900x1080&text=Slide One" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						<div class="item">
							<img src="http://placehold.it/1900x1080&text=Slide One" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						...
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
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
	</div>
</body>
</html>