package com.github.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Coach javaCoach = context.getBean("javaCoach", Coach.class);
		
		System.out.println(javaCoach.getDailyWorkout());
		System.out.println(javaCoach.getDailyFortune());

		context.close();
	}

}
