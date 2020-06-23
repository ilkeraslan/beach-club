<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.ilker.apsw.beachclub.models.Seat"%>
<%@ page import="it.ilker.apsw.beachclub.BeachBookingService"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Seat Info</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
	<% 
		String seatId = (String) request.getAttribute("seatId"); 
		Seat seat = BeachBookingService.findSeat(seatId);
		String currentUsername = (String) request.getSession().getAttribute("username"); 
	%>
	<div class="container-fluid">
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/beach-club/">BeachClub</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			  <% if(currentUsername == null && request.getRemoteUser() == null) { %>
			    <div class="navbar-nav">
			      <a class="nav-item nav-link active" href="/beach-club/">Home <span class="sr-only">(current)</span></a>
				  <a class="nav-item nav-link" href="ticket-line">TicketLine</a>
			      <a class="nav-item nav-link" href="client-search.html">Client Search</a>
			      <a class="nav-item nav-link" href="seat-search.html">Seat Search</a>
			      <a class="nav-item nav-link" href="./payments/cart.jsp">Cart</a>
			      <a class="nav-item nav-link" href="./auth/login.html">Login</a>
			      <a class="nav-item nav-link" href="./auth/signup.html">Signup</a>
			    </div>
			    <% } else { %>
			      <div class="navbar-nav">
			        <a class="nav-item nav-link active" href="/beach-club/">Home <span class="sr-only">(current)</span></a>
					<a class="nav-item nav-link" href="ticket-line">TicketLine</a>
			        <a class="nav-item nav-link" href="client-search.html">Client Search</a>
			        <a class="nav-item nav-link" href="seat-search.html">Seat Search</a>
			        <a class="nav-item nav-link" href="./payments/cart.jsp">Cart</a>
			        <a class="nav-item nav-link" href="/beach-club/auth/logout.jsp">Logout</a>
			      </div>
			    <% } %>
			  </div>
			</nav>
		</div>
		<div class="mt-4">
			<table class="table table-bordered table-striped">
				<thead class="thead-light">
					<tr>
						<th colspan="2" class="text-center">Seat Information</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Seat id: <%= seat.getId() %></td>
						<td>Seat is occupied: <%= seat.getIsOccupied() %></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="mt-4">
			<form id="seat_occupation_form" action='/beach-club/booking' method="post">
			  <input type="hidden" id="bookingSeatId" name="bookingSeatId" value="<%= seat.getId() %>">
			  <% if(!seat.getIsOccupied()) { %>
			  <input type="hidden" id="operationType" name="operationType" value="<%= BeachBookingService.OCCUPY %>">
			  <button type="submit" class="btn btn-success">Occupy</button>
			  <button type="submit" class="btn btn-success invisible">Free</button>
			  <% } else { %>
			  <input type="hidden" id="operationType" name="operationType" value="<%= BeachBookingService.FREE %>">
			  <button type="submit" class="btn btn-success invisible">Occupy</button>
			  <button type="submit" class="btn btn-success">Free</button>
			  <% } %>
			</form>
		</div>
		
	</div>
</body>
</html>