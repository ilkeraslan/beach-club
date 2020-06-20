<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.ilker.apsw.beachclub.models.Query"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.List"%>

<h1>Query result:</h1>
<%
	List<List<String>> result = ((Query) request.getAttribute("query")).getResult();
%>
<table border="1">
	<%
		int columnCount = result.get(0).size();
	%>
	<tr>
		<%
			// table header
			for (int i = 0; i < columnCount; i++) {
				out.println("<th>" + result.get(0).get(i) + "</th>");
			}
		%>
	</tr>
	<%
		// the data
		for (int r = 1; r < result.size(); r++) {
	%>
	<tr>
		<%
			for (int i = 0; i < columnCount; i++) {
					out.println("<td>" + result.get(r).get(i) + "</td>");
				}
		%>
	</tr>
	<%
		}
	%>
</table>