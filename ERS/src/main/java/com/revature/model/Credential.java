package com.revature.model;

import java.io.Serializable;


public class Credential implements Serializable {

	
	private static final long serialVersionUID = -966745781250520211L;
	private int id;
	private String username;
	private transient String password;
	private String title;

	public Credential(int id, String username, String password, String title) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.title = title;
	}
	
	
	public Credential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Credential() {}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getTitle() {
		return title;
	}

	public String toString() {

		return "[id: " + id + ", username: " + username + ", title: " + title + "]";
	}
}
