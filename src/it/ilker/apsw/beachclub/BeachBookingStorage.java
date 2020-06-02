package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.Map;

import it.ilker.apsw.beachclub.models.Seat;

public class BeachBookingStorage implements BeachBookingService {
	
	private Map<String, Seat> seats;
	
	public BeachBookingStorage() {
		seats = new HashMap<String, Seat>(25);
		addSeat(new Seat("001"));
		addSeat(new Seat("002"));
		addSeat(new Seat("003"));
		addSeat(new Seat("004"));
		addSeat(new Seat("005"));
	}

	@Override
	public Seat findSeat(String id) {
		if(id != null) {
			return seats.get(id.toLowerCase());
		}
		return null;
	}

	private void addSeat(Seat seat) {
		seats.put(seat.getId(), seat);
	}
}
