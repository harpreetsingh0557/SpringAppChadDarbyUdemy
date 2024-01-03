package com.hibernate.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HQL_CRUDStudent {
	
	private static Logger logger = LoggerFactory.getLogger(HQL_CRUDStudent.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		//create session factory
		SessionFactory sessionFactory = new Configuration().
								 configure("hibernate.cfg.xml").
								 addAnnotatedClass(HQL_Student.class).
								 buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		try {		
			//create a student object
			//Print messages through logging instead of System.out.println
//			System.out.println("Creating new student object...");
			logger.info("CreateStudentDemo class message ---> Creating new student object...");
			HQL_Student tempStudent = new HQL_Student("Tutul", "Putul", "tulpul@shark.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
//			System.out.println("Saving the student...");
			logger.info("CreateStudentDemo class message ---> Saving the student...");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
//			System.out.println("Done!");
			logger.info("CreateStudentDemo class message ---> Done");
		}
		
		finally {
			session.close();
		}	

	}
	
	

}
