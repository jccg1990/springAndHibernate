package com.github.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JavaCoach implements Coach {
	
	@Autowired
	@Qualifier("witchFortune")
	FortuneService fortune;
	
	@Override
	public String getDailyWorkout() {
		return "You should study Java!";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
