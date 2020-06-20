package it.ilker.apsw.beachclub;

import java.util.HashMap;
import java.util.Map;

import it.ilker.apsw.beachclub.models.Client;

public class ClientStorage implements ClientSearchService {

	private Map<String, Client> clients;
	
	public ClientStorage() {
		clients = new HashMap<String, Client>();
		addClient(new Client("001", "Foo", "Bar", "foo@example.acme"));
		addClient(new Client("002", "Bar", "Baz", "bar@example.acme"));
		addClient(new Client("003", "Baz", "Foo", "baz@example.acme"));
		addClient(new Client("004", "Foo", "Foo", "foofoo@example.acme"));
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
