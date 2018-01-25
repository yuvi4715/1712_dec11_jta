package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import com.revature.model.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	//private Session session;

	@Override
	public void insertEmployee(Employee emp) {
		/*
		 * We use the session component to hold the connection to our database.
		 */
		Session session = HibernateUtil.getSession().openSession();
		// We use the transaction component to perform
		// actual operations on data.
		Transaction t1 = null;
		try {
			// Open of a transaction stream for our session.
			t1 = session.beginTransaction();
			session.save(emp);
			// Save will persist the data to the database.
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t1 != null) {
				// If a transaction fails, roll it back.
				t1.rollback();
			}
		} finally {
			// Never have open streams of anything...
			session.close();
		}

	}

	@Override
	public void updateEmployeeName(int id, String name) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		Employee emp = null;
		try {
			t1 = session.beginTransaction();
			emp = session.get(Employee.class, id);
			emp.setEmpName(name);
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t1 != null) {
				t1.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public Employee findById(int id) {
		Session session = HibernateUtil.getSession().openSession();
		// Transaction t1 = null;
		Employee emp = null;
		try {
			session.beginTransaction();
			emp = session.get(Employee.class, id);
			return emp;
		} finally {
			session.close();
		}
	}

	@Override
	public Employee findByName(String name) {

		//works for less than 5.2
		Session session = HibernateUtil.getSession().openSession();
		Employee e = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("empName", name)).list().get(0);
		
		//CriteriaBuilder cb = session.getCriteriaBuilder();
		//CriteriaQuery criteria = cb.createQuery(Employee.class);
		
		session.close();
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSession().openSession();
		List<Employee> employees = null;
		// Transaction t1 = null;
		try {
			session.beginTransaction();
			employees = session.createQuery("from Employee").list();
			return employees;
		} finally {
			session.close();
		}
	}

	public void hqlExample() {
		Session session = HibernateUtil.getSession().openSession();
		Query<Employee> query;
		String hql = "";
		try {
			hql = "from com.revature.model.Employee";
			session.beginTransaction();
			query = session.createQuery(hql);

			List<Employee> listOfEmployees = query.list();
			System.out.println(listOfEmployees);

			hql = "from Employee where id= :someId";
			query = session.createQuery(hql);
			query.setParameter("someId", 2);

			List<Employee> listOfEmployees1 = query.list();
			System.out.println(listOfEmployees1);
			// return employees;
		} finally {
			session.close();
		}
	}

}
