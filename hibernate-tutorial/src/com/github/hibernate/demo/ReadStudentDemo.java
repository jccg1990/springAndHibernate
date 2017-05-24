package com.github.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object
			System.out.println("Creating a new student object....");
			Student student = new Student("John", "Michales", "jm@test.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//find out primary key
			System.out.println("Saved student. Generated id: " + student.getId());
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("\nGetting setudent with id: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			//commit trnasaction
			session.getTransaction().commit();
			
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		
	}

}
