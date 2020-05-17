function addToQueue() {
	var menu = document.getElementById("queueForTicket");
	var item = document.getElementById("nameInputForTicket").value;
	if (item != "") {
		menu.options.add(new Option(item));
	}
}
function removeFromQueue() {
	var menu = document.getElementById("queueForTicket");
	if (menu.options.length > 0) {
		menu.remove(menu.selectedIndex);
	}
}