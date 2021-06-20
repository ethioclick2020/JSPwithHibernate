package com.ethioclicks.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session session;
	
	public static Session getSession(){
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			session = conf.buildSessionFactory().openSession();
		}catch(Exception e){
			System.out.println("Error :"+ e.getMessage());	
		}	
		return session;
	}
}
