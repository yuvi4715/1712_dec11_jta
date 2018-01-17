package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private HibernateUtil() {}
	
	private static SessionFactory obj = null;
	private static SessionFactory mySessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	
	public static SessionFactory getSession() {
		if(obj == null)
			obj = mySessionFactory();
		return obj;
		
	}

}
