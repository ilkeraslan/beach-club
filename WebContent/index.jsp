<!DOCTYPE html>
<%@ page import="it.ilker.apsw.beachclub.BeachBookingStorage"%>
<%@ page import="it.ilker.apsw.beachclub.models.Seat"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Beach Club</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
		<script src="script.js"></script>
		<script type="text/javascript">
			$(window).on('pageshow', function() {
				$.get("/beach-club/sunbeds", function(data, status) {
					if (status == "success") {
						$("#clubAvailability").html(data);
					}
				});
			});
		</script>
	</head>
	<body>
	<% String currentUsername = (String) session.getAttribute("username"); %>
		<div class="container-fluid">
			<div>
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="">BeachClub</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				  <% if(currentUsername == null) { %>
				    <div class="navbar-nav">
				      <a class="nav-item nav-link active" href="">Home <span class="sr-only">(current)</span></a>
				      <a class="nav-item nav-link" href="client-search.html">Client Search</a>
				      <a class="nav-item nav-link" href="seat-search.html">Seat Search</a>
				      <a class="nav-item nav-link" href="./payments/cart.html">Cart</a>
				      <a class="nav-item nav-link" href="./auth/login.html">Login</a>
				      <a class="nav-item nav-link" href="./auth/signup.html">Signup</a>
				    </div>
				    <% } else { %>
				      <div class="navbar-nav">
				        <a class="nav-item nav-link active" href="">Home <span class="sr-only">(current)</span></a>
				        <a class="nav-item nav-link" href="client-search.html">Client Search</a>
				        <a class="nav-item nav-link" href="seat-search.html">Seat Search</a>
				        <a class="nav-item nav-link" href="./payments/cart.html">Cart</a>
				        <a class="nav-item nav-link" href="./auth/logout.jsp">Logout</a>
				      </div>
				    <% } %>
				  </div>
				</nav>

				<ul>
					<li>Now: <%= new java.util.Date() %></li>
					<li>Operator session: <%= session.getId() %></li>
				</ul>
			</div>
			
			<div>
				<div class="form-group">
					<h2>Queue</h2>
					<select class="form-control" id="queueForTicket">
						<option selected disabled hidden="false">Choose here</option>
					</select>
					<input type="text" class="form-control" id="nameInputForTicket" placeholder="Your name here.">
					<button onclick="addToQueue()" type="submit" class="btn btn-success">Get in line</button>
					<button onclick="removeFromQueue()" type="submit" class="btn btn-danger">Leave the line</button>
				</div>
				<div>
					<h2>Current Queue Length: <span id="currentQueueLength">0</span></h2>
				</div>
			</div>
			
			<div>
				<div id="clubAvailability" class="table-responsive"></div>
			</div>
			
		</div>
	</body>
</html>