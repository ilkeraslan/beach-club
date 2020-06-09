<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
	String connectionURL = "jdbc:mysql://localhost:3306/aslan-beachclub?useLegacyDatetimeCode=false&serverTimezone=Europe/Rome";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String query = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST DB</title>
</head>
<body>
	<%
		connection = DriverManager.getConnection(connectionURL, "root", "Testpass");
		statement = connection.createStatement();
		query = "SELECT * FROM users";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			out.println(resultSet.getString("firstName"));
		}
		resultSet.close();
		statement.close();
		connection.close();
	%>
</body>
</html>