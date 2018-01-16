package com.revature.reimbursement;

public class Closed {
	private int rid;
	private int amt;
	private int eid; //update this class with this attribute
	private String status;
	private String starttime; // formating needed
	private String endtime;   //formatting needed
	private String description;
	private String resolvedby;
	
	public Closed(int rid){
		super();
		this.rid = rid;
	}
	
	public Closed(int rid, int amt, int eid, String status, String starttime, String endtime, String description, String resolvedby){
		super();
		this.rid = rid;
		this.amt = amt;
		this.eid = eid;
		this.status = status;
		this.starttime = starttime;
		this.endtime = endtime;
		this.description = description;
		this.resolvedby = resolvedby;
	}
	
	public Closed(int amt, int eid, String status, String description){
		super();
		//this.rid = rid;
		this.amt = amt;
		this.eid = eid;
		this.status = status; //upon insertion, this will be set to PENDING
		//this.starttime = starttime;
		//this.endtime = endtime;    --these times will be entered automitically by the system
		this.description = description;
		//this.resolvedby = resolvedby; value will be entered from manager controller methods
	}
	
	public Closed(){
		this.rid = 0;
		this.amt = 0;
		this.eid = 0;
		this.status = "";
		this.starttime = "";
		this.endtime = "";
		this.description = "";
		this.resolvedby = "";
	}
	
	//rid
	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	//amt
	public int getAmt() {
		return amt;
	}
	
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	//eid
		public int getEid() {
			return eid;
		}
		
		public void setEid(int eid) {
			this.eid = eid;
		}
	
	//status
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	//starttime
	public String getStarttime() {
		return starttime;
	}
	
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	

	//endtime
	public String getEndtime() {
		return endtime;
	}
	
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	

	//description
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//resolvedby
		public String getResolvedby() {
			return resolvedby;
		}
		
		public void setResolvedby(String resolvedby) {
			this.resolvedby = resolvedby;
		}
	
	
}
