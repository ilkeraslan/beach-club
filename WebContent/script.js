function addToQueue() {
	var menu = document.getElementById("queueForTicket");
	var item = document.getElementById("nameInputForTicket").value;
	if (item != "") {
		menu.options.add(new Option(item));
		updateCurrentQueueLength();
	}
}

function removeFromQueue() {
	var menu = document.getElementById("queueForTicket");
	if (menu.options.length > 1) {
		menu.remove(menu.selectedIndex);
		updateCurrentQueueLength();
	}
}

function updateCurrentQueueLength() {
	var currentQueueLength = document.getElementById("currentQueueLength");
	var menu = document.getElementById("queueForTicket");
	currentQueueLength.textContent = menu.options.length - 1;
}