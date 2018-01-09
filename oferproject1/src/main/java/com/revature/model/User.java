package com.revature.model;

public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String errormessage="";
	private int mflag; //0 = employee, 1 = manager
	private int lflag; //0 = currently logged out, 1 = currently logged in
	
	public User() {
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.password = "";
		this.email = "";
		this.id=0;
		//this.errormessage="";
	}

	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(String errormessage) {
		this.errormessage=errormessage;
		this.username=errormessage;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String firstname, String lastname, String username, String password, String email) {
		super();
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
/*	
	public User(String firstname, String lastname, String username, String password, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
*/	
	public User(int id, String firstname, String lastname, String username, String password, String email, int mflag) {
		super();
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mflag = mflag;
		this.lflag = 0;
	}

	public User(int id, String firstname, String lastname, String username, String password, String email, int mflag, int lflag) {
		super();
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mflag = mflag;
		this.lflag = lflag;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMflag() {
		return mflag;
	}

	public void setMflag(int mflag) {
		this.mflag = mflag;
	}
	
	public int getLflag() {
		return lflag;
	}

	public void setLflag(int lflag) {
		this.lflag = lflag;
	}

	@Override
	public String toString() {
	if(errormessage.isEmpty()) {
		
		return id + ":" + firstname + ":" + lastname + ":" + username
				+ ":" + email+ ":" + mflag+":" + lflag+":" + password +":\n";
		/*
		if(mflag==0) {
			return "Employee ID=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + ", Username=" + username
							+ ", Email=" + email+ ", Manager=" + mflag+", Logged in=" + lflag+", Password=" + password +"\n";
				
		}
		else {
			return "Manager ID=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + ", Username=" + username
					+ ", Email=" + email+ ", Manager=" + mflag+", Logged in=" + lflag+", Password=" + password +"\n";	
		}
		*/
		}
	else
		return errormessage;

	}
	
	
}
