package com.majorbit.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory= buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		Configuration configuration= new Configuration();
		return configuration.configure("hibernate.config.xml").buildSessionFactory();
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
