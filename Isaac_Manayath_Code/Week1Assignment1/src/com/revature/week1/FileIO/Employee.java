package com.revature.week1.FileIO;

public class Employee {

	// Creating the employee bean
	String id;
	String first_name;
	String Last_name;
	String role;

	public Employee(String id, String first_name, String last_name, String role) {
		super();
		this.id = id;
		this.first_name = first_name;
		Last_name = last_name;
		this.role = role;
	}

	public synchronized final String getId() {
		return id;
	}

	public synchronized final void setId(String id) {
		this.id = id;
	}

	public synchronized final String getFirst_name() {
		return first_name;
	}

	public synchronized final void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public synchronized final String getLast_name() {
		return Last_name;
	}

	public synchronized final void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public synchronized final String getRole() {
		return role;
	}

	public synchronized final void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", Last_name=" + Last_name + ", role=" + role
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Last_name == null) ? 0 : Last_name.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Last_name == null) {
			if (other.Last_name != null)
				return false;
		} else if (!Last_name.equals(other.Last_name))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
}
