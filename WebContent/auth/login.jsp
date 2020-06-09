<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!doctype html>
<html>
<head>
<title>Authentication test</title>
</head>

<body>
	<div>
		<h3>Authentication test</h3>
	</div>

	<div id="login">
		<%
			String show = request.getParameter("show");
			if (show != null && show.equals("logerror"))
				out.println("<p>Wrong username or password</p>");
		%>

		<form id="login_form" action='j_security_check' method="post">
			<label for="j_username">User</label> <input id="j_username"
				type="text" name="j_username" maxlength="30" size="18"> <br>
			<label for="j_password">Password</label> <input id="j_password"
				type="password" name="j_password" maxlength="30" size="18">
			<br>
			<br>
			<button class='login_button' type=submit>Enter</button>
		</form>

	</div>
</body>
</html>