package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.connection.ConnectionFactory;

// DAO operations to the database
public class EmployeeDAO implements EmployeeDAOInterface {
	
	String commitSql = "COMMIT";

	//Method to add an employee to the Employee_Tbl
	@Override
	public void addEmployee(Employee emp, Connection con) throws Exception {
		String insertSql = "INSERT INTO EMPLOYEE_TBL (employee_id, first_name, last_name, email, employee_role, title, reports_to)"
				+ " VALUES (Employee_SQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(insertSql);
		ps.setString(1, emp.getEmp_fname());
		ps.setString(2, emp.getEmp_lname());
		ps.setString(3, emp.getEmp_email());
		ps.setString(4, emp.getEmp_role());
		ps.setString(5, emp.getEmp_title());
		ps.setInt(6, emp.getEmp_reportsTo());
		
		ps.executeQuery();
		ps.close();
		
		con.prepareStatement(commitSql).executeQuery();
		con.close();
	}

	//Method to add an employee to the User_Tbl
	@Override
	public void createUser(Employee emp, Connection con) throws Exception {
		
		String user = emp.getUsername();
		String pass = emp.getPassword();
		
		int empID = getEmployeeID(emp, con);
		
		System.out.println("user: " + user);
		System.out.println("pass: " + pass);
		System.out.println("empID: " + empID);
		
		String createUserSql = "INSERT INTO USER_TBL (EMPLOYEE_ID, LOG_STATUS, EMP_USERNAME, EMP_PASSWORD) VALUES ("+ empID +", 1, ?, ?)";
		
		System.out.println(createUserSql);
		
		PreparedStatement ps = con.prepareStatement(createUserSql);
		ps.setString(1, user.toLowerCase());
		ps.setString(2, pass);
		
		ps.executeQuery();
		ps.close();
		
		con.prepareStatement(commitSql).executeQuery();
		con.close();
	}
	
	@Override
	public void updateUser(Employee emp, Connection con) throws Exception {
		
		String updateEmpTblSql = "UPDATE EMPLOYEE_TBL SET EMAIL = ?, EMPLOYEE_ROLE = ?, REPORTS_TO = ? WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = con.prepareStatement(updateEmpTblSql);
		ps.setString(1, emp.getEmp_email());
		ps.setString(2, emp.getEmp_role());
		ps.setInt(3, emp.getEmp_reportsTo());
		ps.setInt(4, emp.getEmp_id());
		
		
		String updateUserTblSql = "UPDATE USER_TBL SET EMP_USERNAME = ?, EMP_PASSWORD = ? WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps2 = con.prepareStatement(updateUserTblSql);
		ps2.setString(1, emp.getUsername());
		ps2.setString(2, emp.getPassword());
		ps2.setInt(3, emp.getEmp_id());
		
		ps.executeQuery();
		ps.close();
		
		ps2.executeQuery();
		ps2.close();
		
		con.prepareStatement(commitSql).executeQuery();
		con.close();
	}
	
	// Method to list all the Employees
	@Override
	public List<Employee> elist(Connection con) throws Exception {
		
		List<Employee> list = new ArrayList<>();
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, EMPLOYEE_ROLE, TITLE, REPORTS_TO FROM EMPLOYEE_TBL ORDER BY EMPLOYEE_ID ASC";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			list.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"), 
					rs.getString("EMPLOYEE_ROLE"), rs.getString("TITLE"), rs.getInt("REPORTS_TO")));
		}
		
		rs.close();
		ps.close();
		
		return list;
	}
	
	// Method to get the manager's information
	@Override
	public List<Employee> infoList(String empUser, Connection con) throws Exception {
		
		List<Employee> list = new ArrayList<>();
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.EMAIL, E.EMPLOYEE_ROLE, E.REPORTS_TO, U.EMP_USERNAME" + 
				" FROM EMPLOYEE_TBL E FULL OUTER JOIN USER_TBL U ON E.EMPLOYEE_ID = U.EMPLOYEE_ID" +
				" WHERE U.EMP_USERNAME = '" + empUser + "'";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			list.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"), 
					rs.getString("EMPLOYEE_ROLE"), rs.getInt("REPORTS_TO"), rs.getString("EMP_USERNAME")));
		}
		
		rs.close();
		ps.close();
		
		return list;
	}
	
	// works as long as the employee object you pass has the email field
	@Override
	public int getEmployeeID(Employee emp, Connection con) throws Exception {
		
		String getIDSql = "SELECT EMPLOYEE_ID FROM EMPLOYEE_TBL WHERE EMAIL = '";
		String email = emp.getEmp_email();
		int empID = 0;
		
		PreparedStatement ps = con.prepareStatement(getIDSql + email + "'");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			empID = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return empID;
	}

// ---------- METHODS THAT RETRIEVE INFORMATION FROM THE DATABASE ----------
	// retrieves the employee's first name, when passed the username
	@Override
	public int getEmpID(String user, Connection con) throws Exception {
		
		int retrievedUser = 0;
		String getSql = "SELECT ET.EMPLOYEE_ID FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
	
	// retrieves the employee's first name, when passed the username
	@Override
	public String getEmployeeFirstName(String user, Connection con) throws Exception {
		
		String retrievedUser = "";
		String getSql = "SELECT ET.FIRST_NAME FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}

	// retrieves the employee's last name, when passed the username
	@Override
	public String getEmployeeLastName(String user, Connection con) throws Exception {
		
		String retrievedUser = "";
		String getSql = "SELECT ET.LAST_NAME FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
	
	// retrieves the employee's email, when passed the username
	@Override
	public String getEmployeeEmail(String user, Connection con) throws Exception {
		
		String retrievedUser = "";
		String getSql = "SELECT ET.EMAIL FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
	
	// retrieves the employee's role, when passed the username
	@Override
	public String getEmployeeRole(String user, Connection con) throws Exception {
		
		String retrievedUser = "";
		String getSql = "SELECT ET.EMPLOYEE_ROLE FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
	
	// retrieves the employee's title, when passed the username
	@Override
	public String getEmployeeTitle(String user, Connection con) throws Exception {
		
		String retrievedUser = "";
		String getSql = "SELECT ET.TITLE FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		}
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
	
	// retrieves who the employee reports to, when passed the username
	@Override
	public int getEmployeeReportsTo(String user, Connection con) throws Exception {
		
		int retrievedUser = 0;
		String getSql = "SELECT ET.REPORTS_TO FROM EMPLOYEE_TBL ET WHERE ET.EMPLOYEE_ID IN (SELECT UT.EMPLOYEE_ID FROM USER_TBL UT WHERE UT.EMP_USERNAME = '" + user + "')";
		
		PreparedStatement ps = con.prepareStatement(getSql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			retrievedUser = rs.getInt(1);
		}
		
		// check for NULL value
		
		System.out.println(retrievedUser);
		
		ps.close();
		rs.close();
		
		return retrievedUser;
	}
}
