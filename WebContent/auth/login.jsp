<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!doctype html>
<html>
	<meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Expires" content="-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
	<head>
		<title>Login</title>
	</head>
	
	<body>
		<div class="container-fluid">
			<div>
				<h3>Login</h3>
			</div>
		
			<div id="login">
				<%
					String show = request.getParameter("show");
					if (show != null && show.equals("logerror")) {
						out.println("<p>Wrong username or password</p>");
					}
				%>
				
				<form id="login_form" action='j_security_check' method="post">
					<div class="form-group">
						<label for="j_username">Username</label> 
						<input id="j_username" class="form-control" type="text" name="j_username" maxlength="30"> 
					</div>
					<div class="form-group">
						<label for="j_password">Password</label> 
						<input id="j_password" class="form-control" type="password" name="j_password" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</body>
</html>