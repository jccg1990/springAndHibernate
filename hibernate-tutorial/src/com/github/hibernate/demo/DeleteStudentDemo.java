package com.github.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try{
			int studentId=1;
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("\nGetting setudent with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating the student...");
			myStudent.setFirstName("Scooby");
			
			//commit trnasaction
			session.getTransaction().commit();
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//upddate email for all studens
			System.out.println("Update email for all studetns");
			
			session.createQuery("update Student set email='foo@test.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		
	}

}
