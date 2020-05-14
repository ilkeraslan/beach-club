<!DOCTYPE html>
<html>
	<head>
		<title>Beach Club</title>
	</head>
	<body>
		<div>
			<h2>Beach Club</h2>
			<ul>
				<li>Now: <%= new java.util.Date() %></li>
				<li>Operator session: <%= session.getId() %></li>
			</ul>
		</div>
		<div>
			<h2>Availability</h2>
		</div>
	</body>
</html>