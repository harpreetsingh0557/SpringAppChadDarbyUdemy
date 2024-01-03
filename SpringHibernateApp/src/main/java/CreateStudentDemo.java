

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.HQL_Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().
								 configure("hibernate.config.xml").
								 addAnnotatedClass(HQL_Student.class).
								 buildSessionFactory();
	
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new student object...");
			HQL_Student tempStudent = new HQL_Student("Tutul", "Putul", "tulpul@shark.com");
			//start a transaction
			
			//save the student object
			
			//commit transaction
		}
		
		finally {
			factory.close();
		}
	}
	
	

}
