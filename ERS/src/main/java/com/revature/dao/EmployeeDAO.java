package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.model.Credential;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO implements IEmployeeDAO {

	private Logger logger = Logger.getLogger(EmployeeDAO.class);	
	private static EmployeeDAO obj;
	private EmployeeDAO() {}
	public static EmployeeDAO getInstance() {
		if(obj == null)
			obj = new EmployeeDAO();
		return obj;
	}
	
	@Override
	public Employee getUserInfoByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			Employee employeeInfo = null;
			PreparedStatement stmt = null;
			String query = "select employee.employee_id, employee.firstname, employee.lastname, infoemployee.address, infoemployee.city, infoemployee.state, infoemployee.zipcode, infoemployee.phone, email.email, jobtitle.title "
					+ "from rpadmin.employee "
					+ "inner join rpadmin.logininfo on logininfo.login_id = employee.login_id "
					+ "inner join rpadmin.infoemployee on infoemployee.employee_id = employee.employee_id "
					+ "inner join rpadmin.email  on email.EMPLOYEE_ID = employee.EMPLOYEE_ID "
					+ "inner join rpadmin.jobtitle on jobtitle.TITLE_ID = logininfo.TITLE_ID "
					+ "where rpadmin.logininfo.username = '" + username + "'";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				employeeInfo = new Employee(rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zipcode"),
						rs.getLong("phone"),
						rs.getString("email"),
						rs.getString("title"),
						rs.getInt("employee_id"));
			}
			return employeeInfo;
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return new Employee();
	}
	
	@Override
	public String getUsername(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			PreparedStatement ps = null;
			String username = null;
			String query = "select username from rpadmin.logininfo inner join rpadmin.employee where "
					+ " logininfo.login_id = employee.login_ id and employee = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, employee.getEid());
			rs = ps.executeQuery();
			if(rs.next()) {
				username = rs.getString("username");
			}
			return username;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}
	
	@Override
	public ArrayList<Employee> getEmployeeNames() {
		ArrayList<Employee> tempNames = new ArrayList<Employee>();
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs;
			Statement stmt = null;
			String query = "Select * from rpadmin.employee";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
			tempNames.add(new Employee(rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getInt("employee_id")));
			}
		
			return tempNames;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}
	
	
	@Override
	public boolean updateEmployeeInfo(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = null;
			int placementNumber = 0;
			String query1 = "update rpadmin.employee "
					+ "set firstname = ?, "
					+ "lastname = ? "
					+ "where employee.employee_id = ? ";
			String query2 = "update rpadmin.infoemployee "
					+ "set address = ?, "
					+ "city = ?, "
					+ "state = ?, "
					+ "zipcode = ?, "
					+ "phone = ? "
					+ "where infoemployee.employee_id = ?";
			String query3 = "update rpadmin.email "
					+ "set email = ? "
					+ "where email.employee_id = ?";
			ps = conn.prepareStatement(query1);
			ps.setString(++placementNumber, employee.getFirstname());
			ps.setString(++placementNumber, employee.getLastname());
			ps.setInt(++placementNumber, employee.getEid());
			ps.executeUpdate();
			placementNumber = 0;
			ps = conn.prepareStatement(query2);
			ps.setString(++placementNumber, employee.getAddress());
			ps.setString(++placementNumber, employee.getCity());
			ps.setString(++placementNumber, employee.getState());
			ps.setInt(++placementNumber, employee.getZipCode());
			ps.setLong(++placementNumber, employee.getPhone());
			ps.setInt(++placementNumber, employee.getEid());
			ps.executeUpdate();
			placementNumber = 0;
			ps = conn.prepareStatement(query3);
			ps.setString(++placementNumber, employee.getEmail());
			ps.setInt(++placementNumber, employee.getEid());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}
}
