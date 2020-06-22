package it.ilker.apsw.beachclub.models;

public class Seat {
	private Boolean isOccupied;
	private String id;
	
	public Seat(String id, String occupied) {
		this.id = id;
		this.isOccupied = occupied.equals("0") ? false : true;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public void setIsOccupied(Boolean occupy) {
		this.isOccupied = occupy;
	}
}
