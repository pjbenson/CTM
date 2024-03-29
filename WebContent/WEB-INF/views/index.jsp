<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico" type="icon">

<title>Catch The Monkey</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script src="bootstrap/docs/assets/js/ie-emulation-modes-warning.js"
	type="text/javascript"></script>
<link href="bootstrap/dist/css/carousel.css" rel="stylesheet"
	type="text/css">

</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Catch The Monkey</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home</a></li>
							<c:if test="${empty sessionScope.user.firstName}">
								<li><a href="loginform.html">Login</a></li>
							</c:if>
							<li><a href="#contact">Contact</a></li>
							<c:if test="${empty sessionScope.user.firstName}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="raglanroad.html">Action</a></li>
										<li><a href="#">Another action</a></li>
										<li><a href="#">Something else here</a></li>
										<li class="divider"></li>
										<li class="dropdown-header">Nav header</li>
										<li><a href="#">Separated link</a></li>
										<li><a href="#">One more separated link</a></li>
									</ul></li>
							</c:if>
						</ul>
						<c:if test="${not empty sessionScope.user.firstName}">
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown"><a class="dropdown-toggle"
									role="button" data-toggle="dropdown"><i
										class="glyphicon glyphicon-user"></i>
										${sessionScope.user.firstName} <span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="profile.html">My Profile</a></li>
										<li><a href="updateBalance.html">Add Cash</a></li>
									</ul></li>
								<li><a href="#">Wallet: <i
										class="glyphicon glyphicon-euro"></i>${sessionScope.user.account.balance}</a></li>
								<li><a
									href="${pageContext.request.contextPath}/logout.html"><i
										class="glyphicon glyphicon-lock"></i>Logout</a></li>
							</ul>
						</c:if>
					</div>
				</div>
			</nav>

		</div>
	</div>


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="bootstrap/img/Cheltenham.gif" alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Welcome to Catch The Monkey</h1>
						<p>You can avail of a range of strategies that vary in risk,
							return on investment and complexity. All strategies are designed
							to generate profit through different means via the Betfair
							exchange.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="register.html" role="button">Sign up today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="bootstrap/img/slide2.gif" alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>View Daily Statistics</h1>
						<p>Select from a range of charts to help visualise your
							strategy.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="register.html"
								role="button">Sign up today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="bootstrap/img/slide3.gif" alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Browse Gallery</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="register.html"
								role="button">Sign up today</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

	<hr class="featurette-divider">
	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle"
					src="bootstrap/img/raglanroad.jpg"
					alt="Generic placeholder image"
					style="width: 140px; height: 140px;">
				<h2>Raglan Road</h2>
				<p>Raglan Road is high risk strategy that seeks 
				to generate profit by executing trades automatically
				via Betfair.</p>
				<p>
					<a class="btn btn-default" href="strategyChoice.html" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="bootstrap/img/ginger.jpg"
					alt="Generic placeholder image"
					style="width: 140px; height: 140px;">
				<h2>Ginger Mc</h2>
				<p>Ginger Mc is a medium risk strategy and is seeks to 
				generate profit through more conservative trades than
				Raglan Road.</p>
				<p>
					<a class="btn btn-default" href="strategyChoice.html" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="bootstrap/img/lucayan.png"
					alt="Generic placeholder image"
					style="width: 140px; height: 140px;">
				<h2>Lucayan</h2>
				<p>Lucayan is our lowest risk strategy. All trades are catious in 
				nature and there are many hedging techniques applied to offset risk.</p>
				<p>
					<a class="btn btn-default" href="strategyChoice.html" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
		
		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					A structured investment approach. <span class="text-muted">The next generation in investment.</span>
				</h2>
				<p class="lead">Catch The Monkey allows you to take the stress out of trading
				on Betfair. With high analytical research and quantitative methods each strategy
				provides customers with all the advantages of porfolio investment from a stockbroker.</p>
			</div>
			
			<div class="col-md-5">
				<img class="featurette-image img-responsive" width="700" height="600"
					src="bootstrap/img/pricevolume.png" alt="Generic placeholder image">
			</div>
		</div>


		<div class="row featurette">
			<div class="col-md-5">
				<img class="featurette-image img-responsive" width="700" height="700"
					src="bootstrap/img/betfair.png" alt="Generic placeholder image">
			</div>
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Hassle free, daily returns. <span class="text-muted">Customer orientation.</span>
				</h2>
				<p class="lead">All strategies on Catch The Monkey are executed automatically via the 
				Betfair exchange which means that customers simply sign up to a strategy or strategies of their choice and 
				sit back and reap the rewards of DAILY returns.</p>
			</div>
		</div>


		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Maximum visibilty, less fees. <span class="text-muted">Control.</span>
				</h2>
				<p class="lead">Maximum vivsibility of daily positions on Betfair are accessible on
				each strategies home page, providing customers with live updates every day and charted progess
				of daily positions. All this for just a 5% fee, a lot cheaper than your stockbroker!!</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive" width="700" height="700"
					src="bootstrap/img/charts.png" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->


		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>&copy; 2014 Paul Benson.</p>
		</footer>

	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="bootstrap/docs/assets/js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
