package com.github.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	//new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model){
		
		//read the request param from form
		String name = request.getParameter("studentName");
		
		//convert data to caps
		name = name.toUpperCase();
		
		//create message
		String result = "Hey! " + name;
		
		//add measge to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
		
		//convert data to caps
		theName = theName.toUpperCase();
		
		//create message
		String result = "Hello My Friend, V3! " + theName;
		
		//add measge to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
