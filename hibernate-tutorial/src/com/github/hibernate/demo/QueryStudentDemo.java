package com.github.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try{
			//start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//displarys students
			displayStudents(students);
			
			//query students with lastname Doe
			students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

			//displarys students
			System.out.println("\n\nStudents who have laste name of Doe:");
			displayStudents(students);
			
			//query students last name of Doe OR firstName Mary
			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Mary'").getResultList();
			System.out.println("\n\nStudents who have last name of Doe OR firstname of Mary");
			displayStudents(students);
			
			//query students where emial like '%test.com'
			students = session.createQuery("from Student s where s.email like '%test.com'").getResultList();
			System.out.println("\n\nStudents who have email like '%test.com'");
			displayStudents(students);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students){
			System.out.println(student);
		}
	}

}
