package com.github.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			//delete the student
//			System.out.println("Deleting student: " + myStudent);
//			session.delete(myStudent);
			
			//delete student id=2
			System.out.println("Deleting student with id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
