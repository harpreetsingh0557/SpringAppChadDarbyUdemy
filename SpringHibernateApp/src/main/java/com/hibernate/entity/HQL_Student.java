package com.hibernate.entity;

/* In the version 6.1.6.Final of Hibernate ,
 * jakarta persistence is used
 * In the version 5.6.15.Final of Hibernate ,
 * javax persistence is used
 * Currently using version 5.6.15.Final of Hibernate,
 * therefore using javax persistence
 * 
 * Also there is org.hibernate.annotations.* and 
 * javax.persistence.* libraries/classes, but according to Chad
 * the Hibernate folks recommended to use javax.persistence instead of
 * org.hibernate.annotations. This is come up when we write a new annotation
 * say @Table, when the Eclipse recommends to use org.hibernate.annotations and 
 * javax.persistence, but we choose javax.persistence as recommended.
 * javax.persistence is recommended since it is interface and 
 * org.hibernate.annotations are implementation. We can later change the 
 * implementation from Hibernate to any other JPA implementation.
 * Got it from djb's answer in stackoverflow
 * https://stackoverflow.com/questions/22285882/difference-between-javax-persistence-and-hibernate-annotations
 * 
 */

import javax.persistence.Column;
//import jakarta.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
//import org.hibernate.annotations.Table;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class HQL_Student {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	public HQL_Student(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/* Add the default constructor in addition to another constructor because
	 * of the error No default constructor for entity:  : com.hibernate.entity.Student
	 * This error is because of the restriction on Entity Class as described in 1.1 Default 
	 * or No-Arg Constructor under 1.  Restrictions on Persistent Classes in 
	 * https://openjpa.apache.org/builds/1.2.3/apache-openjpa/docs/jpa_overview_pc.html 
	 * as found from the kamal's answer in this stackoverflow thread 
	 * https://stackoverflow.com/questions/25452018/hibernate-annotations-no-default-constructor-for-entity?rq=1 
	 * The restriction is that if the Entity class has defined a constructor (eg parameterised) 
	 * then the default constructor should also be defined 
	 */
	public HQL_Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
	
}
