package com.github.springdemo;

public class SoccerCoach implements  Coach {

	private FortuneService fortune;
	
	public SoccerCoach(FortuneService service) {
		fortune = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice 10 penalties";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
