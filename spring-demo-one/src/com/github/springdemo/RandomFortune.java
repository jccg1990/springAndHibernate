package com.github.springdemo;

import java.util.List;
import java.util.Random;

public class RandomFortune implements FortuneService {

	private List<String> list;
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String getFortune() {
		Object[] values = list.toArray();
		Random random = new Random();
		
		return (String)values[random.nextInt(list.size())];
	}

}
