package com.revature.model;

public class TicketLine {
	private int lineId;
	private int ticketId;
	private String desc;
	private double amount;
	private int categoryId;
	
	// Used to create a ticketline object when the form is submitted
	public TicketLine(int ticketId, String desc, double amount, String category) {
		super();
		this.ticketId = ticketId;
		this.desc = desc;
		this.amount = amount;
		
		switch (category.toUpperCase()) {
		case "TRAVEL":
			this.categoryId = 1;
		case "RELOCATION":
			this.categoryId = 2;
		case "MATERIALS":
			this.categoryId = 3;
		case "OTHER":
			this.categoryId = 4;			
		}
	}
	

	// Used to create the object when grabbing from database
	public TicketLine(int lineId, int ticketId, String desc, double amount, int categoryId) {
		super();
		this.lineId = lineId;
		this.ticketId = ticketId;
		this.desc = desc;
		this.amount = amount;
		this.categoryId = categoryId;
	}



	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
