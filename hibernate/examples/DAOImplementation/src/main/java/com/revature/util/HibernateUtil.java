package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory mysession;
	
	private HibernateUtil() {
	}
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSession() {
		if (mysession ==null) {
			mysession = HibernateUtil.buildSessionFactory();
		}
		return mysession;
	}

}
