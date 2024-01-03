package com.jpa.entity;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPQL_CRUDStudent {
	
	private static Logger logger = LoggerFactory.getLogger(JPQL_CRUDStudent.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create EntityManager factory
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("StudentPersistenceUnit");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			List<JPQL_Student> studentResultJPA = 
					entityManager.createQuery(
					"Select student " +
					"from JPQL_Student student"					
					).getResultList();
			
//			for (ListIterator<studentResultJPA> studentJPQLResultIterator= studentResultJPA.listIterator(); 
//					studentJPQLResultIterator.hasNext()) {
			
			logger.info("The Number of rows in Result output in JPQL CRUD Student is: " + studentResultJPA.size());
			
			/* 1. For Loop for iterating over the Generic ArrayList
			 * 
			 */
//			for(int i = 0; i<studentResultJPA.size(); i++) {
//				/* Comment the toString method of the JPQL_Student Class and see the difference
//				 * in the result
//				 */
//				
//				logger.info("The output in JPQL CRUD Student is: " + i + " "+ studentResultJPA.get(i));
//			}
			
			/* 2. Enhanced For Loop for iterating over the Generic ArrayList
			 * 
			 */
			
			for(JPQL_Student studentResult : studentResultJPA) {
				/* Comment the toString method of the JPQL_Student Class and see the difference
				 * in the result
				 */
				
				logger.info("The output in JPQL CRUD Student is:  " + studentResult);
			}
			
			/* 3. Iterate over the Generic ArrayList using Iterator
			 * 
			 */
			
			logger.info("The output in JPQL CRUD Student is: " + studentResultJPA.toString());
			
//			}
		}
		
		finally {
			entityManager.close();
		}
	}
	
	

}
