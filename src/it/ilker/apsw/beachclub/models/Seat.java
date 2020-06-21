package it.ilker.apsw.beachclub.models;

public class Seat {
	private Boolean isOccupied = false;
	private String id;
	
	public Seat(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public void occupySeat() {
		this.isOccupied = true;
	}
	
	public void freeSeat() {
		this.isOccupied = false;
	}
}
