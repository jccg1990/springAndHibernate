package com.github.springdemo;

public class MyApp {

	public static void main(String[] args) {
		//create obj
		
		Coach theCoach = new TrackCoach();
		
		//use obj
		System.out.println(theCoach.getDailyWorkout());
	}

}
