package com.github.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService{

	
	private List<String> values = new ArrayList<>();
	
	private Random random = new Random();
	
	@Value("${file}")
	private String fileName;
	
	public FileFortuneService() {
		System.out.println(">> FileFortuneService: inside default constructor");
	}
	
	@PostConstruct
	public void init(){
		System.out.println(">> FileFortuneService: inside init method");
		try(FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)){
			
			String currentLine;
			while((currentLine = br.readLine()) != null){
				values.add(currentLine);
			}
			
		} catch ( IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public String getFortune() {
		return values.get(random.nextInt(values.size()));
	}

}
