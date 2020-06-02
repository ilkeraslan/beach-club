<!DOCTYPE html>
<html>
	<head>
		<title>Beach Club</title>
		<script src="script.js"></script>
	</head>
	<body>
		<div>
			<h1>Beach Club</h1>
			<p><a href="client-search.html">Client Search</a></p>
			<p><a href="seat-search.html">Seat Search</a></p>
			<ul>
				<li>Now: <%= new java.util.Date() %></li>
				<li>Operator session: <%= session.getId() %></li>
			</ul>
		</div>
		<div>
			<div>
				<h2>Queue</h2>
				<select id="queueForTicket">
					<option selected disabled hidden="true">Choose here</option>
				</select>
				<input type="text" id="nameInputForTicket">
				<button onclick="addToQueue()">Get in line</button>
				<button onclick="removeFromQueue()">Leave the line</button>
			</div>
			<div>
				<h2>Current Queue Length: <span id="currentQueueLength">0</span></h2>
			</div>
		</div>
		<div>
			<div id="clubAvailability">
				<h2>Club Availability</h2>
			</div>
		</div>
	</body>
</html>