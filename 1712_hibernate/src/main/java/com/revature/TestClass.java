package com.revature;



import java.util.Date;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.util.HibernateUtil;


public class TestClass {


	public static void main(String[] args) {


		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = session.beginTransaction();


		Customer c1 = new Customer();
		//c1.setCustId(1);
		c1.setCustName("Rob");
		c1.setCustPhone("1-800-756-9968");
		c1.setCustAddress("123 A Nice Place");
		

		session.save(c1);
		t1.commit();
		session.close();


	}


}