package com.revature.model;

public class TicketLine {
	private int lineId;
	private int ticketId;
	private String desc;
	private double amount;
	private int categoryId;
	private String categoryDesc;
	
	// Used to create a ticketline object when the form is submitted
	public TicketLine(int ticketId, String desc, double amount, String category) {
		super();
		this.ticketId = ticketId;
		this.desc = desc;
		this.amount = amount;
		this.categoryDesc = category;
		switch (category) {
			case "TRAVEL":
				this.categoryId = 1;
				break;
			case "RELOCATION":
				this.categoryId = 2;
				break;
			case "MATERIALS":
				this.categoryId = 3;
				break;
			case "OTHER":
				this.categoryId = 4;
				break;
			default:
				this.categoryId = 1;
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



	public TicketLine(int lineId, int ticketId, String categoryDesc, double amount, String itemDesc) {
		// TODO Auto-generated constructor stub
		super();
		this.lineId = lineId;
		this.ticketId = ticketId;
		this.categoryDesc = categoryDesc;
		this.amount = amount;
		this.desc = itemDesc;
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


	public String getCategoryDesc() {
		return categoryDesc;
	}


	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
}
