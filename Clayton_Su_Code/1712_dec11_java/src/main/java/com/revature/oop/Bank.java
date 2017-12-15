package com.revature.oop;

public class Bank {
	private float accountBalance;
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	@Override
	public String toString() {
		return "Bank [accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", accountName=" + accountName + "]";
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalance);
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + accountNumber;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
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
		Bank other = (Bank) obj;
		if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		return true;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	private int accountNumber;
	private String accountType;
	private String accountName;
}
