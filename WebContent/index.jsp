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
		<script src="script.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<div>
				<h1>Beach Club</h1>
				<p><a href="client-search.html">Client Search</a></p>
				<p><a href="seat-search.html">Seat Search</a></p>
				<p><a href="/auth/login.jsp">Login</a></p>
				<ul>
					<li>Now: <%= new java.util.Date() %></li>
					<li>Operator session: <%= session.getId() %></li>
				</ul>
			</div>
			<div>
				<div>
					<h2>Queue</h2>
					<select id="queueForTicket">
						<option selected disabled hidden="true">Choose here</option>
					</select>
					<input type="text" id="nameInputForTicket">
					<button onclick="addToQueue()">Get in line</button>
					<button onclick="removeFromQueue()">Leave the line</button>
				</div>
				<div>
					<h2>Current Queue Length: <span id="currentQueueLength">0</span></h2>
				</div>
			</div>
			<div>
				<div id="clubAvailability" class="table-responsive">
					<h2>Club Availability</h2>
					<% Map<String, Seat> seats = new BeachBookingStorage().getSeats(); %>
						<table class="table table-bordered table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope="col">#</th>
									<th colspan="5" class="text-center">SUNBEDS</th>
								</tr>
							</thead>
							<tbody>
							<tr>
								<th scope="row">1-5</th>
								<% for(Integer i=1; i<=5; i++) {%>
								<td><%= seats.get(i.toString()).getId() %> - Occupied: <%= seats.get(i.toString()).getIsOccupied() %></td>
								<% } %>
							</tr>
							<tr>
								<th scope="row">6-10</th>
								<% for(Integer i=6; i<=10; i++) {%>
								<td><%= seats.get(i.toString()).getId() %> - Occupied: <%= seats.get(i.toString()).getIsOccupied() %></td>
								<% } %>
							</tr>
							<tr>
								<th scope="row">11-15</th>
								<% for(Integer i=11; i<=15; i++) {%>
								<td><%= seats.get(i.toString()).getId() %> - Occupied: <%= seats.get(i.toString()).getIsOccupied() %></td>
								<% } %>
							</tr>
							<tr>
								<th scope="row">16-20</th>
								<% for(Integer i=16; i<=20; i++) {%>
								<td><%= seats.get(i.toString()).getId() %> - Occupied: <%= seats.get(i.toString()).getIsOccupied() %></td>
								<% } %>
							</tr>
							<tr>
								<th scope="row">21-25</th>
								<% for(Integer i=21; i<=25; i++) {%>
								<td><%= seats.get(i.toString()).getId() %> - Occupied: <%= seats.get(i.toString()).getIsOccupied() %></td>
								<% } %>
							</tr>
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</body>
</html>