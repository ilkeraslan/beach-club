package it.ilker.apsw.beachclub.models;

import java.util.HashMap;
import java.util.Map;

public class Beach {
	private Map<String, Seat> seats;
	
	public Beach() {
		this.seats = new HashMap<String, Seat>(25);
	}
	
	public Map<String, Seat> getSeats() {
		return this.seats;
	}
}
