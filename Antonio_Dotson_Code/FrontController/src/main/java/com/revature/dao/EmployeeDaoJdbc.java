package com.revature.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for Customers data access */
public class EmployeeDaoJdbc implements EmployeeDao {
	
	/*Singleton transformation of JDBC implementation object */
	private static EmployeeDaoJdbc EmployeeDaoJdbc;
	
	private EmployeeDaoJdbc() {
		
	}
	
	public static EmployeeDaoJdbc getEmployeeDaoJdbc() {
		if(EmployeeDaoJdbc == null) {
			EmployeeDaoJdbc = new EmployeeDaoJdbc();
		}
		
		return EmployeeDaoJdbc;
	}
	
	/* Regular insert statement for Customer */
	@Override
	public boolean insert(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			System.out.println("connecting");
			int statementIndex = 0;

			String command = "insert into employee values(sequence_id.nextval,employee_seq.nextval,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
	
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getTitle().toUpperCase());
			statement.setInt(++statementIndex, employee.getManagerid());
			statement.setString(++statementIndex, employee.getBirthdate().toUpperCase());
			statement.setString(++statementIndex, employee.getAddress().toUpperCase());
			statement.setString(++statementIndex, employee.getCity().toUpperCase());
			statement.setString(++statementIndex, employee.getState().toUpperCase());
			statement.setString(++statementIndex, employee.getPhone().toUpperCase());
			statement.setString(++statementIndex, employee.getEmail().toUpperCase());


			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new employee", e);
		}
		return false;
	}
	/* Regular insert statement for Customer */
	@Override
	public boolean insertReimbursement(int eid,String description,double amount,String type) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "insert into reimburse values (SEQUENCE_ME.NEXTVAL,?,?,?,SYSDATE,null,?)";
			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
	
			statement.setInt(++statementIndex, eid);
			statement.setString(++statementIndex, description);
			statement.setDouble(++statementIndex, amount);
			statement.setString(++statementIndex, type);
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new reimbursement ", e);
		}
		return false;
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			System.out.println("its trying");
			int statementIndex = 0;
			String command = "Update employee Set lastname = ?,firstname = ?,title = ?, address = ?, city = ?, state = ?, phone = ?, email = ? where  eid = ?"; 
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getTitle().toUpperCase());
			statement.setString(++statementIndex, employee.getAddress().toUpperCase());
			statement.setString(++statementIndex, employee.getCity().toUpperCase());
			statement.setString(++statementIndex, employee.getState().toUpperCase());
			statement.setString(++statementIndex, employee.getPhone().toUpperCase());
			statement.setString(++statementIndex, employee.getEmail().toUpperCase());
			statement.setInt(++statementIndex, employee.getEid());

			if(statement.executeUpdate() > 0) {
				
				return new Employee();
				
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception updating a new employee", e);
		}
		
		return new Employee();
	}
	
	/*public boolean updateStatusAppproved(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			Reimburse rrid = new Reimburse();
			String command = "update status_table set managerid = ?,approved = 1,disapproved = 0,pending = 0,resolved_date "
					+ "=sysdate where managerid = ? and rid = ?";
			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
		
			statement.setInt(++statementIndex,employee.getManagerid());
			statement.setInt(++statementIndex,rrid.getRid());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new customer", e);
		}
		return false;
	}
	
	/*public boolean updateStatusDisppproved(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "update status_table set managerid = ?,approved = 0,disapproved = 1,pending = 0,resolved_date "
					+ "=sysdate where managerid = managerid and rid = rid";
			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
		
			statement.setInt(++statementIndex,employee.getManagerid());
			statement.setInt(++statementIndex,employee.getId());
		
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new customer", e);
		}
		return false;
	}
	
	/* Regular insert statement for Customer */
	@Override
	public boolean updatePassword(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "update login set USERNAME = ?, PASSWORD = ? where LOGIN_ID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
		    statement.setString(++statementIndex, employee.getPassword());
		    statement.setInt(++statementIndex,employee.getEid());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception updatingPassword", e);
		}
		return false;
	}

	/* Insert a customer using the stored procedure we created */
	@Override
	public boolean insertProcedure(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			String command = "{CALL INSERT_CUSTOMER(?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getUsername().toLowerCase());
			statement.setString(++statementIndex, employee.getPassword());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new customer with stored procedure", e);
		}
		return false;
	}

	/* Select Customer based on his username */
	@Override
	public Employee select(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			System.out.println(employee.getPassword());
			int statementIndex = 0;
			String query = "SELECT a.id,a.eid,a.lastname,a.firstname,a.title,a.managerid,a.birthdate,a.address,a.city,a.state,a.phone,a.email,l.username,l.password from employee a left join login l on a.eid = l.login_id where password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet results = statement.executeQuery();
			System.out.println(results);
			while(results.next()) {
		 		return new Employee(
		 				results.getInt("id"),
						results.getInt("eid"),
						results.getString("lastname"),
						results.getString("firstname"),
						results.getString("title"),
						results.getInt("managerid"),
						results.getString("birthdate"),
						results.getString("address"),
						results.getString("city"),
						results.getString("state"),
						results.getString("phone"),
						results.getString("email"),
						results.getString("username"),
						results.getString("password")
						);
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting an employee", e);
		}
		
		return new Employee();
	}
	public boolean checkUserName(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			System.out.println("ok called the right method");
			int statementIndex = 0;
			String query = "select username from login where username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(++statementIndex, employee.getUsername());
			
	if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception checking use name", e);
		}
		return false;
	}
	/* Select all customers */
	public List<Employee> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM Employee";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Employee> customerList = new ArrayList<>();
			while(result.next()) {
				customerList.add(new Employee(
						result.getInt("id"),
						result.getInt("eid"),
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("managerid"),
						result.getString("birthdate"),
						result.getString("address"),
						result.getString("city"),
						result.getString("state"),
						result.getString("phone"),
						result.getString("email")
						
						));
			}

			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception selecting all employees", e);
		} 
		return new ArrayList<>();
	}
	
	

	public List<Reimburse> selectReimburseApproved() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "select e.lastname,e.firstname,e.title,r.id,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date from employee e left join REIMBURSE r on r.eid" + 
					"=e.eid left join status_table s on s.rid = r.rid";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Reimburse> customerList = new ArrayList<>();
			while(result.next()) {
				customerList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}

			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception selecting all reimbursement", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimburse> selectEmployeeReimburseApproved(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			System.out.println(employee.getEid());
			String command = "select e.lastname,e.firstname,e.title,r.rid,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date from employee e left join REIMBURSE r on r.eid=e.eid left join status_table s on s.rid = r.rid where s.approved = 1 and r.eid = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex,employee.getEid());
			ResultSet result = statement.executeQuery();

			List<Reimburse> customerList = new ArrayList<>();
			while(result.next()) {
				customerList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}

			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception selecting reimburse for one employee", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimburse> selectReimburseDisapproved() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "select e.lastname,e.firstname,e.title,r.rid,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date from employee e left join REIMBURSE r on r.eid =e.eid left join status_table s on s.rid = r.rid where s.disapproved = 1 or s.approved =1";
			PreparedStatement statement = connection.prepareStatement(command);
			
			ResultSet result = statement.executeQuery();

			List<Reimburse> customerList = new ArrayList<>();
			while(result.next()) {
				customerList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}
			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception reimbursement on one employee", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimburse> selectEmployeeReimburseDisapproved(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command ="select e.lastname,e.firstname,e.title,r.rid,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date from employee e left join REIMBURSE r on r.eid =e.eid left join status_table s on s.rid = r.rid where s.disapproved = 1 and e.eid = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex,employee.getEid());
			ResultSet result = statement.executeQuery();

			List<Reimburse> customerList = new ArrayList<>();
			while(result.next()) {
				customerList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}
			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception select reimbursement disapprove for one employee", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimburse> selectReimbursePending() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "select e.lastname,e.firstname,e.title,r.rid,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date\r\n" + 
					"from employee e left join REIMBURSE r on r.eid = e.eid left join status_table s on s.rid = r.rid where s.pending =1";		
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			List<Reimburse> newList = new ArrayList<>();
			while(result.next()) {
				newList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}
			return newList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception selecting all pending reimbursement  ", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimburse> selectEmployeeReimbursePending(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "select e.lastname,e.firstname,e.title,r.rid,r.description,r.amount,r.time,r.type,s.managerid,s.timedate,s.resolved_date from employee e left join REIMBURSE r on r.eid \r\n" + 
					"=e.eid left join status_table s on s.rid = r.rid where s.pending = 1 and e.eid =?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getEid());
			ResultSet result = statement.executeQuery();

			List<Reimburse> customerList = new ArrayList<>();
			while(result.next()) {
				System.out.println(result.getInt("rid"));
				customerList.add(new Reimburse(
						result.getString("lastname"),
						result.getString("firstname"),
						result.getString("title"),
						result.getInt("rid"),
						result.getString("description"),
						result.getDouble("amount"),
						result.getString("time"),
						result.getString("type"),
						result.getInt("managerid"),
						result.getString("timedate"),
						result.getString("resolved_date")
						
						
						));
			}
			return customerList;
		} catch (SQLException e) {  
			LogUtil.logger.warn("Exception selecting all customers", e);
		} 
		return new ArrayList<>();
	}
	
	/* Get a customer hash consuming the user defined function we created */
	
	public boolean statusApproved(int rid) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "update status_table set approved =1, disapproved = 0, pending = 0, where rid = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, rid);

			
			if(statement.executeUpdate() > 0) {
						return true;
					}
				} catch (SQLException e) {
					LogUtil.logger.warn("Exception checking use name", e);
				}
				return false;
			}
	
	public boolean statusDisapproved(int rid) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "update status_table set approved =0, disapproved = 1, pending = 0 where rid = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, rid);

			
			if(statement.executeUpdate() > 0) {
						return true;
					}
				} catch (SQLException e) {
					LogUtil.logger.warn("Exception statusDisapprove use name", e);
				}
				return false;
			}
	
	/* Get a customer hash consuming the user defined function we created */
	@Override
	public String getCustomerHash(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT password from login where username = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("password");
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting username error", e);
		} 
		return new String();
	}

	
	
}
