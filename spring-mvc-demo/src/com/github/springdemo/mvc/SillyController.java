package com.github.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	// need a controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm(){
		return "silly";
	}
	
}
