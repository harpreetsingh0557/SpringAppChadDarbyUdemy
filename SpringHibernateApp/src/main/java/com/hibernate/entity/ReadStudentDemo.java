package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadStudentDemo {
	
	private static Logger logger = LoggerFactory.getLogger(ReadStudentDemo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().
									 configure("hibernate.cfg.xml").
									 addAnnotatedClass(HQL_Student.class).
									 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			logger.info("ReadStudentDemo class message ---> Reading the student object...");
			
			session.beginTransaction();
			
			HQL_Student student = session.get(HQL_Student.class , 6 ) ;
			
			logger.info("ReadStudentDemo class message ---> Output is :" + student);
			
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}
		
	}

}
