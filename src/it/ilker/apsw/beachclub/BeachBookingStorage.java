package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.Map;

import it.ilker.apsw.beachclub.models.Seat;

public class BeachBookingStorage implements BeachBookingService {
	
	private Map<String, Seat> seats;
	
	public BeachBookingStorage() {
		seats = new HashMap<String, Seat>(25);
		for(Integer i=1; i<=25; i++) {
			addSeat(new Seat(i.toString()));
		}
	}

	@Override
	public Seat findSeat(String id) {
		if(id != null) {
			return seats.get(id.toLowerCase());
		}
		return null;
	}


	@Override
	public Map<String, Seat> getSeats() {
		return this.seats;
	}
	
	private void addSeat(Seat seat) {
		seats.put(seat.getId(), seat);
	}
}
