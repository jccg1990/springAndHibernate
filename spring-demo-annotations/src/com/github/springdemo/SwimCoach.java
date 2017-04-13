package com.github.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortune;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		fortune = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000m as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
