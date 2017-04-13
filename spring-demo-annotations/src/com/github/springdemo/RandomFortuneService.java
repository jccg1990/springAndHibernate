package com.github.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create array of Strings
	private String[] data = {
		"Beware of the wolf in the sheep's clothing",
		"Diligence is the mother of good luck",
		"The journey is the reward"
	};
	
	//create random number
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index  = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
