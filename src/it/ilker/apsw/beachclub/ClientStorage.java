package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.Map;

import it.ilker.apsw.beachclub.models.Client;

public class ClientStorage implements ClientSearchService {

	private Map<String, Client> clients;
	
	public ClientStorage() {
		clients = new HashMap<String, Client>();
		addClient(new Client("001", "Foo", "Bar"));
		addClient(new Client("002", "Bar", "Baz"));
		addClient(new Client("003", "Baz", "Foo"));
		addClient(new Client("004", "Foo", "Foo"));
	}
	
	@Override
	public Client findClient(String id) {
		if(id != null) {
			return clients.get(id.toUpperCase());
		}
		return null;
	}

	private void addClient(Client client) {
		clients.put(client.getId(), client);
	}
}
