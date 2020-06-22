<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.ilker.apsw.beachclub.models.Query"%>
<%@ page import="it.ilker.apsw.beachclub.models.Seat"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<h2>Club Availability</h2>
<%
	Map<String, Seat> seats = (Map<String, Seat>) request.getAttribute("seats");
	System.out.println(seats.size());
%>
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
			<% for(int i=1; i<=5; i++) {%>
				<td><%= seats.get(""+i).getId() %> - Occupied: 
				<% if(seats.get(""+i).getIsOccupied()) { %>
					<%= "TRUE" %>
				<%} else {%>
					<%= "FALSE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">6-10</th>
			<% for(int i=6; i<=10; i++) {%>
				<td><%= seats.get(""+i).getId() %> - Occupied: 
				<% if(seats.get(""+i).getIsOccupied()) { %>
					<%= "TRUE" %>
				<%} else {%>
					<%= "FALSE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">11-15</th>
			<% for(int i=11; i<=15; i++) {%>
				<td><%= seats.get(""+i).getId() %> - Occupied: 
				<% if(seats.get(""+i).getIsOccupied()) { %>
					<%= "TRUE" %>
				<%} else {%>
					<%= "FALSE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">16-20</th>
			<% for(int i=16; i<=20; i++) {%>
				<td><%= seats.get(""+i).getId() %> - Occupied: 
				<% if(seats.get(""+i).getIsOccupied()) { %>
					<%= "TRUE" %>
				<%} else {%>
					<%= "FALSE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">21-25</th>
			<% for(int i=21; i<=25; i++) {%>
				<td><%= seats.get(""+i).getId() %> - Occupied: 
				<% if(seats.get(""+i).getIsOccupied()) { %>
					<%= "TRUE" %>
				<%} else {%>
					<%= "FALSE" %>
				<%} %></td>
			<% } %>
		</tr>
	</tbody>
</table>
