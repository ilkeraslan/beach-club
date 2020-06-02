package it.ilker.apsw.beachclub;

import java.util.Map;

import it.ilker.apsw.beachclub.models.Seat;

public interface BeachBookingService {
	public Seat findSeat(String id);
	public Map<String, Seat> getSeats();
}
