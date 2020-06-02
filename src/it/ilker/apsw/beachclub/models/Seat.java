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
	
	public Boolean isOccupied() {
		return this.isOccupied;
	}
	
	public void freeOccupation() {
		this.isOccupied = false;
	}
	
	public void occupy() {
		this.isOccupied = true;
	}
}
