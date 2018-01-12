package com.revature.model;

public class Request {

	

	private int requestId;
	private int employeeId;
	private String status;
	private double ammount;
	private String requestDesc;
	private String openTimestamp;
	private String closedTimestamp;
	private String notes;
	private int managerId;
	
	public Request() {}
	
	public Request(int employeeId, double ammount, String requestDesc) {
		super();
		this.employeeId = employeeId;
		this.ammount = ammount;
		this.requestDesc = requestDesc;
	}
	
	public Request(int requestId, String status, String notes, int managerId) {
		super();
		this.requestId = requestId;
		this.status = status;
		this.notes = notes;
		this.managerId = managerId;
	}
	
	public Request(int requestId, int employeeId, String status, double ammount, String requestDesc, String openTimestamp,
			String closedTimestamp, String notes, int managerId) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.status = status;
		this.ammount = ammount;
		this.requestDesc = requestDesc;
		this.openTimestamp = openTimestamp;
		this.closedTimestamp = closedTimestamp;
		this.notes = notes;
		this.managerId = managerId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getRequestDesc() {
		return requestDesc;
	}

	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}

	public String getOpenTimestamp() {
		return openTimestamp;
	}

	public void setOpenTimestamp(String openTimestamp) {
		this.openTimestamp = openTimestamp;
	}

	public String getClosedTimestamp() {
		return closedTimestamp;
	}

	public void setClosedTimestamp(String closedTimestamp) {
		this.closedTimestamp = closedTimestamp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", status=" + status + ", ammount="
				+ ammount + ", requestDesc=" + requestDesc + ", openTimestamp=" + openTimestamp + ", closedTimestamp="
				+ closedTimestamp + ", notes=" + notes + ", managerId=" + managerId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ammount);
		result = prime * result + ((closedTimestamp == null) ? 0 : closedTimestamp.hashCode());
		result = prime * result + employeeId;
		result = prime * result + managerId;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((openTimestamp == null) ? 0 : openTimestamp.hashCode());
		result = prime * result + ((requestDesc == null) ? 0 : requestDesc.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Request other = (Request) obj;
		if (ammount != other.ammount)
			return false;
		if (closedTimestamp == null) {
			if (other.closedTimestamp != null)
				return false;
		} else if (!closedTimestamp.equals(other.closedTimestamp))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (managerId != other.managerId)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (openTimestamp == null) {
			if (other.openTimestamp != null)
				return false;
		} else if (!openTimestamp.equals(other.openTimestamp))
			return false;
		if (requestDesc == null) {
			if (other.requestDesc != null)
				return false;
		} else if (!requestDesc.equals(other.requestDesc))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
