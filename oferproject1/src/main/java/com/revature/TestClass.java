package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.revature.dao.DaoImplement;
import com.revature.model.Request;
import com.revature.model.User;
import com.revature.service.Service;
import com.revature.util.ConnectionUtil;

public class TestClass {

	public static void main(String[] args) {
		
		
/*
 * some of the methods have been altered and will not work in the format below
 * For proper input format see the various controllers (LoginController, LogoutController...etc)
 */

		/********Administrator-only Services***********/
		
		//Test to insert 1 manager with valid credentials
		//System.out.println(Service.getInstance().registerUser(new User(0, "Ofer", "Rosen", "oferiko", "aaa1aa", "hello@world.com",1)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "James", "Bond", "jb007", "aaa1aa", "hello@world.com",1)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "Jason", "Bourne", "jb100", "aaa1aa", "hello@world.com",1)));
		
		//Test to insert 1 manager with an existing username
		//System.out.println(Service.getInstance().registerUser(new User(0, "Ofer", "Rosen", "oferiko", "aaa1aa", "hello@world.com",1)));
		
		/********Manager-only Services***********/
		
		//Test to insert 5 new employees. 1 employee is logged in from another computer. 
		//System.out.println(Service.getInstance().registerUser(new User(0, "Jack", "Bower", "jbe1", "12345a", "adasd@world.com",0,0)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "Mary", "Wilder", "mwowy", "2rc4rx43xr", "ghdgh@world.com",0)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "Willam", "Kendrik", "wikend", "sddddx3", "54ygyt@world.com",0)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "Douglas", "Adams", "dadams", "fxrxgr3", "tryt4@world.com",0)));
		//System.out.println(Service.getInstance().registerUser(new User(0, "Lynda", "Miles", "lmiles", "4xfafwe3", "435yte@world.com",0)));
		
	
		//Test to insert a new employee with an existing username 
		//System.out.println(Service.getInstance().registerUser(new User(0, "Lynda", "Miles", "lmiles", "4xfafwe3", "435yte@world.com",0)));
			
		//Test to retrieve all the users in the database
		//System.out.println(Service.getInstance().listAllUsers());
		
		/********Common Services***********/
		//Test employee login with incorrect password /manager login with incorrect username
		//System.out.println(Service.getInstance().login(new User("oeeriko","aaa1aa",1)));
		//System.out.println(Service.getInstance().login(new User("lmiles","5xfafwe3",0)));
		
		//Test employee login, manager login
		//System.out.println(Service.getInstance().login(new User("oferiko","aaa1aa")));
		//System.out.println(Service.getInstance().login(new User("lmiles","4xfafwe3",0)));
		
		//Repeat - Test employee and manager attempt to login while already logged in
		//System.out.println(Service.getInstance().login(new User("oferiko","aaa1aa",1)));
		//System.out.println(Service.getInstance().login(new User("lmiles","4xfafwe3",0)));	
		
		//Test submission of request
		/*
		System.out.println(Service.getInstance().submit(new Request(30,"100","Travel")));
		System.out.println(Service.getInstance().submit(new Request(30,"200","Training")));
		System.out.println(Service.getInstance().submit(new Request(30,"300","Lodging")));
		System.out.println(Service.getInstance().submit(new Request(31,"400","Other")));
		System.out.println(Service.getInstance().submit(new Request(31,"500","Travel")));
		System.out.println(Service.getInstance().submit(new Request(31,"600","Training")));
		System.out.println(Service.getInstance().submit(new Request(33,"700","Lodging")));
		System.out.println(Service.getInstance().submit(new Request(33,"800","Other")));
		System.out.println(Service.getInstance().submit(new Request(33,"900","Travel")));
		System.out.println(Service.getInstance().submit(new Request(34,"1000","Training")));
		System.out.println(Service.getInstance().submit(new Request(34,"1100","Lodging")));
		System.out.println(Service.getInstance().submit(new Request(34,"1200","Other")));
		System.out.println(Service.getInstance().submit(new Request(28,"1300","Travel")));
		System.out.println(Service.getInstance().submit(new Request(28,"1400","Training")));
		System.out.println(Service.getInstance().submit(new Request(28,"1500","Lodging")));
		*/
		
		/* Test View requests method
		 * viewRequests(new Request(17,"Pending"))	- view all pending requests of employee 17
		 * viewRequests(new Request(17,"Resolved"))	- view all resolved requests of employee 17
		 * viewRequests(new Request(0,"Pending"))	- view all pending requests of all employees
		 * viewRequests(new Request(0,"Resolved"))	- view all resolved requests of all employees*/
		//System.out.println(Service.getInstance().viewRequests(new Request(27,"Pending")));
		
		//Test update of personal information (first Name, last Name, password, email)
		//Make sure correct user ID is inputted!
		//System.out.println(Service.getInstance().newInfo(new User(27,"Ofer", "Rosen", "lmiles", "aaa1aa", "hello@world.com")));
		//System.out.println(Service.getInstance().newInfo(new User(6,"Lynda", "Miles", "lmiles", "4xfafwe3", "435yte@world.com")));
		
		//Test close Request method		
	//	Service.getInstance().closeRequest(new Request(13,27,"Denied"));
		
		//Test employee and manager logout
		//System.out.println(Service.getInstance().logout(new User("oferiko")));
		//System.out.println(Service.getInstance().logout(new User("lmiles","4xfafwe3")));
		
		//Test employee attempt to login to manager homepage, and manager attempt to login to employee homepage
		//System.out.println(Service.getInstance().login(new User("lmiles","4xfafwe3",1)));
		//System.out.println(Service.getInstance().login(new User("oferiko","aaa1aa",0)));
		
		// Test various SQL injections
		
				
	}

}
