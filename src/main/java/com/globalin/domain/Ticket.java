package com.globalin.domain;

public class Ticket {
	
	private int bno;
	private String owner;
	private String garde;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getGarde() {
		return garde;
	}
	public void setGarde(String garde) {
		this.garde = garde;
	}
	@Override
	public String toString() {
		return "Ticket [bno=" + bno + ", owner=" + owner + ", garde=" + garde + "]";
	}
}
