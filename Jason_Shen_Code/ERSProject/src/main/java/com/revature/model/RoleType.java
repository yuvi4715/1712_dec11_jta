package com.revature.model;

public class RoleType {
	private int roleid;
	private String type;
	
	public RoleType( ) {
		this.roleid = 1;
		this.type = "EMPLOYEE";
	}
	
	public RoleType(int roleid, String type) {
		super();
		this.roleid = roleid;
		this.type = type;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
