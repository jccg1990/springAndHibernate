package com.github.springdemo;

import org.springframework.stereotype.Component;

@Component
public class WitchFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "This is your Witch Fortune";
	}

}
