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
	
	@Override
	public void occupySeat(Integer seatId) {
		try {
			Seat seat = seats.get(seatId.toString());
			String sql = "update sunbeds set isOccupied='1' where id='" + seatId + "'";
			Query query = new Query(sql);
			Database.execute(query);
			
			if(query.getStatus() == Database.NORESULT) {
				System.out.println("Occupied the seat");
			} else if(query.getStatus() == Database.RESULT) {
				System.out.println("Query returned result");
			} else {
				System.out.println("Error during query.");
			}
		} catch(Exception exception) {
			System.out.println(exception.getLocalizedMessage());
		}
	}
	
	private void addSeat(Seat seat) {
		seats.put(seat.getId(), seat);
	}
}
