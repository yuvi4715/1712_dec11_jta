package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao{

	private static CustomerDaoImpl customerDaoImpl;
	
	private CustomerDaoImpl() {
	}
	
	public static CustomerDaoImpl getInstance() {
		if (customerDaoImpl == null) {
			customerDaoImpl = new CustomerDaoImpl();
		}
		return customerDaoImpl;
	}
	
	//Insert into customer table using PreparedStatement
	@Override
	public boolean insert(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//Simple insert statement to insert into customer table
			String sql = "insert into customer values(NULL, ?, ?, ?, ?)";
			
			//Execute an insert statement using prepared statement
			PreparedStatement p = conn.prepareStatement(sql);
			
			//Incrementing the statementIndex helps in ordering the parameters
			p.setString(++statementIndex, customer.getFirstname().toUpperCase());
			p.setString(++statementIndex, customer.getLastname().toUpperCase());
			p.setString(++statementIndex, customer.getUsername().toUpperCase());
			p.setString(++statementIndex, customer.getPassword());
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Insert into customer table using PreparedStatement	
	@Override
	public boolean insertProcedure(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//Calling the store procedure
			String storedProc = "CALL INSERT_CUSTOMER(?,?,?,?)";
			
			//Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);
			
			//Set attributes to insert
			c.setString(++statementIndex, customer.getFirstname().toUpperCase());
			c.setString(++statementIndex, customer.getLastname().toUpperCase());
			c.setString(++statementIndex, customer.getUsername().toUpperCase());
			c.setString(++statementIndex, customer.getPassword());
			
			if(c.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Select customer based on his user name
	@Override
	public Customer select(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			String sql = "SELECT * FROM CUSTOMER WHERE C_USERNAME = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			
			//Incrementing the statementIndex helps in ordering the parameters
			p.setString(++statementIndex, customer.getFirstname());
			
			ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Customer(
				result.getInt("C_ID"),
				result.getString("C_FIRSTNAME"),
				result.getString("C_LASTNAME"),
				result.getString("C_USERNAME"),
				result.getString("C_PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Customer();
	}

	@Override
	public List<Customer> selectAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "Select * from customer";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			List<Customer> customerList = new ArrayList<>();
			while (rs.next()) {
				customerList.add(new Customer(
						rs.getInt("C_ID"),
						rs.getString("C_FIRSTNAME"),
						rs.getString("C_LASTNAME"),
						rs.getString("C_USERNAME"),
						rs.getString("C_PASSWORD"))
						);
			}
			
			return customerList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	/* Get a customer hash consuming the user defined function we created */
	@Override
	public String getCustomerHash(Customer customer) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT GET_CUSTOMER_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, customer.getUsername());
			statement.setString(++statementIndex, customer.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new String();
	}
}
