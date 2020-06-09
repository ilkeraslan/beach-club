<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.sql.DataSource"%>
<%
	Context ctx = null;
	DataSource ds = null;
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<title>Test DB</title>
</head>
<body>
	<%
		ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/aslan-beachclub");
		connection  = ds.getConnection();
		statement = connection.createStatement();
		rs = statement.executeQuery("SELECT * FROM users");
		while (rs.next()) {
			out.print(rs.getString("id") + ") ");
			out.println(rs.getString("name") + ", ");
			out.println(rs.getString("surname") + "<br>");
		}
		rs.close();
		statement.close();
		connection.close();
	%>
</body>
</html>