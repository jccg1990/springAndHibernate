package com.github.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Prfactice your shoots";
	}
	
	@Override
	public String getDailyFortune() {
		return null;
	}


}
