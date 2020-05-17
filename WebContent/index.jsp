<!DOCTYPE html>
<html>
	<head>
		<title>Beach Club</title>
		<script src="script.js"></script>
	</head>
	<body>
		<div>
			<h1>Beach Club</h1>
			<ul>
				<li>Now: <%= new java.util.Date() %></li>
				<li>Operator session: <%= session.getId() %></li>
			</ul>
		</div>
		<div>
			<h2>Availability</h2>
		</div>
		<div>
			<h2>Queue</h2>
			<select id="queueForTicket">
				<option>----</option>
			</select>
			<input type="text" id="nameInputForTicket">
			<button onclick="addToQueue()">Get in line</button>
			<button onclick="removeFromQueue()">Leave the line</button>
		</div>
	</body>
</html>