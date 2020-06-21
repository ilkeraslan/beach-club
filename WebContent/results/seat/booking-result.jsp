<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="container-fluid">
		<div class="mt-4">
			<table class="table table-bordered table-striped">
				<thead class="thead-light">
					<tr>
						<th colspan="2" class="text-center">Seat Information</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Seat id: ${seat.id}</td>
						<td>Seat is occupied: ${seat.isOccupied}</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="mt-4">
			<form id="seat_occupation_form" action='/beach-club/booking' method="post">
			  <input type="hidden" id="bookingSeatId" name="bookingSeatId" value="${seat.id}">
			  <button type="submit" class="btn btn-success">Occupy</button>
			  <button type="submit" class="btn btn-success invisible">Free</button>
			</form>
		</div>
		
	</div>
</body>
</html>