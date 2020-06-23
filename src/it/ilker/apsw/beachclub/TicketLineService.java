package it.ilker.apsw.beachclub;

import java.util.ArrayList;
import java.util.List;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.Client;
import it.ilker.apsw.beachclub.models.Query;

public class TicketLineService {
	
	private static List<Client> line = new ArrayList<Client>();
	
	static {
		String sql = "select * from ticket_line order by id";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		System.out.println(result.toString());
		
		for(int i=1; i<result.size(); i++) {
			insertClientToLine(ClientSearchService.findClient(""+result.get(i).get(1)));
		}
	}
	
	private static void refreshLine() {
		String sql = "select * from ticket_line order by id";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		line = new ArrayList<Client>();
		
		for(int i=1; i<result.size(); i++) {
			insertClientToLine(ClientSearchService.findClient(""+result.get(i).get(1)));
		}
	}
	
	private static void insertClientToLine(Client client) {
		if(!line.contains(client)) {
			line.add(client);
		}
	}

	public static List<Client> getLine() {
		return line;
	}
	
	public static void addToLine(Client client) {
		if(!line.contains(client)) {
			try {
				String sql = "insert into ticket_line (user_id) values " + "('" + client.getId() + "')";
				Query query = new Query(sql);
				Database.execute(query);
				
				if(query.getStatus() == Database.NORESULT) {
					line.add(client);
					System.out.println("Added to line.");
				} else {
					System.out.println("Insertion in line failed.");
				}
			} catch(Exception exception) {
				System.out.println("Insertion in line failed: " + exception.getLocalizedMessage());
			}
		}
	}
	
	public static void removeFromLine(Client client) {
		if(line.contains(client)) {
			try {
				String sql = "delete from ticket_line where user_id='" + client.getId() + "'";
				Query query = new Query(sql);
				Database.execute(query);
				
				System.out.println(sql);
				
				if(query.getStatus() == Database.NORESULT) {
					line.remove(client);
					System.out.println("Deleted from line.");
				} else {
					System.out.println("Deletion from line failed.");
				}
			} catch(Exception exception) {
				System.out.println("Deletion from line failed: " + exception.getLocalizedMessage());
			}
		}
	}
}
