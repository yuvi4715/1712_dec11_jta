package com.revature;

import java.util.Date;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
public class TestClass {

	public static void main(String[] args) {
		
		//Employee e1 = new Employee("Bob","admin",new Date());
		//Employee e2 = new Employee("mike","yuvi",new Date());
		//Employee e3 = new Employee("mike","yuvi",new Date());
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		//ed.insertEmployee(e1);
		//ed.insertEmployee(e2);
		//ed.insertEmployee(e3);
		//ed.updateEmployeeName(52,"John");
		
		//System.out.println(ed.findById(103));
		
		//System.out.println(ed.getAllEmployees());
		
		//ed.hqlExample();
		
		System.out.println(ed.findByName("Bob"));
	}

//	public static void insertCustomer() {
//		Session session = HibernateUtil.getSession().openSession();
//		session.beginTransaction();
//		Customer c1 = new Customer();
//		//c1.setCustId(2);
//		c1.setCustName("Peyton Manning");
//		c1.setCustPhone("123-456-7890");
//		c1.setCustAddress("1, main st, herndon, va 20170");
//		session.save(c1);
//		session.getTransaction().commit();
//		session.close();
//	}
	
//	public void insertEmployee() {
//		Session session = HibernateUtil.getSession().openSession();
//		Transaction t1 = session.beginTransaction();
//		NeverDoThis e1 = new NeverDoThis();
//		e1.setEmpId(4);
//		e1.setEmpName("test4");
//		e1.setCreatedBy("yuvi");
//		e1.setCreatedDate(new Date());
//		session.save(e1);
//		t1.commit();
//		session.close();
//	}
}
