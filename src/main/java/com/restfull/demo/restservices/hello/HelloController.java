package com.restfull.demo.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String hello() {
		return "Hello!!";
	}
	
	@GetMapping(path = "/helloYou")
	public String helloYou() {
		return "Hello You!!";
	}
	
	@GetMapping(path = "/helloBean")
	public HelloBean helloBean() {
		return new HelloBean("Hello Bean!!");
	}
}
