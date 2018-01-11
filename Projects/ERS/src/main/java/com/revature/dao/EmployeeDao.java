package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

/* Contract interface that uses DAO design pattern rules that can be implemented
 * by many types of technologies like JDBC, Hibernate, MongoDB, etc.
 */
public interface EmployeeDao {
	public boolean insert(Employee employee);
	public boolean insertProcedure(Employee employee);
	public Employee select(Employee employee);
	public Employee getEmployeeByUsername(String username);
	public List<Employee> selectAll();
	public String getEmployeeHash(Employee employee);
	public boolean authenticateEmployee(String username, String password);
	public boolean updateInfo(Employee employee);
}
