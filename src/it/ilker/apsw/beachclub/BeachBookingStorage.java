package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.Query;
import it.ilker.apsw.beachclub.models.Seat;

public class BeachBookingStorage implements BeachBookingService {
	
	private Map<String, Seat> seats;
	
	public BeachBookingStorage() {
		seats = new HashMap<String, Seat>(25);
		String sql = "select * from sunbeds";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		for(int i=1; i<result.size(); i++) {
			addSeat(new Seat(result.get(i).get(0)));
		}
	}

	@Override
	public Seat findSeat(String id) {
		if(id != null) {
			return seats.get(id);
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
