package it.ilker.apsw.beachclub;

import java.util.ArrayList;
import java.util.List;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.Client;
import it.ilker.apsw.beachclub.models.Query;

public class TicketLineService {
	
	private static final List<Client> line = new ArrayList<Client>();
	
	static {
		String sql = "select * from ticket_line order by id";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		for(int i=1; i<result.size(); i++) {
			addToLine(ClientSearchService.findClient(""+i));
		}
	}
	
	public static void addToLine(Client client) {
		if(!line.contains(client)) {
			line.add(client);
		}
	}
	
	public static void removeFromLine(Client client) {
		if(line.contains(client)) {
			line.remove(client);
		}
	}
	
	public static List<Client> getLine() {
		return line;
	}
	
	/*
	 * public static void occupySeat(String seatId) { try { Seat seat =
	 * seats.get(seatId); String sql =
	 * "update sunbeds set isOccupied='1' where id='" + seatId + "'"; Query query =
	 * new Query(sql); Database.execute(query);
	 * 
	 * if(query.getStatus() == Database.NORESULT) {
	 * System.out.println("Occupied the seat " + seat.getId());
	 * seat.setIsOccupied(true); } else if(query.getStatus() == Database.RESULT) {
	 * System.out.println("Query returned result"); } else {
	 * System.out.println("Error during query."); } } catch(Exception exception) {
	 * System.out.println(exception.getLocalizedMessage()); } }
	 * 
	 * public static void freeSeat(String seatId) { try { Seat seat =
	 * seats.get(seatId); String sql =
	 * "update sunbeds set isOccupied='0' where id='" + seatId + "'"; Query query =
	 * new Query(sql); Database.execute(query);
	 * 
	 * if(query.getStatus() == Database.NORESULT) {
	 * System.out.println("Seat is free now"); seat.setIsOccupied(false); } else
	 * if(query.getStatus() == Database.RESULT) {
	 * System.out.println("Query returned result"); } else {
	 * System.out.println("Error during query."); } } catch(Exception exception) {
	 * System.out.println(exception.getLocalizedMessage()); } }
	 */
}
