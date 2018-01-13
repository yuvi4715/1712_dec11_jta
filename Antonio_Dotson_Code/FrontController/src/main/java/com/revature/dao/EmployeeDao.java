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
	public List<Employee> selectAll();
	public String getCustomerHash(Employee employee);
	boolean updatePassword(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean insertReimbursement(int eid, String description, double amount, String type);
	public List<Reimburse> selectReimburseDisapproved();
	public List<Reimburse> selectReimburseApproved();
	public List<Reimburse> selectReimbursePending();
	public List<Reimburse> selectEmployeeReimburseApproved(Employee employee);
	public List<Reimburse> selectEmployeeReimbursePending(Employee employee);
	public List<Reimburse> selectEmployeeReimburseDisapproved(Employee employee);
	public boolean statusDisapproved(int rid);
	public boolean statusApproved(int rid);
	
}
