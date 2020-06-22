package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.ilker.apsw.beachclub.controllers.Database;
import it.ilker.apsw.beachclub.models.Client;
import it.ilker.apsw.beachclub.models.Query;

public class ClientSearchService {
	
	private static final Map<String, Client> clients = new HashMap<String, Client>(25);
	
	static {
		String sql = "select * from users";
		Query query = new Query(sql);
		Database.execute(query);
		List<List<String>> result = query.getResult();
		
		for(int i=1; i<result.size(); i++) {
			addClient(
				new Client(
					result.get(i).get(0), 
					result.get(i).get(1),
					result.get(i).get(2),
					result.get(i).get(3)
				)
			);
		}
	}
	
	public static Client findClient(String id) {
		if(id != null) {
			return clients.get(id);
		}
		return null;
	}
	
	private static void addClient(Client client) {
		clients.put(client.getId(), client);
	}
}
