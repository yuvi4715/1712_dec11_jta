package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAOInterface {
	public void addEmployee(Employee emp, Connection con) throws Exception;
	public void createUser(Employee emp, Connection con) throws Exception;
	
	public void updateUser(Employee emp, Connection con) throws Exception;
	
	public List<Employee> elist(Connection con) throws Exception;
	public List<Employee> infoList(String empUser, Connection con) throws Exception;
	
	public int getEmployeeID(Employee emp, Connection con) throws Exception;
	
	public int getEmpID(String user, Connection con) throws Exception;
	public String getEmployeeFirstName(String user, Connection con) throws Exception;
	public String getEmployeeLastName(String user, Connection con) throws Exception;
	public String getEmployeeEmail(String user, Connection con) throws Exception;
	public String getEmployeeRole(String user, Connection con) throws Exception;
	public String getEmployeeTitle(String user, Connection con) throws Exception;
	public int getEmployeeReportsTo(String user, Connection con) throws Exception;
}
