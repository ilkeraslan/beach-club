<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="it.ilker.apsw.beachclub.ClientSearchService"%>
<%@ page import="it.ilker.apsw.beachclub.models.Client"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Client Info</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
	<%  
		Client client = (Client) request.getAttribute("client");
	%>
	<div class="container-fluid">
		<div class="m-4">
			<table class="table table-bordered table-striped">
				<thead class="thead-light">
					<tr>
						<th colspan="2" class="text-center">Client Information</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Client ID</td>
						<td><%= client.getId() %></td>
					</tr>
					<tr>
						<td>Client First Name</td>
						<td><%= client.getFirstName() %></td>
					</tr>
					<tr>
						<td>Client Last Name</td>
						<td><%= client.getLastName() %></td>
					</tr>
					<tr>
						<td>Client Email</td>
						<td><%= client.getEmail() %></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="mt-4 text-center">
			<form action='/beach-club/client-search.html' method="post">
				<button type="submit" class="btn btn-success">Search Another Client</button>	
			</form>
		</div>
	</div>

</body>
</html>