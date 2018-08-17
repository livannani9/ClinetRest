
package com.app.models;

public class Team {

	
	private Integer id;
	private String name;
	private int matchWon;
	private int matchLose;
	private int matchtotal;
	private String status;
	private String reason;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMatchWon() {
		return matchWon;
	}
	public void setMatchWon(int matchWon) {
		this.matchWon = matchWon;
	}
	public int getMatchLose() {
		return matchLose;
	}
	public void setMatchLose(int matchLose) {
		this.matchLose = matchLose;
	}
	public int getMatchtotal() {
		return matchtotal;
	}
	public void setMatchtotal(int matchtotal) {
		this.matchtotal = matchtotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
		
	
}
