<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.ilker.apsw.beachclub.models.Query"%>
<%@ page import="java.util.List"%>

<h2>Club Availability</h2>
<%
	List<List<String>> result = ((Query) request.getAttribute("query")).getResult();
%>
<table class="table table-bordered table-striped">
	<%
		int columnCount = result.get(0).size();
	%>
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
				<td><%= result.get(i).get(0) %> - Occupied: 
				<% if(result.get(i).get(1).equals("0")) { %>
					<%= "FALSE" %>
				<%} else {%>
					<%= "TRUE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">1-5</th>
			<% for(int i=1; i<=5; i++) {%>
				<td><%= result.get(i).get(0) %> - Occupied: 
				<% if(result.get(i).get(1).equals("0")) { %>
					<%= "FALSE" %>
				<%} else {%>
					<%= "TRUE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">1-5</th>
			<% for(int i=1; i<=5; i++) {%>
				<td><%= result.get(i).get(0) %> - Occupied: 
				<% if(result.get(i).get(1).equals("0")) { %>
					<%= "FALSE" %>
				<%} else {%>
					<%= "TRUE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">1-5</th>
			<% for(int i=1; i<=5; i++) {%>
				<td><%= result.get(i).get(0) %> - Occupied: 
				<% if(result.get(i).get(1).equals("0")) { %>
					<%= "FALSE" %>
				<%} else {%>
					<%= "TRUE" %>
				<%} %></td>
			<% } %>
		</tr>
		<tr>
			<th scope="row">1-5</th>
			<% for(int i=1; i<=5; i++) {%>
				<td><%= result.get(i).get(0) %> - Occupied: 
				<% if(result.get(i).get(1).equals("0")) { %>
					<%= "FALSE" %>
				<%} else {%>
					<%= "TRUE" %>
				<%} %></td>
			<% } %>
		</tr>
	</tbody>
</table>
