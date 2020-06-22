package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.Query;
import it.ilker.apsw.beachclub.models.Seat;

public class BeachBookingService {
	
	public static final String OCCUPY = "OCCUPY";
	public static final String FREE = "FREE";
	
	private static final Map<String, Seat> seats = new HashMap<String, Seat>(25);
	
	static {
		String sql = "select * from sunbeds";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		for(int i=1; i<result.size(); i++) {
			addSeat(new Seat(result.get(i).get(0), result.get(i).get(1)));
		}
	}
	
	private static void addSeat(Seat seat) {
		seats.put(seat.getId(), seat);
	}
	
	public static Seat findSeat(String id) {
		if(id != null) {
			return seats.get(id);
		}
		return null;
	}
	
	public static Map<String, Seat> getSeats() {
		return seats;
	}
	
	public static void occupySeat(String seatId) {
		try {
			Seat seat = seats.get(seatId);
			String sql = "update sunbeds set isOccupied='1' where id='" + seatId + "'";
			Query query = new Query(sql);
			Database.execute(query);
			
			if(query.getStatus() == Database.NORESULT) {
				System.out.println("Occupied the seat " + seat.getId());
				seat.setIsOccupied(true);
			} else if(query.getStatus() == Database.RESULT) {
				System.out.println("Query returned result");
			} else {
				System.out.println("Error during query.");
			}
		} catch(Exception exception) {
			System.out.println(exception.getLocalizedMessage());
		}
	}
	
	public static void freeSeat(String seatId) {
		try {
			Seat seat = seats.get(seatId);
			String sql = "update sunbeds set isOccupied='0' where id='" + seatId + "'";
			Query query = new Query(sql);
			Database.execute(query);
			
			if(query.getStatus() == Database.NORESULT) {
				System.out.println("Seat is free now");
				seat.setIsOccupied(false);
			} else if(query.getStatus() == Database.RESULT) {
				System.out.println("Query returned result");
			} else {
				System.out.println("Error during query.");
			}
		} catch(Exception exception) {
			System.out.println(exception.getLocalizedMessage());
		}
	}
}
