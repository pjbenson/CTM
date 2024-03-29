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

<title>Catch The Monkey</title>

<!-- Bootstrap Core CSS -->
<link
	href="bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="bootstrap/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet" type="text/css">

<!-- Timeline CSS -->
<link href="bootstrap/dist/css/timeline.css" rel="stylesheet"
	type="text/css">

<!-- Custom CSS -->
<link href="bootstrap/dist/css/sb-admin-2.css" rel="stylesheet"
	type="text/css">

<!-- Morris Charts CSS -->
<link href="bootstrap/bower_components/morrisjs/morris.css"
	rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link
	href="bootstrap/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="bootstrap/dist/css/xcharts.min.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript" src="bootstrap/dist/js/bootstrap.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script>
	$(document).ready(function() {
		$('addCash').formValidation({
			message : 'This value is not valid',
			excluded : [ ':disabled' ],
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				amount : {
					validators : {
						notEmpty : {
							message : 'Amount is required'
						}
					}
				}
			}
		});
	});
</script>
<script type="text/javascript">
	function doAjax(x) {
		$.ajax({
			type: "POST",
			url : 'month.html',
			data : ({ val : x }),
			success : function(data) {
				$('#month').html(data);
			}
		});
	}
</script>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
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
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/index.html">Catch the
						Monkey</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<c:if test="${not empty sessionScope.user.firstName}">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a class="dropdown-toggle"
								role="button" data-toggle="dropdown"><i
									class="glyphicon glyphicon-user"></i>${sessionScope.user.firstName} <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="profile.html">My Profile</a></li>
									<li><a href="updateBalance.html">Add To Wallet</a></li>
									<li><a href="" data-target="#addCash" data-toggle="modal">Invest
											in Raglan Road</a></li>
								</ul></li>
							<li><a href="#">Wallet: <i
									class="glyphicon glyphicon-euro"></i>${sessionScope.user.account.balance}</a></li>
							<li><a href="${pageContext.request.contextPath}/logout.html"><i
									class="glyphicon glyphicon-lock"></i>Logout</a></li>
						</ul>
					</c:if>
				</div>
			</div>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">${sessionScope.strategy.name}</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-line-chart fa-fw"></i> Raglan Road ROI
						<div class="pull-right">
							<div class="btn-group">
								<button type="button"
									class="btn btn-default btn-xs dropdown-toggle"
									data-toggle="dropdown">
									Month <span class="caret"></span>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a onclick="doAjax(0)">January</a></li>
									<li><a onclick="doAjax(1)">February</a></li>
									<li><a onclick="doAjax(2)">March</a></li>
									<li><a onclick="doAjax(3)">April</a></li>
									<li><a onclick="doAjax(4)">May</a></li>
									<li><a onclick="doAjax(5)">June</a></li>
									<li><a onclick="doAjax(6)">July</a></li>
									<li><a onclick="doAjax(7)">August</a></li>
									<li><a onclick="doAjax(8)">September</a></li>
									<li><a onclick="doAjax(9)">October</a></li>
									<li><a onclick="doAjax(10)">November</a></li>
									<li><a onclick="doAjax(11)">December</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<img align="bottom" alt="Google Pie Chart" src="${lineChart}"
							width="610px" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i> Todays runners
						<div class="pull-right">
							<div class="btn-group">
								<button type="button"
									class="btn btn-default btn-xs dropdown-toggle"
									data-toggle="dropdown">
									Actions <span class="caret"></span>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a href="">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr>
											<th>Race Name</th>
											<th>Horse Name</th>
											<th>Date & Time</th>
											<th>Price</th>
											<th>Return per €100</th>
										</tr>
									</thead>
									<c:forEach items="${list}" var="list">
										<tbody>
											<c:if test="${sessionScope != null}">

												<tr>
													<td><a target="_blank"
														href="https://www.betfair.com/exchange/plus/#/horse-racing/market/${list.marketId }"><c:out
																value="${list.raceName}" /></a></td>
													<td><c:out value="${list.horseName}" /></td>
													<td><c:out value="${list.date}" /></td>
													<td><c:out value="${list.price}" /></td>
													<td><c:out value="${list.expWinnings}" /></td>
												</tr>

											</c:if>
										</tbody>
									</c:forEach>
								</table>
							</div>
							<!-- /.table-responsive -->
							<!-- /.col-lg-4 (nested) -->
							<div class="col-lg-8">
								<div id="morris-bar-chart"></div>
							</div>
							<!-- /.col-lg-8 (nested) -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.panel-body -->
				</div>

				<div class="modal fade" id="addCash" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Investment Amount</h4>
							</div>

							<div class="modal-body">
								<!-- The form is placed inside the body of modal -->
								<form:form id="addCash" method="POST" action="/CTM/addCash.html"
									class="form-horizontal">
									<div class="form-group">
										<label class="col-xs-3 control-label">Amount</label>
										<div class="col-xs-5">
											<input type="text" class="form-control" name="amount" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-5 col-xs-offset-3">
											<button type="submit" class="btn btn-default">Add</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>

				<!-- /.panel -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i> Runner Pie Chart
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<img alt="Return Pie Chart" src="${pieChart}" width="610px" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart fa-fw"></i> Raglan Road Information
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="list-group">
							<a href="#" class="list-group-item"> <i
								class="fa fa-user fa-fw"></i>Amount you have invested: <span
								class="pull-right text-muted small">
									€${sessionScope.user.account.raglanroad}</span>
							</a> <a href="#" class="list-group-item"> <i
								class="fa fa-user fa-fw"></i>Date you invested: <span
								class="pull-right text-muted small">
									${signUpDate}</span>
							</a><a href="#" class="list-group-item"> <i
								class="fa fa-user fa-fw"></i> Your total return to date: <span
								class="pull-right text-muted small">€${totalUserReturn}</span>
							</a> <a href="#" class="list-group-item"> <i
								class="fa fa-users fa-fw"></i> Total number of investors: <span
								class="pull-right text-muted small">${raglanSubscribers }
							</span>
							</a> <a href="#" class="list-group-item"> <i
								class="fa fa-money fa-fw"></i> Total pool: <span
								class="pull-right text-muted small">
									€${sessionScope.strategy.pool}</span>
							</a> <a href="#" class="list-group-item"> <i
								class="fa fa-money fa-fw"></i> Total return to date: <span
								class="pull-right text-muted small">€${totalReturn}</span>
							</a>
						</div>
						<!-- /.list-group -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i>Your Monthly returns
						<div class="pull-right">
							<div class="btn-group">
								<button type="button"
									class="btn btn-default btn-xs dropdown-toggle"
									data-toggle="dropdown">
									Month <span class="caret"></span>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a onclick="myFunction(1)">January</a></li>
									<li><a href="#">February</a></li>
									<li><a href="#">March</a></li>
									<li><a href="#">April</a></li>
									<li><a href="#">May</a></li>
									<li><a href="#">June</a></li>
									<li><a href="#">July</a></li>
									<li><a href="#">August</a></li>
									<li><a href="#">September</a></li>
									<li><a href="#">October</a></li>
									<li><a href="#">November</a></li>
									<li><a href="#">December</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div id="morris-donut-chart"></div>
						<img alt="Google Pie Chart" src="${barChart}" width="610px" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-line-chart fa-fw"></i>Strategy Performance
						Comparison
					</div>
					<div class="panel-body">
						<div id="morris-donut-chart"></div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
				<div class="chat-panel panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-comments fa-fw"></i> Chat
						<div class="btn-group pull-right">
							<button type="button"
								class="btn btn-default btn-xs dropdown-toggle"
								data-toggle="dropdown">
								<i class="fa fa-chevron-down"></i>
							</button>
							<ul class="dropdown-menu slidedown">
								<li><a href="#"> <i class="fa fa-refresh fa-fw"></i>
										Refresh
								</a></li>
								<li><a href="#"> <i class="fa fa-check-circle fa-fw"></i>
										Available
								</a></li>
								<li><a href="#"> <i class="fa fa-times fa-fw"></i> Busy
								</a></li>
								<li><a href="#"> <i class="fa fa-clock-o fa-fw"></i>
										Away
								</a></li>
								<li class="divider"></li>
								<li><a href="#"> <i class="fa fa-sign-out fa-fw"></i>
										Sign Out
								</a></li>
							</ul>
						</div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<ul class="chat">
							<li class="left clearfix"><span class="chat-img pull-left">
							</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Jack Sparrow</strong> <small
											class="pull-right text-muted"> <i
											class="fa fa-clock-o fa-fw"></i> 12 mins ago
										</small>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Curabitur bibendum ornare dolor, quis ullamcorper ligula
										sodales.</p>
								</div></li>
							<li class="left clearfix">
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Jack Sparrow</strong> <small
											class="pull-right text-muted"> <i
											class="fa fa-clock-o fa-fw"></i> 14 mins ago
										</small>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Curabitur bibendum ornare dolor, quis ullamcorper ligula
										sodales.</p>
								</div>
							</li>
							<li class="left clearfix">
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Jack Sparrow</strong> <small
											class="pull-right text-muted"> <i
											class="fa fa-clock-o fa-fw"></i> 14 mins ago
										</small>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Curabitur bibendum ornare dolor, quis ullamcorper ligula
										sodales.</p>
								</div>
							</li>
						</ul>
					</div>
					<!-- /.panel-body -->
					<div class="panel-footer">
						<div class="input-group">
							<input id="btn-input" type="text" class="form-control input-sm"
								placeholder="Type your message here..." /> <span
								class="input-group-btn">
								<button class="btn btn-warning btn-sm" id="btn-chat">
									Send</button>
							</span>
						</div>
					</div>
					<!-- /.panel-footer -->
				</div>
				<!-- /.panel .chat-panel -->
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="bootstrap/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="bootstrap/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="bootstrap/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="bootstrap/bower_components/raphael/raphael-min.js"></script>
	<script src="bootstrap/bower_components/morrisjs/morris.min.js"></script>
	<script src="bootstrap/js/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="bootstrap/dist/js/sb-admin-2.js"></script>

</body>

</html>
