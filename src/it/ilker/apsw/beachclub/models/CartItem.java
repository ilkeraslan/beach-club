package it.ilker.apsw.beachclub.models;

public class CartItem {

	private final String id, clientID;
	private Integer debt;
	
	public CartItem(String id, String clientID) {
		this.id = id;
		this.clientID = clientID;
		this.debt = 0;
	}
	
	public CartItem(String id, String clientID, Integer debt) {
		this.id = id;
		this.clientID = clientID;
		this.debt = debt;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getclientID() {
		return this.clientID;
	}
	
	public Integer getDebt() {
		return this.debt;
	}
	
	public void setDebt(Integer newDebt) {
		this.debt = newDebt;
	}
}
