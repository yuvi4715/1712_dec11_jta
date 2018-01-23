package com.revature;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Employee;
import com.revature.util.HibernateUtil;

public class TestClass {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = session.beginTransaction();
		
		try {
			Employee e1 = new Employee();
			e1.setEmpId(3);
			e1.setEmpName("Sayla");
			e1.setCreatedBy("admin");
			e1.setCreatedDate(new Date());
			
			session.save(e1);
			t1.commit();
		}
		finally {
			session.close();
		}
		
	}

}
