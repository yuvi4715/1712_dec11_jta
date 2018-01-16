package com.revature.reimbursement;

public class User {
	private int eid;
	private String username;
	private String password;
	private String logstatus;
	private String admin;  //if manager, has admin rights (yes or no)
	
	User(int eid){
		super();
		this.eid = eid;
	}
	
	public User(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	User(int eid, String username, String password, String logstatus, String admin){
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.logstatus = logstatus;
		this.admin = admin;
	}
	
	User() {
		this.eid = 0;
		this.username = "";
		this.password = "";
		this.logstatus = "";
		this.admin = "";	
	}
	
	// Eid
		public int getEid() {
			return eid;
		}
		
		public void setEid(int eid) {
			this.eid = eid;
		}
		
	//username
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
	//password
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
	//logstatus
		public String getLogstatus() {
			return logstatus;
		}
		
		public void setLogstatus(String logstatus) {
			this.logstatus = logstatus;
		}
		
	//admin
		public String getAdmin() {
			return admin;
		}
		
		public void setAdmin(String admin) {
			this.admin = admin;
		}
}
