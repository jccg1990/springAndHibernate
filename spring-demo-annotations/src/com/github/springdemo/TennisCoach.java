package com.github.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("protoype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define init method
	@PostConstruct
	public void doStartup(){
		System.out.println(">> TennisCoach: inside of doStartup()");
	}
	
	//define destroy method
	@PreDestroy
	public void doCleanUp(){
		System.out.println(">> TennisCoach: inside of doCleanUp()");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortune) {
//		this.fortuneService = fortune;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setter method");
//		this.fortuneService = fortuneService;
//	}

}
