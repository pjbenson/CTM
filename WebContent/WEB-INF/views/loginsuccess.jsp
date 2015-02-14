<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
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
<meta charset="utf-8">
<title>Sign in &middot; Twitter Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="../assets/ico/favicon.png">
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
				<a class="navbar-brand" href="index.html">Catch the Monkey</a>
			</div>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a class="dropdown-toggle" role="button"
					data-toggle="dropdown" href="#"><i
						class="glyphicon glyphicon-user"></i>
						${sessionScope.user.firstName} <span class="caret"></span></a>
					<ul id="g-account-menu" class="dropdown-menu" role="menu">
						<li><a href="#">My Profile</a></li>
						<li><a href="#">Add Cash</a></li>
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/logout.html"><i
						class="glyphicon glyphicon-lock"></i>Logout</a></li>
			</ul>
		</div>
	</nav>

	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">

	</div>
	<!-- /Header -->

	<!-- Main -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<!-- Left column -->
				<a href="#"><strong><i
						class="glyphicon glyphicon-wrench"></i> Tools</strong></a>

				<hr>

				<ul class="list-unstyled">
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#userMenu">
							<h5>
								Settings <i class="glyphicon glyphicon-chevron-down"></i>
							</h5>
					</a>
						<ul class="list-unstyled collapse in" id="userMenu">
							<li class="active"><a href="#"><i
									class="glyphicon glyphicon-home"></i> Home</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
									Messages <span class="badge badge-info">4</span></a></li>
							<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
									Options</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
									Shoutbox</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									Staff List</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-flag"></i>
									Transactions</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-exclamation-sign"></i> Rules</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-off"></i>
									Logout</a></li>
						</ul></li>
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#menu2">
							<h5>
								Reports <i class="glyphicon glyphicon-chevron-right"></i>
							</h5>
					</a>

						<ul class="list-unstyled collapse" id="menu2">
							<li><a href="#">Information &amp; Stats</a></li>
							<li><a href="#">Views</a></li>
							<li><a href="#">Requests</a></li>
							<li><a href="#">Timetable</a></li>
							<li><a href="#">Alerts</a></li>
						</ul></li>
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#menu3">
							<h5>
								Social Media <i class="glyphicon glyphicon-chevron-right"></i>
							</h5>
					</a>

						<ul class="list-unstyled collapse" id="menu3">
							<li><a href="#"><i class="glyphicon glyphicon-circle"></i>
									Facebook</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-circle"></i>
									Twitter</a></li>
						</ul></li>
				</ul>

				<hr>

				<a href="#"><strong><i class="glyphicon glyphicon-link"></i>
						Resources</strong></a>

				<hr>

				<ul class="nav nav-pills nav-stacked">
					<li class="nav-header"></li>
					<li><a href="#"><i class="glyphicon glyphicon-list"></i>
							Layouts &amp; Templates</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-briefcase"></i>
							Toolbox</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-link"></i>
							Widgets</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-list-alt"></i>
							Reports</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-book"></i>
							Pages</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"></i>
							Social Media</a></li>
				</ul>

				<hr>
				<ul class="nav nav-stacked">
					<li class="active"><a href="http://bootply.com"
						title="The Bootstrap Playground" target="ext">Playground</a></li>
					<li><a href="/tagged/bootstrap-3">Bootstrap 3</a></li>
					<li><a href="/61518" title="Bootstrap 3 Panel">Panels</a></li>
					<li><a href="/61521" title="Bootstrap 3 Icons">Glyphicons</a></li>
					<li><a href="/62603">Layout</a></li>
				</ul>

				<hr>

				<a href="#"><strong>Want More Templates?</strong></a>

				<hr>

				<ul class="nav nav-stacked">
					<li class="active"><a rel="nofollow"
						href="http://goo.gl/pQoXEh" target="ext">Premium Themes</a></li>
					<li><a rel="nofollow"
						href="http://gridgum.com/themes/category/bootstrap-themes/?affiliates=45">GridGum</a></li>
					<li><a rel="nofollow" href="http://bootstrapzero.com">BootstrapZero</a></li>
				</ul>


			</div>
			<!-- /col-3 -->
			<div class="col-sm-9">

				<!-- column 2 -->
				<ul class="list-inline pull-right">
					<li><a href="#"><i class="glyphicon glyphicon-cog"></i></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-comment"></i><span
							class="count">3</span></a>
					<ul class="dropdown-menu" role="menu">
							<li><a href="#">1. Is there a way..</a></li>
							<li><a href="#">2. Hello, admin. I would..</a></li>
							<li><a href="#"><strong>All messages</strong></a></li>
						</ul></li>
					<li><a href="#"><i class="glyphicon glyphicon-user"></i></a></li>
					<li><a title="Add Widget" data-toggle="modal"
						href="#addWidgetModal"><span
							class="glyphicon glyphicon-plus-sign"></span> Add Widget</a></li>
				</ul>
				<a href="#"><strong><i
						class="glyphicon glyphicon-dashboard"></i> My Dashboard</strong></a>

				<hr>

				<div class="row">



					<!-- center left-->
					<div class="col-md-6">
						<div class="well">
							Inbox Messages <span class="badge pull-right">3</span>
						</div>

						<hr>

						<div class="btn-group btn-group-justified">
							<a href="#" class="btn btn-primary col-sm-3"> <i
								class="glyphicon glyphicon-plus"></i><br> Service
							</a> <a href="#" class="btn btn-primary col-sm-3"> <i
								class="glyphicon glyphicon-cloud"></i><br> Cloud
							</a> <a href="#" class="btn btn-primary col-sm-3"> <i
								class="glyphicon glyphicon-cog"></i><br> Tools
							</a> <a href="#" class="btn btn-primary col-sm-3"> <i
								class="glyphicon glyphicon-question-sign"></i><br> Help
							</a>
						</div>

						<hr>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>Reports</h4>
							</div>
							<div class="panel-body">

								<small>Success</small>
								<div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="72" aria-valuemin="0"
										aria-valuemax="100" style="width: 72%">
										<span class="sr-only">72% Complete</span>
									</div>
								</div>
								<small>Info</small>
								<div class="progress">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
										style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
								<small>Warning</small>
								<div class="progress">
									<div class="progress-bar progress-bar-warning"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
								<small>Danger</small>
								<div class="progress">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="80" aria-valuemin="0"
										aria-valuemax="100" style="width: 80%">
										<span class="sr-only">80% Complete</span>
									</div>
								</div>

							</div>
							<!--/panel-body-->
						</div>
						<!--/panel-->

						<hr>

						<!--tabs-->
						<div class="container">
							<div class="col-md-4">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#profile" data-toggle="tab">Profile</a></li>
									<li><a href="#messages" data-toggle="tab">Messages</a></li>
									<li><a href="#settings" data-toggle="tab">Settings</a></li>
								</ul>

								<div class="tab-content">
									<div class="tab-pane active" id="profile">
										<h4>
											<i class="glyphicon glyphicon-user"></i>
										</h4>
										Lorem profile dolor sit amet, consectetur adipiscing elit.
										Duis pharetra varius quam sit amet vulputate.
										<p>Quisque mauris augue, molestie tincidunt condimentum
											vitae, gravida a libero. Aenean sit amet felis dolor, in
											sagittis nisi.</p>
									</div>
									<div class="tab-pane" id="messages">
										<h4>
											<i class="glyphicon glyphicon-comment"></i>
										</h4>
										Message ipsum dolor sit amet, consectetur adipiscing elit.
										Duis pharetra varius quam sit amet vulputate.
										<p>Quisque mauris augu.</p>
									</div>
									<div class="tab-pane" id="settings">
										<h4>
											<i class="glyphicon glyphicon-cog"></i>
										</h4>
										Lorem settings dolor sit amet, consectetur adipiscing elit.
										Duis pharetra varius quam sit amet vulputate.
										<p>Quisque mauris augue, molestie.</p>
									</div>
								</div>
							</div>
						</div>

						<!--/tabs-->

						<hr>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>New Requests</h4>
							</div>
							<div class="panel-body">
								<div class="list-group">
									<a href="#" class="list-group-item active">Hosting virtual
										mailbox serv..</a> <a href="#" class="list-group-item">Dedicated
										server doesn't..</a> <a href="#" class="list-group-item">RHEL
										6 install on new..</a>
								</div>
							</div>
						</div>

					</div>
					<!--/col-->
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>Notices</h4>
							</div>
							<div class="panel-body">

								<div class="alert alert-info">
									<button type="button" class="close" data-dismiss="alert">×</button>
									This is a dismissable alert.. just sayin'.
								</div>

								This is a dashboard-style layout that uses Bootstrap 3. You can
								use this template as a starting point to create something more
								unique. <br>
								<br> Visit the Bootstrap Playground at <a
									href="http://bootply.com">Bootply</a> to tweak this layout or
								discover more useful code snippets.
							</div>
						</div>

						<table class="table table-striped">
							<thead>
								<tr>
									<th>Visits</th>
									<th>ROI</th>
									<th>Source</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>45</td>
									<td>2.45%</td>
									<td>Direct</td>
								</tr>
								<tr>
									<td>289</td>
									<td>56.2%</td>
									<td>Referral</td>
								</tr>
								<tr>
									<td>98</td>
									<td>25%</td>
									<td>Type</td>
								</tr>
								<tr>
									<td>..</td>
									<td>..</td>
									<td>..</td>
								</tr>
								<tr>
									<td>..</td>
									<td>..</td>
									<td>..</td>
								</tr>
							</tbody>
						</table>

						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-title">
									<i class="glyphicon glyphicon-wrench pull-right"></i>
									<h4>Post Request</h4>
								</div>
							</div>
							<div class="panel-body">

								<form class="form form-vertical">

									<div class="control-group">
										<label>Name</label>
										<div class="controls">
											<input type="text" class="form-control"
												placeholder="Enter Name">
										</div>
									</div>

									<div class="control-group">
										<label>Message</label>
										<div class="controls">
											<textarea class="form-control"></textarea>
										</div>
									</div>

									<div class="control-group">
										<label>Category</label>
										<div class="controls">
											<select class="form-control"><option>options</option></select>
										</div>
									</div>

									<div class="control-group">
										<label></label>
										<div class="controls">
											<button type="submit" class="btn btn-primary">Post</button>
										</div>
									</div>

								</form>


							</div>
							<!--/panel content-->
						</div>
						<!--/panel-->

						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-title">
									<h4>Engagement</h4>
								</div>
							</div>
							<div class="panel-body">
								<div class="col-xs-4 text-center">
									<img src="http://placehold.it/80/BBBBBB/FFF"
										class="img-circle img-responsive">
								</div>
								<div class="col-xs-4 text-center">
									<img src="http://placehold.it/80/EFEFEF/555"
										class="img-circle img-responsive">
								</div>
								<div class="col-xs-4 text-center">
									<img src="http://placehold.it/80/EEEEEE/222"
										class="img-circle img-responsive">
								</div>
							</div>
						</div>
						<!--/panel-->

					</div>
					<!--/col-span-6-->

				</div>
				<!--/row-->

				<hr>

				<a href="#"><strong><i
						class="glyphicon glyphicon-comment"></i> Discussions</strong></a>

				<hr>

				<div class="row">
					<div class="col-md-12">
						<ul class="list-group">
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-flash"></i> <small>(3 mins
										ago)</small> The 3rd page reports don't contain any links. Does anyone
									know why..</a></li>
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-flash"></i> <small>(1 hour
										ago)</small> Hi all, I've just post a report that show the
									relationship betwe..</a></li>
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-heart"></i> <small>(2 hrs
										ago)</small> Paul. That document you posted yesterday doesn't seem to
									contain the over..</a></li>
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-heart-empty"></i> <small>(4
										hrs ago)</small> The map service on c243 is down today. I will be
									fixing the..</a></li>
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-heart"></i> <small>(yesterday)</small>
									I posted a new document that shows how to install the services
									layer..</a></li>
							<li class="list-group-item"><a href="#"><i
									class="glyphicon glyphicon-flash"></i> <small>(yesterday)</small>
									..</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!--/col-span-9-->
		</div>
	</div>
	<!-- /Main -->

	<footer class="text-center">
		This Bootstrap 3 dashboard layout is compliments of <a
			href="http://www.bootply.com/85850"><strong>Bootply.com</strong></a>
	</footer>

	<div class="modal" id="addWidgetModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">Add Widget</h4>
				</div>
				<div class="modal-body">
					<p>Add a widget stuff here..</p>
				</div>
				<div class="modal-footer">
					<a href="#" data-dismiss="modal" class="btn">Close</a> <a href="#"
						class="btn btn-primary">Save changes</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dalog -->
	</div>
	<!-- /.modal -->





	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<script type='text/javascript'
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>







	<!-- JavaScript jQuery code from Bootply.com editor  -->

	<script type='text/javascript'>
        
        $(document).ready(function() {
        
            $(".alert").addClass("in").fadeOut(4500);

/* swap open/close side menu icons */
$('[data-toggle=collapse]').click(function(){
  	// toggle icon
  	$(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
});
        
        });
        
        </script>

	<script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
          ga('create', 'UA-40413119-1', 'bootply.com');
          ga('send', 'pageview');
        </script>



	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery.js"></script>
	<script src="../assets/js/bootstrap-transition.js"></script>
	<script src="../assets/js/bootstrap-alert.js"></script>
	<script src="../assets/js/bootstrap-modal.js"></script>
	<script src="../assets/js/bootstrap-dropdown.js"></script>
	<script src="../assets/js/bootstrap-scrollspy.js"></script>
	<script src="../assets/js/bootstrap-tab.js"></script>
	<script src="../assets/js/bootstrap-tooltip.js"></script>
	<script src="../assets/js/bootstrap-popover.js"></script>
	<script src="../assets/js/bootstrap-button.js"></script>
	<script src="../assets/js/bootstrap-collapse.js"></script>
	<script src="../assets/js/bootstrap-carousel.js"></script>
	<script src="../assets/js/bootstrap-typeahead.js"></script>
</body>
</html>